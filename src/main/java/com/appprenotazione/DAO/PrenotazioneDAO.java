package com.appprenotazione.DAO;

import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.model.Prenotazione;
import com.appprenotazione.model.Utente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class PrenotazioneDAO {

    public List<PrenotazioneDTO> getAllPrenotazioni() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();


        List<Prenotazione> listaPrenotazioni = session.createQuery("from Prenotazione").list();
        List<PrenotazioneDTO> listaPrenotazioniDTO = new ArrayList<>();
        for (Prenotazione temp : listaPrenotazioni) {
            listaPrenotazioniDTO.add(new PrenotazioneDTO(temp, temp.getUtente(), temp.getPostazione().getStanza().getSede(),
                    temp.getPostazione().getStanza()));
        }

        return listaPrenotazioniDTO;
    }

    public List<PrenotazioneDTO> getPrenotazioniUtente(Utente utente) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();



        List<Prenotazione> listaPrenotazioni = session.createQuery("from Prenotazione p where p.utente = :utente ")
                .setParameter("utente", utente).list();
        List<PrenotazioneDTO> listaPrenotazioniDTO = new ArrayList<>();
        for (Prenotazione temp : listaPrenotazioni) {
            listaPrenotazioniDTO.add(new PrenotazioneDTO(temp, temp.getUtente(), temp.getPostazione().getStanza().getSede(),
                    temp.getPostazione().getStanza()));
        }

        return listaPrenotazioniDTO;
    }

}
