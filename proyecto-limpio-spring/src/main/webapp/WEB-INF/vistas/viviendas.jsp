<%--
  Created by IntelliJ IDEA.
  User: suble
  Date: 30/6/2022
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>


<section class="container">
    <h2 class="text-center">Todas tus Viviendas</h2>
    <div class="container d-grid gap-2 d-md-flex justify-content-md-end text-center">
        <p>${Mensaje}</p>
        <a class="btn btn-success" href="crearVivienda" role="button">Crear habitacion</a>
    </div>
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Direccion</th>
                <th scope="col">Cantidad maxima</th>
                <th scope="col">Acciones</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="unaVivienda" items="${datosVivienda}"  >

                <tr>
                    <td> ${unaVivienda.vivienda} </td>
                    <td> ${unaVivienda.direccion} </td>
                    <td> ${unaVivienda.cantidadMaximaRoomies} </td>
                    <td>
                        <a class="btn btn-info" href="editar/${unaVivienda.vivienda}" role="button">Editar</a>
                        <a class="btn btn-danger" href="borrar/${unaVivienda.vivienda}" role="button">Borrar</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
