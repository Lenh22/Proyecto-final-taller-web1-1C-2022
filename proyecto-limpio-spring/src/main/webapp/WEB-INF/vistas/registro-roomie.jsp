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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class = "container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <%--@elvariable id="datosRegistro" type="java"--%>
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
            <h3 class="w3-opacity w3-center">Bienvenido ${datosRegistro.nombre}</h3>
            <h4 class="w3-opacity w3-center">Elija los atributos con los que se sienta identificado para terminar con el registro</h4>
            <hr class="colorgraph">
            <br>
        <form:form class="w3-input w3-border" action="validar-registro-roomie" method="POST" commandName="datosRegistro" modelAttribute="datosRegistro">
            <form:checkboxes class="w3-check" items="${atributos}" path="atributos"/>
            <br>
            <button id="btn-registrarme" class="w3-button w3-black w3-section w3-right" Type="Submit"/>Registrarme</button>
        </form:form>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
