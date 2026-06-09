package com.appprenotazione.model;

public class Sede {
    private int id;
    private String paese;
    private String citta;
    private String regione;
    private String indirizzo;

    public Sede() {
    }

    public Sede(int id, String paese, String citta, String regione, String indirizzo) {
        this.id = id;
        this.paese = paese;
        this.citta = citta;
        this.regione = regione;
        this.indirizzo = indirizzo;
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
}
