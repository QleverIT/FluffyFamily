<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Редактирование анкеты питомца</title>
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

<spring:form modelAttribute="petEditForm" method="post" action="/simple-web/pet/lk_moderator/edit_pet/working">

<div class="row">
    <div class="col-sm-3 col-sm-offset-2">
        <div class="shopper-info">
            <br></br>
            <h5>Питомец :</h5>
                ${petForm.type}
                <spring:checkbox path="type"/>


            <h5>Пол :</h5>
                ${petForm.gender}
                <spring:checkbox path="gender"/>


            <h5>Возраст :</h5>
                ${petForm.age}
            месяцев
                <spring:checkbox path="age"/>


            <h5>Характер :</h5>
                ${petForm.character}
                <spring:checkbox path="character"/>


            <h5>Умения :</h5>
                ${petForm.training}
                <spring:checkbox path="training"/>


            <h5>Цвет глаз :</h5>
                ${petForm.eyeColor}
                <spring:checkbox path="eyeColor"/>


            <h5>Окрас :</h5>
                ${petForm.color}
                <spring:checkbox path="color"/>


            <h5>Цена :</h5>
                ${petForm.price}
                <spring:checkbox path="price"/>


            <h5>Имя :</h5>
                ${petForm.name}
                <spring:checkbox path="name"/>


            <h5>Краткое описание :</h5>
                ${petForm.annotation}
                <spring:checkbox path="annotation"/>


            <h5>Описание :</h5>
                ${petForm.about}
                <spring:checkbox path="about"/>


            <h5>Контакт :</h5>
                ${petForm.contact}
                <spring:checkbox path="contact"/>


            <h5>Фотография :</h5>
                ${petForm.passImg}
                <spring:checkbox path="img"/>


            <h5>Сообщение пользователю:<h5>
                    <spring:input path="message"/>

                <spring:button>Сохранить</spring:button>
                </spring:form>

                <a href="/simple-web/pet/lk_moderator/edit/return">Вернуться в личный кабинет</a>
</body>
</html>
