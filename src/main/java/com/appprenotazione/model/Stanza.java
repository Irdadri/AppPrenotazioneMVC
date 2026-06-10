package com.appprenotazione.model;

import java.util.List;

public class Stanza {
    private int id;
    private String nStanza;
    private List<Postazione> listaPostazioni;
    private Sede sede;

    public Stanza(int id, String nStanza, List<Postazione> listaPostazioni, Sede sede) {
        this.id = id;
        this.nStanza = nStanza;
        this.listaPostazioni = listaPostazioni;
        this.sede = sede;
    }

    public Stanza() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnStanza() {
        return nStanza;
    }

    public void setnStanza(String nStanza) {
        this.nStanza = nStanza;
    }

    public List<Postazione> getListaPostazioni() {
        return listaPostazioni;
    }

    public void setListaPostazioni(List<Postazione> listaPostazioni) {
        this.listaPostazioni = listaPostazioni;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
