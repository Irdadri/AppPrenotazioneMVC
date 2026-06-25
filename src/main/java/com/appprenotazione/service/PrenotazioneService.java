package com.appprenotazione.service;

import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.dto.PrenotazioneRequest;
import com.appprenotazione.entities.Prenotazione;
import com.appprenotazione.entities.Utente;

import java.util.List;

public interface PrenotazioneService {
    List<PrenotazioneDTO> getAllPrenotazioni();
    List<PrenotazioneDTO> getPrenotazioniUtente(Utente utente);
    Prenotazione insertPrenotazione(PrenotazioneRequest request, Utente utente);
}
