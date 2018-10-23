<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${newUser!=null}">

        <div>Регистрация прошла успешно.</div>
        <p>
            <label>Ваши данные для входа в личный кабинет.</label>
            <br/>
            Login: ${newUser.login}
            <br/>
            Password: ${newUser.password}
        </p>
        <p>
            Пожалуйста, запомните ваши данные, а затем вернитесь на главную страницу и авторизируйтесь.
        </p>
    </c:when>
    <c:otherwise>

            Кажется что-то пошло не так. Попробуйте авторизироваться на главной странице. <br/>
            Или зарегестрироваться снова, если авторизация пройдет не успешно. <br/>

    </c:otherwise>
</c:choose>

    <a class="btn" href="/simple-web/user/return" role="button">Вернуться на главную страницу.</a>
</body>
</html>
