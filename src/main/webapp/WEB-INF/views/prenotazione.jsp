<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="common/head.jspf" %>
<head>

    <title>Prenota una postazione</title>
</head>
<body>
<%@include file="common/navbar.jspf" %>

<div class="container" style="min-height: 500px">

    <div id="responseContent"></div>

    <div class="starter-template">
        <form:form id="prenotazioni-form" class="row g-3" modelAttribute="prenotazioniForm">
            <div class="col-md-6">
                <form:label path="nPostazione" class="form-label">Stanza</form:label>
                <form:select path="nPostazione" name="nPostazione" class="form-select">

                    <form:option value="">-- seleziona postazione --</form:option>

                    <c:forEach var="stanza" items="${listaStanze}">

                        <optgroup label="Stanza ${stanza.nStanza}">

                            <c:forEach var="postazione" items="${stanza.listaPostazioni}">
                                <form:option value="${postazione.id}">
                                    Postazione ${postazione.id}
                                </form:option>
                                <form:errors path="nPostazione" cssClass="text-danger"/>
                            </c:forEach>

                        </optgroup>

                    </c:forEach>

                </form:select>
            </div>


            <div class="col-md-6">
                <form:label path="dataInizio" class="form-label">giorno</form:label>
                <form:input path="dataInizio" type="datetime-local" class="form-control"/>
                <form:errors path="dataInizio" cssClass="text-danger"/>

            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" id="btn-search"
                            class="btn btn-primary btn-lg">Prenota
                    </button>
                </div>
            </div>
        </form:form>
    </div>
</div>

<div class="modal fade" id="submitModal" tabindex="-1" aria-labelledby="submitModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title" id="submitModalLabel">Prenotazione effettuata</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body" id="modalBody">
                ---
            </div>

            <div class="modal-footer flex-column align-items-stretch w-100 gap-2 pb-3 border-top-0">
                <button type="button" class="btn btn-lg btn-primary" id="dashboardButton">ritorna alla dashboard
                </button>
                <button type="button" class="btn btn-lg btn-primary" id="nuovaPrenotazione">prenota un'altra
                    postazione
                </button>
            </div>
            <!--
            <div class="modal-footer">
                <div class="d-grid gap-2">
                    posso provare a mettere dei button e main.js in ascolto

                </div>
            </div>
            -->
        </div>
    </div>
</div>
</body>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript" src="<c:url value="/static/css/main.js" />"></script>
<script>const contextPath = '${pageContext.request.contextPath}';</script>


</html>
