<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel Principal</title>
</head>
<body>
	<h1>Panel Principal</h1>
	<div>Ingresos</div>
	<div>Egresos</div>
	<div>Nominal</div>
	<div>Balance</div>
	
	
	<a href="GestionarCuentaController?ruta=nuevaCuenta">Nueva Cuenta</a>
	<h1>Listado de cuentas Ingreso o Egreso</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<c:forEach items="${cuentasIngresoEgreso }" var="cuenta">
			<tr>
				<td>${cuenta.id}</td>
				<td>${cuenta.nombre}</td>
				<td>${cuenta.descripcion}</td>
				<td><a href="GestionarCuentaController?ruta=actualizar&id=${cuenta.id}">Actualizar</a> | <a href="GestionarCuentaController?ruta=eliminar&id=${cuenta.id}">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<h1>Listado de cuentas Balance</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>Monto</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<c:forEach items="${cuentasBalance }" var="cuenta">
			<tr>
				<td>${cuenta.id}</td>
				<td>${cuenta.nombre}</td>
				<td>${cuenta.descripcion}</td>
				<td>${cuenta.monto}</td>
				<td><a href="GestionarCuentaController?ruta=actualizar&id=${cuenta.id}">Actualizar</a> | <a href="GestionarCuentaController?ruta=eliminar&id=${cuenta.id}">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>${tipoCuenta}</p>
	<a href="">Crear nueva cuenta</a>
	<a href="GestionarCuentaController?ruta=nuevoMovimiento">Traspasar dinero entre cuentas</a>
</body>
</html>