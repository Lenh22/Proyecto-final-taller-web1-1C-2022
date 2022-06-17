<%--
  Created by IntelliJ IDEA.
  User: Leandro
  Date: 17/6/2022
  Time: 02:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class = "container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <%--@elvariable id="datosRegistro" type="java"--%>
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
        <form:form action="validar-registro-roomie" method="POST" modelAttribute="datosRegistro">
            <h3 class="form-signin-heading">Bienvenido ${datosRegistro.nombre}</h3>
            <h4 class="form-signin-heading">Complete por favor los siguientes datos para terminar el registro</h4>
            <hr class="colorgraph"><br>

            <label>Ingresos</label>
            <form:input path="nombre" type="number" id="ingreso" class="form-control" />
            <label>Atributos</label>
            <form:checkbox path="atributos" id="atributos" value="FUMADOR"/>FUMADOR
            <form:checkbox path="atributos" id="atributos" value="DIURNO"/>DIURNO
            <form:checkbox path="atributos" id="atributos" value="NOCTURNO"/>NOCTURNO
            <form:checkbox path="atributos" id="atributos" value="PETFRIENDLY"/>PETFRIENDLY
            <form:checkbox path="atributos" id="atributos" value="VEGGIE"/>VEGGIE
            <form:checkbox path="atributos" id="atributos" value="OMNIVORO"/>OMNIVORO
            <form:checkbox path="atributos" id="atributos" value="INCLUSIVO"/>INCLUSIVO
            <form:checkbox path="atributos" id="atributos" value="GAMER"/>GAMER
            <form:checkbox path="atributos" id="atributos" value="SEXWORK"/>SEXWORK
            <form:checkbox path="atributos" id="atributos" value="WEEDFRIENDLY"/>WEEDFRIENDLY

            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" Type="Submit"/>Registrarme</button>
        </form:form>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
