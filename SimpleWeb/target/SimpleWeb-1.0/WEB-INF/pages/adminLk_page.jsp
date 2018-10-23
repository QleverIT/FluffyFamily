<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>valid</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
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
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-2">
            <br>
            <h4>Вы обладаете правами администратора</h4>
            <h1>Вы обладаете правами администратора</h1>
            <a class="btn btn-primary" role="button" href="/simple-web/admin/lk/new_moderator">Добавить модератора</a>

            <a class="btn btn-primary" role="button" href="/simple-web/admin/lk/return">Выход</a>
            <br>
            <a class="btn btn-primary" role="button" href="/simple-web/user/lk_admin/find_user">Найти пользователя</a>
        </div>
        <div class="col-sm-4">
            <br>

            <c:if test="${lkForm.modetators!=null}">
                <c:forEach var="moder" items="${lkForm.modetators}">
                    <p>
                            ${moder.name} ${moder.middleName} ${moder.surname}
                    </p>
                    <p>
                            ${moder.email}
                    </p>
                    <spring:form modelAttribute="lkForm" method="post" action="/simple-web/admin/lk/moderator_view">
                        <input type="hidden" value="${moder.idModerator}" name="idModerator">
                        <form:button>Просмотреть</form:button>
                    </spring:form>
                </c:forEach>
            </c:if>

        </div>
    </div>
</body>
</html>
