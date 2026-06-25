package com.appprenotazione.service;

import com.appprenotazione.entities.Sede;
import com.appprenotazione.entities.Stanza;
import com.appprenotazione.repository.StanzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StanzaServiceImpl implements StanzaService{

    private final StanzaRepository stanzaRepository;

    public StanzaServiceImpl(StanzaRepository stanzaRepository) {
        this.stanzaRepository = stanzaRepository;
    }


    @Override
    public List<Stanza> getStanzeBySede(Sede sede) {
        return stanzaRepository.findBySede(sede);
    }
}
