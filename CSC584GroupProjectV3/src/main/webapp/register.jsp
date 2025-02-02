<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
// Prevent browser caching
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
// Check if the session exists
session = request.getSession(false);

// If the session is null or no user email is stored in the session, invalidate and redirect
if (session == null || session.getAttribute("sessionEmail") == null) {
	if (session != null) {
		session.invalidate(); // Invalidate session if it exists
	}
	response.sendRedirect(request.getContextPath() + "/signin.jsp"); // Redirect to the login page
	return; // Prevent further processing
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">	
	<title>Register</title>
</head>
<body>
<div class="container">
<br><br>
<h3>Register</h3>
<br><br>
<form action="RegisterController" method="POST">
 <div class="mb-3">
    <label for="staffFirstName" class="form-label">First Name</label>    
    <input type="text" class="form-control" id="staffFirstName" name="staffFirstName" placeholder="staffFirstName.." required>   
  </div>
 <div class="mb-3">
    <label for="staffLastName" class="form-label">Last Name</label>    
    <input type="text" class="form-control" id="staffLastName" name="staffLastName" placeholder="staffLastName.." required>   
  </div>
 <div class="mb-3">
    <label for="staffPhoneNumber" class="form-label">Phone Number</label>    
    <input type="text" class="form-control" id="staffPhoneNumber" name="staffPhoneNumber" placeholder="staffPhoneNumber.." required>   
  </div>
 <div class="mb-3">
    <label for="staffEmail" class="form-label">Email</label>    
    <input type="email" class="form-control" id="staffEmail" name="staffEmail" placeholder="staffEmail.." required>   
  </div>
 <div class="mb-3">
    <label for="staffAddress" class="form-label">Address</label>    
    <input type="text" class="form-control" id="staffAddress" name="staffAddress" placeholder="staffAddress.." required>   
  </div>
  <div class="mb-3">
    <label for="staffPassword" class="form-label">Password</label>    
    <input type="password" class="form-control" id="staffPassword" name="staffPassword" placeholder="staffPassword.." required>   
  </div>
  <div class="mb-3">
    <label for="staffRole" class="form-label">Role</label> <br>   
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