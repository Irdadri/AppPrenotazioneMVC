<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<h1>Benvenuto in Prenota la tua Postazione</h1>
<div>
    <h3>Accedi</h3>

    <form action="loginServlet" method="POST">
        <table class="table-login">
            <tr>
                <td>email</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Accedi"/></td>
            </tr>
        </table>
    </form>
</div>
<div>
    <c:set var="error" value="${error}"/>
    <c:if test="${error}">
        <h3>email o password errati</h3>
    </c:if>
</div>
</body>
</html>
