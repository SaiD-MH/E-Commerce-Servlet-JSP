package modelsConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.connection.GetConnection;
import models.Order;
import models.Product;

public class OrderConnection {

	private Connection connect ;
	public OrderConnection(Connection con) {
	
		this.connect = con;
	}
	
	
	public List ListAllOrdersOfUser(int user_id) {
		
		ArrayList<Order>lst = new ArrayList<Order>();
		try {
		
		String SQL_Query = "select * from orders where user_id = ?";
		
		PreparedStatement stat = connect.prepareStatement(SQL_Query);
		stat.setInt(1,user_id);
		
		ResultSet res = stat.executeQuery();
		
		while(res.next()) {
			
			int  oder_id 	= res.getInt("orderId");
			Date orderDate  = res.getDate("orderDate");
			int  quntity    = res.getInt("quntity");
			int  userId	= res.getInt("user_id");
			int  product_id = res.getInt("product_id");
			
			
			 
			Order order = new Order(oder_id,userId , orderDate,quntity,product_id);
			
			lst.add(order);
			
		}
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return  lst;
		
		
	}
	
	public void SaveOrder(Order order) {
		
		try {
			
			
			String SQL_Q = "insert into orders (orderId ,orderDate ,  quntity , user_id ,product_id  ) values(?,?,?,?,?)";
			
			PreparedStatement stat = connect.prepareStatement(SQL_Q);
			
			stat.setInt(1, order.getOrder_id());
			stat.setDate(2, new java.sql.Date(order.getOrder_Date().getTime() ) );
			stat.setInt(3, order.getQuntity());
			stat.setInt(4, order.getUser_id());
			stat.setInt(5, order.getProduct_id());
			
			int insertedRows = stat.executeUpdate();
			
			if(insertedRows > 0)
				System.out.println("Order Inserted :)");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public int countOrders(int user_id) {
		int totalOrders = -1 ;
		try {
			
		
		String SQL_Q = "select count(*) as 'total' from orders where user_id = ?";
		
		PreparedStatement stat = connect.prepareStatement(SQL_Q);
		stat.setInt(1, user_id);
		
		ResultSet res = stat.executeQuery();
		while(res.next()) {
			
		
		totalOrders = res.getInt("total");
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return totalOrders;
		
	}
	
	
	public void deleteOrderByID(int orID) {
		
		try {
		String SQL_Q = "delete from orders where orderId = ?";
		PreparedStatement stat = connect.prepareStatement(SQL_Q);
		stat.setInt(1, orID);
		int delRow = stat.executeUpdate();
		if(delRow > 0 )
			System.out.println("Order Deleted");
		
		ResultSet res = stat.executeQuery();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	/*
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		System.out.println(new OrderConnection(GetConnection.getConnection()).countOrders(1));
		
		
	}
	
	*/
}
