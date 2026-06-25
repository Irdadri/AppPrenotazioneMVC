package com.appprenotazione.utils;

import com.appprenotazione.entities.Utente;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class UserDataTag extends SimpleTagSupport {
    private Utente utente;

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        //out.println("<details>");
//        out.println("<summary>");
//        out.println("dettagli utente");
//        out.println("</summary>");

        out.println("<table class=\"table-user\">");

        out.println("<tr>");
        out.println("<td>");
        out.println(utente.getNome());
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.println(utente.getCognome());
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.println(utente.getEmail());
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.println(utente.getTelefono());
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.println(utente.getTipoUtente());
        out.println("</td>");
        out.println("</tr>");

        out.println("</table>");

       // out.println("<a href= \"<spring:url value=\"/logout\"/> method=\"GET\">\" " + "<button>logout</button>" + "</a>");
        //<a href="${pageContext.request.contextPath}/logout">logout</a>

        //out.println("<a href=\"${pageContext.request.contextPath}/logout\">" + "<button>logout</button>" + "</a>");
       // out.println("</details>");
    }
}
