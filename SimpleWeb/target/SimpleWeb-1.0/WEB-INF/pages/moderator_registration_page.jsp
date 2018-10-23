<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Регистрация модератора</title>
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
            <h4>Регистрация модератора</h4>
            <div class="login-form"><!--login form-->

                <spring:form modelAttribute="moderator" method="post" action="/simple-web/moderator/registration"
                             class="login-form">

                    <p>

                        <spring:input path="email" type="text" name="email" placeholder="Email"/>
                        <spring:errors path="email" cssClass="error"/>
                        <label class="error">${errorEmail}</label>
                    </p>

                    <p>

                        <spring:input path="name" type="text" name="email" placeholder="Имя"/>
                        <spring:errors path="name" cssClass="error"/>
                    </p>

                    <p>

                        <spring:input path="surname" type="text" name="email" placeholder="Фамилия"/>
                        <spring:errors path="surname" cssClass="error"/>
                    </p>

                    <p>

                        <spring:input path="middleName" type="text" name="email" placeholder="Отчество"/>
                        <spring:errors path="middleName" cssClass="error"/>
                    </p>

                    <p>

                        <spring:input path="telephone" type="text" name="email" placeholder="Телефон"/>
                        <spring:errors path="telephone" cssClass="error"/>
                    </p>

                    <p>
                        <spring:button type="submit" class="btn btn-default">
                            Зарегистрировать
                        </spring:button>
                    </p>
                </spring:form>
                <a href="/simple-web/moderator/registration/return">Отмена</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
