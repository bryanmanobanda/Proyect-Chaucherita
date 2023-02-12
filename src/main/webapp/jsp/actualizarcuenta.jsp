<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar</title>
</head>
<body>
	<form action="GestionarCuentaController?ruta=actualizarCuenta" method="post">
		id <input type="text" name="txtId" value="${cuenta.id }" readonly="readonly"/><br>
		Nombre <input type="text" name="txtNombreCuenta" value="${cuenta.nombre }"/> <br> 
		Descripcion <input type="text" name="txtDescripcion" value="${cuenta.descripcion }" /><br>
		<input type="submit" name="Actualizar Cuenta" />
	</form>
</body>
</html>