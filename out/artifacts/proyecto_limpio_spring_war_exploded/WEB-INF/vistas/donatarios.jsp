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
    <h1>Lista de donatarios</h1>
    <table>
        <tr>
            <th> Nombre </th>
            <th> Apellido </th>
            <th> Email </th>
            <th> Billetera </th>
        </tr>

        <c:forEach items="${donatarios}" var="each" >

        <tr>
            <td> ${each.nombre} </td>
            <td> ${each.apellido} </td>
            <td> ${each.email} </td>
            <td> ${each.billeteraDeDonaciones} </td>
         </tr>
        </c:forEach>

</div>
<div>
    <a href="darDonacion">donar a un donatario</a>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>