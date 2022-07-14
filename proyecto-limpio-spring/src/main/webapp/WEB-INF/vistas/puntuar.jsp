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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {font-family: "Lato", sans-serif}
        .mySlides {display: none}
    </style>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
</head>
<body>
<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-black w3-card">
        <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="home" class="w3-bar-item w3-button w3-padding-large">HOME</a>
        <a href="ir-a-resultado-roomie-compatibles" class="w3-bar-item w3-button w3-padding-large w3-hide-small">RECOMENDADOS</a>
        <a href="generar-descuento" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DESCUENTO</a>
        <a href="denuncia" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DENUNCIAR</a>
        <a href="puntuar" class="w3-bar-item w3-button w3-padding-large w3-hide-small">PUNTUAR</a>
        <div class="w3-dropdown-hover w3-hide-small">
            <button class="w3-padding-large w3-button" title="More">BUSCADOR <i class="fa fa-caret-down"></i></button>
            <div class="w3-dropdown-content w3-bar-block w3-card-4">
                <a href="buscador-alquiler" class="w3-bar-item w3-button">VIVIENDAS</a>
                <a href="buscador-roomie" class="w3-bar-item w3-button">ROOMIES</a>
            </div>
        </div>
        <div class="w3-dropdown-hover w3-hide-small">
            <button class="w3-padding-large w3-button" title="More">DONACIONES<i class="fa fa-caret-down"></i></button>
            <div class="w3-dropdown-content w3-bar-block w3-card-4">
                <a href="darDonacion" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DONAR A ROOMIE</a>
                <a href="donatarios" class="w3-bar-item w3-button">LISTA DE DONATARIOS</a>
                <a href="activarDonacion" class="w3-bar-item w3-button">SOLICITAR APTO DONACION</a>
            </div>
        </div>
    </div>
</div>
<div class = "container">
    <div id="loginbox" style="margin:7em;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="ver-puntuacion" method="POST" modelAttribute="puntuacion">
            <h2 class="w3-opacity w3-center">Puntuar a un roomie</h2>

            <form:input path="email" id="email" type="text" class="w3-input w3-border" placeholder="Ingrese el email del roomie a puntuar"/>
            <form:input path="puntuacion" type="text" id="puntuacion" class="w3-input w3-border" placeholder="Ingrese 'true' para voto positivo y 'false' para voto negativo"/>

            <button class="w3-button w3-black w3-margin-top" Type="Submit"/>Puntuar</button>
        </form:form>
        <%--Bloque que es visible si el elemento error no esta vacio	--%>
        <c:if test="${not empty error}" >
            <div class="w3-panel w3-red">
                <h3>Error</h3>
                <span >${error}</span>
            </div>
        </c:if>
        ${msg}
    </div>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
<footer class="w3-container w3-padding-64 w3-center w3-opacity w3-black w3-xlarge" style="position: fixed;bottom: 0; width: 100%">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
    <p class="w3-medium"><a href="https://github.com/Lenh22/Proyecto-final-taller-web1-1C-2022" target="_blank">Repositorio</a> </p>
    <p class="w3-medium">Alonso Leandro</p>
    <p class="w3-medium">Aquino Arami</p>
    <p class="w3-medium">Gomez Emanuel</p>
    <p class="w3-medium">Gomez Leandro</p>
</footer>
</html>
