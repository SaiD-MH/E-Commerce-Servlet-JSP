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
import java.util.HashMap;
import java.util.Set;

import database.connection.GetConnection;



@WebServlet(urlPatterns = {"/checkall"})
public class CheckAll extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public CheckAll() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
		
		
		HashMap<Integer, Integer>productQuntity =(HashMap<Integer, Integer>)request.getSession().getAttribute("productQuntity");
		ArrayList<Integer> mycarts = (ArrayList<Integer>)request.getSession().getAttribute("myCarts");
		Set<Integer> productIDs = productQuntity.keySet();
		
		Product myProduct ;
		
		//new ProductConnection(GetConnection.getConnection()).getProductById(mycarts.get(i));
		
		for(Integer id : productIDs) {
			
			
			myProduct = new ProductConnection(GetConnection.getConnection()).getProductById(id);
			int Quntity = productQuntity.get(id);
			User user =(User)request.getSession().getAttribute("user");
			//	public Order(int user_id, Date order_Date, int quntity, int product_id)
			Order myorder = new Order(user.getId() , new Date() , Quntity , id );
			
			new OrderConnection(GetConnection.getConnection()).SaveOrder(myorder);
			
		}
		productQuntity.clear();
		mycarts.clear();
		response.sendRedirect("myCarts.jsp");
		
		
		}catch (Exception e) {
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
