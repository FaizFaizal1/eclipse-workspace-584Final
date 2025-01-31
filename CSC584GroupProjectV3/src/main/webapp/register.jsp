<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);
  
  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">	
	<title>Login</title>
</head>
<body>
<div class="container">
<br><br>
<h3>Login</h3>
<br><br>
<form action="RegisterController" method="POST">
 <div class="mb-3">
    <label for="staffFirstName" class="form-label">Staff First Name</label>    
    <input type="text" class="form-control" id="staffFirstName" name="staffFirstName" placeholder="staffFirstName.." required>   
  </div>
 <div class="mb-3">
    <label for="staffLastName" class="form-label">Staff Last Name</label>    
    <input type="text" class="form-control" id="staffLastName" name="staffLastName" placeholder="staffLastName.." required>   
  </div>
 <div class="mb-3">
    <label for="staffPhoneNumber" class="form-label">Staff Phone Number</label>    
    <input type="text" class="form-control" id="staffPhoneNumber" name="staffPhoneNumber" placeholder="staffPhoneNumber.." required>   
  </div>
 <div class="mb-3">
    <label for="staffEmail" class="form-label">Staff Email</label>    
    <input type="email" class="form-control" id="staffEmail" name="staffEmail" placeholder="staffEmail.." required>   
  </div>
 <div class="mb-3">
    <label for="staffAddress" class="form-label">Staff Address</label>    
    <input type="text" class="form-control" id="staffAddress" name="staffAddress" placeholder="staffAddress.." required>   
  </div>
  <div class="mb-3">
    <label for="staffPassword" class="form-label">Staff Password</label>    
    <input type="password" class="form-control" id="staffPassword" name="staffPassword" placeholder="staffPassword.." required>   
  </div>
  <div class="mb-3">
    <label for="staffRole" class="form-label">Staff Role</label> <br>   
    <input type="radio" id="staffRole" name="staffRole" value="Dispatcher">Dispatcher
    <input type="radio" id="staffRole" name="staffRole" value="Admin">Admin   
  </div>
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit"> 
    <input type="reset" class="btn btn-primary" value="Reset">  
  </div>
</form>
</div>
</body>
</html>
<!-- Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
Date:12 January 2023 -->