<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Поиск</title>
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
<!-- Блок с параметрами поиска -->
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <ul class="nav navbar-nav">
            <li><a href="/simple-web/authorize">Вход</a></li>
            <li><a href="/simple-web/user/registration">Регистрация пользователя</a></li>

        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <div class="left-sidebar">
                <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#search">
                                    <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                    Поиск
                                </a>
                            </h4>
                        </div>
                        <div id="search" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>
                                    <spring:form modelAttribute="findPetForm" method="post"
                                                 action="/simple-web/pet/find_pets"
                                                 class="login-form">

                                    <h5>Питомец</h5>
                                    <form:select path="idType">
                                        <c:forEach var="type" items="${typesPet}">
                                            <form:option value="${type.idParamPet}" label="${type.nameParamPet}"/>
                                        </c:forEach>
                                    </form:select>

                                    <h5>Окрас</h5>
                                    <form:select path="idColor">
                                        <c:forEach var="сolor" items="${colorsPet}">
                                            <form:option value="${сolor.idParamPet}" label="${сolor.nameParamPet}"/>
                                        </c:forEach>
                                    </form:select>
                                    <h5>Цвет глаз</h5>
                                    <form:select path="idEyeColor">
                                        <c:forEach var="eyeColor" items="${eyeColorsPet}">
                                            <form:option value="${eyeColor.idParamPet}"
                                                         label="${eyeColor.nameParamPet}"/>
                                        </c:forEach>
                                    </form:select>
                                    <h5>Умения</h5>
                                    <form:select path="idTraining">
                                        <c:forEach var="training" items="${trainingsPet}">
                                            <form:option value="${training.idParamPet}"
                                                         label="${training.nameParamPet}"/>
                                        </c:forEach>
                                    </form:select>

                                    <h5>Характер</h5>
                                    <form:select path="idCharacter">
                                        <c:forEach var="сharacter" items="${charactersPet}">
                                            <form:option value="${сharacter.idParamPet}"
                                                         label="${сharacter.nameParamPet}"/>
                                        </c:forEach>
                                    </form:select>
                                </ul>
                                <spring:button class="btn btn-primary">
                                    Найти
                                </spring:button>
                                </spring:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-5 col-sm-offset-1">

            <c:if test="${!find}">
                <p>По вашему запросу ничего не найдено.</p>
            </c:if>
            <c:if test="${resultFindPets != null}">
                <!-- это вид блока, для каждого найденного питомца по запросу -->
                <c:forEach var="pet" items="${resultFindPets}">

                    <img src="${pet.passImg}" width="270px" height="200px" alt=""/><br>
                    <h4>Имя:</h4>
                    <h5>${pet.name}<br></h5>
                    <h4>Описание:</h4>
                    <h5> ${pet.annotation}<br></h5>


                    <h3>${pet.price} руб.</h3>


                    <spring:form modelAttribute="find" method="post" action="/simple-web/pet/find_pets/more">
                        <input type="hidden" value="${pet.idPet}" name="idPet">
                        <form:button class="btn btn-default">Подробнее...</form:button>
                    </spring:form>

                    </p>
                </c:forEach>
            </c:if>

        </div>

    </div>
    <a href="/simple-web/pet/find_pets/return">Вернуться на главную страницу</a>
</div>

<footer id="footer"><!--Footer-->


    <div class="footer-bottom">
        <div class="container">
            <div class="row">
                <p class="pull-left">©Мохнатая семья 2018</p>

            </div>
        </div>
    </div>

</footer>
</body>
</html>
