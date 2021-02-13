<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>
<meta charset="ISO-8859-1">
<title>Carrito Compras</title>

<script>
function selectRowForUpdate(value) {
	this.document.getElementById("idStatusForUpdateBook").value = value;
}
function mostrar_alert() {
	var msg = '${message}';
	if (msg.length > 1) {
		alert(msg);	
	}
}
</script>
</head>
<body onload="mostrar_alert()">
	<jsp:include page="/view/login/menu_admin.jsp" flush="true" />
	<br>
	<h2 class="mx-auto" style="text-align: center;">Gestión de
		Carritos de Compra</h2>
	<br>
	<form action="carritoCompras" method="get" id="CarritoComprasForm" role="form" enctype="multipart/form-data">
		<input type="hidden" id="action" name="action">
		<input type="hidden" id="idStatusForUpdateBook"
			name="idStatusForUpdateBook">
	<div class="container overflow-hidden">
			<div class="row gy-6">
					<div class="col-4">
				<div class="p-3">
					<label for="periodoInTXT" class="form-label">Fecha
						Inicial</label> <input type="date" class="form-control" id="periodoInTXT" name="periodoInTXT"
						required>
				</div>
			</div>

			<div class="col-4">
				<div class="p-3">
					<label for="periodoFinTXT" class="form-label">Fecha Final</label>
					<input type="date" class="form-control" id="periodoFinTXT" name="periodoFinTXT" required>
				</div>
			</div>
			</div>
				</div>
	<div class="container overflow-hidden">

		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Folio</th>
					<th scope="col">Fecha de compra</th>
					<th scope="col">Fecha de Entrega</th>
					<th scope="col">Lugar Entrega</th>
					<th scope="col">Nombre comprador</th>
					<th scope="col">Status</th>
					<th scope="col">Editar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="carritocompras" items="${carritocompras}">
								<tr id="${carritocompras.'idcarritocompras'}">
									<td>${carritocompras.'foliocarritocompras'}</td>
									<td>${carritocompras.'fechacompra'}</td>
									<td>${carritocompras.'fechaentrega'}</td>
									<td>${carritocompras.'lugarentrega'}</td>
									<td>${carritocompras.'lugarentrega'}</td>
									<td>${carritocompras.'nombrecomprador'} </td>
									<td><input class="form-check-input" type="radio"
										name="inlineRadioOptions" id="${libro.idLibro}"
										onchange="selectRowForUpdateOrDelete(this.value)"
										value="${libro.idLibro}"></td>
								</tr>
							</c:forEach>
			</tbody>
		</table>
		<div class="container overflow-hidden">
			<div class="row gy-5">
				<div class="col-4">
					<div class="p-3">
						<button id="btnActualizarEntregado" type="submit"
							class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span>Actualizar Entregado
						</button>
					</div>
					</div>

					<div class="col-4">
						<div class="p-3">

							<button id="btnActualizarNoEntregado" type="submit"
								class="btn btn-info">
								<span class="glyphicon glyphicon-search"></span>Actualizar No Entregado
							</button>

						</div>

					</div>






				</div>
			</div>
		</div>
			</form>
</body>
</html>