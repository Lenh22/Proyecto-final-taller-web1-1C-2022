<%--
  Created by IntelliJ IDEA.
  User: Arami
  Date: 18/05/2022
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!--CON ESTA IMPORTACION PODEMOS VERTODO LO QUE ESTA DENTRO DE <FORM>-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Puntaje de usuario</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<c:if test="${empty error}" >
    <p> La puntuacion total actual del usuario es: ${puntaje}</p>
</c:if>
<c:if test="${not empty error}" >
    <br>
    <br>
    <h4><span class="alert alert-danger" role="alert" >${error}</span></h4>
    <br>
</c:if>
${msg}

</body>
</html>
