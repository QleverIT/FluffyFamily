<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Просмотр модератора</title>
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
            <h3>Приюти друга!</h3>
        </div>
        <div class="col-sm-1">
            <div class="logo pull-left">
                <img src="https://openclipart.org/image/2400px/svg_to_png/265742/Grooming-Cat-Line-Art.png" width="150"
                     height="150" alt=""/></a>
            </div>
        </div>
    </div>

</header>
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-2">




            <!-- дописать параметры модератора все -->
            <p><h4>Логин:</h4> ${moderator.login}</p>
            <p><h4>Никнейм:</h4> ${moderator.nickname}</p>
            <p><h4>Пароль:</h4> ${moderator.password}</p>
            <p><h4>Почта:</h4> ${moderator.email}</p>
        </div>
        <div class="col-sm-4">
            <p><h4>Имя:</h4> ${moderator.name}</p>
            <p><h4>Фамилия:</h4> ${moderator.surname}</p>
            <p><h4>Отчество:</h4> ${moderator.middleName}</p>
            <p><h4>Пароль:</h4> ${moderator.password}</p>
            <p><h4>Телефон:</h4> ${moderator.telephone}</p>


            <a class="btn btn-primary" href="/simple-web/admin/lk" >Вернуться в личный кабинет</a>

        </div>
    </div>
</div>
</body>
</html>
