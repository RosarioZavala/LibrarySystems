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
<title>Library Systems</title>
</head>
<body>

	<jsp:include page="/view/login/menu_admin.jsp" flush="true" />

	<!-- este div es el que nos dará cierto margen  para nuestro formulario. -->
	<div class="container">
		<div class="mx-auto" style="width: 450px;">
			<br>
			<h2 class="mx-auto" style="text-align: center;">Gestión de
				Editoriales</h2>
			<br>
			<form action="login" method="get" id="loginForm" role="form">
				<div class="mb-3">
					
					<label for="editorialSelect" class="form-label">Selecciona Editorial</label> <select
						id="editorialSelect" name="editorialSelect" class="form-select"
						aria-label="Default select example">
						<option value="-1" selected>- Seleccione un valor -</option>
						<c:forEach var="i" items="${listEditorial}">
							<option value="${i[0]}">${i[1]} ${i[2]}</option>
						</c:forEach>
					</select>
				</div>

			</form>

		</div>
	</div>

</body>

</html>