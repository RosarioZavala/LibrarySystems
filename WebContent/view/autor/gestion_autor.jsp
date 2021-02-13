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
<script>
	
	function save_autor() {
		this.document.getElementById("action").value = 'save';
		var frm = this.document.getElementById("autorForm");
		frm.submit();
	}

	function find_autor() {
		this.document.getElementById("action").value = 'find';
		var frm = this.document.getElementById("autorForm");
		frm.submit();
	}

	function mostrar_alert() {
		var msg = '${message}';
		if (msg.length > 1) {
			alert(msg);
		}
	}
	
	function delete_autor() {
		this.document.getElementById("action").value = 'delete';
		var form = this.document.getElementById("autorForm");
		form.submit();
	}
	function update_autor(){
		this.document.getElementById("action").value = 'update';
		var frm = this.document.getElementById("autorForm");
		frm.submit();
	}
	function mostrar_alert_delete() {
		var msg = '${messageError}';
		if (msg.length > 1) {
			alert(msg);
		}
	}
	
	function selectRowForUpdateOrDelete(value) {
		this.document.getElementById("idAutorForDeleteOrUpdate").value = value;
	}

	function limpiarForm() {
		this.document.getElementById("idAutorForDeleteOrUpdate").value = '';
	}
	
</script>
</head>
<body onload="mostrar_alert()">

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
		<input type="hidden" id="action" name="action"> <input
			type="hidden" id="idAutorForDeleteOrUpdate"
			name="idAutorForDeleteOrUpdate">

		<div class="container overflow-hidden">
			<div class="row gy-5">
				<div class="col-7">
					<div class="p-3">
						<label for="claveAutorTXT" class="form-label">Clave Autor</label>
						<input type="text" class="form-control" id="claveAutorTXT"
							name="claveAutorTXT"
							placeholder="Por ejemplo: CURP, No. de Ciudadano" required>
					</div>
				</div>



				<div class="col-4">
					<div class="p-3">
						<label for="nacionalidadTXT" class="form-label">Nacionalidad</label>
						<input type="text" class="form-control" id="nacionalidadTXT"
							name="nacionalidadTXT" placeholder="Por ejemplo: Mexicana"
							required>
					</div>
				</div>


				<div class="col-7" style="margin-top: 5px">
					<div class="p-3">
						<label for="nombreTXT" class="form-label">Nombre Completo
							del Autor</label> <input type="text" class="form-control" id="nombreTXT"
							name="nombreTXT" placeholder="Por ejemplo: Pepe Martínez Morán"
							required>
					</div>
				</div>

				<div class="col-12">

					<table id="autorForm" class="table table-hover table-striped"
						role="form">

						<thead>
							<tr>
								<th scope="col">Clave Autor</th>
								<th scope="col">Nombre Completo Autor</th>
								<th scope="col">Nacionalidad</th>
								<th scope="col">Eliminar/Editar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="autor" items="${autores}">
								<tr id="${autor.idautor}">
									<td>${autor.claveautor}</td>
									<td>${autor.nombreCompleto}</td>
									<td>${autor.nacionalidad}</td>
									<td><input class="form-check-input" type="radio"
										name="inlineRadioOptions" id="${autor.idautor}"
										onchange="selectRowForUpdateOrDelete(this.value)"
										value="${autor.idautor}"></td>
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
						<button id="btnConsultar" type="button" class="btn btn-info"
							onclick="find_autor()">
							<span class="glyphicon glyphicon-search"></span> Consultar
						</button>
					</div>
				</div>

				<div class="col-2">
					<div class="p-3">
						<button id="btnAgregar" type="button" class="btn btn-info"
							onclick="save_autor()">
							<span class="glyphicon glyphicon-search"></span> Agregar
						</button>
					</div>

				</div>

				<div class="col-2">
					<div class="p-3">
						<button type="button" id="btnActualizar" class="btn btn-info" onclick="update_autor()">
							<span class="glyphicon glyphicon-search"></span> Actualizar
						</button>
					</div>
				</div>

				<div class="col-2">
					<div class="p-3">
						<button type="button" id="btnEliminar" type="button"
							class="btn btn-info" onclick="delete_autor()">
							<span class="glyphicon glyphicon-search"></span> Eliminar
						</button>
					</div>
				</div>

				<div class="col-2">
					<div class="p-3">
						<button id="btnLimpiar" type="reset" class="btn btn-info"
							onclick="limpiarForm()">
							<span class="glyphicon glyphicon-search"></span> Limpiar
						</button>
					</div>
				</div>
			</div>
		</div>

	</form>
</body>
</html>