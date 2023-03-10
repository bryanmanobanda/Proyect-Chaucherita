package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Balance;
import modelo.Cuenta;
import modelo.IngresoEgreso;

/**
 * Servlet implementation class GestionarCuentaController
 */
@WebServlet("/GestionarCuentaController")
public class GestionarCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionarCuentaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			procesar(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		String ruta = (request.getParameter("ruta") == null ? "listar" : request.getParameter("ruta"));
		switch (ruta) {
		case "listar":
			this.listar(request, response);
			break;
		case "nuevaCuenta":
			this.nuevaCuenta(request, response);
			break;
		case "guardarCuenta":
			this.guardarCuenta(request, response);
			break;
		case "editarCuenta":
			this.editarCuenta(request, response);
			break;
		case "actualizarCuenta":
			this.actualizarCuenta(request, response);
			break;
		case "eliminarCuenta":
			this.eliminarCuenta(request, response);
			break;
		}
	}

	private void eliminarCuenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int idCuenta = Integer.parseInt(request.getParameter("id"));
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		if (tipo == 0) {
			Balance modeloCuenta = new Balance();
			modeloCuenta.eliminarCuenta(idCuenta);
		} else {
			IngresoEgreso modeloCuenta = new IngresoEgreso();
			modeloCuenta.eliminarCuenta(idCuenta);
		}
		this.listar(request, response);
	}

	private void actualizarCuenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int idCuenta = Integer.parseInt(request.getParameter("txtId"));
		String nombre = request.getParameter("txtNombreCuenta");
		String descripcion = request.getParameter("txtDescripcion");
		String tipo = request.getParameter("txtTipo");
		if (tipo.equals("Balance")) {
			Balance modeloCuenta = new Balance();
			modeloCuenta.actualizarCuenta(idCuenta, nombre, descripcion);
		} else {
			IngresoEgreso modeloCuenta = new IngresoEgreso();
			modeloCuenta.actualizarCuenta(idCuenta, nombre, descripcion);
		}
		this.listar(request, response);
	}

	private void editarCuenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCuenta = Integer.parseInt(request.getParameter("id"));
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		String nombre;
		String descripcion;
		if (tipo == 0) {
			Balance modeloCuenta = new Balance();
			Balance cuenta = modeloCuenta.buscar(idCuenta);
			request.setAttribute("cuenta", cuenta);
			request.setAttribute("tipo", "Balance");
		} else {
			IngresoEgreso modeloCuenta = new IngresoEgreso();
			IngresoEgreso cuenta = modeloCuenta.buscar(idCuenta);
			request.setAttribute("cuenta", cuenta);
			request.setAttribute("tipo", "Ingreso o Egreso");
		}

		request.getRequestDispatcher("jsp/actualizarcuenta.jsp").forward(request, response);
	}

	private void guardarCuenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int tipoCuenta = Integer.parseInt(request.getParameter("tipoCuenta"));
		String nombre = request.getParameter("txtNombreCuenta");
		String descripcion = request.getParameter("txtDescripcion");
		if (tipoCuenta == 0) {
			Balance cuenta = new Balance(0, 11, nombre, descripcion);
			Balance modeloCuenta = new Balance();
			modeloCuenta.crearCuenta(cuenta);
		} else {
			IngresoEgreso cuenta = new IngresoEgreso(false, 7, nombre, descripcion);
			IngresoEgreso modeloCuenta = new IngresoEgreso();
			modeloCuenta.crearCuenta(cuenta);
		}

		this.listar(request, response);

	}

	private void nuevaCuenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("jsp/crearcuenta.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		IngresoEgreso modeloCuenta = new IngresoEgreso();
		List<IngresoEgreso> cuentasIngresoEgreso = modeloCuenta.getCuentas();
		request.setAttribute("cuentasIngresoEgreso", cuentasIngresoEgreso);

		Balance modeloCuentaBalance = new Balance();
		List<Balance> cuentasBalance = modeloCuentaBalance.getCuentas();
		request.setAttribute("cuentasBalance", cuentasBalance);

		request.getRequestDispatcher("jsp/panelprincipal.jsp").forward(request, response);
	}

}
