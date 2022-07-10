<%--
  Created by IntelliJ IDEA.
  User: Arami
  Date: 30/06/2022
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscador roomies</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <a href="buscador-roomie">Volver</a>
            <br>
            <br>
        </div>
    </div>

</body>
</html>
