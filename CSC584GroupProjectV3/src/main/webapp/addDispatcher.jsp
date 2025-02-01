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
	<title>Add Dispatcher</title>
</head>
<body>
<div class="container">
<br><br>
<h3>Add Dispatcher</h3>
<br><br>
<form action=DispatcherController method="POST">
 <div class="mb-3">
    <label for="dispatcherFirstName" class="form-label">Dispatcher First Name</label>    
    <input type="text" class="form-control" id="dispatcherFirstName" name="dispatcherFirstName" placeholder="dispatcherFirstName.." required>   
  </div>
 <div class="mb-3">
    <label for=dispatcherLastName class="form-label">Dispatcher Last Name</label>    
    <input type="text" class="form-control" id=dispatcherLastName name=dispatcherLastName placeholder="dispatcher_last_name.." required>   
  </div>
 <div class="mb-3">
    <label for="dispatcherPhoneNumber" class="form-label">Dispatcher Phone Number</label>    
    <input type="text" class="form-control" id="dispatcherPhoneNumber" name="dispatcherPhoneNumber" placeholder="dispatcherPhoneNumber.." required>   
  </div>
 <div class="mb-3">
    <label for="dispatcherEmail" class="form-label">Dispatcher Email</label>    
    <input type="email" class="form-control" id="dispatcherEmail" name="dispatcherEmail" placeholder="dispatcherEmail.." required>   
  </div>
 <div class="mb-3">
    <label for="dispatcherAddress" class="form-label">Dispatcher Address</label>    
    <input type="text" class="form-control" id="dispatcherAddress" name="dispatcherAddress" placeholder="dispatcherAddress.." required>   
  </div>
  <div class="mb-3">
    <label for="dispatcherPassword" class="form-label">Dispatcher Password</label>    
    <input type="password" class="form-control" id="dispatcherPassword" name="dispatcherPassword" placeholder="dispatcherPassword.." required>   
  </div>
  <div class="mb-3">
    <label for="dispatcherEmploymentType" class="form-label">Dispatcher Employment Type</label> <br>   
    <input type="radio" id="dispatcherEmploymentType" name="dispatcherEmploymentType" value="Full-time">Full-time
    <input type="radio" id="dispatcherEmploymentType" name="dispatcherEmploymentType" value="Part-time">Part-time
  </div>
  <div class="mb-3">
    <label for="dispatcherStatus" class="form-label">Dispatcher Status</label> <br>   
    <input type="radio" id="dispatcherStatus" name="dispatcherStatus" value="Active">Active
    <input type="radio" id="dispatcherStatus" name="dispatcherStatus" value="Inactive">Inactive
  </div>
  <div class="mb-3">
    <input type="hidden" id="staffRole" name="staffRole" value="Dispatcher">   	
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