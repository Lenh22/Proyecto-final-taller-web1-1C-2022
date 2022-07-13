<%--
  Created by IntelliJ IDEA.
  User: Arami
  Date: 30/06/2022
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscador roomies</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class = "container">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

        <h3 class="form-signin-heading">Resultado de su busqueda:</h3>
        <hr class="colorgraph"><br>
            <br>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Email</th>
                    <th scope="col">Edad</th>
                    <th scope="col">Puntuar</th>
                    <th scope="col">Donar</th>
                    <th scope="col">Denunciar</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="roomie" items="${lista}"  >

                    <tr>
                        <td> ${roomie.id} </td>
                        <td> ${roomie.apellido} </td>
                        <td> ${roomie.nombre} </td>
                        <td> ${roomie.email} </td>
                        <td> ${roomie.edad} </td>
                        <td><a href="puntuar" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                        </td>
                        <td><a href="#" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-heart-empty"></span>
                        </a></td>
                        <td><a href="#" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-bullhorn"></span>
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
            <a href="buscador-roomie">Volver</a>
            <br>
            <br>

        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
