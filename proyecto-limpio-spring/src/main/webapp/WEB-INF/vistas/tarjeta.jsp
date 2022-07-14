<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tarjeta</title>
    <link href="css/tarjetaStyle.css" rel="stylesheet">
</head>
<body>

<div id="card-success" class="hidden">
    <i class="fa fa-check"></i>
    <p>Pago exitoso!</p>
</div>
<div id="form-errors" class="hidden">
    <i class="fa fa-exclamation-triangle"></i>
    <p id="card-error">Error en la tarjeta</p>
</div>
<div id="form-container">

    <div id="card-front">
        <div id="shadow"></div>
        <div id="image-container">
            <span id="amount">Pago: <strong>$ ${precio}</strong></span>
            <span id="card-image">

        </span>
        </div>
        <h3 class="text-center">${Mensaje}</h3>
        <!--- end card image container --->
        <form:form action="pagar" method="post" modelAttribute="datosTarjeta">
        <label for="card-number">
            Numero de tarjeta
        </label>
        <form:input  path="numeroTarjeta" id="card-number" type="number" class="form-control" required="required" placeholder="1234 5678 9101 1112" maxlength="16"/>
        <div id="cardholder-container">
            <label for="card-holder">Titular
            </label>
            <form:input  path="titular" id="card-holder" type="text" class="form-control" placeholder="E.J. Pepe Argento" required="required"/>
        </div>
        <!--- end card holder container --->
        <div id="exp-container" style="width: 36%">
            <label>
                Expiracion
            </label>
            <form:input  path="mes" id="card-month" type="number" placeholder="MM"  required="required" style="max-width: 6em;"/>
            <form:input  path="anio" id="card-year" type="number" placeholder="YY"  required="required" style="max-width: 6em;"/>
        </div>
        <div id="cvc-container">
            <label for="card-cvc"> CVC/CVV</label>
            <form:input  path="cvc" id="card-cvc" type="number" placeholder="XXX" class="form-control" required="required" min-length="3" max-length="4"/>
            <p>Ultimos 3 digitos</p>
        </div>
        <!--- end CVC container --->
        <!--- end exp container --->
    </div>
    <!--- end card front --->
    <div id="card-back">
        <div id="card-stripe">
        </div>

    </div>
    <!--- end card back --->
    <input type="text" id="card-token" />

    <button type="submit" id="card-btn">Pagar</button>
    </form:form>
</div>
<!--- end form container --->
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<script src="https://use.fontawesome.com/f1e0bf0cbc.js"></script>
<script src="js/tarjetaJS.js" type="text/javascript"></script>


</body>
</html>
