package com.appprenotazione.controller;

import com.appprenotazione.dto.UtenteDTO;
import com.appprenotazione.service.SedeService;
import com.appprenotazione.service.UtenteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManagerController {

    private final SedeService sedeService;
    UtenteService utenteService;

    public ManagerController(UtenteService utenteService, SedeService sedeService){
        this.utenteService = utenteService;
        this.sedeService = sedeService;
    }

    @GetMapping("/signup")
    public String getCreaUtente(ModelMap modelMap){
        modelMap.addAttribute("nuovoUtente", new UtenteDTO());
        modelMap.addAttribute("listaSedi", sedeService.getAllSedi());
        return "createUser";
    }

    @PostMapping("/signup")
    public String creaUtente(ModelMap modelMap,
                             @Valid @ModelAttribute("nuovoUtente") UtenteDTO utenteDTO,
                             BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "createUser";
        }

        utenteService.inserisciUtente(utenteDTO);
        return "managerDashboard";
    }
}
