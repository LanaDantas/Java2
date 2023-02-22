package it.lanadantas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/carrello")

public class CarrelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String url = "jdbc:mysql://localhost:3306/commerce";
	private static String user = "root";
	private static String password = "0_mysql_1";
	private static Connection myConnection = null;
	private static Statement myStatement = null;
	private static PreparedStatement myPreparedStatement = null;
	private static ResultSet myResultSet = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter myPrintWriter = response.getWriter();

		HttpSession mySession = request.getSession();
		String sessionId = mySession.getId();

		String buy = "";
		if (request.getParameter("id_prodotto") != null) {
			buy = request.getParameter("id_prodotto");

			mySession.setAttribute("buy", buy);
		}
		 
		myPrintWriter.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Carrello</title></head><body>");
		myPrintWriter.println("<h2>Carrello</h2>");
		myPrintWriter.println("<hr>" + "<a href='index.html'>Home</a> | " + "<a href='catalogo'>Catalogo</a> | "
				+ "<a href='carrello'>Carrello</a> | " + "<a href='checkout'>Checkout</a> | "
				+ "<a href='login.html'>Login</a> | " + "<a href='signin.html'>Signin</a>" + "<hr>");

		// Se il carrello in sessione non esiste lo crea e aggiunge il prodotto
		if (mySession.getAttribute("carrello") == null) {
			List<String> carrello = new ArrayList<String>();
			if (request.getParameter("id_prodotto") != null) {
				carrello.add(buy);
				mySession.setAttribute("carrello", carrello);
				// Reindirizza al catalogo
				getServletContext().getRequestDispatcher("/catalogo").forward(request, response);
			}
			// Se il carrello in sessione esiste, lo usa per creare un altro arraylist e
			// aggiunge il prodotto
		} else {
			@SuppressWarnings("unchecked")
			List<String> carrello = (ArrayList<String>) mySession.getAttribute("carrello");
			if (request.getParameter("id_prodotto") != null) {
				carrello.add(buy);
				mySession.setAttribute("carrello", carrello);
				// Reindirizza al catalogo
				getServletContext().getRequestDispatcher("/catalogo").forward(request, response);
			}
			myPrintWriter.println("Prodotto " + carrello + " aggiunto al carrello");
		}
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
