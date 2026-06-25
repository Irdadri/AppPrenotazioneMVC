package com.appprenotazione.service;

import com.appprenotazione.entities.Postazione;
import com.appprenotazione.entities.Stanza;
import com.appprenotazione.repository.PostazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneServiceImpl implements PostazioneService {
    private PostazioneRepository postazioneRepository;

    public PostazioneServiceImpl(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }



}
