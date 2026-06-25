package com.appprenotazione.config;

import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.dto.UtenteDTO;
import com.appprenotazione.dto.UtenteRequest;
import com.appprenotazione.entities.Prenotazione;
import com.appprenotazione.entities.Utente;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper(){
       ModelMapper modelMapper = new ModelMapper();
       modelMapper.getConfiguration().setSkipNullEnabled(true)
        .setMatchingStrategy(org.modelmapper.convention.MatchingStrategies.STRICT);
        //specific config
       modelMapper.addMappings(prenotazioneDTOPropertyMap);
       modelMapper.addMappings(utentePropertyMap);
       modelMapper.addMappings(utenteDTOPropertyMap);

       return modelMapper;
    }

    PropertyMap<Prenotazione, PrenotazioneDTO> prenotazioneDTOPropertyMap = new PropertyMap<Prenotazione, PrenotazioneDTO>() {
        @Override
        protected void configure() {
            map().setNomeUtente(source.getUtente().getNome());
            map().setCognomeUtente(source.getUtente().getCognome());
            map().setCitta(source.getPostazione().getStanza().getSede().getCitta());
            map().setIndirizzo(source.getPostazione().getStanza().getSede().getIndirizzo());
            map().setnStanza(source.getPostazione().getStanza().getnStanza());
            map().setnPostazione(source.getPostazione().getId());
        }
    };

    PropertyMap<UtenteRequest, Utente> utentePropertyMap = new PropertyMap<UtenteRequest, Utente>() {
        @Override
        protected void configure() {
            map().getSede().setId(source.getIdSede());
        }
    };

    PropertyMap<Utente, UtenteDTO> utenteDTOPropertyMap = new PropertyMap<Utente, UtenteDTO>() {
        @Override
        protected void configure() {
            map().setPaese(source.getSede().getPaese());
            map().setCitta(source.getSede().getCitta());
            map().setRegione(source.getSede().getRegione());
            map().setIndirizzo(source.getSede().getIndirizzo());
        }
    };
}
