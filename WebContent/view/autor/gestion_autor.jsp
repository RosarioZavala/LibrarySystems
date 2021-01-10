<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>
<meta charset="ISO-8859-1">
<title>Gestión de Autores</title>
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

	<form action="autor" method="get" id="autorForm" role="form">

		<div class="container overflow-hidden">
			<div class="row gy-5">
				<div class="col-7">
					<div class="p-3">
						<label for="claveAutorTXT" class="form-label">Clave Autor</label>
						<input type="text" class="form-control" id="claveAutorTXT"
							placeholder="Por ejemplo: CURP, No. de Ciudadano" required>
					</div>
				</div>



				<div class="col-4">
					<div class="p-3">
						<label for="nacionalidadTXT" class="form-label">Nacionalidad</label>
						<input type="text" class="form-control" id="nacionalidadTXT"
							placeholder="Por ejemplo: Mexicana" required>
					</div>
				</div>


				<div class="col-7" style="margin-top: 5px">
					<div class="p-3">
						<label for="nombreTXT" class="form-label">Nombre Completo
							del Autor</label> <input type="text" class="form-control" id="nombreTXT"
							placeholder="Por ejemplo: Pepe Martínez Morán" required>
					</div>
				</div>

				<div class="col-12">

					<table id="autorForm" class="table table-hover" role="form">

						<thead>
							<tr>


								<th scope="col">Clave Autor</th>
								<th scope="col">Nombre Completo Autor</th>
								<th scope="col">Nacionalidad</th>

							</tr>
						</thead>
						<tbody >
							<c:forEach var="autor" items="${autores}">
								<tr id="${autor.idautor}" >
									<td >${autor.claveautor}</td>
									<td >${autor.nombreCompleto}</td>
									<td >${autor.nacionalidad}</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>


		<div class="container overflow-hidden">
			<div class="row gy-5">

				<div class="col-2">
					<div class="p-3">

						<button id="btnConsultar" type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Consultar
						</button>

					</div>

				</div>

				<div class="col-2">
					<div class="p-3">

						<button id="btnAgregar" type="button" class="btn btn-info"
							onclick="location.href='http://127.0.0.1:8080/LibrarySystems/autor?action=save'">
							<span class="glyphicon glyphicon-search"></span> Agregar
						</button>

					</div>

				</div>


				<div class="col-2">
					<div class="p-3">

						<button id="btnActualizar" type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Actualizar
						</button>

					</div>

				</div>


				<div class="col-2">
					<div class="p-3">
						<button id="btnEliminar" type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Eliminar
						</button>
					</div>

				</div>
	</form>



</body>

</html>