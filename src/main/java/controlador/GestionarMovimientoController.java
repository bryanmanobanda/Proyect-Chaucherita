package controlador;

import java.io.IOException;
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
		
	}

	private void nuevoMovimiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IngresoEgreso modeloCuenta = new IngresoEgreso();
		List<IngresoEgreso> cuentasIngresoEgreso = modeloCuenta.getCuentas();
		request.setAttribute("cuentasIngresoEgreso", cuentasIngresoEgreso);

		Balance modeloCuentaBalance = new Balance();
		List<Balance> cuentasBalance = modeloCuentaBalance.getCuentas();
		request.setAttribute("cuentasBalance", cuentasBalance);

		request.getRequestDispatcher("/jsp/nuevomovimiento.jsp").forward(request, response);
	}

}
