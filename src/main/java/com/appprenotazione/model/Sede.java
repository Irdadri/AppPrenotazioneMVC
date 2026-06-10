package com.appprenotazione.model;

import java.util.List;

public class Sede {
    private int id;
    private String paese;
    private String citta;
    private String regione;
    private String indirizzo;

    private List<Utente> utentiSede;
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
