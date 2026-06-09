<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form action="managerServlet" method="POST">
    <table>
        <tr>
            <td>nome</td>
            <td><input type="text" name="nome"></td>
        </tr>
        <tr>
            <td>cognome</td>
            <td><input type="text" name="cognome"></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>telefono</td>
            <td><input type="text" name="telefono"></td>
        </tr>
        <tr>
            <td>tipo utente</td>
            <td><input type="text" name="tipoUtente"></td>
        </tr>
        <%--
            <td>citta</td>
            <td><input type="text" name="citta"></td>
        </tr> modifica con form action datalist --%>

        <tr>
            <td>citta</td>
            <td>
                <select name="sede">
                    <c:forEach var="listaSedi" items="${listaSedi}">
                        <option value="${listaSedi.id}">${listaSedi.citta} + ${listaSedi.indirizzo}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" name="Salva"/></td>
        </tr>
    </table>
</form>
</body>
</html>
