package models;

import java.util.Date;

public class Order  {

	private int order_id;
	private int user_id;
	private Date order_Date;
	private int quntity , product_id;
	public Order(int user_id, Date order_Date, int quntity, int product_id) {
		super();
		this.user_id = user_id;
		this.order_Date = order_Date;
		this.quntity = quntity;
		this.product_id = product_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getOrder_Date() {
		return order_Date;
	}
	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Order(int order_id, int user_id, Date order_Date, int quntity, int product_id) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_Date = order_Date;
		this.quntity = quntity;
		this.product_id = product_id;
	}
	
	
	
	
	
	
}
