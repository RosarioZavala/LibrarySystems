<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>

<meta charset="ISO-8859-1">
<title>Test</title>

</head>
<body>
	<jsp:include page="/view/login/menu_admin.jsp" flush="true" />


	<h2 class="mx-auto" style="text-align: center;">Manejo de algunos
		componentes</h2>

	<div class="container overflow-hidden">
		<div class="row gy-5">
			<div class="col-7">
				<div class="p-3">
					<label for="usuarioTXT" class="form-label">Clave Autor</label> <input
						type="text" class="form-control" id="usuarioTXT"
						placeholder="Por ejemplo: CURP, No. de Ciudadano" required>
				</div>
			</div>

			<div class="col-5">
				<div class="p-3">
					<label for="nombreTXT" class="form-label">Nombre Completo
						del Autor</label> <input type="text" class="form-control" id="nombreTXT"
						placeholder="Nombre Completo del autor" required>
				</div>
			</div>

			<div class="col-2">
				<div class="p-3">
					<label for="otroTXT" class="form-label">Otro campo</label> <input
						type="text" class="form-control" id="otroTXT"
						placeholder="Otro campo" required>
				</div>
			</div>

			<div class="col-6">
				<div class="p-3">Custom column padding</div>
			</div>

		</div>
	</div>

</body>
</html>