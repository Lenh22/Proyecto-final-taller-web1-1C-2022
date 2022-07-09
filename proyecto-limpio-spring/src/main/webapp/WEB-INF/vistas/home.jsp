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
	<div class="container px-4 py-5" id="featured-3">
		<h2 class="pb-2 border-bottom">Bienvenido a Roomie's ${usuario.nombre}</h2>
		<div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
			<div class="feature col">
				<div class="feature-icon d-inline-flex align-items-center justify-content-center bg-primary bg-gradient text-white fs-2 mb-3">
					<svg class="bi" width="1em" height="1em"><use xlink:href="#collection"></use></svg>
				</div>
				<h2>Sugerencias de roomie</h2>
				<p>Busca personas con las mismas caracteristicas que vos</p>
				<br>
				<%--@elvariable id="id" type="java"--%>
				<form:form action="ir-a-resultado-roomie-compatibles" method="POST" modelAttribute="id">
					<button class="btn btn-primary" Type="Submit" value="${usuario.id}"/>ir</button>
				</form:form>
				<!--<a href="#" class="icon-link d-inline-flex align-items-center">

					<svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"></use></svg>
				</a>-->
			</div>
		</div>
	</div>


		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>