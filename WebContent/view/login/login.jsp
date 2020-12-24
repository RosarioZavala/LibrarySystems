  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Systems</title>
</head>
<body>

    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.js"></script>

    <div class="container">
        <h2>Administrador</h2>
        <form action="login" method="get" id="loginForm"
            role="form">
           
            <div class="form-group col-xs-5">
                <label class=form-control-label-for-login">Usuario</label>
                <input type="text" name="usuarioTXT" id="usuarioTXT"
                    class="form-control-input-for-login" required="true"
                    placeholder="Escriba su usuario" />
            </div>
            <div class="form-group col-xs-5">
                <label class="form-control-label-for-login">Contrase&ntilde;a</label>
                <input type="password" name="passwordTXT" id="passwordTXT"
                    class="form-control-input-for-login" required="true"
                    placeholder="Escriba su contrase&ntilde;a" />
            </div>
            <div class="form-group col-xs-5">
                <br>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Autenticarse
                </button>
            </div>
            
        </form>
    </div>

</body>

</html>