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
<form action="AddDispatcherController" method="POST">
 <div class="mb-3">
    <label for="dispatcher_first_name" class="form-label">dispatcher_first_name</label>    
    <input type="text" class="form-control" id="dispatcher_first_name" name="dispatcher_first_name" placeholder="dispatcher_first_name.." required>   
  </div>
 <div class="mb-3">
    <label for="dispatcher_last_name" class="form-label">dispatcher_last_name</label>    
    <input type="text" class="form-control" id="dispatcher_last_name" name="dispatcher_last_name" placeholder="dispatcher_last_name.." required>   
  </div>
 <div class="mb-3">
    <label for="dispatcher_phone_number" class="form-label">dispatcher_phone_number</label>    
    <input type="text" class="form-control" id="dispatcher_phone_number" name="dispatcher_phone_number" placeholder="dispatcher_phone_number.." required>   
  </div>
 <div class="mb-3">
    <label for="dispatcher_email" class="form-label">dispatcher_email</label>    
    <input type="email" class="form-control" id="dispatcher_email" name="dispatcher_email" placeholder="dispatcher_email.." required>   
  </div>
 <div class="mb-3">
    <label for="dispatcher_address" class="form-label">dispatcher_address</label>    
    <input type="text" class="form-control" id="dispatcher_address" name="dispatcher_address" placeholder="dispatcher_address.." required>   
  </div>
  <div class="mb-3">
  
    <label for="dispatcher_password" class="form-label">dispatcher_password</label>    
    <input type="password" class="form-control" id="dispatcher_password" name="dispatcher_password" placeholder="dispatcher_password.." required>   
  </div>
  <div class="mb-3">
    <label for="dispatcher_employment_type" class="form-label">dispatcher_employment_type</label> <br>   
    <input type="radio" id="dispatcher_employment_type" name="dispatcher_employment_type" value="Full-time">Full-time
    <input type="radio" id="dispatcher_employment_type" name="dispatcher_employment_type" value="Part-time">Part-time
  </div>
  <div class="mb-3">
    <input type="hidden" id="staff_role" name="staff_role" value="Dispatcher">   	
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