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
<form action="AdminController?action=updateProfile" method="POST">
 <div class="mb-3">
    <label for="dispatcher_first_name" class="form-label">admin_first_name</label>    
    <input type="text" class="form-control" id="admin_first_name" name="admin_first_name" placeholder="admin_first_name.." required>   
  </div>
 <div class="mb-3">
    <label for="admin_last_name" class="form-label">admin_last_name</label>    
    <input type="text" class="form-control" id="admin_last_name" name="admin_last_name" placeholder="admin_last_name.." required>   
  </div>
 <div class="mb-3">
    <label for="admin_phone_number" class="form-label">admin_phone_number</label>    
    <input type="text" class="form-control" id="admin_phone_number" name="admin_phone_number" placeholder="admin_phone_number.." required>   
  </div>
 <div class="mb-3">
    <label for="admin_address" class="form-label">admin_address</label>    
    <input type="text" class="form-control" id="admin_address" name="admin_address" placeholder="admin_address.." required>   
  </div>
 <div class="mb-3">
    <label for="admin_email" class="form-label">admin_email</label>    
    <input type="email" class="form-control" id="admin_email" name="admin_email" placeholder="admin_email.." required>   
  </div>
  <div class="mb-3">
    <label for="admin_password" class="form-label">admin_password</label>    
    <input type="password" class="form-control" id="admin_password" name="admin_password" placeholder="admin_password.." required>   
  </div>
  <div class="mb-3">
    <label for="admin_role" class="form-label">admin_role</label> <br>   
    <input type="radio" id="admin_role" name="admin_role" value="Lead">Lead
    <input type="radio" id="admin_role" name="admin_role" value="Member">Member
  </div>
  <div class="mb-3">
    <input type="hidden" id="staffID" name="staffID" value="${staff.staffID}">
  </div>
  <div class="mb-3">
    <input type="hidden" id="staff_role" name="staff_role" value="${staff.staffRole}">   	
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