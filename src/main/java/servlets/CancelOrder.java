package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelsConnections.OrderConnection;

import java.io.IOException;

import database.connection.GetConnection;
@WebServlet(urlPatterns = {"/cancelOrder"})
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CancelOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {
			
			String temp = request.getParameter("orderId");
			
			int orderId = Integer.parseInt(temp);
			
			
			new OrderConnection(GetConnection.getConnection()).deleteOrderByID(orderId); 

			response.sendRedirect("orderListing.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
