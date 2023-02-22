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

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String url = "jdbc:mysql://localhost:3306/commerce";
	private static String user = "root";
	private static String password = "0_mysql_1";
	private static Connection myConnection = null;
	private static Statement myStatement = null;
	private static PreparedStatement myPreparedStatement = null;
	private static ResultSet myResultSet = null;
	
	 private String host;
	 private String port;
	 private String user1;
	 private String pass;
	 
	 public void init() {
		 host = "smtp.gmail.com";
		 port = "465";
		 user1 = "lana.hanabi@gmail.com";
		 pass = "jxlqdmrwrvjonxuz";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Sessione
		
		response.setContentType("text/html");
		PrintWriter myPrintWriter = response.getWriter();
		HttpSession mySession = request.getSession(true);
		String sessionId = mySession.getId();

		String recipient = "lana.hanabi@gmail.com";
        String subject = "Conferma Acquisto Da Java Web Ecommerce";
        String content = "Abbiamo ricevuto il tuo ordine di acquisto.\n"
        		+ "La consegna è prevista per domani.\n"
        		+ mySession.getAttribute("carrello") + "\n"
        		+ "Totale ordine: " 
        		+ "Grazie";
        String resultMessage = "";
			
			try {
            EmailUtility.sendEmail(host, port, user1, pass, recipient, subject, content);
            resultMessage = "Email inviata";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "Errore invio email: " + ex.getMessage();
        } finally {
            request.setAttribute("message", resultMessage);
        }
				
		response.setContentType("text/html");
		myPrintWriter.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Checkout</title></head><body>");
		myPrintWriter.println("<h2>Checkout</h2>");		
		myPrintWriter.println(
				"<hr>"
				+ "<a href='index.html'>Home</a> | "
				+ "<a href='catalogo'>Catalogo</a> | "
				+ "<a href='carrello'>Carrello</a> | "
				+ "<a href='checkout'>Checkout</a> | "
				+ "<a href='login.html'>Login</a> | "
				+ "<a href='signin.html'>Signin</a>"  
				+ "<hr>");
		
		myPrintWriter.println("Messaggio: " + resultMessage);
		myPrintWriter.println("<hr>Session id: " + sessionId);
		myPrintWriter.println("</body></html>");
		
	/*	@SuppressWarnings("unchecked")
		List<String> carrello = (ArrayList<String>) mySession.getAttribute("carrello");
		carrello.forEach(id -> myPrintWriter.println(id));

		double totale = 0;
		int id = 0;
		String nome = "";
		String marca = "";
		double prezzo = 0;
		
		List<String> prodotti = new ArrayList<String>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			myConnection = DriverManager.getConnection(url, user, password);
			System.out.println("Conessione successfull");
		
			for (String prodotto : carrello) {
				myStatement = myConnection.createStatement();
				String select = "SELECT * FROM prodotti where id_prodotto='"+mySession.getAttribute("carrello")+"'";
				myResultSet = myStatement.executeQuery(select);

			while(myResultSet.next()) {
				myPrintWriter.println("<p>" + myResultSet.getString("nome"));
				myPrintWriter.println(myResultSet.getString("marca"));
				myPrintWriter.println(myResultSet.getString("prezzo") + "</p>");
				
				id = myResultSet.getInt("id_prodotto");
				nome = myResultSet.getString("nome");
				marca = myResultSet.getString("marca");
				prezzo = myResultSet.getInt("prezzo");
				String product = (id + nome + marca + prezzo);
				prodotti.add(product);
				totale += myResultSet.getDouble("prezzo");

			} if (myResultSet != null) {
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
		}
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (myPrintWriter != null) {
				myPrintWriter.close();
			}*/
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nomeCliente = request.getParameter("nome").trim();
			String passwordCliente = request.getParameter("password").trim();

			String clienteID = request.getParameter("id_cliente").trim();
			String prodottoID = request.getParameter("id_prodotto").trim();
			
		addOrdine(clienteID, prodottoID);
	}
	
	public void addOrdine(String clienteID, String prodottoID) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			myConnection = DriverManager.getConnection(url, user, password);
			System.out.println("Conessione successfull");
			String insert = "INSERT INTO ordini(id_ordine, id_cliente, id_prodotto) VALUES (?,?,?)";
			myPreparedStatement = myConnection.prepareStatement(insert);
			
			myPreparedStatement.setInt(1, Integer.parseInt(clienteID));
			myPreparedStatement.setInt(2,  Integer.parseInt(prodottoID));
			myPreparedStatement.executeUpdate();
			
			System.out.println("Stato inserimento: " + myPreparedStatement.executeUpdate());
			myPreparedStatement.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		}
	}
}

