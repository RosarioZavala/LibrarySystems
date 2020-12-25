<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>
<meta charset="ISO-8859-1">
<title>Library Systems</title>
</head>
<body>

	<jsp:include page="/view/login/menu_admin.jsp" flush="true" />

	<!-- este div es el que nos dará cierto margen  para nuestro formulario. -->
	<div class="container">
		<div class="mx-auto" style="width: 450px;">
			<br>
			<h2 class="mx-auto" style="text-align: center;">Gestión de
				Autores</h2>
			<br>

		</div>
	</div>
	<div style="margin-left: 150px; width: 250px;">


		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link " href="#">Actualizar
					Autor</a> <br></li>
			<li class="nav-item"><a class="nav-link" href="#">Eliminar
					Autor</a> <br></li>
			<li class="nav-item"><a class="nav-link" href="#">Agregar
					Autor</a> <br></li>
			<li class="nav-item"><a class="nav-link " href="#">Consultar
					Autor</a></li>
		</ul>
</body>

</html>