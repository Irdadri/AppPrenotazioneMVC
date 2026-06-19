<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="/WEB-INF/mytld.tld" prefix="com" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<%@ include file="common/head.jspf" %>

<head>
    <title>Welcome</title>

</head>
<body>
<%@include file="common/navbar.jspf" %>


<div class="container-fluid">
    <div class="row">
        <div class="sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary">
            <div class="offcanvas-md offcanvas-end bg-body-tertiary" tabindex="-1" id="sidebarMenu"
                 aria-labelledby="sidebarMenuLabel">
                <div class="offcanvas-body d-md-flex flex-column p-0 pt-lg-3 overflow-y-auto">
                    <ul class="nav flex-column">
                        <li>
                            <com:userDataTag utente="${utente}"/>
                        </li>
                        <li>

                            <a href="<spring:url value="/logout" /> " class="btn btn-primary btn-lg">
                                logout
                            </a>
                        </li>

                        <li>
                            <a href="signup" class="btn btn-primary btn-lg">
                                Crea Utente
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Lista prenotazioni</h1>
            </div>
            <div class="table-responsive small">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>numero prenotazione</th>
                        <th>nome utente</th>
                        <th>cognome utente</th>
                        <th>citta</th>
                        <th>indirizzo</th>
                        <th>numero stanza</th>
                        <th>codice postazione</th>
                        <th>data inizio</th>
                        <th>data fine</th>
                        <th>stato</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="prenotazione" items="${prenotazioni}">
                        <tr>
                            <td>${prenotazione.id} </td>
                            <td>${prenotazione.nomeUtente}</td>
                            <td>${prenotazione.cognomeUtente}</td>
                            <td>${prenotazione.citta}</td>
                            <td>${prenotazione.indirizzo}</td>
                            <td>${prenotazione.nStanza}</td>
                            <td>${prenotazione.nPostazione}</td>
                            <td>${prenotazione.dataInizio}</td>
                            <td>${prenotazione.dataFine}</td>
                            <td>${prenotazione.stato}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>

    </div>

</div>


<!--
<div>
    <h3>tutte le prenotazioni</h3>
    <table class="table-prenotazioni">
        <tr>
            <th>numero prenotazione</th>
            <th>nome utente</th>
            <th>cognome utente</th>
            <th>citta</th>
            <th>indirizzo</th>
            <th>numero stanza</th>
            <th>codice postazione</th>
            <th>data inizio</th>
            <th>data fine</th>
            <th>stato</th>
        </tr>
        <%--
        <c:forEach var="prenotazione" items="${prenotazioni}">
            <tr>
                <td>${prenotazione.id} </td>
                <td>${prenotazione.nomeUtente}</td>
                <td>${prenotazione.cognomeUtente}</td>
                <td>${prenotazione.citta}</td>
                <td>${prenotazione.indirizzo}</td>
                <td>${prenotazione.nStanza}</td>
                <td>${prenotazione.nPostazione}</td>
                <td>${prenotazione.dataInizio}</td>
                <td>${prenotazione.dataFine}</td>
                <td>${prenotazione.stato}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<c:set var="tipoUtente" value="${utente.tipoUtente}"/>
<c:set var="checkUtente" value="manager"/>
<c:if test="${ tipoUtente eq checkUtente }">
</c:if>
--%>
<a href="signup">
    <button>Crea Utente</button>
</a>
-->
</body>
</html>
