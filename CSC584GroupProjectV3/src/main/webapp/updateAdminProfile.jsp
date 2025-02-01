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
<h3>Update Admin</h3>
<br><br>
<form action="AdminController" method="POST">
  <div class="mb-3">
    <input type="hidden" id="staffId" name="staffId" value="${staff.staffId}">   	
  </div> 
 <div class="mb-3">
    <label for="adminFirstName" class="form-label">Admin First Name</label>    
    <input type="text" class="form-control" id="adminFirstName" name="adminFirstName" placeholder="adminFirstName.." required>   
  </div>
 <div class="mb-3">
    <label for="adminLastName" class="form-label">Admin Last Name</label>    
    <input type="text" class="form-control" id="adminLastName" name="adminLastName" placeholder="adminLastName.." required>   
  </div>
 <div class="mb-3">
    <label for="adminPhoneNumber" class="form-label">Admin Phone Number</label>    
    <input type="text" class="form-control" id="adminPhoneNumber" name="adminPhoneNumber" placeholder="adminPhoneNumber.." required>   
  </div>
 <div class="mb-3">
    <label for="adminAddress" class="form-label">Admin Address</label>    
    <input type="text" class="form-control" id="adminAddress" name="adminAddress" placeholder="adminAddress.." required>   
  </div>
 <div class="mb-3">
    <label for="adminEmail" class="form-label">Admin Email</label>    
    <input type="email" class="form-control" id="adminEmail" name="adminEmail" placeholder="adminEmail.." required>   
  </div>
  <div class="mb-3">
    <label for="adminPassword" class="form-label">Admin Password</label>    
    <input type="password" class="form-control" id="adminPassword" name="adminPassword" placeholder="adminPassword.." required>   
  </div>
  <div class="mb-3">
    <label for="adminRole" class="form-label">Admin Role</label> <br>   
    <input type="radio" id="adminRole" name="adminRole" value="Lead">Lead
    <input type="radio" id="adminRole" name="adminRole" value="Member">Member
  </div>
  <div class="mb-3">
    <input type="hidden" id="staffId" name="staffId" value="${staff.staffId}">
  </div>
  <div class="mb-3">
    <input type="hidden" id="staffRole" name="staffRole" value="${staff.staffRole}">   	
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