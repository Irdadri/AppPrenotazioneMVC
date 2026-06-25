package com.appprenotazione.config;

import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.entities.Postazione;
import com.appprenotazione.entities.Prenotazione;
import com.appprenotazione.entities.Utente;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Primary
public class CustomDataSerializer extends StdSerializer<PrenotazioneDTO> {
    public CustomDataSerializer() {
        this(null);
    }

    public CustomDataSerializer(Class<PrenotazioneDTO> t) {
        super(t);
    }

    @Override
    public void serialize(
            PrenotazioneDTO prenotazione, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", prenotazione.getId());
        jsonGenerator.writeStringField("nomeUtente", prenotazione.getNomeUtente());
        jsonGenerator.writeStringField("cognomeUtente", prenotazione.getCognomeUtente());
        jsonGenerator.writeStringField("citta", prenotazione.getCitta());
        jsonGenerator.writeStringField("indirizzo", prenotazione.getIndirizzo());
        jsonGenerator.writeStringField("nStanza", prenotazione.getnStanza());
        jsonGenerator.writeNumberField("nPostazione", prenotazione.getnPostazione());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        jsonGenerator.writeStringField("dataInizio", prenotazione.getDataInizio().format(formatter));
        jsonGenerator.writeStringField("dataFine", prenotazione.getDataFine().format(formatter));

        jsonGenerator.writeStringField("stato", prenotazione.getStato());
        jsonGenerator.writeEndObject();
    }
}
