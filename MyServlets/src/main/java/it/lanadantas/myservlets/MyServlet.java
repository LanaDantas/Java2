package it.lanadantas.myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet ("myservlet")
public class MyServlet implements Servlet {
	
	ServletConfig config = null; 
    /*
    L'interfaccia Servlet ha cinque metodi che occorre implementare e sovrascrivere in base alle proprie necessità.
    Il metodo accetta due argomenti del tipo ServletRequest e ServletResponse:
    - l'oggetto Request comunica al servlet la richiesta fatta dal client 
    - l'oggetto Response viene utilizzato per restituire la risposta al client
    L'unico metodo che viene chiamato più volte durante il ciclo di vita del servlet, ogni volta che il server riceve una richiesta.
    */
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter myPrintWriter = response.getWriter();
    	myPrintWriter.println("<h1>My Servlet che implemeta l'interfaccia Servlet</h1>");
    	myPrintWriter.println("<p>Scheme: <em>" + request.getScheme() + "</em></p>");
    	myPrintWriter.close();    	
    }
    
    /* Inizializzazione della Servlet
    Permette di accedere a risorse utili alla Servelt (es. aprire connessioni a un DB). 
    Viene eseguita una volta soltanto
    */
	@Override
    public void init(ServletConfig config) throws ServletException {
    	this.config = config;
    	System.out.println("Servlet init().");		
    }
	/* Restituisce un oggetto contenente eventuali parametri di inizializzazione e avvio della Servlet */
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	/* Restituisce eventuali informazioni sulla servlet, come autore, versione e copyright */
	@Override
	public String getServletInfo() {
		return "Esempio base di Servlet. Ugo Betori - 2022";
	}
	// La Servlet viene distrutta
	@Override
	public void destroy() {
		System.out.println("Servlet destroy().");
	}

}
