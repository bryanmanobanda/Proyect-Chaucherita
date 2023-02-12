package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionarCuentaController
 */
@WebServlet("/GestionarCuentaController")
public class GestionarCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionarCuentaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			procesar(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			procesar(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void procesar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ruta = (request.getParameter("ruta") == null ? "listar":request.getParameter("ruta"));
		switch(ruta) {
		case "listar":
			this.listar(request, response);
			break;
		/*case "nuevo":
			this.nuevo(request, response);
			break;
		case "guardar":
			this.guardar(request, response);
			break;
		case "eliminar":
			this.eliminar(request, response);
			break;
		case "actualizar":
			this.actualizar(request, response);
			break;
		case "guardarA":
			this.actualizarDato(request, response);
			break;*/
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.getRequestDispatcher("jsp/PanelPrincipal.jsp").forward(request,response);
	}

}
