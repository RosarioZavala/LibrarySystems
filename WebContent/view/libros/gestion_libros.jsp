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
<title>Gestión de libros</title>

<script>	
function save_libro() {
  this.document.getElementById("action").value = 'save';
  var frm = this.document.getElementById("librosForm");
  frm.submit();
}

function find_libro() {
    this.document.getElementById("action").value = 'find';
    var frm = this.document.getElementById("librosForm");
    frm.submit();
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

	<h2 class="mx-auto" style="text-align: center;">Gestión de Libros</h2>
	<br>
	<form action="libros" method="get" id="librosForm" role="form" enctype="multipart/form-data">
		<input type="hidden" id="action" name="action">
		
		<div class="container overflow-hidden">
			<div class="row gy-5">
				<div class="col-6">
					<div class="p-3">
						<label for="isbnTXT" class="form-label">ISBN</label> <input
							type="text" class="form-control" id="isbnTXT"
							placeholder="Por ejemplo: 843030407X" name="isbnTXT" required>
					</div>
				</div>

				<div class="col-6">
					<div class="p-3">
						<label for="tituloTXT" class="form-label">Título del libro</label>
						<input type="text" class="form-control" id="tituloTXT"
							name="tituloTXT" placeholder="Por ejemplo: el libro de sofia. "
							required>
					</div>
				</div>

				<div class="col-6" style="margin-top: 20px">
					<div class="p-3">
						<label for="descripcionTXT" class="form-label">Descripción
							del libro</label> <input type="text" class="form-control"
							id="descripcionTXT" name="descripcionTXT"
							placeholder="Por ejemplo: Encuadernación de tapa blanda..."
							required>
					</div>
				</div>
				<div class="col-3" style="margin-top: 20px">
					<div class="p-3">
						<label for="numeroPaginasTXT" class="form-label">Num
							Páginas</label> <input type="text" class="form-control"
							id="numeroPaginasTXT" name="numeroPaginasTXT"
							placeholder="Por ejemplo: 192" required>
					</div>
				</div>


				<div class="col-3" style="margin-top: 20px">
					<div class="p-3">
						<label for="inventarioTXT" class="form-label">Inventario</label> <input
							type="text" class="form-control" id="inventarioTXT"
							name="inventarioTXT" placeholder="Por ejemplo: 52" required>
					</div>
				</div>


				<div class="col-6" style="margin-top: 20px">
					<div class="p-3">
						<label for="precioVentaTXT" class="form-label">Precio
							Venta en Pesos</label> <input type="text" class="form-control"
							id="precioVentaTXT" name="precioVentaTXT"
							placeholder="Por ejemplo: 452" required>
					</div>




				</div>
				<div class="col-6" style="margin-top: 20px">
					<div class="p-3">
						<label for="precioComprasTXT" class="form-label">Precio
							Compra en Pesos</label> <input type="text" class="form-control"
							id="precioComprasTXT" name="precioComprasTXT"
							placeholder="Por ejemplo: 152" required>
					</div>
				</div>


				<div class="col-6" style="margin-top: 20px">
					<div class="p-3">
						<label for="autorSelect" class="form-label">Selecciona
							Autor</label> <select id="autorSelect" name="autorSelect"
							class="form-select" aria-label="Default select example">
							<c:forEach var="autor" items="${autores}">
								<option value="${autor.idautor}">${autor.nombreCompleto}</option>
							</c:forEach>
						</select>
					</div>
				</div>





				<div class="col-6" style="margin-top: 20px">
					<div class="p-3">


						<label for="editorialSelect" class="form-label">Selecciona
							Editorial</label> <select id="editorialSelect" name="editorialSelect"
							class="form-select" aria-label="Default select example">
							<c:forEach var="editorial" items="${editoriales}">
								<option value="${editorial.idEditorial}">${editorial.nombreEditorial}</option>
							</c:forEach>
						</select>


					</div>

				</div>
				
				<div class="col-6" style="margin-top: 20px">
					<div class="p-3">


						<label for="portadaTXT" class="form-label">Portada</label> 
						<input type="submit" name="btnPortada" id="btnPortada" value="Guardar">
						<input type="submit" name="btnPortada" id="portadaTXT" value="Regresar" >


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

							<c:forEach var="libros" items="${libros }">
								<tr id="${libros.idLibro }">
									<td>${libros.isbn}</td>
									<td>${libros.titulo}</td>
									<td>${libros.descripcion}</td>
									<td>${libros.paginas} pág</td>
									<td>${libros.inventario}</td>
									<td>$ ${libros.precioCompra}</td>
									<td>$ ${libros.precioVenta}</td>

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
						<button id="btnConsultar" type="button" class="btn btn-info" onclick="find_libro()">
							<span class="glyphicon glyphicon-search"></span> Consultar
						</button>
					</div>

				</div>


				<div class="col-2" style="margin-left: 5px">
					<div class="p-3">

						<button id="btnAgregar" type="button" class="btn btn-info"
						 onclick="save_libro()">
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
						<button id="btnLimpiar" type="reset" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Limpiar
						</button>

					</div>

				</div>




			</div>

		</div>
	</form>

</body>
</html>