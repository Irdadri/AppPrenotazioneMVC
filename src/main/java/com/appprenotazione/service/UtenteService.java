package com.appprenotazione.service;

import com.appprenotazione.dto.UtenteDTO;
import com.appprenotazione.entities.Utente;
import org.springframework.stereotype.Service;


public interface UtenteService {
    public void inserisciUtente(UtenteDTO utente);
    public Utente loginUtente(String email, String password);

}
