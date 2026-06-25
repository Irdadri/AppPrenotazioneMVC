package com.appprenotazione.service;

import com.appprenotazione.dto.UtenteDTO;
import com.appprenotazione.dto.UtenteRequest;
import com.appprenotazione.entities.Sede;
import com.appprenotazione.entities.Utente;
import com.appprenotazione.repository.SedeRepository;
import com.appprenotazione.repository.UtenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {
    private final ModelMapper modelMapper;
    private final SedeRepository sedeRepository;
    private UtenteRepository repository;

    public UtenteServiceImpl(UtenteRepository repository, ModelMapper modelMapper, SedeRepository sedeRepository) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.sedeRepository = sedeRepository;
    }

    public Utente loginUtente(String email, String password) {
        Utente utente = repository.findByEmail(email);

        if (utente != null) {
            String encryptedPassword = null;
            try {
                encryptedPassword = passwordEncrypting(password);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }


            if (encryptedPassword.equals(utente.getPassword())) {
                return utente;
            }
        }
        return null;
    }

    public void inserisciUtente(UtenteRequest utenteRequest) {
        try {
            utenteRequest.setPassword(passwordEncrypting(utenteRequest.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Utente utente = modelMapper.map(utenteRequest, Utente.class);

        if (utenteRequest.getIdSede() != null) {
            Sede sede = sedeRepository.findSedeById(utenteRequest.getIdSede());
            if(sede != null) {
                utente.setSede(sede);
            } else {
                utente.setSede(new Sede());
            }
        } else {
            utente.setSede(new Sede());
        }
        repository.save(utente);
    }


    public String passwordEncrypting(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));

        return HexFormat.of().formatHex(encodedhash);
    }

    public List<UtenteDTO> getAllUtenti(){
        List<Utente> utenti = repository.findAll();
        List<UtenteDTO> utentiDTO = new ArrayList<>();
        for(int i=0; i<utenti.size(); i++){
            utentiDTO.add(modelMapper.map(utenti.get(i), UtenteDTO.class));
        }

        return utentiDTO;
    }
}
