<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>

	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-black w3-card">
			<a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">HOME</a>
			<a href="ir-a-resultado-roomie-compatibles" class="w3-bar-item w3-button w3-padding-large w3-hide-small">RECOMENDADOS</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DONAR A ROOMIE</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DESCUENTO</a>
			<div class="w3-dropdown-hover w3-hide-small">
				<button class="w3-padding-large w3-button" title="More">MORE <i class="fa fa-caret-down"></i></button>
				<div class="w3-dropdown-content w3-bar-block w3-card-4">
					<a href="#" class="w3-bar-item w3-button">Merchandise</a>
					<a href="#" class="w3-bar-item w3-button">Extras</a>
					<a href="#" class="w3-bar-item w3-button">Media</a>
				</div>
			</div>
			<div class="w3-dropdown-hover w3-hide-small">
				<button class="w3-padding-large w3-button" title="More">BUSCADOR <i class="fa fa-caret-down"></i></button>
				<div class="w3-dropdown-content w3-bar-block w3-card-4">
					<a href="buscador-alquiler" class="w3-bar-item w3-button">VIVIENDAS</a>
					<a href="buscador-roomie/" class="w3-bar-item w3-button">ROOMIES</a>
				</div>
			</div>
			<a href="javascript:void(0)" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i class="fa fa-search"></i></a>
		</div>
	</div>

	<div class="w3-container w3-content w3-center w3-padding-64" style="max-width:800px" id="band">
		<h2 class="w3-wide">Bienvenido a Roomiest</h2>
		<p class="w3-opacity"><i>La manera mas facil de encontrar alguien con quien convivir</i></p>
		<p class="w3-justify">Te brindamos los mejores servicios para que encuentre todo lo que buscas, ademas de tambien poder ayudar alguien que lo necesite</p>
	</div>

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>