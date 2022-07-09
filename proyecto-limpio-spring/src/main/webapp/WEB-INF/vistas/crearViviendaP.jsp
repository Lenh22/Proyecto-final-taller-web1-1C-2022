<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<h2 class="text-center">Vivienda Creada</h2>
<section class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
<table class="table">
    <thead>
    <tr>
        <th scope="col">Direccion</th>
        <th scope="col">Cant max</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${viviendaCreada.direccion} </td>
        <td>${viviendaCreada.cantidadMaximaRoomies}</td>
    </tr>

    </tbody>
</table>
</div>
</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js">')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>

</html>
