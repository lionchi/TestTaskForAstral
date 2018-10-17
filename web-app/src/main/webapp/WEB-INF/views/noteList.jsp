<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" language="java" %>

<html>
<head>
    <title>Список заметок</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>
<body>
<div class="panel-heading"><span class="lead">Список заметок</span></div>
<table class="table table-hover">
    <thead>
    <tr>
        <th width="100">Наименование</th>
        <th width="100">Описание</th>
        <th width="100"></th>
        <th width="100"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${notes}" var="note">
        <tr>
            <td>${note.name}</td>
            <td>${note.description}</td>
            <td><a href="<c:url value='/edit-note-${note.id}' />"class="btn btn-success custom-width">редактор</a></td>
            <td><a href="<c:url value='/delete-note-${note.id}' />"class="btn btn-danger custom-width">удалить</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<div class="well">
    <a href="<c:url value='/newnote' />"class="btn btn-success">Добавить новую заметку</a>
</div>
<form action="/logout" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input type="submit" class="btn btn-danger custom-width" value="Выход">
</form>
</body>
</html>
