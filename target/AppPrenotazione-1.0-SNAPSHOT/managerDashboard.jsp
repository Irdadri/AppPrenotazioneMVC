<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/mytld.tld" prefix="com" %>
<html>

<head>
    <title>Welcome</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

<com:userDataTag utente="${utenteLoggato}"/>


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
            <th>data inizio</th>
            <th>data fine</th>
            <th>stato</th>
        </tr>
        <c:forEach var="prenotazione" items="${listaPrenotazione}">
            <tr>
                <td>${prenotazione.id} </td>
                <td>${prenotazione.nomeUtente}</td>
                <td>${prenotazione.cognomeUtente}</td>
                <td>${prenotazione.citta}</td>
                <td>${prenotazione.indirizzo}</td>
                <td>${prenotazione.nStanza}</td>
                <td>${prenotazione.dataInizio}</td>
                <td>${prenotazione.dataFine}</td>
                <td>${prenotazione.stato}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<%--
<c:set var="tipoUtente" value="${utenteLoggato.tipoUtente}"/>
<c:set var="checkUtente" value="manager"/>
<c:if test="${ tipoUtente eq checkUtente }">
</c:if>
--%>
<a href="managerServlet">
    <button>Crea Utente</button>
</a>

</body>
</html>
