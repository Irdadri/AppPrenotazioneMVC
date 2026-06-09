package com.appprenotazione.controller;

import com.appprenotazione.dto.UtenteDTO;
import com.appprenotazione.model.Sede;
import com.appprenotazione.model.Utente;
import com.appprenotazione.utils.UtenteUtils;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "managerServlet", value = "/managerServlet")
public class ManagerServlet extends HttpServlet {
    private UtenteUtils utils;

    @Resource(name = "jdbc/app_prenotazione")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            utils = new UtenteUtils(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sede> listaSedi = utils.getAllSedi();
        request.setAttribute("listaSedi", listaSedi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/createUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sedeId = Integer.parseInt(request.getParameter("sede"));

        Utente utente = new Utente(request.getParameter("nome"), request.getParameter("cognome"), request.getParameter("email"),
                request.getParameter("password"), request.getParameter("telefono"), request.getParameter("tipoUtente"),
                sedeId);
        try {
            utils.inserisciUtente(utente);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
