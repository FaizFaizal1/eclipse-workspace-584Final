<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
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
	<title>List All</title>	
</head>
<body>

<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">      
    	<a class="navbar-brand" href="<c:url value='/DashboardController'/>">Home</a>              
  		<a class="navbar-brand" class="active" href="<c:url value='/ProductController?action=listAll'/>">List All</a>
  		<a class="navbar-brand" href="<c:url value='/SupplierController?action=listSupplier'/>">Manage Supplier</a>
  		<a class="navbar-brand" href="<c:url value='/ProductController?action=listProduct'/>">Manage Product</a> 
  		<a class="navbar-brand" href="<c:url value='/RegisterController'/>">Manage User</a>
  		<a class="navbar-brand" href="<c:url value='/LogoutController'/>">Logout</a>       		
    </div>
  </nav>
</div>
<div class="container">
	<br><br>
	Welcome <b> <c:out value="${sessionEmail}" /> </b>
	<br><br>
<h3>List of Suppliers and Products</h3>
<br><br>
<table id="list" class="table table-striped" style="width:100%">
  <tr>
    <th>Staff ID</th>
    <th>Dispatcher First Name</th>
    <th>Dispatcher Last Name</th>
    <th>Dispatcher Phone Number</th>
    <th>Dispatcher Email</th>
    <th>Dispatcher Address</th>
    <th>Dispatcher Date Of Hire</th>
    <th>Dispatcher Status</th>
    <th>Dispatcher Employment Type</th>
    <th colspan="2">Actions</th>
  </tr>
 <c:forEach items="${dispatchers}" var="dispatcher">
  	<tr>
    <td><c:out value="${dispatcher.staffId}" /></td>
    <td><c:out value="${dispatcher.staff.staffFirstName}" /></td>
    <td><c:out value="${dispatcher.staff.staffLastName}" /></td>
    <td><c:out value="${dispatcher.staff.staffPhoneNumber}" /></td>  
    <td><c:out value="${dispatcher.staff.staffEmail}" /></td>
    <td><c:out value="${dispatcher.staff.staffAddress}" /></td>
    <td><c:out value="${dispatcher.staff.staffDateOfHire}" /></td>
    <td><c:out value="${dispatcher.dispatcherStatus}" /></td>
    <td><c:out value="${dispatcher.dispatcherEmploymentType}" /></td>   
    <td><a href="<c:url value='DeleteDispatcherController?staff_email=${dispatcher.staff.staffEmail}'/>" class="btn btn-primary">Delete Dispatcher</a></td>
    <td><a href="<c:url value='/ProductController?action=viewProduct&pid=${product.pid}'/>" class="btn btn-primary">View Product</a></td>     
     </tr>	   
    </c:forEach>       
</table>
</div>
<script>
$(document).ready(function() {
    $('#list').DataTable();
} );
</script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
<!-- Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
Date: 21 Jan 2025 -->