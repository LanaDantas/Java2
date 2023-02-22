package it.lanadantas.myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("myhttpservlet?myname=lana&mypassword=1")
public class MyHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Imposta il tipo di contenuto delle Response
		response.setContentType("text/html");
		// Accede all'oggetto di scrittura
		PrintWriter myPrintWriter = response.getWriter();
		// Scrive l'HTML
		myPrintWriter.println("<h1>My HttpServlet</h1>");
		myPrintWriter.println("<p>Gestione GET</p>");
		 
		
		myPrintWriter.println("<p>QueryString: " + request.getQueryString() + "</p>");
		myPrintWriter.println("<p>getParameter: " + request.getParameter("myname") + " " + request.getParameter("mypassword"));
		
		String myname = request.getParameter("myname");
		String mypassword = request.getParameter("mypassword");
		
		if (myname.equals("lana") && mypassword.equals("9")) {
			myPrintWriter.println("<img src='images/moon.jpg'><br>");
		} else {
			myPrintWriter.println("<img src='images/supernova.jpg'><br>");

		}
    	
       // myPrintWriter.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter myPrintWriter = response.getWriter();
		
		myPrintWriter.println("<h1>My HttpServlet</h1>");
		myPrintWriter.println("<p>Gestione POST</p>");

		// Ottiene i parametri dall'oggetto request
		String myName = request.getParameter("myname").trim();
		String myPassword = request.getParameter("mypassword").trim();
		
		if (myName.equals("lana") && myPassword.equals("9")) {
			myPrintWriter.println("<img src='images/moon.jpg'><br>");
		} else {
			myPrintWriter.println("<img src='images/supernova.jpg'><br>");

		}
		
		myPrintWriter.println("Dati inviati dal Form: " + myName + " " + myPassword);
	}
	
}
