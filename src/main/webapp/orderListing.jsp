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
<title>Orders</title>
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
</style>
<body>

	<% 
	User user =(User)session.getAttribute("user");
	ArrayList<Order>allOrders =(ArrayList<Order>) new OrderConnection(GetConnection.getConnection()).ListAllOrdersOfUser(user.getId());
	
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
	
<h2>Orders /</h2>

</div>

<div class="tOrders">
<table>
    <tr>
        <th>Date</th>
        <th>Product</th>
        <th>Category</th>
        <th>Quntity</th>
        <th>Price</th>
        <th>Cancel</th>
    </tr>
    
    <% for(int i = 0 ;i<allOrders.size();i++){
    	Order curOrder = allOrders.get(i); 
    	Product curProd = (Product) new ProductConnection(GetConnection.getConnection()).getProductById(curOrder.getProduct_id());	
    %>
    <tr class="DataRow">
        <td><%=curOrder.getOrder_Date() %></td>
        <td><%=curProd.getProductName()%></td>
        <td><%=curProd.getCategory() %></td>
        <td><%=curOrder.getQuntity() %></td>
        <td><%=curProd.getPrice() %></td>
        <td><a href="cancelOrder?orderId=<%=curOrder.getOrder_id() %>" class="cancel">Cancel</a></td>
        
    </tr>
  <%} %>

</table>

</div>




</div>

</body>
</html>