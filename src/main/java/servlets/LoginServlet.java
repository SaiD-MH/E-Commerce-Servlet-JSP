package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import modelsConnections.UserConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import database.connection.GetConnection;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter pw = response.getWriter();
    	pw.print("dqwdqw");
    	
    	
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try (PrintWriter pw = response.getWriter()){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			
			
		//	UserConnection userCon = new UserConnection(GetConnection.getConnection());
			
			User user = new UserConnection(GetConnection.getConnection()).isLoged(email,password);
			if(user!=null) {
				
				
				//ArrayList<Integer> myCarts = new ArrayList<Integer>();
				ArrayList<Integer>myCarts = new ArrayList<Integer>();
				HashMap<Integer, Integer>productQuntity = new HashMap<Integer, Integer>();
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("myCarts", myCarts);
				request.getSession().setAttribute("productQuntity", productQuntity);
				
				
				response.sendRedirect("loged.jsp");

				
				
			}
			else {
					
				
				response.sendRedirect("form.jsp");


			}



			}
			catch (Exception e) {
				// 
				System.out.println(e);
				
			}
			
			
		
	}

	

}
