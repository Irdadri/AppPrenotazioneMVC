package com.appprenotazione.service;

import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.entities.Utente;

import java.util.List;

public interface PrenotazioneService {
    public List<PrenotazioneDTO> getAllPrenotazioni();
    public List<PrenotazioneDTO> getPrenotazioniUtente(Utente utente);
}
