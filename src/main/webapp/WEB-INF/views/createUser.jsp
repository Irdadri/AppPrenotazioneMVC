<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Adriana
  Date: 05/06/2026
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserimento Utente</title>
</head>
<body>
<h3>Inserisci i dati</h3>

<form:form action="signup" method="POST" modelAttribute="nuovoUtente">
    <form:errors path="*"/>
    <table>
        <tr>
            <td>nome</td>
            <td><form:input type="text" id="nome" path="nome"/>
                <form:errors path="nome"/>
            </td>
        </tr>
        <tr>
            <td>cognome</td>
            <td><form:input type="text" id="cognome" path="cognome"/>
                <form:errors path="cognome"/>
            </td>
        </tr>
        <tr>
            <td>email</td>
            <td><form:input type="text" id="email" path="email"/>
                <form:errors path="email"/>
            </td>
        </tr>
        <tr>
            <td>password</td>
            <td><form:input type="password" id="password" path="password"/>
                <form:errors path="password"/>
            </td>
        </tr>
        <tr>
            <td>telefono</td>
            <td><form:input type="text" id="telefono" path="telefono"/>
                <form:errors path="telefono"/>
            </td>
        </tr>
        <tr>
            <td>tipo utente</td>
            <td><form:input type="text" id="tipoUtente" path="tipoUtente"/>
                <form:errors path="tipoUtente"/>
            </td>
        </tr>
        <tr>
            <td>citta</td>
            <td>
                <form:select id="idSede" path="idSede">
                    <form:option value="${null}" label="--seleziona sede--"/>
                    <c:forEach var="sede" items="${listaSedi}">

                        <form:option value="${sede.id}" label="${sede.citta} + ${sede.indirizzo}"/>

                    </c:forEach>
                    <form:errors path="idSede"/>
                </form:select>
            </td>
        </tr>
        <tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" name="Salva"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
