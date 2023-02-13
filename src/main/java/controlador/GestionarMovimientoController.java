package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Balance;
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
		}
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
		Date fecha = new Date();
		
		if(tipoCuentaOrigen == 0) {
			Balance modeloCuenta = new Balance();
			modeloCuenta.buscar(idCuentaOrigen).restarMonto(monto);
			if(tipoCuentaDestino == 0) {
				modeloCuenta.buscar(idCuentaDestino).sumarMonto(monto);
			}else {
				
			}
		}else {
			Balance modeloCuenta = new Balance();
			modeloCuenta.buscar(idCuentaDestino).restarMonto(monto);
		}
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
