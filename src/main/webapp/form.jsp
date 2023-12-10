<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style type="text/css">
	
	body{
	background-color:cornsilk; 
	}
	
	div{
		
		    width: 500px;
		    display:flex;
	}
	input{
	
	    margin-left: 10px;
    height: 20px;
    margin-top: 17px;
    
    }
    .mail{
    	margin-left:35px;
    }
    .formS{
    	
    lign-content: center;
    border: 1px solid peru;
    height: 250px;
    padding-left: 160px;
    padding-top: 100px;
    margin-left: 308px;
    margin-top: 100px;
    background-color: bisque;
    
    }
    
    .submit{
    	
   	width: 51px;
    height: 35px;
    margin-left: 137px;
    background-color: bisque;
    font-family: cursive;
    font-style: italic;
    padding: 6px;
    }
</style>

</head>

<body>
		
		<div class="formS">

		<form method="post" action="loginServlet">
			
			<div>
			<h4>Email</h4>
			<input type="text" class="mail" name="email">
			</div>
		
		
			<div>
			<h4>Password</h4>
			<input type="password" name="password">
			</div>
			
			<input type="submit" value="login" class="submit">
		</form>
	</div>

</body>
</html>