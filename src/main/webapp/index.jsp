<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page 
	import="java.util.List"
	import="modelsConnections.ProductConnection"
	import="database.connection.GetConnection"
	import="models.Product"
	import="models.User"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Commerce </title>

<style>

@charset "UTF-8";



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
    
    
</style>

</head>
<body>

<%@include file="./includes/nav.jsp" %>

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
			<a href="form.jsp" >Buy Now</a>	
		</div>
		
		<div class="linkBox">
			<a href="form.jsp">Add To Card </a>
		</div>
		
		</div>
		
		
	</div>
	
<%} %>
		
		
	</div>
	

</body>
</html>