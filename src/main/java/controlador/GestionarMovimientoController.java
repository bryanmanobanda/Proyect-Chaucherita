package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Balance;
import modelo.Cuenta;
import modelo.Flujo;
import modelo.IngresoEgreso;
import modelo.Movimiento;

@WebServlet("/GestionarMovimientoController")
public class GestionarMovimientoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionarMovimientoController() {
		super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			procesar(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			procesar(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ruta = (request.getParameter("ruta") == null ? "listarMovimientos" : request.getParameter("ruta"));
		switch (ruta) {
		case "listarMovimientos":
			this.listarMovimientos(request, response);
			break;
		case "nuevoMovimiento":
			this.nuevoMovimiento(request, response);
			break;
		case "guardarMovimiento":
			this.guardarMovimiento(request, response);
			break;
		case "mostrarEstado":
			this.mostrarEstado(request, response);
			break;
		}
	}

	private void mostrarEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		System.out.println(fechaInicio);
		Movimiento modeloMovimiento = new Movimiento();
		List<Movimiento> rangoMovimientos = modeloMovimiento.rangoFechas(fechaInicio, fechaFin);
		
		request.setAttribute("movimientos", rangoMovimientos);
		request.getRequestDispatcher("/jsp/mostrarestado.jsp").forward(request, response);
	}


	private void listarMovimientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movimiento modeloMovimiento = new Movimiento();
		List<Movimiento> movimientos = modeloMovimiento.getMovimientos();
		
		request.setAttribute("movimientos", movimientos);
		request.getRequestDispatcher("/jsp/listarmovimientos.jsp").forward(request, response);
	}

	private void guardarMovimiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tipoCuentaOrigen = Integer.parseInt(request.getParameter("tipoCuentaOrigen"));
		int tipoCuentaDestino = Integer.parseInt(request.getParameter("tipoCuentaDestino"));
		
		int idCuentaOrigen = Integer.parseInt(request.getParameter("cuentaOrigen").split("-")[0]);
		int idCuentaDestino = Integer.parseInt(request.getParameter("cuentaDestino").split("-")[0]);
		
		double monto = Double.parseDouble(request.getParameter("txtMonto"));
		String concepto = request.getParameter("txtConcepto");
		LocalDate fecha = LocalDate.now();
		
		Cuenta cuentaOrigen;
		Cuenta cuentaDestino;
		
		if(tipoCuentaOrigen == 0) {
			Balance modeloCuenta = new Balance();
			modeloCuenta.buscar(idCuentaOrigen).restarMonto(monto);
			cuentaOrigen = modeloCuenta.buscar(idCuentaOrigen);
			if(tipoCuentaDestino == 0) {
				modeloCuenta.buscar(idCuentaDestino).sumarMonto(monto);
				cuentaDestino = modeloCuenta.buscar(idCuentaDestino);
			}else {
				IngresoEgreso modeloEgreso = new IngresoEgreso();
				Flujo flujo = new Flujo(0, monto, fecha);
				modeloEgreso.buscar(idCuentaDestino).agregarFlujo(flujo);
				cuentaDestino = modeloEgreso.buscar(idCuentaDestino);
			}
		}else {
			IngresoEgreso modeloIngreso = new IngresoEgreso();
			cuentaOrigen = modeloIngreso.buscar(idCuentaOrigen);
			Flujo flujo = new Flujo(0, monto, fecha);
			modeloIngreso.buscar(idCuentaOrigen).agregarFlujo(flujo);
			
			Balance modeloCuenta = new Balance();
			modeloCuenta.buscar(idCuentaDestino).sumarMonto(monto);
			cuentaDestino = modeloCuenta.buscar(idCuentaDestino);
		}
		Movimiento modeloMovimiento = new Movimiento();
		Movimiento movimiento = new Movimiento(0, cuentaOrigen, cuentaDestino, concepto, fecha, monto);
		modeloMovimiento.crearMovimiento(movimiento);
		this.listarMovimientos(request, response);
	}

	private void nuevoMovimiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IngresoEgreso modeloCuenta = new IngresoEgreso();
		List<IngresoEgreso> cuentasIngreso = modeloCuenta.getCuentasIngreso();
		List<IngresoEgreso> cuentasEgreso = modeloCuenta.getCuentasEgreso();
		request.setAttribute("cuentasIngreso", cuentasIngreso);
		request.setAttribute("cuentasEgreso", cuentasEgreso);

		Balance modeloCuentaBalance = new Balance();
		List<Balance> cuentasBalance = modeloCuentaBalance.getCuentas();
		request.setAttribute("cuentasBalance", cuentasBalance);

		request.getRequestDispatcher("/jsp/nuevomovimiento.jsp").forward(request, response);
	}

}
