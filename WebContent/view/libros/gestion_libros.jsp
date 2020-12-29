<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>

<meta charset="ISO-8859-1">
<title>Gestión de libros</title>

</head>
<body>
	<jsp:include page="/view/login/menu_admin.jsp" flush="true" />
	<br>

	<h2 class="mx-auto" style="text-align: center;">Gestión de Libros</h2>
	<br>
	
	<div class="container overflow-hidden">
		<div class="row gy-5">
			<div class="col-6">
				<div class="p-3">
					<label for="isbnTXT" class="form-label">ISBN</label> <input
						type="text" class="form-control" id="isbnTXT"
						placeholder="Por ejemplo: 843030407X" required>
				</div>
			</div>

			<div class="col-6">
				<div class="p-3">
					<label for="tituloTXT" class="form-label">Título del libro</label>
					<input type="text" class="form-control" id="tituloTXT"
						placeholder="Por ejemplo: el libro de sofia. " required>
				</div>
			</div>

			<div class="col-6" style="margin-top: 20px">
				<div class="p-3">
					<label for="descripcionTXT" class="form-label">Descripción del libro</label> <input type="text" class="form-control"
						id="descripcionTXT"
						placeholder="Por ejemplo: Encuadernación de tapa blanda..." required>
				</div>
			</div>
			<div class="col-3" style="margin-top: 20px">
				<div class="p-3">
					<label for="numeroPaginasTXT" class="form-label">Num
						Páginas</label> <input type="text" class="form-control"
						id="numeroPaginasTXT" placeholder="Por ejemplo: 192" required>
				</div>
			</div>


			<div class="col-3" style="margin-top: 20px">
				<div class="p-3">
					<label for="inventarioTXT" class="form-label">Inventario</label> <input
						type="text" class="form-control" id="inventarioTXT"
						placeholder="Por ejemplo: 52" required>
				</div>
			</div>


			<div class="col-6" style="margin-top: 20px">
				<div class="p-3">
					<label for="precioVentaTXT" class="form-label">Precio Venta en Pesos</label>
					<input type="text" class="form-control" id="precioVentaTXT"
						placeholder="Por ejemplo: 452" required>
				</div>




			</div>
			<div class="col-6" style="margin-top: 20px">
				<div class="p-3">
					<label for="precioComprasTXT" class="form-label">Precio
						Compra en Pesos</label> <input type="text" class="form-control"
						id="precioComprasTXT" placeholder="Por ejemplo: 152" required>
				</div>
			</div>


			<div class="col-6" style="margin-top: 20px">
				<div class="p-3">
					<label for="autorCMB" class="form-label">Autor</label> <select
						class="form-select" aria-label="Default select example"
						id="autorCMB" required>
						<option selected>Seleccione un autor</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select>
				</div>
			</div>



			<div class="col-6" style="margin-top: 20px">
				<div class="p-3">
					<label for="editorialCMB" class="form-label">Editorial</label> <select
						id="editorialCMB" class="form-select"
						aria-label="Default select example">
						<option selected>Seleccione una editorial</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select>
				</div>

			</div>


			<div class="col-12">

				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">ISBN</th>
							<th scope="col">Título</th>
							<th scope="col">Descripción</th>
							<th scope="col">Número de Páginas</th>
							<th scope="col">Inventario</th>
							<th scope="col">Precio Compra</th>
							<th scope="col">Precio Venta</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td></td>
							<td></td>
							<td></td>
								<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
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
					<button id="btnConsultar" type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-search"></span> Consultar
					</button>
				</div>

			</div>


			<div class="col-2" style="margin-left: 5px">
				<div class="p-3">

					<button id="btnAgregar" type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-search"></span> Agregar
					</button>

				</div>

			</div>


			<div class="col-2" style="margin-left: 5px">
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
				<div class="col-2">
				<div class="p-3">

					<button id="btnLimpiar" type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-search"></span> Limpiar
					</button>

				</div>

			</div>
			
			
			
			
			</div>
			
			</div>
</body>
</html>