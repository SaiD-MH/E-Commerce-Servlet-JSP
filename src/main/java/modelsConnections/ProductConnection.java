package modelsConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.connection.GetConnection;
import models.Product;

public class ProductConnection {

	private Connection connect = null;
	
	
	public ProductConnection(Connection con) {
		
		this.connect = con;
		
	}
	
	public List GetProductList() {
		
		ArrayList<Product>lst = new ArrayList<Product>();
		try {
			
		
		
		
		
		String SQL_Query = "select * from product";
		
		Statement stat = connect.createStatement();
		
		ResultSet res = stat.executeQuery(SQL_Query);
		
		while(res.next()) {
			
			int id			 = res.getInt("id");
			String prodName  = res.getString("proudctName");
			String Cate      = res.getString("category"); 
			String img       = res.getString("image");
			Double Price     = res.getDouble("price");
			
			Product prod = new Product();
			
			prod.setId(id);
			prod.setCategory(Cate);
			prod.setImagePath(img);
			prod.setProductName(prodName);
			prod.setPrice(Price);
			
			lst.add(prod);
			
		}
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return  lst;
		
		
		
	}
	public Product getProductById(int Pid) {
		
		Product prod = new Product();
		try {
		String SQL_Query = "select * from product where id = ?";
	 
		PreparedStatement mystat = connect.prepareStatement(SQL_Query);
		
		mystat.setInt(1,Pid);
		
		ResultSet res = mystat.executeQuery();
		
		
		
		while(res.next()) {
			
			prod.setId(Pid);
			prod.setCategory(res.getString("category"));
			prod.setProductName(res.getString("proudctName"));
			prod.setPrice(res.getDouble("price"));
			prod.setImagePath(res.getString("image"));
			
		}
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			return prod;

		}
		
		
		
	}
	
	
	
	/*public static void main (String []args) throws ClassNotFoundException, SQLException {
		
		
		
		
		
		
		Product prod = new ProductConnection(GetConnection.getConnection()).getProductById(1) ;
		
		System.out.println(prod.getProductName() + " --- " + prod.getPrice());
			
		}
		*/
		
	}
	
	
	

