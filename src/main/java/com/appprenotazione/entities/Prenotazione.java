package com.appprenotazione.entities;

import com.appprenotazione.config.CustomPrenotazioneSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "prenotazione")
//@JsonSerialize(using = CustomPrenotazioneSerializer.class)
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;

    @Column(name = "data_fine")
    private LocalDateTime dataFine;

    @Column(name = "stato")
    private String stato;

    @ManyToOne
    @JoinColumn(name = "id_utente", referencedColumnName = "id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_postazione", referencedColumnName = "id")
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
