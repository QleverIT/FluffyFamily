
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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous">
    </script>
    <style>
        <%@include file="/webcontent/css/admin_style.css"%>
    </style>
</head>
<body>
    <h1>Вы обладаете правами пользователя</h1>

    <spring:form modelAttribute="lkForm" method="get" action="/simple-web/user/lk/new_pet">
        <spring:button class="btn btn-primary" role="button">new pet</spring:button>
    </spring:form>

    <a class="btn btn-primary" role="button" href="/simple-web/user/lk/return">return home</a>

    <div>
        <h1>
            Список опубликованных анкет
        </h1>
        <c:if test="${lkForm.publicPets!=null}">
            <c:forEach var="pet" items="${lkForm.publicPets}">
                ${pet.name}
                <spring:form modelAttribute="lkForm" method="post" action="/simple-web/pet/lk_user/view_pet">
                    <input type="hidden" value="${pet.idPet}" name="idPet">
                    <form:button>look</form:button>
                </spring:form>
                <spring:form modelAttribute="lkForm" method="post" action="/simple-web/pet/lk_user/delete_pet">
                    <input type="hidden" value="${pet.idPet}" name="idPet">
                    <form:button>delete</form:button>
                </spring:form>
            </c:forEach>
        </c:if>
    </div>
    <div>
        <h1>
            Список анкет в обработке
        </h1>
        <c:if test="${lkForm.hoverPets!=null}">
            <c:forEach var="pet" items="${lkForm.hoverPets}">
                <spring:form modelAttribute="lkForm" method="post" action="/simple-web/pet/lk_user/view_pet">
                    <input type="hidden" value="${pet.idPet}" name="idPet">
                    ${pet.name}
                    <form:button>look</form:button>
                </spring:form>
            </c:forEach>
        </c:if>
    </div>
    <div>
        <h1>
            Список анкет непрошедших проверку
        </h1>
        <c:if test="${lkForm.editPets!=null}">
            <c:forEach var="pet" items="${lkForm.editPets}">
                ${pet.name}
                <spring:form modelAttribute="lkForm" method="post" action="/simple-web/pet/lk_user/edit_pet">
                    <input type="hidden" value="${pet.idPet}" name="idPet">
                    <form:button>edit</form:button>
                </spring:form>
                <spring:form modelAttribute="lkForm" method="post" action="/simple-web/pet/lk_user/delete_pet">
                    <input type="hidden" value="${pet.idPet}" name="idPet">
                    <form:button>delete</form:button>
                </spring:form>
            </c:forEach>
        </c:if>
    </div>
</body>
</html>
