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
	<title>Update Staff</title>
</head>
<body>
<div class="container">
<br><br>
<h3>Update Staff</h3>
<br><br>
<form action="UpdateStaffController" method="POST">
 <div class="mb-3">
    <label for="staff_first_name" class="form-label">staff_first_name</label>    
    <input type="text" class="form-control" id="staff_first_name" name="staff_first_name" placeholder="staff_first_name.." required>   
  </div>
 <div class="mb-3">
    <label for="staff_last_name" class="form-label">staff_last_name</label>    
    <input type="text" class="form-control" id="staff_last_name" name="staff_last_name" placeholder="staff_last_name.." required>   
  </div>
 <div class="mb-3">
    <label for="staff_phone_number" class="form-label">staff_phone_number</label>    
    <input type="text" class="form-control" id="staff_phone_number" name="staff_phone_number" placeholder="staff_phone_number.." required>   
  </div>
 <div class="mb-3">
    <label for="staff_email" class="form-label">staff_email</label>    
    <input type="email" class="form-control" id="staff_email" name="staff_email" placeholder="staff_email.." required>   
  </div>
 <div class="mb-3">
    <label for="staff_address" class="form-label">staff_address</label>    
    <input type="text" class="form-control" id="staff_address" name="staff_address" placeholder="staff_address.." required>   
  </div>
  <div class="mb-3">
    <label for="staff_password" class="form-label">staff_password__${staffId}_${staff.staffRole}__${staff.staffId}</label>    
    <input type="password" class="form-control" id="staff_password" name="staff_password" placeholder="staff_password.." required>   
  </div>
  <div class="mb-3">
    <input type="hidden" id="staff_role" name="staff_role" value="${staff.staffRole}">   	
  </div>
  <div class="mb-3">
    <input type="hidden" id="staffId" name="staffId" value="${staff.staffId}">   	
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