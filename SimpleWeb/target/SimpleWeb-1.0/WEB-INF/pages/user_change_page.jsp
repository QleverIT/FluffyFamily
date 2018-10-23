
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form modelAttribute="user" method="post" action="/simple-web/user/lk_admin/user_change" class="login-form">
<p>
    <label>Логин</label>
    <spring:input path="login" type="text" name="login" value="${user.login}"/>
    <spring:errors path="login" cssClass="error" />
    <a class="error">${errorLogin}</a>
</p>
<p>
    <label>Email</label>
    <spring:input path="email" type="text" name="email" value="${user.email}"/>
    <spring:errors path="email" cssClass="error" />
    <a class="error">${errorEmail}</a>
</p>
<p>
    <label>Пароль</label>
    <spring:input path="password" type="text" name="password" value="${user.password}"/>
    <spring:errors path="password" cssClass="error" />
</p>
<p>
    <label>Имя Отчество в дательном падеже: пишите на почту</label>
    <spring:input path="nameAndMiddleName" type="text" name="nameAndMiddleName" value="${user.nameAndMiddleName}"/>
    <spring:errors path="nameAndMiddleName" cssClass="error" />
</p>
<p>
    <spring:button>
        Сохранить изменения
    </spring:button>
</p>
</spring:form>
<a href="/simple-web/user/lk_admin/delete_user">Удалить пользователя</a>
<a href="/simple-web/user/lk_admin/find_user/return">Вернуться в личный кабинет</a>
</body>
</html>
