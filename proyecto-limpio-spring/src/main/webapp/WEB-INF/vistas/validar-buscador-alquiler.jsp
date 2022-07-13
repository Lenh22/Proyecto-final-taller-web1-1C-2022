<%--
  Created by IntelliJ IDEA.
  User: Arami
  Date: 30/06/2022
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscador viviendas</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class = "container">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <hr class="colorgraph"><br>
        <br>
            <h2 class="text-center">Resultado de su busqueda:</h2>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Direccion</th>
                    <th scope="col">Cantidad maxima</th>
                    <th scope="col">Aqluiler</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="unaVivienda" items="${lista}"  >

                    <tr>
                        <td> ${unaVivienda.vivienda} </td>
                        <td> ${unaVivienda.direccion} </td>
                        <td> ${unaVivienda.cantidadMaximaRoomies} </td>
                        <td><a href="#" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-usd"></span>
                        </a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

            <c:if test="${not empty error}" >
                <br>
                <br>
                <h4><span class="alert alert-danger" role="alert" >${error}</span></h4>
                <br>
            </c:if>
            ${msg}

            </table>
            <a href="buscador-alquiler"	>Volver</a>
        </div>
    </div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
