package com.appprenotazione.entities;



import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stanza")
public class Stanza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "n_stanza")
    private String nStanza;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stanza")
    private List<Postazione> listaPostazioni;

    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id")
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
