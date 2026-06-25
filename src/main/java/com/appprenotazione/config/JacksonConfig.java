package com.appprenotazione.config;


import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.entities.Prenotazione;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

//    @Bean
//    public Module modulePrenotazione(){
//        //ObjectMapper objectMapper = new ObjectMapper();
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(Prenotazione.class, new CustomPrenotazioneSerializer());
//        //objectMapper.registerModule(module);
//
//        //return objectMapper.writeValueAsString(p);
//        return module;
//    }


    public static final Logger log = LoggerFactory.getLogger(JacksonConfig.class);
    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Prenotazione.class, new CustomPrenotazioneSerializer());
        module.addSerializer(PrenotazioneDTO.class, new CustomDataSerializer());
        mapper.registerModule(module);
        log.info("hello");
        return mapper;
    }
}
