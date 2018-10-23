<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск пользователя</title>

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
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <div class="login-form"><!--login form-->
                <br></br>
                <br></br>
                <h3>Поиск пользователя по почте или логину</h3>
                <spring:form method="post" modelAttribute="userFindForm" action="/simple-web/user/lk_admin/find_user">
                    <p>
                        Login: <form:input path="login" class="login-field" value="${userFindForm.login}"/>
                    </p>
                    <p>
                        Email: <form:input path="email" class="login-field" value="${userFindForm.email}"/>
                    </p>
                    <form:button class="btn btn-large btn-block">Найти</form:button>
                    <br>
                    <a href="/simple-web/user/lk_admin/find_user/return">Вернуться в личный кабинет</a>
                </spring:form>
                <c:if test="${(!userFindForm.login.equals('')||!userFindForm.email.equals(''))&&(userFindForm.email!=null&&userFindForm.login!=null)}">
                    Пользователь не найден.
                </c:if>
            </div>
        </div>
    </div>
</div>

</body>
</html>
