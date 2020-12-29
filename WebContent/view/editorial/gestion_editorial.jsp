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
<title>Library Systems</title>
</head>
<body>

	<jsp:include page="/view/login/menu_admin.jsp" flush="true" />

	<!-- este div es el que nos dará cierto margen  para nuestro formulario. -->
	<div class="container">
		<div class="mx-auto" style="width: 450px;">
			<br>
			<h2 class="mx-auto" style="text-align: center;">Gestión de
				Editoriales</h2>
			<br>
				</div>
			
				<div class="container overflow-hidden">
		<div class="row gy-5">
			<div class="col-7">
				<div class="p-3">
					<label for="nombreEditorialTXT" class="form-label">Nombre
						Editorial</label> <input type="text" class="form-control"
						id="nombreEditorialTXT" placeholder="Por ejemplo: Planeta Verde"
						required>
				</div>
			</div>



			<div class="col-4">
				<div class="p-3">
					<label for="lugarImpresiónTXT" class="form-label">Lugar
						impresión</label> <input type="text" class="form-control"
						id="lugarImpresiónTXT" placeholder="Por ejemplo: México" required>
				</div>
			</div>





			<div class="col-12">

				<table class="table table-hover">

					<thead>
						<tr>


							<th scope="col">Nombre Editorial</th>
							<th scope="col">Lugar Impresión</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row"></th>
							<td></td>

						</tr>
						<tr>
							<th scope="row"></th>
							<td></td>

						</tr>
						<tr>
							<th scope="row"></th>
							<td colspan="2"></td>

						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="container overflow-hidden">
		<div class="row gy-5">
		
			<div class="col-2" style="margin-left: 18px">
				<div class="p-3">
					<button id="btnConsultarEd" type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-search"></span> Consultar
					</button>
				</div>

			</div>
	<div class="col-2" style="margin-left: 5px">
				<div class="p-3">

					<button id="btnAgregarEd" type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-search"></span> Agregar
					</button>

				</div>

			</div>

			<div class="col-2" style="margin-left: 5px">
				<div class="p-3">
					<button id="btnActualizarEd" type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-search"></span> Actualizar
					</button>
				</div>

			</div>
			<div class="col-2">
				<div class="p-3">

					<button id="btnLimpiarEd" type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-search"></span> Limpiar
					</button>

				</div>

			</div>

		

		

		</div>
	</div>
			
			
			
			
			<form action="editorial" method="get" id="editorialForm" role="form">
				<div class="mb-3">

					<label for="editorialSelect" class="form-label">Selecciona
						Editorial</label> <select id="editorialSelect" name="editorialSelect"
						class="form-select" aria-label="Default select example">
						<c:forEach  var="editorial" items="${editoriales}">
							<option value="${editorial.idEditorial}">${editorial.nombreEditorial}</option>
						</c:forEach>
					</select>
					
				</div>

			</form>

		</div>


</body>

</html>