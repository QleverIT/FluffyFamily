<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Регистрация пользователя</title>
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

            <li><a href="/simple-web/pet/find_pets">Поиск питомца</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form"><!--login form-->
                <br></br>
                <br></br>
                <h2>Зарегистрируйтесь</h2>
                <spring:form modelAttribute="newUser" method="post" action="/simple-web/user/registration"
                             class="login-form">
                    <p>

                        <spring:input path="login" type="text" name="login" placeholder="Логин"/>
                        <spring:errors path="login" cssClass="error"/>
                        <a class="error">${errorLogin}</a>
                    </p>
                    <p>

                        <spring:input path="email" type="text" name="email" placeholder="Почта"/>
                        <spring:errors path="email" cssClass="error"/>
                        <a class="error">${errorEmail}</a>
                    </p>
                    <p>

                        <spring:input path="password" type="text" name="password" placeholder="Пароль"/>
                        <spring:errors path="password" cssClass="error"/>
                    </p>
                    <p>
                    <h5>Имя Отчество в родительном падеже: "пишите на почту..."</h5>
                    <spring:input path="nameAndMiddleName" type="text" name="nameAndMiddleName"
                                  placeholder="Имя Отчество"/>
                    <spring:errors path="nameAndMiddleName" cssClass="error"/>
                    </p>
                    <p>
                        <spring:button type="submit" class="btn btn-default">
                            Зарегистрироваться
                        </spring:button>
                    </p>
                </spring:form>
                <spring:form modelAttribute="newUser" method="get" action="/simple-web/user/return"
                             class="login-form">
                    <spring:button href="/simple-web/user/return" class="btn btn-default">
                        Отмена
                    </spring:button>
                </spring:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
