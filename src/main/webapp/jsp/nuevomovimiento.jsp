<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movimientos</title>
</head>
<body>
	<h1>Traspasar dinero entre cuentas</h1>
	<form action="GestionarMovimientoController?ruta=guardarMovimiento">
		<input type="radio" id="Balance" name="tipoCuenta" value="0"
			onclick="llenar1();" required> <label for="Balance">Balance</label><br>
		<input type="radio" id="IngresoEgreso" name="tipoCuenta" value="1"
			onclick="llenar2();" required> <label for="IngresoEgreso">Ingreso
			o Egreso</label><br> <label for="cuentaOrigen">Cuenta origen</label> <select
			name="cuentaOrigen" id="cuentaOrigen">

		</select><br> <label for="cuentaDestino">Cuenta Destino</label> <select
			name="cuentaDestino" id="cuentaDestino">
			<c:forEach items="${cuentasIngresoEgreso }" var="cuenta">
				<option>${cuenta.nombre}</option>
			</c:forEach>
			<c:forEach items="${cuentasBalance }" var="cuenta">
				<option>${cuenta.nombre}</option>
			</c:forEach>
		</select><br> <label for="monto">Agregar Monto</label> <input type="text">
		<input type="submit" value="Realizar Movimiento" />
	</form>


</body>
<script>
	function llenar1() {
		var html = '<c:forEach items="${cuentasBalance }" var="cuenta">';
		html += '<option>${cuenta.nombre}</option>';
		html += '</c:forEach>';
		document.getElementById("cuentaOrigen").innerHTML = html;
	}
	function llenar2() {
		var html = '<c:forEach items="${cuentasIngresoEgreso }" var="cuenta">';
		html += '<option>${cuenta.nombre}</option>';
		html += '</c:forEach>';
		document.getElementById("cuentaOrigen").innerHTML = html;
	}
</script>
</html>