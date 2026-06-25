package com.appprenotazione.repository;

import com.appprenotazione.entities.Postazione;
import com.appprenotazione.entities.Stanza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    Postazione findPostazioneById(int id);
}
