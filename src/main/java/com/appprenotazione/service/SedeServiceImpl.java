package com.appprenotazione.service;

import com.appprenotazione.entities.Sede;
import com.appprenotazione.repository.SedeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements SedeService{

    private final SedeRepository sedeRepository;

    public SedeServiceImpl(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    @Override
    public List<Sede> getAllSedi() {
        return sedeRepository.findAll().stream().toList();
    }
}
