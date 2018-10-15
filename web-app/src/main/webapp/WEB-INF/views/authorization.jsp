<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Авторизация</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>
<body>
<h3>Авторизация</h3>
<%--@elvariable id="user" type="com.gavrilov.model.dto.UserDTO"--%>
<form:form method="POST" action="/login-user" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="login">Login</form:label></td>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input  type="password" path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Вход"/></td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>
