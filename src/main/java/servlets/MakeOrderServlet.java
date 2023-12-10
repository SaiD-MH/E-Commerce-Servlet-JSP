package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Order;
import models.User;
import modelsConnections.OrderConnection;

import java.io.IOException;
import java.util.Date;

import database.connection.GetConnection;

/**
 * Servlet implementation class MakeOrderServlet
 */
@WebServlet(urlPatterns = {"/MakeOrder"})
public class MakeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
		String temp = request.getParameter("productId");
		int product_id = Integer.parseInt(temp);
		temp = request.getParameter("q");
		int quntity = Integer.parseInt(temp);

		//public Order(int user_id, Date order_Date, int quntity, int product_id) 
		
		User orderOwner = (User)request.getSession().getAttribute("user");
		int user_id = orderOwner.getId();
		
		Order order = new Order(user_id,new Date(),quntity,product_id);
		
		response.sendRedirect("loged.jsp");
		
		new OrderConnection(GetConnection.getConnection()).SaveOrder(order);
		} catch (Exception e) {
				
			
		}
		
	}

	

}
