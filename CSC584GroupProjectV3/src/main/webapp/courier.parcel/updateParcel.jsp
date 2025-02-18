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
<meta charset="utf-8">
<title>FLDExpress</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid position-relative d-flex p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem;" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->


		<!-- Sidebar Start -->
		<div class="sidebar pe-4 pb-3">
			<nav class="navbar bg-secondary navbar-dark">
				<a href="index.html" class="navbar-brand mx-4 mb-3"> <img
					src="img/FLD_Express_Logo.png" alt="Brand Image"
					style="width: 150px; height: 150px; margin-right: 10px;">
					<h3 class="text-primary">
						</i>FLDExpress
					</h3>
				</a>
				<div class="d-flex align-items-center ms-4 mb-4">
					<div class="position-relative">
						<img class="rounded-circle" src="img/blankProfile.jpg" alt=""
							style="width: 40px; height: 40px;">
						<div
							class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
					</div>
					<div class="ms-3">
						<h6 class="mb-0"><c:out value="${sessionFirstName}"/></h6>
						<span>Admin</span>
					</div>
				</div>
				<div class="navbar-nav w-100">
					<a href="DashboardController" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a> <!-- index.html -->
					<div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Manage Staff</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="DispatcherController?action=listDispatchers" class="dropdown-item">Manage Dispatchers</a> <!-- element.html -->
                            <a href="AdminController?action=listAdmins" class="dropdown-item">Manage Admins</a> <!-- element.html -->
                        </div>
                    </div>
                    <a href="${sessionRole}Controller?action=update${sessionRole}Profile" class="nav-item nav-link"><i class="fa fa-address-card me-2"></i>Update Profile</a>
                    <a href="ParcelController?action=listParcels" class="nav-item nav-link"><i class="fa fa-boxes me-2"></i>Scan & Sort</a> <!-- form.html -->
                    <a href="PaymentController?action=listPayments" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>Payment</a> <!-- chart.html -->				
               </div>
			</nav>
		</div>
		<!-- Sidebar End -->


		<!-- Content Start -->
		<div class="content">
			<!-- Navbar Start -->
			<nav
				class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
				<a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
					<h2 class="text-primary mb-0">
						<i class="fa fa-user-edit"></i>
					</h2>
				</a> <a href="#" class="sidebar-toggler flex-shrink-0"> <i
					class="fa fa-bars"></i>
				</a>
				<form class="d-none d-md-flex ms-4">
					<input class="form-control bg-dark border-0" type="search"
						placeholder="Search">
				</form>
				<div class="navbar-nav align-items-center ms-auto">
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"> <img
							class="rounded-circle me-lg-2" src="img/blankProfile.jpg" alt=""
							style="width: 40px; height: 40px;"> <span
							class="d-none d-lg-inline-flex"><c:out value="${sessionFirstName}"/></span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
							<a href="LogoutController" class="dropdown-item">Log Out</a>
						</div>
					</div>
				</div>
			</nav>
			<!-- Navbar End -->


			<!-- Form Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="row g-4">
					<div class="col-sm-12 col-xl-6">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4">Update Parcel</h6>
                            <form action=ParcelController method="POST">
                            	<input type="hidden" name="parcelId" id="parcelId" value="<c:out value="${parcel.parcelId}"/>"/>
                                <div class="row mb-3">
                                    <label for="parcelName" class="col-sm-2 col-form-label">Parcel Name</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="parcelName" id="parcelName" class="form-control" value="${parcel.parcelName}"/>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="parcelAddress" class="col-sm-2 col-form-label">Parcel Address</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="parcelAddress" id="parcelAddress" class="form-control" value="${parcel.parcelAddress}"/>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="parcelWeight" class="col-sm-2 col-form-label">Parcel Weight</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="parcelWeight" id="parcelWeight" class="form-control" value="${parcel.parcelWeight}"/>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="parcelStatus" class="col-sm-2 col-form-label">Parcel Status</label>
									<div class="col-sm-10">
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio" id="parcelStatus" name="parcelStatus" value="Received" <c:if test="${parcel.parcelStatus == 'Received'}">checked</c:if>>
											<label class="form-check-label" for="parcelStatus">Received</label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio" id="parcelStatus" name="parcelStatus" value="Unreceived" <c:if test="${parcel.parcelStatus == 'Unreceived'}">checked</c:if>>
											<label class="form-check-label" for="parcelStatus">Unreceived</label>
										</div>
									</div>
                                </div>
                                <div class="row mb-3">
                                    <label for="staffId" class="col-sm-2 col-form-label">Staff Id</label> <!-- TODO make it a selection -->
                                    <div class="col-sm-10">
                                        <input type="text" name="staffId" id="staffId" class="form-control" value="${parcel.staffId}"/>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Update parcel</button>
                            </form>
                    	</div>
                    </div>
				</div>
			</div>
			<!-- Form End -->


			<!-- Footer Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="bg-secondary rounded-top p-4">
					<div class="row">
						<div class="col-12 col-sm-6 text-center text-sm-start">
							&copy; <a href="index.html">FLDExpress</a>, All Right Reserved.
						</div>
						<div class="col-12 col-sm-6 text-center text-sm-end">
							<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
							Designed By <a href="https://htmlcodex.com">HTML Codex</a> <br>Distributed
							By: <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
						</div>
					</div>
				</div>
			</div>
			<!-- Footer End -->
		</div>
		<!-- Content End -->


		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
			class="bi bi-arrow-up"></i></a>
	</div>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/chart/chart.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/tempusdominus/js/moment.min.js"></script>
	<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>
</html>