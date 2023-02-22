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

public class LoginServlet extends HttpServlet {
	
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter myPrintWriter = response.getWriter();
		HttpSession mySession = request.getSession(true);

		String myName = request.getParameter("nome").trim();
		String myPassword = request.getParameter("password").trim();
	//	myPrintWriter.println("Username: " + myName + " Password :" + myPassword);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			myConnection = DriverManager.getConnection(url, user, password);
			String select = "select * from utenti";
			myStatement = myConnection.createStatement();
			myResultSet = myStatement.executeQuery(select);

			while (myResultSet.next()) {
				String nomeUtente = myResultSet.getString("nome");
				String passwordUtente = myResultSet.getString("password");

				if (myName.equals(nomeUtente) && myPassword.equals(passwordUtente)) {
					mySession.setAttribute("logged", "si");

					break;
				}
			}

			if (mySession.getAttribute("logged").equals("si")) {
				myPrintWriter.println("<h1><font color=#116062>Benvenuto " + myName + "!" + "<ul>" +  "</font></h1>" + "<br><li><a href=\"utentiservlet\">Utenti</a></li>"
						+ "<br><li><a href=\"http://localhost:8080/MyEXE_Servlet.JDBC\">Home</a></li>" + "<br><li><a href=\"logoutservlet\">Logout</a></li>" + "</ul>");

			} 
			else {
				myPrintWriter.println("<h1><font color=#D21F1B>Nome utente e/o password sbagliate!</font></h1>");
			}

		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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
