<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>
<meta charset="ISO-8859-1">
<title>Detalle Libro</title>
</head>
<script type="text/javascript">
	function calculaPrecio(value) {
		this.document.getElementById("totalTXT").value = (value * this.document
				.getElementById("precioTXT").value);

	}
</script>
<!-- ****sss -->

<body>
	<div class="container">
		<div style="width: 1100px;">

			<br>
			<h2 class="mx-auto" style="text-align: center;">Library Systems
			</h2>
			<br> <br>
			<h3 class="mx-auto">Detalle Libro</h3>
			<jsp:include page="/view/viewClient/menuClient.jsp" flush="true" />

		</div>
	</div>


	<form action="detalleLibro" method="post" id="detalleLibro" role="form">
		<input type="hidden" id="action" name="action"> <input
			type="hidden" id="idLibroForSeeDetail" name="idLibroForSeeDetail">


		<div class="container overflow-hidden">
			<div class="row gy-5">


				<div class="col-7">
					<div class="p-3">

						<img src="img/portad.jpg" style="margin-left: 55px;"
							card-img-top" alt="...">

					</div>

				</div>

				
				<div class="col-3">
					<div class="p-3">

						<label for="tituloLibroTXT" class="form-label"
							style="margin-left: -300px; margin-top: 40px;">
							T&iacutetulo</label> <input type="text" class="form-control"
							id="tituloLibroTXT" name="tituloLibroTXT"
							style="margin-left: -300px;" value="${detalleLibro.titulo}"
							readonly="readonly">

					</div>
				</div>

				<div class="col-2">
					<div class="p-3">

						<label for="gyjgj" class="form-label"
							style="margin-left: -300px; margin-top: 40px;"> ISBN</label> <input
							type="text" class="form-control" id="ISBNLibroTXT"
							name="ISBNLibroTXT" style="margin-left: -300px;"
							value="${detalleLibro.isbn}" readonly="readonly">
					</div>

				</div>



				<div class="col-7">
					<div class="p-3"></div>

				</div>

				<div class="col-3">
					<div class="p-1" style="margin-top: -360px;">

						<label for="autorTXT" class="form-label"
							style="margin-left: -290px;"> Autor</label> <input type="text"
							class="form-control" id="autorTXT" name="autorTXT"
							style="margin-left: -290px;" value="${detalleLibro.autor}"
							readonly="readonly">

					</div>
				</div>

				<div class="col-2">
					<div class="p-1" style="margin-top: -360px;">

						<label for="existenciaTXT" class="form-label"
							style="margin-left: -290px;"> Existencias</label> <input
							type="text" class="form-control" id="existenciaTXT"
							name="existenciaTXT" style="margin-left: -300px;"
							value="${detalleLibro.inventario}" readonly="readonly">

					</div>

				</div>

				<div class="col-7">
					<div class="p-1" style="margin-top: -300px;"></div>

				</div>

				<div class="col-5">
					<div class="p-1" style="margin-top: -340px;">

						<label for="descripcionTXT" class="form-label"
							style="margin-left: -290px;"> Descripción</label> <input
							type="text" class="form-control" id="descripcionTXT"
							name="descripcionTXT" style="margin-left: -290px;"
							value="${detalleLibro.descripcion}" readonly="readonly">

					</div>

				</div>

				<div class="col-7">
					<div class="p-1" style="margin-top: -300px;"></div>
				</div>

				<div class="col-1">
					<div class="p-1" style="margin-top: -300px;">

						<label for="cantidadTXT" class="form-label"
							style="margin-left: -290px;"> Cantidad</label> <input
							type="number" class="form-control"
							onchange="calculaPrecio(this.value)" id="cantidadTXT"
							name="cantidadTXT" style="margin-left: -290px;">

					</div>

				</div>

				<div class="col-2">
					<div class="p-1" style="margin-top: -300px;">

						<label for="precioTXT" class="form-label"
							style="margin-left: -290px;"> Precio</label> <input type="text"
							class="form-control" id="precioTXT" name="precioTXT"
							style="margin-left: -290px;" value="${detalleLibro.precioVenta}"
							readonly="readonly">

					</div>

				</div>

				<div class="col-2">
					<div class="p-1" style="margin-top: -300px;">

						<label for="totalTXT" class="form-label"
							style="margin-left: -290px;"> Total</label> <input type="number"
							class="form-control" id="totalTXT" name="totalTXT"
							style="margin-left: -290px;" readonly="readonly">
					</div>

				</div>

				<div class="col-5">
					<div class="p-1" style="margin-top: -250px;"></div>
				</div>
				<div class="col-3">
					<div class="p-3" style="margin-top: -250px;">

						<button id="btnAñadirAlCarrito" type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Añadir al
							carrito de compras
						</button>


					
				<div class="col-3">
					<div class="p-3">

						<label for="IDLibroTXT" class="form-label"
							style="margin-left: -300px; margin-top: 40px;">
							iD</label> <input type="text" class="form-control"
							id="IDLibroTXT" name="IDLibroTXT"
							style="margin-left: -300px;" value="${detalleLibro.idLibro}"
							readonly="readonly">
					</div>
				</div>
					</div>

				</div>




				<div class="col-4"></div>





			</div>
		</div>







	</form>
</body>
</html>