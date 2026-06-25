package com.appprenotazione.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/* oggetto per il form inserisci prenotazione
l'utente sceglie la sede (cittá, indirizzo), il numero della stanza e la postazione
e il giorno da prenotare*/


public class PrenotazioneRequest {

    @NotBlank
    private String nPostazione;

    @NotNull
    private LocalDateTime dataInizio;

    public PrenotazioneRequest() {
    }

    public PrenotazioneRequest(String nPostazione, LocalDateTime dataInizio) {
        this.nPostazione = nPostazione;
        this.dataInizio = dataInizio;
    }

    public String getnPostazione() {
        return nPostazione;
    }

    public void setnPostazione(String nPostazione) {
        this.nPostazione = nPostazione;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }
}
