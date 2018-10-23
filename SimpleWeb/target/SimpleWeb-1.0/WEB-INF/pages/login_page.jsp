<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Вход</title>
    <%--<link herf="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>--%>

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
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <ul class="nav navbar-nav">


            <li><a href="/simple-web/pet/find_pets">Поиск питомца</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <div class="login-form"><!--login form-->
                <br></br>
                <br></br>
                <h2>Войдите в свой аккаунт</h2>


                <spring:form modelAttribute="loginForm" method="post" action="/simple-web/authorize"
                             class="login-form">
                    <div class="control-group">
                        <p class="error">${errorMessage}</p>
                        <spring:input path="login" class="login-field" placeholder="Логин"/>
                        <spring:errors path="login" cssClass="error"/>
                        <label class="login-field-icon fui-user" for="login"></label>
                    </div>
                    <div class="control-group">
                        <spring:input path="password" class="login-field" placeholder="Пароль"/>
                        <spring:errors path="password" cssClass="error"/>
                        <label class="login-field-icon fui-lock" for="password"></label>
                    </div>
                    <p class="error">${errorMessage}</p>
                    <spring:button type="submit" class="btn btn-large btn-block">Войти</spring:button>
                    <a href="/simple-web/authorize/return"  class="btn btn-primary btn-large btn-block">Отмена</a>
                    <a class="btn" href="/simple-web/user/registration" role="button">Регистрация пользователя</a>


                </spring:form>
            </div>
        </div>
    </div>
</div>

</html>