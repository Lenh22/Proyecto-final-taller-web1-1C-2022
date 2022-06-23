<%--
  Created by IntelliJ IDEA.
  User: COMPU
  Date: 12/6/2022
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
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
        <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
        <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
        <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>

            <h3><span class="alert alert-success" role="alert" >${error}</span></h3>
            <br>
            <br>
            <hr class="colorgraph">
            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <p>Email: ${email}</p>

            <p>Billetera: $ ${billetera}</p>

            <br>
            <hr class="colorgraph">
        <a href="donatarios">Ver la lista de Roomies Donatarios</a>

    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>