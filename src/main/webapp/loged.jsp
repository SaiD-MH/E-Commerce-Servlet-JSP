<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page 
	
	import="models.User"
	import="java.util.List"
	import="modelsConnections.ProductConnection"
	import="database.connection.GetConnection"
	import="models.Product"
	import="modelsConnections.OrderConnection"
	import="java.util.ArrayList"
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Commerce</title>

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



.content {
    margin-top: 15px;
    padding: 40px;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
   
}

.product{
	background-color: beige;
    width: 270px;
    padding-left: 50px;
    padding-top: 28px;
    height: auto;
	color: chocolate;
    font-family: serif;
    margin-top:15px;
}

.Buyying a {

    text-decoration: none;
    border: 1px solid;
    color: white;
}
.Productcard img{
	width:250px;
} 

.linkBox{
    background-color: chocolate;
    display:flex;
        justify-content: space-evenly;
    
    
    }
    
    .Buyying{
    display: flex;
    justify-content: space-evenly;
    
    }
    
    span{
    	
   	color: white;
    background-color: red;
    padding: 3px;
    border-radius: 27%;
    margin-left: 2px;

    }
    
</style>


<body> 

	
	

<nav class = "nav"> 
	
<div class="left">
	
	<h3 class="appName">E-Commerce</h3>

</div>
<div class="Hello">
	<h3 "welcome">Hello , <% 
	User  user =(User)session.getAttribute("user");
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
	

<%
	List test = new ProductConnection(GetConnection.getConnection()).GetProductList();
	
	

%>

<div class = "content">
	
	
	<%
		Product currentProd;
		for(int i = 0;i<test.size();i++){
		
		 currentProd = (Product)test.get(i);
		 
		
		%>
	
	<div class="product">
		
		<div class="Productcard">
		<img src="./cards/<%=currentProd.getImagePath()%>">
		
		</div>
		
		<div class="prodData">
		<h3 class="prodName">
		
			<%=currentProd.getProductName() %>
		</h3>
		<h4 class="Category">Category: 
		
			<%=currentProd.getCategory() %>
		
		</h4>
		<h4 class="price">Price: $<%=currentProd.getPrice() %></h4>
		</div>
		
		<div class="Buyying">
			
		<div class="linkBox">
			<a href="MakeOrder?productId=<%=currentProd.getId()%>&q=1" >Buy Now</a>	
		</div>
		
		<div class="linkBox">
			<a href="addCart?product_id=<%=currentProd.getId()%>">Add To Card </a>
		</div>
		
		</div>
		
		
	</div>
	
<%} %>
		
		
	</div>
	


</body>
</html>