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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UtentiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String url = "jdbc:mysql://localhost:3306/dbutenti";
	private static String user = "root";
	private static String password = "0_mysql_1";
	private static Connection myConnection = null;
	private static Statement myStatement = null;
	private static PreparedStatement myPreparedStatement2 = null;
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
			myResultSet = myStatement.executeQuery("SELECT * FROM utenti");

			HttpSession mySession = request.getSession();

			String mysession = (String) mySession.getAttribute("logged");

			if (mysession != null) {
				while (myResultSet.next()) {
					myPrintWriter.println("<table border=1 width=300>");
					myPrintWriter.println("<tr>");
					myPrintWriter.println("<td>" + myResultSet.getInt("id_utente") + "</td>");
					myPrintWriter.println("<td>" + myResultSet.getString("nome") + "</td>");
					myPrintWriter.println("<td>" + myResultSet.getString("password") + "</td>");
					myPrintWriter.println("</tr>");
				}
				myPrintWriter.println("</table>");

			} else {
				myPrintWriter.println("<h1><font color=#D21F1B>Fare prima il login!</font></h1>"
						+ "<br><strong><a href=\"http://localhost:8080/MyEXE_Servlet.JDBC\">Home</strong></a>");
			}
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

//logged=true/false
//getAttribute
