<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>W3.CSS Template</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {font-family: "Lato", sans-serif}
        .mySlides {display: none}
    </style>
</head>
<body>
<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-black w3-card">
        <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="home-propietario" class="w3-bar-item w3-button w3-padding-large">HOME</a>
        <a href="ir-a-lista-alquileres-propietario" class="w3-bar-item w3-button w3-padding-large w3-hide-small">MIS ALQUILERES</a>
        <a href="#" class="w3-bar-item w3-button w3-padding-large w3-hide-small">AGREGAR ALQUILER</a>
    </div>
    <div class = "container">
        <div id="loginbox" style="margin:7em;" class="mainbox col-md-1 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
            <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
            <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>

            <form:form  action="editar-vivienda" method="post" modelAttribute="vivienda" >

                <h2 class="w3-opacity w3-center"> Modifique los datos de la vivienda </h2>
                <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>

                <form:input class="w3-input w3-border" path="direccion" id="direccion" type="text" value="${vivienda.direccion}"/>
                <br>
                <form:input class="w3-input w3-border" path="cantidadMaximaRoomies" type="number" id="cantidadMaximaRoomies" value="${vivienda.cantidadMaximaRoomies}"/>
                <br>
                <form:input class="w3-input w3-border" path="descripcion" id="text" type="text" value="${vivienda.descripcion}"/>
                <br>
                <form:input class="w3-input w3-border" path="cantidadAmbientes" type="number" id="cantidadMaximaRoomies" value="${vivienda.cantidadAmbientes}"/>
                <br>
                <form:input class="w3-input w3-border" path="precioAlquiler" type="number" id="precioAlquiler" value="${vivienda.precioAlquiler}"/>
                <br>
                <form:checkbox path="amueblado" value="${datosVivienda.amueblado}"/> Es amueblado
                <button class="w3-button w3-black w3-section w3-right" Type="Submit"/>Editar Vivienda</button>
            </form:form>

            <c:if test="${not empty error}" >
                <br>
                <br>
                <div class="w3-panel w3-red">
                    <h3>Error</h3>
                    <span >${error}</span></div>

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