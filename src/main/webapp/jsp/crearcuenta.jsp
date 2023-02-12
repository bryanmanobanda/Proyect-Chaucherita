<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear nueva cuenta</title>
</head>
<body>
	<form action="GestionarCuentaController?ruta=guardarCuenta" method="post">
		<input type="radio" id="Balance" name="tipoCuenta" value="0" required>
		<label for="Balance">Balance</label><br>
		<input type="radio" id="IngresoEgreso" name="tipoCuenta" value="1" required>
		<label for="IngresoEgreso">Ingreso o Egreso</label><br>
		id <input type="hidden" name="txtId" /> <br>
		Nombre <input type="text" name="txtNombreCuenta" /> <br> 
		Descripcion <input type="text" name="txtDescripcion" /><br>
		<input type="submit" name="Crear cuenta" />
	</form>
</body>
</html>