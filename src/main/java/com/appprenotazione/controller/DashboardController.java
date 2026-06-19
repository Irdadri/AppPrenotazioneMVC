package com.appprenotazione.controller;

import com.appprenotazione.dto.UtenteDTO;
import com.appprenotazione.entities.Utente;
import com.appprenotazione.service.PrenotazioneService;
import com.appprenotazione.service.SedeService;
import com.appprenotazione.service.UtenteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private SedeService sedeService;
    private PrenotazioneService prenotazioneService;
    UtenteService utenteService;

    public DashboardController(UtenteService utenteService, SedeService sedeService, PrenotazioneService prenotazioneService) {
        this.utenteService = utenteService;
        this.sedeService = sedeService;
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping("/")
    public String getManagerDashboard(ModelMap modelMap , @SessionAttribute("utente") Utente utente){
        if(utente.getTipoUtente().equals("manager")){
            modelMap.addAttribute("prenotazioni", prenotazioneService.getAllPrenotazioni());
            return "managerDashboard";
        } else {
            modelMap.addAttribute("prenotazioni", prenotazioneService.getPrenotazioniUtente(utente));
            return "userDashboard";
        }
    }

    @GetMapping("/signup")
    public String getCreaUtente(ModelMap modelMap) {
        modelMap.addAttribute("nuovoUtente", new UtenteDTO());
        modelMap.addAttribute("listaSedi", sedeService.getAllSedi());
        return "createUser";
    }

    @PostMapping("/signup")
    public String creaUtente(ModelMap modelMap,
                             @Valid @ModelAttribute("nuovoUtente") UtenteDTO utenteDTO,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("nuovoUtente", utenteDTO);
            modelMap.addAttribute("listaSedi", sedeService.getAllSedi());
            return "createUser";
        }

        utenteService.inserisciUtente(utenteDTO);
        return "managerDashboard";
    }
}
