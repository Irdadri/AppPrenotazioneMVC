package com.appprenotazione.repository;

import com.appprenotazione.entities.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedeRepository extends JpaRepository<Sede, Integer> {
    Sede findSedeById(int id);
}
