<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<h2>Авторизация</h2>
<form action="/authorization" method="post">
    <c:if test="${param.error != null}">
        <p style='color:red'>
            Неправильный пароль или логин.
        </p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p style='color:blue'>
            Вы вышли из системы.
        </p>
    </c:if>
    <p>
        <label for="username">Логин</label>
        <input type="text" id="username" name="username"/>
    </p>
    <p>
        <label for="password">Пароль</label>
        <input type="password" id="password" name="password"/>
    </p>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit">Вход</button> или <a href="<c:url value='/registration'/>">Зарегистрироваться</a>
</form>
</body>
</html>
