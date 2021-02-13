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

<title>Vista Cliente</title>
<script >
function find_libro() {
    this.document.getElementById("action").value = 'find';
    var frm = this.document.getElementById("librosFormClient");
    frm.submit();
}
function go_toBook() {
    this.document.getElementById("action").value = 'save';
    location.href=
    	"http://127.0.0.1:8080/LibrarySystems/detalleLibro?action=init&idLibroForSeeDetail="+
    	this.document.getElementById("idLibroForSeeDetail").value;
    
}

function selectRowForForSeeDetail(value) {
	this.document.getElementById("idLibroForSeeDetail").value = value;
}
</script>
</head>
<body>

	
	<div class="container">
		<div  style="width: 1100px;">
	<br>
	<jsp:include page="/view/viewClient/menuClient.jsp" flush="true" />
			<h3 class="mx-auto" > Libros </h3>
						
			<br>
		</div>

	</div>

<form action="libro" method="get" id="librosFormClient" role="form" enctype="multipart/form-data">
<input type="hidden" id="action" name="action">
		<input type="hidden" id="idLibroForSeeDetail"
			name="idLibroForSeeDetail">
	<div class="container overflow-hidden">
			<div class="row gy-6">
					<div class="col-2">
				<div class="p-3">
					<label for="buscarTXT"  class="form-label" style="margin-left: 100px"></label> 
				</div>
			</div>
|	<div class="col-2">
				<div class="p-3">

									<label for="isbnTXT" class="form-label">Ingresa un autor, Titulo o editorial</label>
				</div>
			</div>
			<div class="col-4">
				<div class="p-3">
					<input type="text" class="form-control" id="buscarTXT" name="buscarTXT"
						placeholder = "T&iacute;tulo,autor, editorial" required>
				</div>
			</div>
			<div class="col-2">
				<div class="p-3">

							<button id="btnbuscar" type="submit"
								class="btn btn-info" onclick="find_libro()">
								<span class="glyphicon glyphicon-search"></span>Buscar
							</button>
				</div>
			</div>
			
			<div class="col-1">
				<div class="p-3">

							<button id="btnVer" type="button"
								class="btn btn-info" onclick="go_toBook()">
								<span class="glyphicon glyphicon-search"></span>Ir a detalle Libro
							</button>
				</div>
			</div>
			</div>
				</div>	
	

	
	<div class="container overflow-hidden">
			
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">ISBN</th>
					<th scope="col">T&iacutetulo</th>
					<th scope="col">Autor</th>
					<th scope="col">Editorial</th>
					<th scope="col">Descripción</th>
					<th scope="col">Número de páginas</th>
					<th scope="col">Existencias</th>
					<th scope="col">Precio</th>
					<th scope="col">Explorar</th>
					</tr>
			</thead>
			<tbody>
				<c:forEach var="libro" items="${libros}">
								<tr id="${libro.idLibro}">
									<td>${libro.isbn}</td>
									<td>${libro.titulo}</td>
									<td>${libro.autor}</td>
									<td>${libro.editorial}</td> 
									<td>${libro.descripcion}</td>
									<td>${libro.paginas} p&aacuteg</td>
									<td>${libro.inventario}</td>
									<td>$ ${libro.precioCompra}</td>									
									<td><input class="form-check-input" type="radio"
										name="inlineRadioOptions" id="${libro.idLibro}"
										onchange="selectRowForForSeeDetail(this.value)"
										value="${libro.idLibro}"></td>
								</tr>
							</c:forEach>
			</tbody>
		</table>
				</div>
	
		</form>

</body>
</html>