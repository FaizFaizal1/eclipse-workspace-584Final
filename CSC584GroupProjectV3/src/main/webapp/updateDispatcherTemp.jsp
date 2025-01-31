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
<form action="UpdateDispatcherControllerTemp" method="POST">
  <div class="mb-3">
    <label for="dispatcher_employment_type" class="form-label">dispatcher_employment_type</label> <br>   
    <input type="radio" id="dispatcher_employment_type" name="dispatcher_employment_type" value="Full-time">Full-time
    <input type="radio" id="dispatcher_employment_type" name="dispatcher_employment_type" value="Part-time">Part-time
  </div>
  <div class="mb-3">
    <label for="dispatcher_employment_type" class="form-label">dispatcher_status</label> <br>   
    <input type="radio" id="dispatcher_employment_type" name="dispatcher_employment_type" value="Full-time">Active
    <input type="radio" id="dispatcher_employment_type" name="dispatcher_employment_type" value="Part-time">Inactive
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