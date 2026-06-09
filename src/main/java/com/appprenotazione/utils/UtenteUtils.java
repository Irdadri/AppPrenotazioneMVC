package com.appprenotazione.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.dto.UtenteDTO;
import com.appprenotazione.model.Prenotazione;
import com.appprenotazione.model.Sede;
import com.appprenotazione.model.Utente;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteUtils {
    private DataSource dataSource;

    public UtenteUtils(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Utente loginUtente(String email, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            String sql = "select * from utente where email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            Utente utenteTrovato = new Utente();

            if (resultSet.next()) {
                String tempPassword = resultSet.getString("password");
                String insertedPassword = passwordEncrypting(password);

                /*String tempPassword = resultSet.getString("password");

                BCrypt.Result result = BCrypt.verifyer()
                        .verify(password.toCharArray(), tempPassword);

                if (result.verified) */

                if (insertedPassword.equals(tempPassword)) {
                    utenteTrovato.setId(resultSet.getInt("id"));
                    utenteTrovato.setNome(resultSet.getString("nome"));
                    utenteTrovato.setCognome(resultSet.getString("cognome"));
                    utenteTrovato.setEmail(resultSet.getString("email"));
                    utenteTrovato.setPassword(resultSet.getString("password"));
                    utenteTrovato.setTelefono(resultSet.getString("telefono"));
                    utenteTrovato.setTipoUtente(resultSet.getString("tipo_utente"));
                    utenteTrovato.setIdSede(resultSet.getInt("id_sede"));
                } else {
                    utenteTrovato = null;
                }
            } else {
                utenteTrovato = null;
            }
            return utenteTrovato;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, statement, resultSet);
        }
    }

    public List<PrenotazioneDTO> getPrenotazioneUtente(int utenteId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<PrenotazioneDTO> listaPrenotazioniUtente = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            String sql = "select pr.id, u.nome, u.cognome, s.citta, s.indirizzo, st.n_stanza, pr.data_inizio, pr.data_fine, pr.stato " +
                    "from utente u " +
                    "join prenotazione pr on pr.id_utente = u.id " +
                    "join postazione p on pr.id_postazione = p.id " +
                    "join stanza st on p.id_stanza = st.id " +
                    "join sede s on st.id_sede = s.id " +
                    "where pr.id_utente = ?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, utenteId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                listaPrenotazioniUtente.add(new PrenotazioneDTO(resultSet.getInt("id"), resultSet.getString("nome"),
                        resultSet.getString("cognome"), resultSet.getString("citta"), resultSet.getString("indirizzo"),
                        resultSet.getString("n_stanza"), resultSet.getTimestamp("data_inizio").toLocalDateTime(),
                        resultSet.getTimestamp("data_fine").toLocalDateTime(), resultSet.getString("stato")));
            }
            return listaPrenotazioniUtente;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, statement, resultSet);
        }

    }

    public List<PrenotazioneDTO> getAllPrenotazioni() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<PrenotazioneDTO> listaPrenotazioni = new ArrayList<>();

        try {
            connection = dataSource.getConnection();
            String sql = "select pr.id, u.nome, u.cognome, s.citta, s.indirizzo, st.n_stanza, pr.data_inizio, pr.data_fine, pr.stato " +
                    "from utente u " +
                    "join prenotazione pr on pr.id_utente = u.id " +
                    "join postazione p on pr.id_postazione = p.id " +
                    "join stanza st on p.id_stanza = st.id " +
                    "join sede s on st.id_sede = s.id ";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                listaPrenotazioni.add(new PrenotazioneDTO(resultSet.getInt("id"), resultSet.getString("nome"),
                        resultSet.getString("cognome"), resultSet.getString("citta"), resultSet.getString("indirizzo"),
                        resultSet.getString("n_stanza"), resultSet.getTimestamp("data_inizio").toLocalDateTime(),
                        resultSet.getTimestamp("data_fine").toLocalDateTime(), resultSet.getString("stato")));
            }
            return listaPrenotazioni;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, statement, resultSet);
        }

    }

    public void inserisciUtente(Utente utente) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            String sql = "INSERT INTO utente (nome, cognome, email, password, telefono, tipo_utente, id_sede)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            statement = connection.prepareStatement(sql);

            statement.setString(1, utente.getNome());
            statement.setString(2, utente.getCognome());
            statement.setString(3, utente.getEmail());
            String cryptedPassword = passwordEncrypting(utente.getPassword());
            statement.setString(4, cryptedPassword);
            statement.setString(5, utente.getTelefono());
            statement.setString(6, utente.getTipoUtente());
            statement.setInt(7, utente.getIdSede());

            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, statement, resultSet);
        }
    }

    public List<Sede> getAllSedi(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<Sede> listaSedi = new ArrayList<>();

        try{
            connection = dataSource.getConnection();
            String sql = "select * from sede";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                listaSedi.add(new Sede(resultSet.getInt("id"), resultSet.getString("paese"),
                        resultSet.getString("citta"), resultSet.getString("regione"), resultSet.getString("indirizzo") ));
            }

            return listaSedi;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void close(Connection connection, Statement statement, ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /*
    public void passwordEncrypting(String password) {
        String hash = BCrypt.withDefaults()
                .hashToString(12, password.toCharArray());

    }
*/
    public String passwordEncrypting(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
