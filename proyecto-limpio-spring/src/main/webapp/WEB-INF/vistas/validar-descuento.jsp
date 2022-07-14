<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!--CON ESTA IMPORTACION PODEMOS VERTODO LO QUE ESTA DENTRO DE <FORM>-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Descuentos</title>
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
        <a href="#" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DONAR A ROOMIE</a>
        <a href="generar-descuento" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DESCUENTO</a>
        <a href="puntuar" class="w3-bar-item w3-button w3-padding-large w3-hide-small">PUNTUAR</a>
        <div class="w3-dropdown-hover w3-hide-small">
            <button class="w3-padding-large w3-button" title="More">BUSCADOR <i class="fa fa-caret-down"></i></button>
            <div class="w3-dropdown-content w3-bar-block w3-card-4">
                <a href="buscador-alquiler" class="w3-bar-item w3-button">VIVIENDAS</a>
                <a href="buscador-roomie" class="w3-bar-item w3-button">ROOMIES</a>
            </div>
        </div>
    </div>
</div>
<div class = "container" >
    <div id="loginbox" style="margin:7em; height: 800px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <c:if test="${empty error}" >
            <h2 class="w3-opacity w3-center">Felicidades !!! Obtuvo 10% de descuento</h2>
            <div class="w3-panel w3-center">
                <h3 class="glyphicon glyphicon-education" > CONTRASEÑA: 1234</h3>
            </div>
            <div style="width: 500px;
    height: 500px;
    background-size: cover">
                <div class="fondo">
                </div>
            </div>

        </c:if>

        <c:if test="${not empty error}" >
            <div class="w3-panel w3-red">
                <h3>Error</h3>
                <span >${error}</span>
            </div>
        </c:if>
        ${msg}
    </div>
</div>
</body>
<footer class="w3-container w3-padding-64 w3-center w3-opacity w3-black w3-xlarge">
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
<style>
    .fondo{
        width: 500px;
        height: 650px;
        background-size: cover;
        background-image: url("https://trello.com/1/cards/62ce0acfe902804709023e6a/attachments/62d077e7c749952e0b4f2a97/download/Descuento10.jpeg");
    }
</style>