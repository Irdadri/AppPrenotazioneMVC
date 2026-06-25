package com.appprenotazione.config;

import com.appprenotazione.entities.Postazione;
import com.appprenotazione.entities.Prenotazione;
import com.appprenotazione.entities.Utente;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomPrenotazioneSerializer extends StdSerializer<Prenotazione> {
    public CustomPrenotazioneSerializer() {
        this(null);
    }

    public CustomPrenotazioneSerializer(Class<Prenotazione> t) {
        super(t);
    }

    @Override
    public void serialize(
            Prenotazione prenotazione, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", prenotazione.getId());
        jsonGenerator.writeStringField("dataInizio", prenotazione.getDataInizio().toString());
        jsonGenerator.writeStringField("dataFine", prenotazione.getDataFine().toString());
        jsonGenerator.writeStringField("stato", prenotazione.getStato());
        Utente utente = prenotazione.getUtente();
        if(utente != null){
        jsonGenerator.writeStringField("utente", prenotazione.getUtente().getNome());
        } else {
            jsonGenerator.writeStringField("utente", null);
        }
        Postazione postazione = prenotazione.getPostazione();
        if(postazione != null) {
            jsonGenerator.writeNumberField("postazione", prenotazione.getPostazione().getId());
        } else {
            jsonGenerator.writeStringField("postazione", null);
        }
        jsonGenerator.writeEndObject();
    }
}
