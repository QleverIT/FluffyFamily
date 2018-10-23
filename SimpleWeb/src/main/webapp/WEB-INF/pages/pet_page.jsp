<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Страница питомца</title>
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
                     height="150" alt=""/>
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

<div class="row">
    <div class="col-sm-3 col-sm-offset-2">
        <div class="shopper-info">
            <br></br>


            <img src="${petForm.passImg}" width="270"
                 height="200">

            <p></p>

            <u><h5>Имя питомца:</h5></u>
            ${petForm.name}

            <u><h5>Питомец:</h5></u>

            ${petForm.type}


            <u><h5>Пол питомца:</h5></u>

            ${petForm.gender}


            <u><h5>Возраст питомца (мес.):</h5></u>
            ${petForm.age}
            месяцев


            <u><h5>Характер питомца:</h5></u>
            ${petForm.character}

            <u><h5>Окрас питомца:</h5></u>
            ${petForm.color}


            <u><h5>Цена на питомца:</h5></u>
            ${petForm.price}


        </div>
    </div>

    <div class="col-sm-3 col-sm-offset 4">
        <br class="bill-to">


        <br class="form-one">


        <u><h5>Умения питомца:</h5></u>
        ${petForm.training}


        <u><h5>Цвет глаз питомца:</h5></u>
        ${petForm.eyeColor}


        <u><h5>Краткое описание:</h5></u>
        ${petForm.annotation}


        <u><h5>Описание:</h5></u>
        ${petForm.about}


        <u><h5>Контакт:</h5></u>
        ${petForm.contact}
        <br></br>
        <p>
            <c:if test="${ret=='pub'}">
                <a href="/simple-web/pet/find_pets/more/return">Вернуться к поиску</a>
            </c:if>
            <c:if test="${ret.equals('user')}">
                <a href="/simple-web/pet/lk_user/view/return">Вернуться в личный кабинет</a>
            </c:if>
            <c:if test="${ret.equals('moder')}">
                <a href="/simple-web/pet/lk_moderator/view/return">Вернуться в личный кабинет</a>
            </c:if>
        </p>
    </div>
</div>


</body>
</html>
