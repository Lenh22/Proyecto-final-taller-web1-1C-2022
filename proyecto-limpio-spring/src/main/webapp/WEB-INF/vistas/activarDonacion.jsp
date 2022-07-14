<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="w3-top">
    <div class="w3-bar w3-black w3-card">
        <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="home" class="w3-bar-item w3-button w3-padding-large">HOME</a>
        <a href="ir-a-resultado-roomie-compatibles" class="w3-bar-item w3-button w3-padding-large w3-hide-small">RECOMENDADOS</a>
        <a href="generar-descuento" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DESCUENTO</a>
        <a href="denuncia" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DENUNCIAR</a>
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
    <div id="loginbox" style="margin-top:100px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
        <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
        <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
        <form:form action="activarDonacionValidacion" method="post" modelAttribute="datosLogin"  >
            <h3 class="form-signin-heading">Activar recibir donaciones </h3>
            <hr class="colorgraph">
            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <p>tu email es:</p>
            <form:input  path="email" id="email" type="email" class="w3-input w3-border" readonly="true" onmousedown="false" value="${email}"/>
            <p>Quiere recibir donacione?</p>
            <div>
                <p>Si <form:radiobutton path="aceptodonacion" name="serDonatario" value="true"/> </p>
                <p>No <form:radiobutton path="aceptodonacion" name="serDonatario" value="false"/> </p>
            </div>
            <br>
            <button class="w3-button w3-black w3-section w3-right" Type="Submit"/>Donar</button>
        </form:form>
        <c:if test="${not empty error}" >
            <br>
            <br>
            <div class="w3-panel w3-red">
                <h3>Error!</h3>
                <span>${error}</span>
            </div>
            <br>
        </c:if>
        <c:if test="${not empty exito}" >
            <br>
            <br>
            <div class="w3-panel w3-green">
                <h3>Exito!</h3>
                <span>${exito}</span>

            </div>
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