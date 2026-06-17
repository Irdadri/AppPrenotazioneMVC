<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<h1>Benvenuto in Prenota la tua Postazione</h1>
<div>
    <h3>Accedi</h3>

    <form:form action="login" method="POST" modelAttribute="loginForm">
        <form:errors path="*"/>
        <table class="table-login">
            <tr>
                <td>email</td>
                <td>
                    <form:input type="text" id="email" path="email"/>
                    <form:errors path="email"/>
                </td>
            </tr>
            <tr>
                <td>password</td>
                <td>
                    <form:input type="password" id="password" path="password"/>
                    <form:errors path="password"/>
                </td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Accedi"/></td>
            </tr>
        </table>
    </form:form>
</div>
<div>
    <c:set var="error" value="${error}"/>
    <c:if test="${error}">
        <h3>email o password errati</h3>
    </c:if>
</div>
</body>
</html>
