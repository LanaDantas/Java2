package it.lanadantas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/catalogo")

public class CatalogoServlet extends HttpServlet {

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

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			myConnection = DriverManager.getConnection(url, user, password);
			System.out.println("Conessione successfull");
			myStatement = myConnection.createStatement();
			String select = "SELECT * FROM prodotti";
			myResultSet = myStatement.executeQuery(select);


			myPrintWriter.println("<html><head><title>Catalogo Prodotti</title></head></body>");
			myPrintWriter.println("<h1>Catalogo Prodotti</h1>");
			
			myPrintWriter.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Catalogo</title></head><body>");
			myPrintWriter.println("<hr>" + "<a href='index.html'>Home</a> | " + "<a href='catalogo'>Catalogo</a> | "
					+ "<a href='carrello'>Carrello</a> | " + "<a href='checkout'>Checkout</a> | "
					+ "<a href='login.html'>Login</a> | " + "<a href='signin.html'>Signin</a>" + "<hr>");

			while(myResultSet.next()) {
				String nomeProdotto = myResultSet.getString("nome");
				String marcaProdotto = myResultSet.getString("marca");
				String prezzoProdotto = myResultSet.getString("prezzo");

				int id_prodotto  = myResultSet.getInt("id_prodotto");
				
				myPrintWriter.println("<table width=600>");
				myPrintWriter.println("<tr><h2>");
				myPrintWriter.println("<td>" + myResultSet.getInt("id_prodotto") + "</td>");
				myPrintWriter.println("<td>" + " | " + myResultSet.getString("nome") + "</td>");
				myPrintWriter.println("<td>" + " | " + myResultSet.getString("marca") + "</td>");
				myPrintWriter.println("<td>" + " | " + myResultSet.getInt("prezzo") + " $ </td>");
				myPrintWriter.println("<td>" + " | " + "<a href=\"carrello?id_prodotto="+ id_prodotto + " " + nomeProdotto + " " + marcaProdotto + " " + prezzoProdotto + "\">Aggiungi al carrello</a>" + "</td>");

				myPrintWriter.println("</h2></tr>");
			}
			myPrintWriter.println("</table>");
			myPrintWriter.println("</body></html>");

			if (myResultSet != null) {
				try {
					myResultSet.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			} if (myStatement != null) {
				try {
					myStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			} if (myConnection != null) {
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			}
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (myPrintWriter != null) {
				myPrintWriter.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
