package com.appprenotazione.controller;
/*
import com.appprenotazione.dto.PrenotazioneRequest;
import com.appprenotazione.entities.Prenotazione;
import com.appprenotazione.entities.Utente;
import com.appprenotazione.service.PrenotazioneService;
import com.appprenotazione.service.StanzaService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.modelmapper.internal.Errors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class PrenotazioneController {

    public static final Logger log = LoggerFactory.getLogger(PrenotazioneController.class);

    private final StanzaService stanzaService;
    public PrenotazioneService prenotazioneService;
    public PrenotazioneController(PrenotazioneService prenotazioneService, StanzaService stanzaService){
        this.prenotazioneService = prenotazioneService;
        this.stanzaService = stanzaService;
    }

    /*
    @PostMapping(value = "/inserisci"
           //produces = MediaType.APPLICATION_JSON_VALUE,
           //consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Prenotazione insertPrenotazioneAjax(@Valid @RequestBody PrenotazioneRequest prenotazioneRequest,
                                               Errors error){

        return prenotazioneService.insertPrenotazione(prenotazioneRequest, null);
    }

    @PostConstruct
    public void log(){
        log.info("qualcosa");
    }
}
*/