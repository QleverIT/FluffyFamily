<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Регистрация прошла успешно</title>
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
            <li><a href="/simple-web/authorize">Вход</a></li>
            <li><a href="/simple-web/user/registration">Регистрация пользователя</a></li>
            <li><a href="/simple-web/pet/find_pets">Поиск питомца</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <h3>Регистрация прошла успешно.</h3>
            <h5>Логин: ${moderator.login}</h5>
            <h5>Никнейм: ${moderator.nickname}</h5>
            <h5>Пароль: ${moderator.password}</h5>
            <br></br>
            <a href="/simple-web/moderator/registration/return" class="btn btn-default">Готово</a>
        </div>
    </div>
</div>


</body>
</html>
