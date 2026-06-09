<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Adriana
  Date: 08/06/2026
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/mytld.tld" prefix="com" %>
<head>
    <title>Welcome</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

<com:userDataTag utente="${utenteLoggato}"/>


<h3>Le tue prenotazioni</h3>
<div>
    <table class="table-prenotazioni">
        <tr>
            <th>numero prenotazione</th>
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
</body>
</html>
