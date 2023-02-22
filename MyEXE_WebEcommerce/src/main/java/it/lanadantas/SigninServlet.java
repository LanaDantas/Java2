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
import javax.servlet.http.HttpSession;


@WebServlet ("/signin")

public class SigninServlet extends HttpServlet {
	
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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter myPrintWriter = response.getWriter();
		HttpSession session = request.getSession(true);


		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String eta = request.getParameter("eta");
		String citta = request.getParameter("citta");
		String password1 = request.getParameter("password1");
		
	      session.setAttribute("nome", nome );
	      session.setAttribute("cognome", cognome );
	      session.setAttribute("eta", eta);
	      session.setAttribute("citta", citta);
	      session.setAttribute("password1", password1);
	      
	      response.sendRedirect("http://localhost:8080/signin");
	      
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			myConnection = DriverManager.getConnection(url, user, password);
			String insert = "INSERT INTO clienti(nome, cognome, eta, citta, password) VALUES (?,?,?,?,?)";
			myPreparedStatement = myConnection.prepareStatement(insert);

			myPreparedStatement.setString(1, "nome");
			myPreparedStatement.setString(2, "cognome");
			myPreparedStatement.setInt(3, 22);
			myPreparedStatement.setString(4, "citta");
			myPreparedStatement.setString(5, "password");

			myPrintWriter.println("Stato inserimento: " + myPreparedStatement.executeUpdate());			
			
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			myPrintWriter.close();
		} if (myPreparedStatement != null) {
			try {
				myPreparedStatement.close();
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
	}
}
