package it.lanadantas.myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet ("/mygenericservlet?parametro1=10&parametro2=1")
public class MyGenericServlet extends GenericServlet {
	
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	PrintWriter myPrintWriter = response.getWriter();
    	myPrintWriter.println("<h1>My Generic Servlet</h1>");
        
    	// Ottiene i valori dei parametri presenti nella request
    	int n1 = Integer.parseInt(request.getParameter("parametro1"));
        int n2 = Integer.parseInt(request.getParameter("parametro2"));
        
        myPrintWriter.println("Risultato: " + (n1 + n2));
        myPrintWriter.close();
	
	}

}
