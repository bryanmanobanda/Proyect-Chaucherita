<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Movimientos</title>
</head>
<body>
	<h1>Movimientos</h1>
	<a href="GestionarCuentaController">Regresar</a>
	<h3>Ingresa el rango de fechas</h3>
	<form action="GestionarMovimientoController?ruta=mostrarEstado" method="post">
		Fecha Inicio<input type="date" name="fechaInicio" required/> <br> Fecha
		Fin<input type="date" name="fechaFin" required/>
		<input type="submit" value="consultar" />
	</form>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Cuenta de Origen</th>
				<th>Cuenta de Destino</th>
				<th>Concepto</th>
				<th>Fecha</th>
				<th>Valor</th>
			</tr>
			<c:forEach items="${movimientos}" var="movimiento">
				<tr>
					<td>${movimiento.id}</td>
					<td>${movimiento.cuentaOrigen.nombre}</td>
					<td>${movimiento.cuentaDestino.nombre}</td>
					<td>${movimiento.concepto}</td>
					<td>${movimiento.fecha}</td>
					<td>$ ${movimiento.valor}</td>
				</tr>
			</c:forEach>
		</thead>
	</table>
</body>
</html>