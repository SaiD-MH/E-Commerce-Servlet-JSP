package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Order;
import models.Product;
import models.User;
import modelsConnections.OrderConnection;
import modelsConnections.ProductConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import database.connection.GetConnection;

/**
 * Servlet implementation class CartBuyNow
 */
@WebServlet(urlPatterns = {"/cartBuyNow"})
public class CartBuyNow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartBuyNow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

		String temp = request.getParameter("quntity");
		int q = Integer.parseInt(temp);
		temp = request.getParameter("prod_id");
		int prod_id = Integer.parseInt(temp);
		User user =(User)request.getSession().getAttribute("user");
		Product myProd = new ProductConnection(GetConnection.getConnection()).getProductById(prod_id);
		
		Order order = new Order(user.getId(),new Date(), q , prod_id);
		
		new OrderConnection(GetConnection.getConnection()).SaveOrder(order);
		
		ArrayList<Integer>carts=(ArrayList<Integer>)request.getSession().getAttribute("myCarts");
		carts.remove(Integer.valueOf(prod_id));
		
		response.sendRedirect("myCarts.jsp");
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
