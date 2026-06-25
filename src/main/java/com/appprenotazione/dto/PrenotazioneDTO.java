package com.appprenotazione.dto;

import com.appprenotazione.entities.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PrenotazioneDTO {
    private int id;
    private String nomeUtente;
    private String cognomeUtente;
    private String citta;
    private String indirizzo;
    private String nStanza;
    private int nPostazione;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataInizio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataFine;

    private String stato;

    public PrenotazioneDTO(int id, String nomeUtente, String cognomeUtente, String citta, String indirizzo, String nStanza, int nPostazione, LocalDateTime dataInizio, LocalDateTime dataFine, String stato) {
        this.id = id;
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.nStanza = nStanza;
        this.nPostazione = nPostazione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
    }

    public PrenotazioneDTO(Prenotazione prenotazione, Utente utente, Sede sede, Stanza stanza, Postazione postazione) {
        this.id = prenotazione.getId();
        this.nomeUtente = utente.getNome();
        this.nomeUtente = utente.getCognome();
        this.citta = sede.getCitta();
        this.indirizzo = sede.getIndirizzo();
        this.nStanza = stanza.getnStanza();
        this.nPostazione = postazione.getId();
        this.dataInizio = prenotazione.getDataInizio();
        this.dataFine = prenotazione.getDataFine();
        this.stato = prenotazione.getStato();

    }

    public PrenotazioneDTO(Prenotazione prenotazione) {
        this.id = prenotazione.getId();
    }

    public PrenotazioneDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getCognomeUtente() {
        return cognomeUtente;
    }

    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getnStanza() {
        return nStanza;
    }

    public void setnStanza(String nStanza) {
        this.nStanza = nStanza;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public int getnPostazione() {
        return nPostazione;
    }

    public void setnPostazione(int nPostazione) {
        this.nPostazione = nPostazione;
    }
}
