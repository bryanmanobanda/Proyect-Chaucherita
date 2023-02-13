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
		<input type="radio" id="BalanceOrigen" name="tipoCuentaOrigen" value="0"
			onclick="llenar1(0);" required> 
			<label for="BalanceOrigen">Balance</label><br>
		<input type="radio" id="IngresoOrigen" name="tipoCuentaOrigen" value="1"
			onclick="llenar2(0);" required>
			 <label for="IngresoOrigen">Ingreso o Egreso</label><br> 
			 <label for="cuentaOrigen">Cuenta origen</label>
			 <select name="cuentaOrigen" id="cuentaOrigen">

		</select><br> 
		<input type="radio" id="BalanceDestino" name="tipoCuentaDestino" value="0"
			onclick="llenar1(1);" required> 
			<label for="BalanceDestino">Balance</label><br>
		<input type="radio" id="EgresoDestino" name="tipoCuentaDestino" value="1"
			onclick="llenar2(1);" required>
			<label for="EgresoDestino">Ingreso o Egreso</label><br> 
			 <label for="cuentaDestino">Cuenta Destino</label>
		<select	name="cuentaDestino" id="cuentaDestino"></select><br> 
		Agregar Monto<input type="text" name="txtMonto"><br>
		Ingresar concepto<input type="text" name="txtConcepto"><br>
		<input type="submit" value="Realizar Movimiento" />
	</form>


</body>
<script>
	function llenar1(tipo) {
		if(tipo == 0){
			var html = '<c:forEach items="${cuentasBalance }" var="cuenta">';
			html += '<option>${cuenta.id}-${cuenta.nombre}</option>';
			html += '</c:forEach>';
			document.getElementById("cuentaOrigen").innerHTML = html;
		}
		if(tipo == 1){
			var html = '<c:forEach items="${cuentasBalance }" var="cuenta">';
			html += '<option>${cuenta.id}-${cuenta.nombre}</option>';
			html += '</c:forEach>';
			document.getElementById("cuentaDestino").innerHTML = html;
		}
		
	}
	function llenar2(tipo) {
		if(tipo == 0){
			var html = '<c:forEach items="${cuentasIngreso }" var="cuenta">';
			html += '<option>${cuenta.id}-${cuenta.nombre}</option>';
			html += '</c:forEach>';
			document.getElementById("cuentaOrigen").innerHTML = html;
		}
		if(tipo == 1){
			var html = '<c:forEach items="${cuentasEgreso }" var="cuenta">';
			html += '<option>${cuenta.id}-${cuenta.nombre}</option>';
			html += '</c:forEach>';
			document.getElementById("cuentaDestino").innerHTML = html;
		}
		
	}
</script>
</html>