package com.appprenotazione.entities;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "postazione")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "manutenzione")
    private boolean manutenzione;

    @ManyToOne
    @JoinColumn(name = "id_stanza", referencedColumnName = "id")
    private Stanza stanza;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postazione")
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
