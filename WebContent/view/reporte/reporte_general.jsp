<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>
<title>Reporte General</title>
</head>
<body>
	<jsp:include page="/view/login/menu_admin.jsp" flush="true" />
	<div class="container">
		<div class="mx-auto" style="width: 450px;">
			<br>
			<h2 class="mx-auto" style="text-align: center;">Reporte General</h2>
			<br>

		</div>
	</div>

	<div class="container overflow-hidden">
		<div class="row gy-6">
				<div class="col-4">
				<div class="p-3">
					<label for="periodoInTXT" class="form-label">Fecha
						Inicial</label> <input type="date" class="form-control" id="periodoInTXT"
						required>
				</div>
			</div>

			<div class="col-4">
				<div class="p-3">
					<label for="periodoFinTXT" class="form-label">Fecha Final</label>
					<input type="date" class="form-control" id="periodoFinTXT" required>
				</div>
			</div>


			<div class="col-12" style="margin-top: 5px">
				<div class="p-3">
					<table class="table table-hover">

						<thead>
							<tr>
								<th scope="col">Título</th>
								<th scope="col">Autor</th>
								<th scope="col">Precio Venta</th>
								<th scope="col">Precio Compra</th>
								<th scope="col">Ganancia</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row"></th>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<th scope="row"></th>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<th scope="row"></th>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="col-4">
				<div class="p-3">
					<label for="precioCompraTXT" class="form-label">Total
						Precio Compra:</label> <input type="text" class="form-control"
						id="precioCompraTXT" readonly="readonly">
				</div>
			</div>

			<div class="col-4">
				<div class="p-3">
					<label for="precioVentaTXT" class="form-label">Total Precio
						Venta:</label> <input type="text" class="form-control" id="precioVentaTXT"
						 readonly="readonly">
				</div>

			</div>

			<div class="col-4">
				<div class="p-3">
					<label for="gananciaTXT" class="form-label">Ganancia</label> <input
						type="text" class="form-control" id="gananciaTXT" readonly="readonly">
				</div>
			</div>
		</div>



		<div class="container overflow-hidden">
			<div class="row gy-5">
			

				<div class="col-4">
					<div class="p-3">

						<button id="btnGenerarRep" type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Generar
						</button>

					</div>

				</div>

				<div class="col-4">
					<div class="p-3">

						<button id="btnGuardarRep" type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Exportar
						</button>

					</div>

				</div>

				<div class="col-4"></div>




			</div>
		</div>
	</div>
</body>
</html>