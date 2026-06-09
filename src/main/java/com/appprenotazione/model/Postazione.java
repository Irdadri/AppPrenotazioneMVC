package com.appprenotazione.model;

public class Postazione {
    private int id;
    private int idStanza;
    private boolean manutenzione;

    public Postazione() {
    }

    public Postazione(int id, int idStanza, boolean manutenzione) {
        this.id = id;
        this.idStanza = idStanza;
        this.manutenzione = manutenzione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStanza() {
        return idStanza;
    }

    public void setIdStanza(int idStanza) {
        this.idStanza = idStanza;
    }

    public boolean isManutenzione() {
        return manutenzione;
    }

    public void setManutenzione(boolean manutenzione) {
        this.manutenzione = manutenzione;
    }
}
