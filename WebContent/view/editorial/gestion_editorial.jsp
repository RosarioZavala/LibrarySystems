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
<script>
	function save_Editorial() {
		this.document.getElementById("action").value = 'save';
		var frm = this.document.getElementById("editorialForm");
		frm.submit();
	}
	function mostrar_alertEdi() {
		var msg = '${message}';
		if (msg.length > 1) {
			alert(msg);
		}
	}
	function find_editorial() {
		this.document.getElementById("action").value = 'find';
		var form = this.document.getElementById("editorialForm");
		form.submit();
	}
</script>
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
	</div>

	<form action="editorial" method="get" id="editorialForm" role="form">
		<input type="hidden" id="action" name="action">
		<div class="container overflow-hidden">
			<div class="row gy-5">
				<div class="col-7">
					<div class="p-3">
						<label for="nombreEditorialTXT" class="form-label">Nombre
							Editorial</label> <input type="text" class="form-control"
							id="nombreEditorialTXT" name="nombreEditorialTXT" placeholder="Por ejemplo: Planeta Verde"
							required>
					</div>
				</div>



				<div class="col-4">
					<div class="p-3">
						<label for="lugarImpresionTXT" class="form-label">Lugar impresion</label> <input type="text" class="form-control"
							id="lugarImpresionTXT" name="lugarImpresionTXT" placeholder="Por ejemplo: México" required>
					</div>
				</div>





				<div class="col-12">


					<table id="editorialForm" class="table table-hover table-striped"
						role="form">


						<thead>
							<tr>


								<th scope="col">Nombre Editorial</th>
								<th scope="col">Lugar Impresión</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="editorial" items="${editoriales}">
								<tr id="${editorial.idEditorial}">
									<td>${editorial.nombreEditorial}</td>
									<td>${editorial.lugarDeImpresion}</td>


								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="container overflow-hidden">
			<div class="row gy-5">

				<div class="col-2" style="margin-left: 18px">
					<div class="p-3">
						<button id="btnConsultarEd" type="button" class="btn btn-info"
							onclick="find_editorial()">
							<span class="glyphicon glyphicon-search"></span> Consultar
						</button>


					</div>

				</div>
				<div class="col-2" style="margin-left: 5px">
					<div class="p-3">

						<button id="btnAgregar" type="button" class="btn btn-info"
							onclick="save_Editorial()">
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

						<button id="btnLimpiarEd" type="reset" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Limpiar
						</button>

					</div>

				</div>





			</div>
		</div>

		<div class="mb-3">

			<label for="editorialSelect" class="form-label">Selecciona
				Editorial</label> <select id="editorialSelect" name="editorialSelect"
				class="form-select" aria-label="Default select example">
				<c:forEach var="editorial" items="${editoriales}">
					<option value="${editorial.idEditorial}">${editorial.nombreEditorial}</option>
				</c:forEach>
			</select>

		</div>




	</form>
</body>

</html>