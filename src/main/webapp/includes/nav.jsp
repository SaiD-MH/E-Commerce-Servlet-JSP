<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	width: 77%;
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
}

</style>
<body>


<nav class = "nav"> 
	
<div class="left">
	
	<h3 class="appName">E-Commerce</h3>

</div>

<div class="right"></div>

	<a href="" class="rightLink">Home</a>
	<a href="form.jsp" class="rightLink">Cart </a>
	<a href="form.jsp" class="rightLink">Orders </a>
	<a href="form.jsp" class="rightLink">Login</a>
	
</nav>



</body>
</html>