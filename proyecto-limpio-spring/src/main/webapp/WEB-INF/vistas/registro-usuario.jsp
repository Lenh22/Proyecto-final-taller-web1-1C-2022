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
    <div id="loginbox" style="margin:7em;" class="mainbox col-md-1 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <%--@elvariable id="datosRegistro" type="java"--%>
        <form:form action="validar-registro" method="POST" modelAttribute="datosRegistro">
            <h3 class="w3-opacity w3-center">Nuevo Roomie</h3>
            <hr class="colorgraph"><br>

            <form:input path="nombre" type="text" id="nombre" class="w3-input w3-border" placeholder="Ingrese su nombre"/>
            <br>
            <form:input path="apellido" type="text" id="apellido" class="w3-input w3-border" placeholder="Ingrese su apellido"/>
            <br>
            <form:input path="edad" type="numbre" id="edad" class="w3-input w3-border" placeholder="Ingrese su edad"/>
            <br>
            <form:input path="email" type="email" id="email" class="w3-input w3-border" placeholder="Ingrese su email"/>
            <br>
            <form:input path="password" type="password" id="password" class="w3-input w3-border" placeholder="Ingrese un password"/>
            <br>
            <label>Seleccione el tipo de cuenta que quiere registrar:</label>
            <br>
            <label>Roomie</label>
            <form:radiobutton path="rol" value="roomie"/>
            <label>Propietario</label>
            <form:radiobutton path="rol" value="propietario"/>
            <br>
            <button id="btn-registrarme" class="w3-button w3-black w3-section w3-right" Type="Submit"/>Registrarme</button>
        </form:form>

        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
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