package com.appprenotazione.service;

import com.appprenotazione.entities.Sede;
import com.appprenotazione.entities.Stanza;

import java.util.List;

public interface StanzaService {
    public List<Stanza> getStanzeBySede(Sede sede);
 }
