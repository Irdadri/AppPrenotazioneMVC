package com.appprenotazione.controller;
import com.appprenotazione.DAO.PrenotazioneDAO;
import com.appprenotazione.DAO.UserDAO;
import com.appprenotazione.dto.PrenotazioneDTO;
import com.appprenotazione.model.Prenotazione;
import com.appprenotazione.model.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;
    private PrenotazioneDAO prenotazioneDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userDAO = new UserDAO();
        this.prenotazioneDAO = new PrenotazioneDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        boolean error = false;
        try {
            Utente utenteLogin = userDAO.loginUtente(email, password);
            if (utenteLogin != null) {
                error = false;
                if (utenteLogin.getTipoUtente().equals("manager")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/managerDashboard.jsp");
                    List<PrenotazioneDTO> prenotazioneList = prenotazioneDAO.getAllPrenotazioni();
                    request.setAttribute("listaPrenotazione", prenotazioneList);
                    session.setAttribute("utenteLoggato", utenteLogin);
                    dispatcher.forward(request, response);
                } else if (utenteLogin.getTipoUtente().equals("user")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/userDashboard.jsp");
                    List<PrenotazioneDTO> prenotazioneList = prenotazioneDAO.getPrenotazioniUtente(utenteLogin);
                    request.setAttribute("listaPrenotazione", prenotazioneList);
                    session.setAttribute("utenteLoggato", utenteLogin);
                    dispatcher.forward(request, response);
                }
            } else {
                error = true;
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                request.setAttribute("error", error);
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
