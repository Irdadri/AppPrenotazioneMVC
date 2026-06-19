package com.appprenotazione.controller;

import com.appprenotazione.dto.LoginRequest;
import com.appprenotazione.entities.Utente;
import com.appprenotazione.service.PrenotazioneService;
import com.appprenotazione.service.UtenteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("utente")
public class LoginController {

    private final PrenotazioneService prenotazioneService;
    private UtenteService utenteService;

    public LoginController(UtenteService utenteService, PrenotazioneService prenotazioneService) {
        this.utenteService = utenteService;
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping("/")
    public String getLoginPage(ModelMap modelMap) {
        modelMap.addAttribute("loginForm", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String utenteLogin(ModelMap model,
                              @Valid @ModelAttribute("loginForm") LoginRequest loginRequest,
                              BindingResult result) {

        if (result.hasErrors()) {
            return "login";
        }

        Utente utente = utenteService.loginUtente(loginRequest.getEmail(), loginRequest.getPassword());
        boolean error = false;

        if (utente != null) {
            error = false;
            model.addAttribute("utente", utente);
            return "redirect:/dashboard/";
        } else {
            error = true;
            model.addAttribute("error", error);
            return "login";
        }

    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }

}
