package com.appprenotazione.service;

import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.entities.Prenotazione;
import com.appprenotazione.entities.Utente;
import com.appprenotazione.repository.PrenotazioneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService{

    private ModelMapper modelMapper;
    private PrenotazioneRepository repository;

    public PrenotazioneServiceImpl(PrenotazioneRepository  repository, ModelMapper modelMapper){
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<PrenotazioneDTO> getAllPrenotazioni() {
       List<Prenotazione> listaPrenotazioni = repository.findAll();
       return listaPrenotazioni.stream()
               .map(prenotazione -> modelMapper.map(prenotazione, PrenotazioneDTO.class))
               .collect(Collectors.toList());
    }

    @Override
    public List<PrenotazioneDTO> getPrenotazioniUtente(Utente utente) {
        List<Prenotazione> listaPrenotazioni = repository.findPrenotazioneByUtente(utente);
        return listaPrenotazioni.stream()
                .map(prenotazione -> modelMapper.map(prenotazione, PrenotazioneDTO.class))
                .collect(Collectors.toList());
    }
}
