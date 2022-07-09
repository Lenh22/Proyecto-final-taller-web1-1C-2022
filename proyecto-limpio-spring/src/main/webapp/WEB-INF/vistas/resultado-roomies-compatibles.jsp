
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Roomies compatibles</h2>
    <p>Segun tus atributos que seleccionaste, estos son los roomies con un alto porcentaje de compatibilidad</p>
    <c:if test="${not empty sinemparejamiento}">
        <h4><span>${sinemparejamiento}</span></h4>
        <br>
    </c:if>
    <table class="table">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${RoomieEncontrado}" var="each">
        <tr class="info">
                <td>${each.nombre}</td>
                <td>${each.apellido}</td>
                <td>${each.email}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
