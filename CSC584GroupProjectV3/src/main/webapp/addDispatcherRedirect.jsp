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
	<meta http-equiv = "refresh" content = "1"; url = "http://localhost:8080/CSC584GroupProject/UpdateDispatcherTempController?dispatcherEmploymentType=
	${staff.dispatcher.employmentType}&staffId=${staff.staffId}&dispatcherStatus=Inactive" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<title>Redirect</title>
</head>
<body>
<!-- 
<div class="container">
<br><br>
<h3>Login</h3>
<br><br>
<form action="UpdateDispatcherTempController" method="POST">
 <div class="mb-3">
    <label for="dispatcherFirstName" class="form-label">dispatcherFirstName</label>    
    <input type="text" class="form-control" id="dispatcherFirstName" name="dispatcherFirstName" placeholder="dispatcherFirstName.." required value="${staff.staffFirstName}">   
  </div>
 <div class="mb-3">
    <label for=dispatcherLastName class="form-label">dispatcher_last_name</label>    
    <input type="text" class="form-control" id=dispatcherLastName name=dispatcherLastName placeholder="dispatcher_last_name.." required value="${staff.staffLastName}">   
  </div>
 <div class="mb-3">
    <label for="dispatcherPhoneNumber" class="form-label">dispatcherPhoneNumber</label>    
    <input type="text" class="form-control" id="dispatcherPhoneNumber" name="dispatcherPhoneNumber" placeholder="dispatcherPhoneNumber.." required value="${staff.staffPhoneNumber}">   
  </div>
 <div class="mb-3">
    <label for="dispatcherEmail" class="form-label">dispatcherEmail</label>    
    <input type="email" class="form-control" id="dispatcherEmail" name="dispatcherEmail" placeholder="dispatcherEmail.." required value="${staff.staffEmail}">   
  </div>
 <div class="mb-3">
    <label for="dispatcherAddress" class="form-label">dispatcherAddress</label>    
    <input type="text" class="form-control" id="dispatcherAddress" name="dispatcherAddress" placeholder="dispatcherAddress.." required value="${staff.staffAddress}">   
  </div>
  <div class="mb-3">
    <label for="dispatcherPassword" class="form-label">dispatcherPassword</label>    
    <input type="password" class="form-control" id="dispatcherPassword" name="dispatcherPassword" placeholder="dispatcherPassword.." required value="${staff.staffPassword}">   
  </div>
  <div class="mb-3">
    <label for="dispatcherEmploymentType" class="form-label">dispatcherEmploymentType</label> <br>
  </div>
  <div class="mb-3">
    <input type="hidden" id="dispatcher_role" name="dispatcher_role" value="Dispatcher">
  </div>  
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit"> 
    <input type="reset" class="btn btn-primary" value="Reset">  
  </div>
</form>
</div>
 -->
</body>
</html>
<!-- Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
Date:12 January 2023 -->