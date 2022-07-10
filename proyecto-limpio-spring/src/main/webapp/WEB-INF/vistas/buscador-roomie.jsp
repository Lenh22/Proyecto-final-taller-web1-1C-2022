<%--
  Created by IntelliJ IDEA.
  User: Arami
  Date: 27/06/2022
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscador roomie</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <form class="form-inline" action="validar-buscador-roomie" method="POST" modelAttribute="datosBuscadorRoomie">
        <input class="form-control mr-sm-2" type="number" path="roomie" id="roomie" placeholder="ingrese id">
        <button class="btn btn-success" type="submit">Buscar</button>
    </form>
</nav>
    <div class = "container">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
            <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
            <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
                <h2 class="text-center">Todos los Roomies disponibles</h2>

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

                    <c:forEach var="roomie" items="${datosBuscadorRoomie}"  >

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

        </div>
    </div>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>