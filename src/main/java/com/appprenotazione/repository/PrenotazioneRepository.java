package com.appprenotazione.repository;

import com.appprenotazione.entities.Prenotazione;
import com.appprenotazione.entities.Sede;
import com.appprenotazione.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    public List<Prenotazione> findPrenotazioneByUtente(Utente utente);
}
