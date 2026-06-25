package com.appprenotazione.service;

import com.appprenotazione.dto.UtenteDTO;
import com.appprenotazione.dto.UtenteRequest;
import com.appprenotazione.entities.Utente;

import java.util.List;


public interface UtenteService {
    public void inserisciUtente(UtenteRequest utente);
    public Utente loginUtente(String email, String password);
    public List<UtenteDTO> getAllUtenti();

}
