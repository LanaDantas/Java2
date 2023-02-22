package it.lanadantas.myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("myjdbc")
public class MyJdbc extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String url = "jdbc:mysql://localhost:3306/commerce";
	private static String user = "root";
	private static String password = "0_mysql_1";
	private static Connection myConnection = null;
	private static Statement myStatement = null;
	private static ResultSet myResultSet = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter myPrintWriter = response.getWriter();
		myPrintWriter.println("<h1>My JDBC via Servlet</h1>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			myConnection = DriverManager.getConnection(url, user, password);
			System.out.println("Conessione successfull");
			myStatement = myConnection.createStatement();
			myResultSet = myStatement.executeQuery("SELECT * FROM clienti");
			
			myPrintWriter.println("<table border=1 width=300>");
			while (myResultSet.next()) {
				myPrintWriter.println("<tr>");
				myPrintWriter.println("<td>" + myResultSet.getInt("id_cliente") + "</td>");
				myPrintWriter.println("<td>" + myResultSet.getString("nome") + "</td>");
				myPrintWriter.println("<td>" + myResultSet.getString("cognome") + "</td>");
				myPrintWriter.println("<td>" + myResultSet.getInt("eta") + "</td>");
				myPrintWriter.println("<td>" + myResultSet.getString("citta") + "</td>");
				myPrintWriter.println("</tr>");
	
			}
			myPrintWriter.println("</table>");
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (myPrintWriter != null) {
				myPrintWriter.close();
			}
			if (myResultSet != null) {
				try {
					myResultSet.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			}
			if (myStatement != null) {
				try {
					myStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			}
			if (myConnection != null) {
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			}
		}
	}
}
