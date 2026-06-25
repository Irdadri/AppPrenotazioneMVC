<%--
  Created by IntelliJ IDEA.
  User: Adriana
  Date: 23/06/2026
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="common/head.jspf" %>
<body>

<%@include file="common/navbar.jspf" %>


<div class="container-fluid">


    <div class="row">
        <div class="sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary">
            <div class="offcanvas-md offcanvas-end bg-body-tertiary" tabindex="-1" id="sidebarMenu"
                 aria-labelledby="sidebarMenuLabel">
                <div class="offcanvas-body d-md-flex flex-column p-0 pt-lg-3 overflow-y-auto">
                    <ul class="nav flex-column">

                        <li class="nav-item">
                            <a href="signup" class="nav-link d-flex align-items-center gap-2">
                                Crea Utente
                            </a>
                        </li>
                        <li class="nav-item">

                            <a href="<spring:url value="/dashboard/prenotazione" /> "
                               class="nav-link d-flex align-items-center gap-2">
                                Prenota Postazione
                            </a>
                        </li>

                        <li class="nav-item">

                            <a href="<spring:url value="/dashboard/" /> "
                               class="nav-link d-flex align-items-center gap-2">
                                Indietro
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>


        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Lista utenti</h1>
            </div>
            <div class="table-responsive small">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>nome utente</th>
                        <th>cognome utente</th>
                        <th>email</th>
                        <th>telefono</th>
                        <th>tipo utente</th>
                        <th>paese</th>
                        <th>citta</th>
                        <th>regione</th>
                        <th>indirizzo</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="utente" items="${listaUtenti}">
                        <tr>
                            <td>${utente.nome}</td>
                            <td>${utente.cognome}</td>
                            <td>${utente.email}</td>
                            <td>${utente.telefono}</td>
                            <td>${utente.tipoUtente}</td>
                            <td>${utente.paese}</td>
                            <td>${utente.citta}</td>
                            <td>${utente.regione}</td>
                            <td>${utente.indirizzo}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>
</body>
</html>
