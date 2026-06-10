package com.appprenotazione.model;

import javafx.geometry.Pos;

import java.util.List;

public class Postazione {
    private int id;
    private boolean manutenzione;
    private Stanza stanza;
    private List<Prenotazione> listaPrenotazioni;

    public Postazione(int id, boolean manutenzione, Stanza stanza, List<Prenotazione> listaPrenotazioni) {
        this.id = id;
        this.manutenzione = manutenzione;
        this.stanza = stanza;
        this.listaPrenotazioni = listaPrenotazioni;
    }

    public Postazione(){
        //
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isManutenzione() {
        return manutenzione;
    }

    public void setManutenzione(boolean manutenzione) {
        this.manutenzione = manutenzione;
    }

    public Stanza getStanza() {
        return stanza;
    }

    public void setStanza(Stanza stanza) {
        this.stanza = stanza;
    }

    public List<Prenotazione> getListaPrenotazioni() {
        return listaPrenotazioni;
    }

    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        this.listaPrenotazioni = listaPrenotazioni;
    }
}
