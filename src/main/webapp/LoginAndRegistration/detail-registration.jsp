<%@ page import="com.revshop.Entity.LoginEntity"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Details Registration</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap"
	rel="stylesheet">
<!-- Basic Page Needs -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="keywords" content="Furniture, Decor, Interior">
<meta name="description"
	content="Furnitica - Minimalist Furniture HTML Template">
<meta name="author" content="tivatheme">
<!-- Mobile Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700"
	rel="stylesheet">
<!-- Vendor CSS -->
<base href="${pageContext.request.contextPath}/">
<link rel="stylesheet"
	href="Static/libs/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="Static/libs/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="Static/libs/nivo-slider/css/nivo-slider.css">
<link rel="stylesheet" href="Static/libs/nivo-slider/css/animate.css">
<link rel="stylesheet" href="Static/libs/nivo-slider/css/style.css">
<link rel="stylesheet"
	href="Static/libs/font-material/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="Static/libs/slider-range/css/jslider.css">
<link rel="stylesheet"
	href="Static/libs/owl-carousel/assets/owl.carousel.min.css">
<!-- Template CSS -->
<link rel="stylesheet" type="text/css" href="Static/css/style.css">
<link rel="stylesheet" type="text/css" href="Static/css/reponsive.css">
<style>
body {
	background-color: #f0f4f8; /* Light blue background */
	font-family: 'Poppins', sans-serif;
}

.main-content {
	padding-top: 50px;
}

.title-page {
	color: #007bff; /* Blue title */
	font-weight: 700;
	margin-bottom: 30px;
}

.register-form {
	background-color: white; /* White form background */
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2);
	/* Light blue shadow */
}

.form-control {
	border-radius: 4px;
	border: 1px solid #007bff; /* Blue border for inputs */
	padding: 10px;
	font-size: 16px;
}

.btn-primary {
	background-color: #0056b3; /* Darker blue button */
	border-color: #004085;
	font-weight: 600;
	padding: 10px 20px;
	border-radius: 4px;
}

.btn-primary:hover {
	background-color: #004085; /* Even darker blue on hover */
	border-color: #003766;
}

.back-to-top {
	position: fixed;
	bottom: 20px;
	right: 20px;
}

.back-to-top a {
	background-color: #007bff; /* Blue back to top button */
	color: white;
	padding: 10px 15px;
	border-radius: 50%;
	box-shadow: 0px 0px 10px rgba(0, 123, 255, 0.3);
}

.section-divider {
	margin: 20px 0;
	font-weight: bold;
	text-align: center;
	color: #007bff; /* Blue section divider */
}

.register-form .row .form-group {
	margin-bottom: 15px;
}
</style>
</head>
<body class="user-login blog">

	<%@ include file="includes/header_no-session.jsp" %>

	<!-- main content -->
	<div class="main-content">
		<!-- main -->
		<div id="wrapper-site">
			<div class="container">
				<div class="row">
					<div id="content-wrapper" class="col-12">
						<div id="main">
							<div id="content" class="page-content">
								<div class="register-form text-center">
									<h1 class="text-center title-page">Details Registration</h1>
									<div id="error-message"
										style="color: red; font-weight: bold; text-align: center;">
										<%
										if (request.getAttribute("RegistererrorMessage") != null) {
										%>
										<%=request.getAttribute("RegistererrorMessage")%>
										<%
										}
										%>
									</div>
									<br>
									<form id="customer-form"
										action="/RevShopRevature/DetailRegistrationServlet"
										method="POST" onsubmit="return validateForm()">
										<!-- Personal Details Section -->
										<div class="section-divider">Personal Details</div>
										<div class="row">
											<div class="form-group col-md-6">
												<input class="form-control" id="firstName" name="firstName"
													type="text" placeholder="First Name">
											</div>
											<div class="form-group col-md-6">
												<input class="form-control" id="lastName" name="lastName"
													type="text" placeholder="Last Name">
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<select class="form-control" id="gender" name="gender">
													<option value="" disabled selected>Select Gender</option>
													<option value="male">Male</option>
													<option value="female">Female</option>
													<option value="other">Other</option>
												</select>
											</div>
											<div class="form-group col-md-6">
												<input class="form-control" id="mobile" name="mobile"
													type="text" placeholder="Mobile">
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<input class="form-control" id="pincode" name="pincode"
													type="text" placeholder="Pincode">
											</div>
											<div class="form-group col-md-12">
												<textarea class="form-control" id="billingAddress"
													name="billingAddress" rows="4"
													placeholder="Billing Address" style="height: 100px;"></textarea>
											</div>
										</div>

										<%
										// Retrieve the LoginEntity object from the session
										LoginEntity user = (LoginEntity) session.getAttribute("user");
										if (user != null) {
										%>
										<input type="hidden" name="userId"
											value="<%=user.getUserId()%>"> <input type="hidden"
											name="email" value="<%=user.getEmail()%>">
										<%
										}

										// Check if the user object is not null and if the role is "seller"
										if (user != null && "seller".equals(user.getRole())) {
										%>
										<!-- Company Details Section -->
										<div class="section-divider">Company Details</div>
										<div class="row">
											<div class="form-group col-md-6">
												<input class="form-control" id="companyName"
													name="companyName" type="text" placeholder="Company Name">
											</div>
											<div class="form-group col-md-6">
												<input class="form-control" id="gstNumber" name="gstNumber"
													type="text" placeholder="GST Number">
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<input class="form-control" id="websiteUrl"
													name="websiteUrl" type="text" placeholder="Website URL">
											</div>
											<div class="form-group col-md-6">
												<input class="form-control" id="panNumber" name="panNumber"
													type="text" placeholder="PAN Number">
											</div>
										</div>

										<!-- Banking Details Section -->
										<div class="section-divider">Banking Details</div>
										<div class="row">
											<div class="form-group col-md-6">
												<input class="form-control" id="bankAccountNo"
													name="bankAccountNo" type="text"
													placeholder="Bank Account Number">
											</div>
											<div class="form-group col-md-6">
												<input class="form-control" id="ifsc" name="ifsc"
													type="text" placeholder="IFSC Code">
											</div>
										</div>
										<%
										}
										%>

										<div class="clearfix text-center">
											<button class="btn btn-primary" data-link-action="sign-in"
												type="submit">Submit Information</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- back to top -->
	<div class="back-to-top">
		<a href="#"> <i class="fa fa-long-arrow-up"></i></a>
	</div>
	<!-- Vendor JS -->
	<script src="Static/libs/jquery/jquery.min.js"></script>
	<script src="Static/libs/popper/popper.min.js"></script>
	<script src="Static/libs/bootstrap/js/bootstrap.min.js"></script>
	<script src="Static/libs/nivo-slider/js/jquery.nivo.slider.js"></script>
	<script src="Static/libs/owl-carousel/owl.carousel.min.js"></script>
	<script src="Static/libs/slider-range/js/tmpl.js"></script>
	<script src="Static/libs/slider-range/js/jquery.dependClass-0.1.js"></script>
	<script src="Static/libs/slider-range/js/draggable-0.1.js"></script>
	<script src="Static/libs/slider-range/js/jquery.slider.js"></script>
	<!-- Template JS -->
	<script src="Static/js/theme.js"></script>

	<!-- JavaScript Validation -->
	<script>
		function validateForm() {
			// Get all form fields
			var firstName = document.getElementById('firstName').value.trim();
			var lastName = document.getElementById('lastName').value.trim();
			var gender = document.getElementById('gender').value;
			var mobile = document.getElementById('mobile').value.trim();
			var pincode = document.getElementById('pincode').value.trim();
			var billingAddress = document.getElementById('billingAddress').value
					.trim();
			var companyName = document.getElementById('companyName');
			var gstNumber = document.getElementById('gstNumber');
			var websiteUrl = document.getElementById('websiteUrl');
			var panNumber = document.getElementById('panNumber');
			var bankAccountNo = document.getElementById('bankAccountNo');
			var ifsc = document.getElementById('ifsc');

			// Validate First Name
			if (firstName === '') {
				alert('Please enter your First Name.');
				return false;
			}

			// Validate Last Name
			if (lastName === '') {
				alert('Please enter your Last Name.');
				return false;
			}

			// Validate Gender
			if (gender === '') {
				alert('Please select your Gender.');
				return false;
			}

			// Validate Mobile Number
			var mobilePattern = /^[6-9]\d{9}$/;
			if (!mobilePattern.test(mobile)) {
				alert('Please enter a valid 10-digit mobile number starting with 6, 7, 8, or 9.');
				return false;
			}

			// Validate Pincode
			var pincodePattern = /^\d{6}$/;
			if (!pincodePattern.test(pincode)) {
				alert('Please enter a valid 6-digit pincode.');
				return false;
			}

			// Validate Billing Address
			if (billingAddress === '') {
				alert('Please enter your Billing Address.');
				return false;
			}

			// If the user is a seller, validate the additional fields
			if (companyName && companyName.value.trim() === '') {
				alert('Please enter your Company Name.');
				return false;
			}

			if (gstNumber && gstNumber.value.trim() === '') {
				alert('Please enter your GST Number.');
				return false;
			}

			if (websiteUrl && websiteUrl.value.trim() === '') {
				alert('Please enter your Website URL.');
				return false;
			}

			if (panNumber && panNumber.value.trim() === '') {
				alert('Please enter your PAN Number.');
				return false;
			}

			if (bankAccountNo && bankAccountNo.value.trim() === '') {
				alert('Please enter your Bank Account Number.');
				return false;
			}

			if (ifsc && ifsc.value.trim() === '') {
				alert('Please enter your Bank IFSC Code.');
				return false;
			}

			// If all validations pass, allow form submission
			return true;
		}
	</script>

	<%@ include file="includes/footer.jsp"%>

</body>
</html>
