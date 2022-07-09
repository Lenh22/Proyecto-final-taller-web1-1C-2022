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
        <form:form action="validar-registro" method="POST" modelAttribute="datosRegistro">
            <h3 class="form-signin-heading">Nuevo Roomie</h3>
            <hr class="colorgraph"><br>

            <label>Nombre</label>
            <form:input path="nombre" type="text" id="nombre" class="form-control" />
            <label>Apellido</label>
            <form:input path="apellido" type="text" id="apellido" class="form-control" />
            <label>Edad</label>
            <form:input path="edad" type="numbre" id="edad" class="form-control" />
            <label>Email</label>
            <form:input path="email" type="email" id="email" class="form-control" />
            <label>Password</label>
            <form:input path="password" type="password" id="password" class="form-control"/>
            <label>Seleccione el tipo de cuenta que quiere registrar:</label>
            <br>
            <label>Roomie</label>
            <form:radiobutton path="rol" value="roomie"/>
            <label>Propietario</label>
            <form:radiobutton path="rol" value="propietario"/>
            <br>
            <button id="btn-registrarme" class="btn btn-primary" Type="Submit"/>Registrarme</button>
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