<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="common/head.jspf" %>
<head>
    <title>Inserimento Utente</title>

    <style>
        @media (min-width: 768px) {
            .bd-example {
                --bd-example-padding: 1.5rem;
                margin-right: 0;
                margin-left: 0;
                border-width: 1px;
                border-radius: var(--bs-border-radius);
            }
        }
    </style>
</head>
<body>

<%@include file="common/navbar.jspf" %>

<h3>Inserisci i dati</h3>

<div class="bd-example m-0 border-0 p-lg-5 p-4">
    <form:form action="signup" method="POST" modelAttribute="nuovoUtente" class="row g-3">
        <div class="col-md-6">
            <form:label path="nome" for="inputName" class="form-label">nome</form:label>
            <form:input type="text" id="inputName" path="nome" class="form-control"/>
            <form:errors path="nome" cssClass="text-danger"/>
        </div>

        <div class="col-md-6">
            <form:label path="cognome" for="inputCognome" class="form-label">cognome</form:label>
            <form:input type="text" id="inputCognome" path="cognome" class="form-control"/>
            <form:errors path="cognome" cssClass="text-danger"/>
        </div>

        <div class="col-md-6">
            <form:label path="email" for="inputEmail" class="form-label">email</form:label>
            <form:input type="email" id="inputEmail" path="email" class="form-control"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>

        <div class="col-md-6">
            <form:label path="password" for="inputPassword" class="form-label">password</form:label>
            <form:input type="password" id="inputPassword" path="password" class="form-control"/>
            <form:errors path="password" cssClass="text-danger"/>
        </div>

        <div class="col-12">
            <form:label path="telefono" for="inputTelefono" class="form-label">telefono</form:label>
            <form:input type="text" id="inputTelefono" path="telefono" class="form-control"/>
            <form:errors path="telefono" cssClass="text-danger"/>
        </div>

        <div class="col-12">
            <form:label path="tipoUtente" for="tipoUtente" class="form-label">tipo utente</form:label>
            <form:input type="text" id="tipoUtente" path="tipoUtente" class="form-control"/>
            <form:errors path="tipoUtente" cssClass="text-danger"/>
        </div>

        <div class="col-md-6">
            <form:label path="tipoUtente" for="idSede" class="form-label">città</form:label>
            <form:select id="idSede" path="idSede">
                <form:option value="${null}" label="--seleziona sede--"/>
                <c:forEach var="sede" items="${listaSedi}">

                    <form:option value="${sede.id}" label="${sede.citta} + ${sede.indirizzo}"/>

                </c:forEach>
                <form:errors path="idSede"/>
            </form:select>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">Salva</button>
        </div>
    </form:form>
</div>
</body>
<%@ include file="common/footer.jspf" %>
</html>
