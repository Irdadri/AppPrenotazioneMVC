package com.appprenotazione.repository;

import com.appprenotazione.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
    public Utente findByEmail(String email);
}
