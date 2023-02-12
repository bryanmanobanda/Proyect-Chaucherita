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
	<form action="" method="post">
		id <input type="hidden" name="txtId" /> <br>
		Nombre <input type="text" name="nombreCuenta" /> <br> 
		Descripcion <input type="text" name="descripcion" /> <br>
		<input type="submit" name="Crear cuenta" />
	</form>
</body>
</html>