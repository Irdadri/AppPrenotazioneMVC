package com.appprenotazione.dto;

import java.time.LocalDateTime;

public class PrenotazioneDTO {
    private int id;
    private String nomeUtente;
    private String cognomeUtente;
    private String citta;
    private String indirizzo;
    private String nStanza;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private String stato;

    public PrenotazioneDTO(int id, String nomeUtente, String cognomeUtente, String citta, String indirizzo, String nStanza, LocalDateTime dataInizio, LocalDateTime dataFine, String stato) {
        this.id = id;
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.nStanza = nStanza;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
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
}
