<%--
  Created by IntelliJ IDEA.
  User: Arami
  Date: 10/06/2022
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!--CON ESTA IMPORTACION PODEMOS VERTODO LO QUE ESTA DENTRO DE <FORM>-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Puntuar a un Usuario</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class = "container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="ver-puntuacion" method="POST" modelAttribute="puntuacion">
            <h3 class="form-signin-heading">Puntuar roomie</h3>
            <hr class="colorgraph"><br>

            <form:input path="id" id="id" type="text" class="form-control" placeholder="Ingrese el id del roomie a puntuar"/>
            <form:input path="puntuacion" type="text" id="puntuacion" class="form-control" placeholder="Ingrese 'true' para voto positivo y 'false' para voto negativo"/>

            <button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Puntuar</button>
        </form:form>
        <a href="home">Home</a>
        <%--Bloque que es visible si el elemento error no esta vacio	--%>
        <c:if test="${not empty error}" >
            <br>
            <br>
            <h4><span class="alert alert-danger" role="alert" >${error}</span></h4>
            <br>
        </c:if>
        ${msg}
    </div>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
