

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Tutoriaservlet
 */
@WebServlet("/Tutoria")
public class Tutoriaservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tutoriaservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nombre = request.getParameter("nombre");
		String profesor = request.getParameter("profesor");
		String dia = request.getParameter("dia");
		String hora = request.getParameter("hora");
		String asunto = request.getParameter("asunto");
		
		//String material1 = request.getParameter("material1");
		//String material2 = request.getParameter("material2");
		//String material3 = request.getParameter("material3");
		String [] arrayMateriales = request.getParameterValues("materiales");
		
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		
		salida.println("DATOS DE LA TUTORIA");
		salida.println("<br>");
		salida.println("Nombre: " +nombre);
		salida.println("<br>");
		salida.println("Profesor: " +profesor);
		salida.println("<br>");
		salida.println("Día " +dia);
		salida.println("<br>");
		salida.println("Hora: " +hora);
		salida.println("<br>");
		salida.println("Asunto " +asunto);
		salida.println("<br>");
		String materiales = " ";
		
		/*
		if(null!=material1) {
			materiales = material1;
			
		}
		if(null!=material2) {
			materiales += " "+material2;
			
		}
		if(null!=material3) {
			materiales += " "+material3;
			
		}
		salida.println("Material aportado " +materiales);		
		*/
			for(int i=0; i < arrayMateriales.length; i++) {
					materiales = arrayMateriales[i]+"";	
			}
			salida.print("Material aportado" +materiales);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
