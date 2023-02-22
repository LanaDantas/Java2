package it.lanadantas.myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet ("myhttpsession")
public class MyHttpSession extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter myPrintWriter = response.getWriter();

		// Ottiene la sessione corrente (se necessario la crea)
		HttpSession mySession = request.getSession(true);
		
		// Ogni sessione viene creata dal Server Web assegnandole un ID random
		String sessionId = mySession.getId();
		myPrintWriter.println("Session id: " + sessionId + "<br>");
		
		// Imposta variabili di sessione
		mySession.setAttribute("mysession.mystring", "Aldo");
		mySession.setAttribute("mysession.myboolean", "true");		
		String[] myArray = {"a","b","c"};
		mySession.setAttribute("mysession.myarray", myArray);
		
		// Legge gli attributi di sessione
		myPrintWriter.println(mySession.getAttribute("mysession.mystring"));
		myPrintWriter.println(mySession.getAttribute("mysession.myboolean"));
		String[] myAttributes = (String[]) mySession.getAttribute("mysession.myarray");
		for(String myA : myAttributes) {
			myPrintWriter.println(myA + " ");
		}
		
		// Cancella l'attributo dalla sessione
		// mySession.removeAttribute("mysession.boolean");
		//myPrintWritter.println(mySession.setAttribute("mysession.myboolean");
		// Rimuove l'intera sessione dal server web
		// mySession.invalidate();
		
		/* Esempio contatore di visite alla pagina */
		// Incrementa il contatore e lo salva in una nuova variabile di sessione 
		Integer count = (Integer) mySession.getAttribute("mysession.mycount");
		if (count == null) {
			count = 1;
		} else {
			count += 1;
		}
		mySession.setAttribute("mysession.mycount", count);
		
		
		myPrintWriter.println("<html><head><title>My HttpSession</title></head>");
		myPrintWriter.println("<body><h1>My SessionTracker</h1>");
		
		myPrintWriter.println("<p>Visite alla pagina: " + count + "</p>");

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
