<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous">
    </script>
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

        </ul>
    </div>
</nav>

<div id="content_center" class="row" style="padding-top: 98px;">
    <div class="col-md-7 col-md-offset-3">


        <h3 id="center_text_first">Доброго времени суток. "Мохнатая семья" - это площадка,<br>
            где можно получить, подарить или продать домашнего<br> питомца. Вы можете начать
            поиск своего друга. Если же Вы хотите пополнить ряды<br> продавцов, то Вам необходимо <a
                    href="/simple-web/user/registration">зарегистрироваться</a>.
            <br></br>
            <div class="col-md-offset-4">
                <a href="/simple-web/pet/find_pets" class="btn btn-primary">Найти питомца</a>
        </h3>
    </div>
</div>


<%--
<div class="col-md-8 white_fon">

<div class="row mar10">
    <div class="col-md-3 centerAll">
        <img src="http://www.sunny-cat.ru/datas/users/1-kenny005.jpg" class="img-thumbnail">
    </div>
    <div class="col-md-3 centerAll">
        <img src="http://aroundpet.ru/wp-content/uploads/pochemu-koshka-posle-sterilizacii-prosit-kota-1170x767.jpg" class="img-thumbnail">
    </div>
    <div class="col-md-3 centerAll">
        <img src="http://blogs.pjstar.com/petpal/files/2010/10/j0427655-500x363.jpg" class="img-thumbnail">
    </div>
    <div class="col-md-3 centerAll">
        <img src="https://i.ytimg.com/vi/2giQVPIl9JM/maxresdefault.jpg" class="img-thumbnail">
    </div>
</div>
</div>
<div class="col-md-2"></div>
</div>--%>
<%--<div class="embed-responsive embed-responsive-4by3">--%>
<%--<iframe class="embed-responsive-item" src="http://www.paws.su/wp-content/uploads/2016/05/insta-4.gif"/>--%>
<%--</div>--%>
<%--<footer class="navbar-fixed-bottom row-fluid">
    <p> Адрес: г. Иркутск ул. Ржанова 166, третий этаж, офис 301 </p>
</footer>--%>
</body>
</html>


<%--../../../resources/animation/cat1.gif--%>
<%--http://www.paws.su/wp-content/uploads/2016/05/insta-4.gif--%>