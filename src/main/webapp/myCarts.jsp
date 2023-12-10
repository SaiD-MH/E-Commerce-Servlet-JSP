<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<%@ page 
	
	import="models.User"
	import="models.Order"
	import="java.util.List"
	import="modelsConnections.ProductConnection"
	import="database.connection.GetConnection"
	import="models.Product"
	import="modelsConnections.OrderConnection"
	import="java.util.HashMap"
	import="java.util.ArrayList"
	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My-Carts</title>
</head>


<style>


.nav{
	
	background-color: beige;
	height: 50px;
	display: flex;
    justify-content: space-between;
    padding-right: 17px;
	
}
.left{
	width: 11%;
}

.appName{
	color: darkgoldenrod;
    margin-left: 28px;
    margin-top: 14px;
    font-style: italic;
}

.rightLink{
	color: darkgoldenrod;
    text-decoration: none;
    font-size: larger;
    font-style: italic;
    font-family: serif;
    margin-top: 10px;
        margin-left: 5px;
    margin-right: -1px;
}
.right{

width: 271px;
        margin-top: 9px;
}
.Hello{
	color: darkgoldenrod;
    font-style: italic;
    font-family: serif;
    margin-top: -9px;
    

}

 span{
    	
   	color: white;
    background-color: red;
    padding: 3px;
    border-radius: 27%;
    margin-left: 2px;

    }
    
    .orderTitle h2{
        border: 1px solid;
    padding: 14px;
    background: burlywood;
    color: white;
    font-style: italic;
    font-family: emoji;
    
    }
    
    table {
            border-collapse: collapse;
            width: 100%;
            
        }
        th, td {
            border: 1px solid thick;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: beige;
        }
        
        .tOrders{
        color:darkgoldenrod;
        margin-top: -18px;
    background: burlywood;
        }
        
       .DataRow{
        	    border-bottom: 8px solid white;
    			color: white;
    			height: 52px;
    			    font-size: large;
    font-style: normal;
    font-weight: bold;
        }
        
        a.cancel {
    text-decoration: none;
    color: white;
    border: 1px solid red;
    background: red;
    padding: 2px;
    border-radius: 15%;
}


 input[type="submit"] {
    border: aliceblue;
    border-radius: 5px;
    padding: 7px 6px;
    background-color: cornsilk;
    color: darkgoldenrod;
    font-size: 13px;
    cursor: pointer;
    font-style: italic;
    cursor: pointer;
}

 input[type="text"] {
   
    width: 30px;
    padding-left: 16px;
}
.showiprice h2{
    color: burlywood;
    }
.showiprice{
    margin-bottom: 40px;
        display: flex;
    width: 380px;
    justify-content: space-between;
}
.showiprice a {
    border: aliceblue;
    border-radius: 15px;
    padding: 20px 15px;
    background-color: burlywood;
    font-size: 18px;
    cursor: pointer;
    font-style: italic;
    cursor: pointer;
    text-decoration: none;
    color: white;
    font-size: larger;

}

a.plus, a.minus {
    background: red;
    padding: 4px;
    font-size: large;
    border-radius: 29%;
    margin: 0px 3px 0px 3px; 
    text-decoration: none;
    color: white;
    }


</style>




<body>


	<% 
	User user =(User)session.getAttribute("user");
	ArrayList<Order>allOrders =(ArrayList<Order>) new OrderConnection(GetConnection.getConnection()).ListAllOrdersOfUser(user.getId());
	ArrayList<Integer> mycarts = (ArrayList<Integer>) session.getAttribute("myCarts");
	HashMap<Integer, Integer>productQuntity =(HashMap<Integer, Integer>)session.getAttribute("productQuntity");;
	ArrayList<Product> AllProducts = new ArrayList<Product>();
	Product myProduct ;
	
	Double totalP = 0.0;
	for(int i=0;i<mycarts.size();i++){
		
		myProduct = new ProductConnection(GetConnection.getConnection()).getProductById(mycarts.get(i));
		
		AllProducts.add(myProduct);
		totalP+=myProduct.getPrice();
		if(productQuntity.get(myProduct.getId())==null){
			productQuntity.put(myProduct.getId(), 1);
		}
		
		
	}
	
	
	
	%>
	

<nav class = "nav"> 
	
<div class="left">
	
	<h3 class="appName">E-Commerce</h3>

</div>
<div class="Hello">
	<h3 "welcome">Hello , <% 
	
	out.print(user.getUsername());
	%>
	</h3>
</div>
<div class="right">

	<a href="loged.jsp" class="rightLink">Home</a>
	<a href="myCarts.jsp" class="rightLink">Cart<span><%
	ArrayList<Integer>myCarts =(ArrayList<Integer>)session.getAttribute("myCarts");
	out.print(myCarts.size());
	%></span> </a>
	<a href="listOrders" class="rightLink">Orders<span><%=new OrderConnection(GetConnection.getConnection()).countOrders(user.getId()) %></span> </a> 
	<a href="logoutServlet" class="rightLink">Logout</a>
	</div>
	
</nav>


<div class="container">
<div class="orderTitle">
	
<h2>My-Carts /</h2>

</div>

<div class="showiprice"><h2>Total Price: $<%=totalP %></h2> <a href="checkall">Checkout</a></div>

<div class="tOrders">

<table>
    <tr>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Buy Now</th>
        <th>Cancel</th>
    </tr>
    
   
   <%  
   
   	for(int i = 0;i<AllProducts.size();i++){	
   	 
   		
   		 myProduct = AllProducts.get(i);
   
   %>
    <tr class="DataRow">
        <td><%=myProduct.getProductName() %></td>
        <td><%=myProduct.getCategory() %></td>
        <td><%=myProduct.getPrice() %></td>
        <td>
        	<form method="post" action="cartBuyNow?prod_id=<%=myProduct.getId()%>">
        	<a href="handelPlusandMinus?op=plus&prod_id=<%=myProduct.getId()%>" class="plus">+</a>
        	<input type="text" name="quntity" value="<%=productQuntity.get(myProduct.getId())%>"> 
        	<a href="handelPlusandMinus?op=minus&prod_id=<%=myProduct.getId()%>" class="minus">-</a>
        	<input type="submit" value="Buy Now" >
        </form>
        </td>
       
       
       
        <td><a href="removeCart?prodId=<%=myProduct.getId() %>" class="cancel">Remove</a></td>
        
        
    </tr>
    
    <%} %>


</table>


</div>




</div>



</body>
</html>