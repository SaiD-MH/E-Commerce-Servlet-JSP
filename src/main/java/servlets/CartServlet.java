package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class CartServlet
 */

@WebServlet(urlPatterns = {"/addCart"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String temp = request.getParameter("product_id");
		int prod_id = Integer.parseInt(temp);
		
		
		ArrayList<Integer> carts = (ArrayList<Integer>)request.getSession().getAttribute("myCarts");
		carts.add(new Integer(prod_id ));
		
		response.sendRedirect("loged.jsp");
		
		
	}

	

}
