package com.appprenotazione.model;

import java.time.LocalDateTime;

public class Prenotazione {
    private int id;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private String stato;
    private Utente utente;
    private Postazione postazione;

    public Prenotazione(int id, LocalDateTime dataInizio, LocalDateTime dataFine, String stato, Utente utente, Postazione postazione) {
        this.id = id;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
        this.utente = utente;
        this.postazione = postazione;
    }

    public Prenotazione() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }
}
