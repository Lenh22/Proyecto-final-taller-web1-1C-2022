
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de alquileres</title>

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
        <a href="home-propietario" class="w3-bar-item w3-button w3-padding-large">HOME</a>
        <a href="ir-a-lista-alquileres-propietario" class="w3-bar-item w3-button w3-padding-large w3-hide-small">MIS ALQUILERES</a>
        <a href="agregar-vivienda" class="w3-bar-item w3-button w3-padding-large w3-hide-small">AGREGAR VIVIENDA</a>
    </div>
</div>
<div class = "container">
    <div id="loginbox" style="margin:7em;" class="mainbox col-md-1 col-md-offset-3 col-sm-8 col-sm-offset-2">

        <h2 class="w3-opacity w3-center">Lista de alquileres</h2>

        <c:if test="${not empty msg}" >
            <br>
            <br>
            <h4><p class="w3-panel w3-red" role="alert" >${msg}</p></h4>
            <br>
        </c:if>

        <c:forEach var="unaVivienda" items="${viviendas}" >
        <div class="w3-center w3-margin-top">
            <div>
                <div class="w3-card w3-container" style="min-height:auto">
                    <div style="display: flex;justify-content: space-between;">
                        <div>
                            <i class="fa fa-home w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
                        </div>
                        <div style="size: 16px!important;">
                            <p>Dirección: ${unaVivienda.direccion}</p>
                            <p>Cantidad máxima de roomies: ${unaVivienda.cantidadMaximaRoomies}</p>
                            <p>Cantidad de ambientes: ${unaVivienda.cantidadAmbientes}</p>
                            <c:if test="${unaVivienda.alquilado}" >
                            <p>Se encuentra alquilado</p>
                            </c:if>
                        </div>
                        <a href="ir-a-editar-vivienda${unaVivienda.id}" class="w3-button w3-black w3-section w3-right" Type="Submit" style="max-height: 2.8em; align-self: flex-end;"/>Editar</a>
                        <a href="ir-a-eliminar-vivienda${unaVivienda.id}" class="w3-button w3-black w3-section w3-right" Type="Submit" style="max-height: 2.8em; align-self: flex-end;"/>Eliminar</a>
                    </div>
                </div>
            </div>
            </c:forEach>

            <c:if test="${not empty error}" >
                <br>
                <br>
                <h4><span class="w3-panel w3-red" role="alert" >${error}</span></h4>
                <br>
            </c:if>
        </div>
    </div>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>