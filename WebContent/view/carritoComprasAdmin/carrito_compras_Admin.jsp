<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>
<meta charset="ISO-8859-1">
<title>Carrito Compras</title>


</head>
<body>
	<jsp:include page="/view/login/menu_admin.jsp" flush="true" />
<br> 
	<h2  class="mx-auto" style="text-align: center;">Gestión de
		Carritos de Compra</h2>
		<br>
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
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>

    </tr>
    <tr>
      <th scope="row">2</th>

    </tr>
    <tr>
      <th scope="row">3</th>

    </tr>
  </tbody>
</table>
		<div class="container overflow-hidden">
			<div class="row gy-5">
				<div class="col-4">
				
				</div>

				<div class="col-4">
					<div class="p-3">

						<button id="btnActualizarStatus" type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span>Actualizar</button>

					</div>

				</div>






			</div>
		</div>
</div>
</body>
</html>