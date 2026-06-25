<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="common/head.jspf" %>
    <style>
        .form-signin {
            max-width: 330px;
            padding: 1rem;
        }
    </style>
</head>
<body class=" bg-body-tertiary">
<%@include file="common/navbar.jspf" %>
<div class="container-fluid">
    <main class="d-flex justify-content-center form-signin w-100 m-auto">
        <form:form action="login" method="POST" modelAttribute="loginForm">

            <h1 class="h3 mb-3 fw-normal">Accedi</h1>

            <div class="form-floating">

                <form:input type="email" id="floatingInput" path="email" class="form-control"/>
                <form:label path="email" for="floatingInput">indirizzo email</form:label>
                <form:errors path="email" cssClass="text-danger"/>
            </div>

            <div class="form-floating">
                <form:input type="password" id="floatingPassword" path="password" class="form-control"/>
                <form:label path="password" for="floatingPassword">password</form:label>
                <form:errors path="password" cssClass="text-danger"/>
            </div>

            <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>


        </form:form>

    </main>

    <div class="d-flex justify-content-center w-100 m-auto">
        <c:set var="error" value="${error}"/>
        <c:if test="${error}">
            <div class="alert alert-danger" role="alert">
                email o password errati
            </div>
        </c:if>
    </div>
</div>
</body>
<%@ include file="common/footer.jspf" %>
</html>
