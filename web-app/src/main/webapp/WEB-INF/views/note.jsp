<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" language="java" %>

<html>
<head>
    <title>Урпавление заметкой</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>
<body>
<div class="generic-container">
    <div class="well lead">Добавление новой заметки</div>
    <%--@elvariable id="note" type="com.gavrilov.model.Note"--%>
    <form:form method="POST" modelAttribute="note" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <input type="hidden" value="${note.user.id}" name="userId"/>

        <c:choose>
            <c:when test="${edit}">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="description">Identicon</label>
                        <div class="col-md-7">
                            <img width="200" height="100" src="<c:url value="/DisplayImageServlet?ID=${note.id}"/>"/>
                        </div>
                    </div>
                </div>
            </c:when>
        </c:choose>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">Наименование</label>
                <div class="col-md-7">
                    <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="description">Описание</label>
                <div class="col-md-7">
                    <form:input type="text" path="description" id="description" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="description" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Обновить" class="btn btn-primary btn-sm"/> или <a
                            href="<c:url value='/noteList'/>" class="btn btn-danger custom-width">Отмена</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Добавить" class="btn btn-primary btn-sm"/> или <a
                            href="<c:url value='/noteList'/>" class="btn btn-danger custom-width">Отмена</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
