<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://127.0.0.1:8080/LibrarySystems/css/bootstrap.css">
<script src="http://127.0.0.1:8080/LibrarySystems/js/bootstrap.js"></script>
<meta charset="ISO-8859-1">
<title>Library Systems</title>
</head>
<body>

	<!-- este div es el que nos dar� cierto margen  para nuestro formulario. -->
	<div class="container">
		<div class="mx-auto" style="width: 450px;">
			<br>
			<h2 class="mx-auto" style="text-align: center;">Administrador</h2>
			<br>
			<form action="login" method="get" id="loginForm" role="form">
				<div class="mb-3">
					<label for="usuarioTXT" class="form-label">Usuario</label> <input
						type="text" class="form-control" id="usuarioTXT" name="usuarioTXT"
						placeholder="Escriba su usuario" required>
				</div>
				<div class="mb-3">
					<label for="passwordTXT" class="form-label">Contrase&ntilde;a</label>
					<input type="password" class="form-control" id="passwordTXT"
						name="passwordTXT" placeholder="Escriba su contrase&ntilde;a"
						required>
				</div>

				<br>

				<div class="mx-auto" style="text-align: center;">
					<button type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-search"></span> Autenticarse
					</button>
				</div>

			</form>

		</div>
	</div>

</body>

</html>