<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Страница модератора</title>
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
            <li><a href="/simple-web/moderator/lk/return">Вернуться на домашнюю
                страницу</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">

    </div>

    <br>
    <br>
    <div class="col-md-4">
        <div class="note">
            <h3>Список новых анкет</h3>

            <c:if test="${lkForm.newPets!=null}">
                <c:forEach var="pet" items="${lkForm.newPets}">
                    ${pet.name}
                    <spring:form modelAttribute="lkForm" method="post"
                                 action="/simple-web/pet/lk_moderator/edit_pet">
                        <input type="hidden" value="${pet.idPet}" name="idPet">
                        <form:button>Редактировать</form:button>
                    </spring:form>
                    <spring:form modelAttribute="lkForm" method="post" action="/simple-web/moderator/lk/update">
                        <input type="hidden" value="${pet.idPet}" name="idPet">
                        <form:button>Сохранить</form:button>
                    </spring:form>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <div class="col-md-4">
        <div class="note">
            <h3>
                Список анкет, ожидающих исправлений пользователя
            </h3>
            <c:if test="${lkForm.hoverPets!=null}">
                <c:forEach var="pet" items="${lkForm.hoverPets}">
                    <spring:form modelAttribute="lkForm" method="post"
                                 action="/simple-web/pet/lk_moderator/view_pet">
                        <input type="hidden" value="${pet.idPet}" name="idPet">
                        ${pet.name}
                        <form:button>Просмотр</form:button>
                    </spring:form>
                </c:forEach>
            </c:if>
        </div>
    </div>

    <div class="col-md-4">
        <div class="note">
            <h3>
                Список анкет, требующих повтороной проверки
            </h3>
            <c:if test="${lkForm.editPets!=null}">
                <c:forEach var="pet" items="${lkForm.editPets}">
                    ${pet.name}
                    <spring:form modelAttribute="lkForm" method="post"
                                 action="/simple-web/pet/lk_moderator/edit_pet">
                        <input type="hidden" value="${pet.idPet}" name="idPet">
                        <form:button>Редактировать</form:button>
                    </spring:form>
                    <spring:form modelAttribute="lkForm" method="post" action="/simple-web/moderator/lk/update">
                        <input type="hidden" value="${pet.idPet}" name="idPet">
                        <form:button>Сохранить</form:button>
                    </spring:form>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
</div>
</body>
</html>
