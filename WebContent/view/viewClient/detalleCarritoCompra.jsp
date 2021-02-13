<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>
<meta charset="ISO-8859-1">
<title>Detalle Carrito Compras</title>

</head>
<body>
	<div class="container">
		<div  style="width: 1100px;">
	<br>
	<jsp:include page="/view/viewClient/menuClient.jsp" flush="true" />
			<h3 class="mx-auto" > Detalle Carrito Compras </h3>
						
			<br>
		</div>

	</div>
	

<form action="detalleLibro" method="post" id="detalleLibro" role="form">
<br>

<div class="container overflow-hidden">
			
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">T&iacutetulo</th>
					<th scope="col">Autor</th>
					<th scope="col">Editorial</th>
					<th scope="col">Precio</th>
					<th scope="col">Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th >1</th>

				</tr>
				<tr>
					<th >2</th>

				</tr>
				<tr>
					<th >3</th>

				</tr>
			</tbody>
		</table>
				</div>


<div class="container overflow-hidden">
		<div class="row gy-6">
				<div class="col-8">
				<div class="p-3">
				</div>
			</div>

			<div class="col-2" style=" margin-top:9px;">
				<div class="p-3">
					<label for="totalCCTXT" class="form-label">Total</label>
				</div>
			</div>
					<div class="col-2" ">
				<div class="p-3">
					<input type="text" class="form-control" id="totalCCTXT" required name="totalCCTXT">
				</div>
			</div>
				<div class="form-check" >
  <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked >
  <label class="form-check-label" for="flexCheckChecked" >
   He finalizado
  </label>
</div>

		<div class="col-6" style=" margin-top:9px;">
				<div class="p-3">
					<label for="direccionTXT" class="form-label">Ingrese direcci&oacuten a entregar art&iacuteculos</label>
				</div>
			</div>
					<div class="col-6" >
				<div class="p-3">
					<input type="text" class="form-control" id="direccionTXT" required name="direccionTXT">
				</div>
			</div>
				<div class="col-4" >
				<div class="p-3">
				</div>
					
			</div>
			<div class="col-3">
					<div class="p-3" >

						<button id="btnFinCompra" type="submit" class="btn btn-info" name="btnFinCompra">
							<span class="glyphicon glyphicon-search"></span> Finalizar Compra
						</button>

					</div>

				</div>
				
			
				</div>
					</div>
					
</form>

</body>
</html>