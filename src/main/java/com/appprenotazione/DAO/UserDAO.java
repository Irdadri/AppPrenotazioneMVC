package com.appprenotazione.DAO;

import com.appprenotazione.model.Sede;
import com.appprenotazione.model.Utente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class UserDAO {
    public Utente loginUtente(String email, String password) throws NoSuchAlgorithmException {

        //hibernate initialization
        try {

            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Utente utente = (Utente) session.createQuery(
                            "from Utente u where u.email = :email")
                    .setParameter("email", email).uniqueResult();

            String checkPassword = passwordEncrypting(password);
            if (checkPassword.equals(utente.getPassword())) {
                session.close();
                return utente;
            }

        } catch (HibernateException e){
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return null;
    }

    public void inserisciUtente(Utente utente, int idSede){
        try{
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Sede sede = session.find(Sede.class, idSede);
            utente.setSede(sede);
            utente.setPassword(passwordEncrypting(utente.getPassword()));
            session.save(utente);
            transaction.commit();
            session.close();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
            System.out.println("error");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

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
