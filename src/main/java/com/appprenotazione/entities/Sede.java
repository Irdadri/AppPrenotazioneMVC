package com.appprenotazione.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sede")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "paese")
    private String paese;

    @Column(name = "citta")
    private String citta;

    @Column(name = "regione")
    private String regione;

    @Column(name = "indirizzo")
    private String indirizzo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sede")
    private List<Utente> utentiSede;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sede")
    private List<Stanza> listStanze;


    public Sede(int id, String paese, String citta, String regione, String indirizzo, List<Utente> utentiSede, List<Stanza> listStanze) {
        this.id = id;
        this.paese = paese;
        this.citta = citta;
        this.regione = regione;
        this.indirizzo = indirizzo;
        this.utentiSede = utentiSede;
        this.listStanze = listStanze;
    }

    public Sede() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<Utente> getUtentiSede() {
        return utentiSede;
    }

    public void setUtentiSede(List<Utente> utentiSede) {
        this.utentiSede = utentiSede;
    }

    public List<Stanza> getListStanze() {
        return listStanze;
    }

    public void setListStanze(List<Stanza> listStanze) {
        this.listStanze = listStanze;
    }
}
