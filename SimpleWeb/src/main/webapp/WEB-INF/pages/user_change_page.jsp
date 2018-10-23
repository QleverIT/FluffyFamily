
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Редактирование пользователя</title>
    <style>

        <%@include file="/webcontent/css/bootstrap.min.css"%>
        <%@include file="/webcontent/css/font-awesome.min.css"%>
        <%@include file="/webcontent/css/main.css"%>

        <%@include file="/webcontent/css/responsive.css"%>

        .error {
            color: darkred;
        }
    </style>
    <script src="${pageContext.request.contextPath}/webcontent/js/jquery.js">
    </script>
    <script src="${pageContext.request.contextPath}/webcontent/js/bootstrap.min.js">
    </script>
    <script src="${pageContext.request.contextPath}/webcontent/js/html5shiv.js">
    </script>
    <script src="${pageContext.request.contextPath}/webcontent/js/jquery.scrollUp.min.js">
    </script>
    <script src="${pageContext.request.contextPath}/webcontent/js/main.js">
    </script>
</head>
<body>
<header class="container-fluid shadow1">

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-5 tel">

        </div>
        <div class="col=md-1"></div>
        <div class="col-md-3">
            <h1>Мохнатая семья</h1>
            <h5>Приюти друга!</h5>
        </div>
        <div class="col-sm-1">
            <div class="logo pull-left">
                <img src="https://openclipart.org/image/2400px/svg_to_png/265742/Grooming-Cat-Line-Art.png" width="150"
                     height="150" alt=""/></a>
            </div>
        </div>
    </div>

</header>
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
