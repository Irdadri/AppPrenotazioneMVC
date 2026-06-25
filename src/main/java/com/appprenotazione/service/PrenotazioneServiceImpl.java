package com.appprenotazione.service;

import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.dto.PrenotazioneRequest;
import com.appprenotazione.entities.*;
import com.appprenotazione.repository.PostazioneRepository;
import com.appprenotazione.repository.PrenotazioneRepository;
import com.appprenotazione.repository.SedeRepository;
import com.appprenotazione.repository.StanzaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService{

    private final SedeRepository sedeRepository;
    private final StanzaRepository stanzaRepository;
    private final PostazioneRepository postazioneRepository;
    private ModelMapper modelMapper;
    private PrenotazioneRepository repository;

    public PrenotazioneServiceImpl(PrenotazioneRepository  repository, ModelMapper modelMapper, SedeRepository sedeRepository, StanzaRepository stanzaRepository, PostazioneRepository postazioneRepository){
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.sedeRepository = sedeRepository;
        this.stanzaRepository = stanzaRepository;
        this.postazioneRepository = postazioneRepository;
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

    @Override
    public Prenotazione insertPrenotazione(PrenotazioneRequest request, Utente utente) {
        Prenotazione prenotazione = modelMapper.map(request, Prenotazione.class);
        prenotazione.setStato("prenotato");
        prenotazione.setPostazione(postazioneRepository.findPostazioneById(Integer.parseInt(request.getnPostazione())));
        prenotazione.setUtente(utente);
        prenotazione.setDataFine(request.getDataInizio());
        repository.save(prenotazione);
        return prenotazione;
    }

}
