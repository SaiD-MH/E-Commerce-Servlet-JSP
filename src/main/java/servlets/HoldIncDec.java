package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Servlet implementation class HoldIncDec
 */

@WebServlet(urlPatterns = {"/handelPlusandMinus"})
public class HoldIncDec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HoldIncDec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String op = request.getParameter("op");
		int prod_id = Integer.parseInt( request.getParameter("prod_id") );
		HashMap<Integer, Integer>productQuntity =(HashMap<Integer, Integer>)request.getSession().getAttribute("productQuntity");
		
		if(op.equals("plus")){
			
			productQuntity.put(prod_id, productQuntity.get(prod_id) + 1);
			
		}
		else {
			
			productQuntity.put(prod_id, productQuntity.get(prod_id) - 1);
			
		}
		
		
		response.sendRedirect("myCarts.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
