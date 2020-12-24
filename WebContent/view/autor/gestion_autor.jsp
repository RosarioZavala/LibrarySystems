<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/bootstrap.js"></script>
<meta charset="ISO-8859-1">
<title>Library Systems</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/bootstrap.js"></script>
</head>
<body>

	<jsp:include page="/view/login/menu_admin.jsp" flush="true" />

	<!-- este div es el que nos dará cierto margen  para nuestro formulario. -->
	<div class="container">
		<div class="mx-auto" style="width: 450px;">
			<br>
			<h2 class="mx-auto" style="text-align: center;">Gestión de Autores</h2>
			<br>
			<ul class="nav flex-column">
  <li class="nav-item">
    <a class="nav-link active" href="#">Actualizar Autor</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Eliminar Autor</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Agregar Autor</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#">Consultar Autor</a>
  </li>
</ul>

		</div>
	</div>

</body>

</html>