<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movimientos</title>
</head>
<body>
	<h1>Traspasar dinero entre cuentas</h1>
	<label for="cuentaOrigen">Cuenta origen</label>
	<select name="cuentaOrigen" id="cuentaOrigen">
	  <c:forEach items="${cuentasIngresoEgreso }" var="cuenta">
		<option>${cuenta.nombre}</option>
	  </c:forEach>
	  <c:forEach items="${cuentasBalance }" var="cuenta">
		<option>${cuenta.nombre}</option>
	  </c:forEach>
	</select><br>
	<label for="cuentaDestino">Cuenta Destino</label>
	<select name="cuentaDestino" id="cuentaDestino">
	  <c:forEach items="${cuentasIngresoEgreso }" var="cuenta">
		<option>${cuenta.nombre}|</option>
	  </c:forEach>
	  <c:forEach items="${cuentasBalance }" var="cuenta">
		<option>${cuenta.nombre}</option>
	  </c:forEach>
	</select><br>
	<label for="monto">Agregar Monto</label><br>
	<input type="text">
	
</body>
</html>