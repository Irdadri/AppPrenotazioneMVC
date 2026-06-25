package com.appprenotazione.controller;

import com.appprenotazione.config.CustomPrenotazioneSerializer;
import com.appprenotazione.config.JacksonConfig;
import com.appprenotazione.dto.*;
import com.appprenotazione.entities.Prenotazione;
import com.appprenotazione.entities.Utente;
import com.appprenotazione.service.PrenotazioneService;
import com.appprenotazione.service.SedeService;
import com.appprenotazione.service.StanzaService;
import com.appprenotazione.service.UtenteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    public static final Logger log = LoggerFactory.getLogger(DashboardController.class);

    private final StanzaService stanzaService;
    private final ModelMapper modelMapper;
    private SedeService sedeService;
    private PrenotazioneService prenotazioneService;
    UtenteService utenteService;

    public DashboardController(UtenteService utenteService, SedeService sedeService, PrenotazioneService prenotazioneService, StanzaService stanzaService, ModelMapper modelMapper) {
        this.utenteService = utenteService;
        this.sedeService = sedeService;
        this.prenotazioneService = prenotazioneService;
        this.stanzaService = stanzaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String getManagerDashboard(ModelMap modelMap, @SessionAttribute("utente") Utente utente) {
        if (utente.getTipoUtente().equals("manager")) {
            modelMap.addAttribute("prenotazioni", prenotazioneService.getAllPrenotazioni());
            return "managerDashboard";
        } else {
            modelMap.addAttribute("prenotazioni", prenotazioneService.getPrenotazioniUtente(utente));
            return "userDashboard";
        }
    }

    @GetMapping("/signup")
    public String getCreaUtente(ModelMap modelMap) {
        modelMap.addAttribute("nuovoUtente", new UtenteRequest());
        modelMap.addAttribute("listaSedi", sedeService.getAllSedi());
        return "createUser";
    }

    @PostMapping("/signup")
    public String creaUtente(ModelMap modelMap,
                             @Valid @ModelAttribute("nuovoUtente") UtenteRequest utenteRequest,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("nuovoUtente", utenteRequest);
            modelMap.addAttribute("listaSedi", sedeService.getAllSedi());
            return "createUser";
        }

        utenteService.inserisciUtente(utenteRequest);
        return "redirect:/dashboard/listautenti";
    }

    @GetMapping("/listautenti")
    public String getListaUtenti(ModelMap modelMap) {
        modelMap.addAttribute("listaUtenti", utenteService.getAllUtenti());
        return "listaUtenti";
    }

    //prenota una postazione
    @GetMapping("/prenotazione")
    public String getPrenotazioniForm(ModelMap modelMap, @SessionAttribute("utente") Utente utente) {
        modelMap.addAttribute("prenotazioniForm", new PrenotazioneRequest());
        modelMap.addAttribute("listaStanze", stanzaService.getStanzeBySede(utente.getSede()));
        return "prenotazione";
    }

    @PostMapping(value = "/prenotazione",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<PrenotazioneDTO> insertPrenotazioneAjax(@SessionAttribute("utente") Utente utente,
                                                                  ModelMap modelMap,
                                                                  @Valid @RequestBody PrenotazioneRequest prenotazioneRequest,
                                                                  BindingResult bindingResult, Model model) throws IOException {
        SimpleResponse msg = new SimpleResponse();

        if (bindingResult.hasErrors()) {
            msg.setMsg(bindingResult.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));

            modelMap.addAttribute("prenotazioniForm", prenotazioneRequest);
            modelMap.addAttribute("listaStanze", stanzaService.getStanzeBySede(utente.getSede()));
            return ResponseEntity.badRequest().build();
        }

        Prenotazione p = prenotazioneService.insertPrenotazione(prenotazioneRequest, utente);
        PrenotazioneDTO dto = modelMapper.map(p, PrenotazioneDTO.class);
        log.info("object created");
        msg.setMsg("inserimento riuscito");

        return ResponseEntity.ok(dto);
    }

}
