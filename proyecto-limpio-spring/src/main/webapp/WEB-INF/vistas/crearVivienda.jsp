<%--
  Created by IntelliJ IDEA.
  User: suble
  Date: 30/6/2022
  Time: 20:44
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

<section class="vh-100" style="background-color: #508bfc;">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <h3 class="mb-5">Crea una vivienda</h3>
                        <form:form action="crearViviendaP" method="post" modelAttribute="datosVivienda">

                        <div class="form-outline mb-4">
                        <form:input  path="direccion" id="direccion" type="text" class="form-control" required="required"/>
                            <label class="form-label" >Direccion</label>
                        </div>

                        <div class="form-outline mb-4">
                            <form:input  path="cantidadMaximaRoomies" id="direccion" type="number" class="form-control" required="required"/>
                            <label class="form-label">Cantidad Maxima</label>
                        </div>


                        <button class="btn btn-primary btn-lg btn-block" type="submit">Crear</button>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
