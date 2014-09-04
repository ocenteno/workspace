package es.insa.curso.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet1() {
		super();
	}
	
	@Override
	protected void doPost(
				HttpServletRequest req, 
				HttpServletResponse resp)
			throws ServletException, IOException {
		String r = (String) req.getAttribute("r");
		System.out.println("Encontrado " + r);
	}

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1� EXTRAER LOS DATOS DE ENTRADA DE REQUEST
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String ope = request.getParameter("op");
		// 2� CONVERTIR LOS DATOS
		double x = Double.valueOf(op1);
		double y = Double.valueOf(op2);
		// 3� DELEGAR LA EJECUCI�N CONCRETA QUE TOQUE
		double resultado = calcular(x, y, ope);
		
		// EN SPRING EL DISPATCHER HACE ESTO
//		ModeAndView resultado = controlador1
//				.handlerRequestInternal(request, response);
//		viewResolver.procesar(resultado);
		
		// 4� DEVOLVER LOS RESULTADOS AL USUARIO
			// a) A LO BRUTO: COMO EL SYSO PERO EN WEB
		response.getWriter().print("El resultado es " + resultado);
			// b) MEDIANTE UNA P�GINA WEB
		request.setAttribute("r", resultado);
		request.getRequestDispatcher("pagina.jsp")
					.forward(request, response);
		// EL C�DIGO QUE PONGA YO AQU� YA NO SIRVE PARA NADA
	}

	private double calcular(double x, double y, String ope) {
		if ("sumar".equals(ope)) {
			return x + y;
		} else if ("restar".equals(ope)) {
			return x - y;
		} else if ("multiplicar".equals(ope)) {
			return x * y;
		} else if ("dividir".equals(ope)) {
			return x / y;
		} else {
			return Double.NaN;
		}
	}
}
