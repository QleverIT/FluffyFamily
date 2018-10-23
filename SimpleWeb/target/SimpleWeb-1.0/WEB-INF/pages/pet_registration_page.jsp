<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<html>
<head>
    <title>Анкета питомца</title>
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
<c:if test="${update}">
    <p>
        Сообщение об ошибках.
    </p>
    <p>
            ${message}
    </p>
</c:if>
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
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <ul class="nav navbar-nav">
            <li><a href="/simple-web/authorize">Вход</a></li>
            <li><a href="/simple-web/user/registration">Регистрация пользователя</a></li>
            <li><a href="/simple-web/pet/find_pets">Поиск питомца</a></li>
        </ul>
    </div>
</nav>
<spring:form modelAttribute="pet" method="post" action="/simple-web/pet/new_pet"
             class="login-form">

<div class="row">
    <div class="col-sm-3 col-sm-offset-2">
        <div class="shopper-info">
            <br></br>
            <h4>Информация о питомце</h4>
            <p></p>
            <h5>Питомец</h5>
            <form:select path="idType">
                <c:forEach var="type" items="${typesPet}">
                    <form:option value="${type.idParamPet}" label="${type.nameParamPet}"/>
                </c:forEach>
            </form:select>


            <h5>Пол питомца</h5>

            <form:radiobutton path="gender" value="м" label="М"/>
            <form:radiobutton path="gender" value="ж" label="Ж"/>
            <form:errors path="gender" cssClass="error"/>


            <!-- нужно создать поле для некоторх парамтров,
            где нельзя вводить ничего кроме цифр и нельзя ввести 0 первым,
            если за ним идут еще цифры (только 0 можно) + ограничение по длинне-->
            <h5>Возраст питомца (мес.)</h5>
            <spring:input path="age"/>


            <h5>Характер питомца</h5>
            <form:select path="idCharacter">
                <c:forEach var="сharacter" items="${charactersPet}">
                    <form:option value="${сharacter.idParamPet}" label="${сharacter.nameParamPet}"/>
                </c:forEach>
            </form:select>


            <h5>Окрас питомца</h5>
            <form:select path="idColor">
                <c:forEach var="сolor" items="${colorsPet}">
                    <form:option value="${сolor.idParamPet}" label="${сolor.nameParamPet}"/>
                </c:forEach>
            </form:select>


            <h5>Цена на питомца</h5>
            <spring:input path="price"/>
            <spring:errors path="price" cssClass="error"/>


            <h5>Имя питомца</h5>
            <spring:input path="name"/>
            <spring:errors path="name" cssClass="error"/>
        </div>
    </div>

    <div class="col-sm-3 col-sm-offset 4">
        <br class="bill-to">


        <br class="form-one">
        <h4>Дополнительно</h4>
        <p></p>
        <h5>Умения питомца</h5>
        <form:select path="idTraining">
            <c:forEach var="training" items="${trainingsPet}">
                <form:option value="${training.idParamPet}" label="${training.nameParamPet}"/>
            </c:forEach>
        </form:select>

        <h5>Цвет глаз питомца</h5>
        <form:select path="idEyeColor">
            <c:forEach var="eyeColor" items="${eyeColorsPet}">
                <form:option value="${eyeColor.idParamPet}" label="${eyeColor.nameParamPet}"/>
            </c:forEach>
        </form:select>

        <p></p>
        <p></p>
        <h5>Краткое описание питомца</h5>
        <spring:textarea path="annotation" placeholder=""/>
        <spring:errors path="annotation" cssClass="error"/>
        <br>
        </br>
        <h5>Описание питомца</h5>
        <spring:textarea path="about" placeholder=""/>
        <spring:errors path="annotation" cssClass="error"/>

        <h5>Фотография</h5>
        <spring:input path="passImg" />
        <spring:errors path="passImg" cssClass="error"/>

        <br>

        </br>
        <spring:button type="submit" class="btn btn-primary">
            Готово
        </spring:button>

        </spring:form>
        <p>

        </p>
        <a href="/simple-web/pet/lk_user/new_pet/return">Отмена</a>
    </div>

</div>

</body>
</html>
