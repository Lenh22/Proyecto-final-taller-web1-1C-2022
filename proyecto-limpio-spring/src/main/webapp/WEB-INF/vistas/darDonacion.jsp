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
        <form:form action="darDonacionValidacion" method="post" modelAttribute="DatosDonacion"  >
            <h3 class="form-signin-heading">Done al donatario </h3>
            <hr class="colorgraph">
            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <p>Ingrese email</p>
            <form:input  path="email" id="email" type="email" class="form-control"/>
            <p>Ingrese monto</p>
             <form:input path="billeteraDeDonaciones" type="number" id="billeteraDeDonaciones" class="form-control"/>
            <br>
            <button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Donar</button>
         </form:form>
            <a href="donatarios">Ver la lista de Roomies Donatarios</a>
        <c:if test="${not empty error}" >
            <br>
            <br>
            <h4><span class="alert alert-danger" role="alert" >${error}</span></h4>
            <br>
        </c:if>
        ${msg}
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
