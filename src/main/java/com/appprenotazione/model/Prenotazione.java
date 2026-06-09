package com.appprenotazione.model;

import java.time.LocalDateTime;

public class Prenotazione {
    private int id;
    private int idUtente;
    private int idPostazione;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private String stato;

    public Prenotazione() {
    }

    public Prenotazione(int id, int idUtente, int idPostazione, LocalDateTime dataInizio, LocalDateTime dataFine, String stato) {
        this.id = id;
        this.idUtente = idUtente;
        this.idPostazione = idPostazione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdPostazione() {
        return idPostazione;
    }

    public void setIdPostazione(int idPostazione) {
        this.idPostazione = idPostazione;
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
