<%@ page import="java.util.List"%>
<%@ page import="com.revshop.Entity.CartEntity"%>
<%@ page import="com.revshop.Entity.UserEntity"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
UserEntity userDetails = (UserEntity) request.getAttribute("userDetails");
List<CartEntity> cartItems = (List<CartEntity>) request.getAttribute("cartItems");

double totalAmount = 0;
for (CartEntity item : cartItems) {
    double priceAfterDiscount = item.getProductPrice() * (1 - item.getProductDiscount() / 100.0);
    double itemTotal = priceAfterDiscount * item.getQuantity();
    totalAmount += itemTotal;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
body {
	background-color: #f0f4f8; /* Light blue background */
	font-family: 'Poppins', sans-serif;
}

.section-divider {
	margin: 20px 0;
	font-weight: bold;
	text-align: center;
	color: #333;
}

.product-summary {
	margin: 20px 0;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
	background-color: white;
}

.product-summary h4 {
	font-weight: bold;
	margin-bottom: 10px;
	color: #007bff;
}

.product-item {
	display: flex;
	justify-content: space-between;
	margin-bottom: 10px;
}

.product-item span {
	display: inline-block;
	margin-right: 10px;
}

.product-total {
	font-weight: bold;
}

.checkout-container {
	display: flex;
	justify-content: space-between;
}

.checkout-form {
	flex: 0 0 65%; /* Adjusts the width of the details section */
	margin-right: 20px;
}

.order-summary {
	flex: 0 0 30%; /* Adjusts the width of the order summary */
	background-color: white;
	padding: 15px;
	border-radius: 8px;
	box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2);
	/* Light blue shadow */
}

.checkout-form form {
	text-align: left;
	background-color: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2);
	/* Light blue shadow */
}

.checkout-form .form-group {
	text-align: left;
	margin-bottom: 15px;
}

.checkout-form .form-control {
	width: 100%;
	text-align: left;
	margin: 0;
	padding: 10px;
	box-sizing: border-box;
	border-radius: 4px;
	border: 1px solid #ddd;
	background-color: #f9f9f9;
	transition: all 0.3s ease-in-out;
}

.checkout-form .form-control:focus {
	border-color: #007bff;
	background-color: #fff;
	box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

.checkout-form .btn-primary {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	font-weight: bold;
	background-color: #0056b3; /* Darker blue button */
	border-color: #004085;
	border-radius: 4px;
}

.checkout-form .btn-primary:hover {
	background-color: #004085; /* Even darker blue on hover */
}

.product-item {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 10px;
}

.product-item span {
	flex: 1; /* Makes each span take up an equal amount of space */
	text-align: left; /* Aligns text to the left */
}

.product-item span:nth-child(2) {
	text-align: center; /* Centers the quantity */
	flex: 0 0 50px; /* Fixed width for quantity */
}

.product-item span:nth-child(3) {
	text-align: right; /* Aligns the total price to the right */
	flex: 0 0 100px; /* Fixed width for total price */
}

.title-page {
	color: #007bff; /* Blue title */
	font-weight: 700;
	margin-bottom: 30px;
}

.logo {
	font-family: Arial, sans-serif; /* Or use a similar font */
	font-weight: 750; /* Extra bold */
	font-size: 24px; /* Adjust size as needed */
	color: #000000; /* Black color */
}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkout</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap"
	rel="stylesheet">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="keywords" content="Furniture, Decor, Interior">
<meta name="description"
	content="Furnitica - Minimalist Furniture HTML Template">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
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
<link rel="stylesheet" type="text/css" href="Static/css/style.css">
<link rel="stylesheet" type="text/css" href="Static/css/reponsive.css">
</head>
<body class="user-login blog">

	<%@ include file="LoginAndRegistration/includes/header.jsp"%>
	<!-- main content -->
	<div class="main-content">
		<div id="wrapper-site">
			<div>
				<div class="row">
					<div id="content-wrapper">
						<div id="main">
							<div id="content" class="page-content">
								<div class="checkout-form">
									<h1 class="text-center title-page">Checkout</h1>
									<div id="error-message"
										style="color: red; font-weight: bold; text-align: center;">
										<!-- Error messages will appear here -->
									</div>
									<br>
									<div class="order-summary">
										<div class="section-divider">Order Summary</div>
										<div class="product-summary">
                                            <h4>Products</h4>
                                            <%
                                            if (cartItems != null && !cartItems.isEmpty()) {
                                                for (CartEntity item : cartItems) {
                                                    double priceAfterDiscount = item.getProductPrice() * (1 - item.getProductDiscount() / 100.0);
                                                    double itemTotal = priceAfterDiscount * item.getQuantity();
                                            %>
                                            <div class="product-item">
                                                <span><%=item.getProductName()%></span> <span>X <%=item.getQuantity()%></span>
                                                <span class="product-total">Rs. <%=String.format("%.2f", itemTotal)%></span>
                                            </div>
                                            <%
                                                }
                                            %>
                                            <div class="product-item">
                                                <strong>Total Amount:</strong> <strong class="product-total">Rs. <%=String.format("%.2f", totalAmount)%></strong>
                                            </div>
                                            <%
                                            } else {
                                            %>
                                            <p>Your cart is currently empty.</p>
                                            <%
                                            }
                                            %>
                                        </div>
                                    </div>
									</div>
									<form id="checkout-form" action="CheckoutServlet" method="POST">
										<!-- Personal Details Section -->
										<div class="section-divider">Personal Details</div>
										<div class="row">
											<div class="form-group col-md-6">
												<input class="form-control" name="firstName" type="text"
													placeholder="First Name"
													value="<%=userDetails.getFirstName()%>" readonly>
											</div>
											<div class="form-group col-md-6">
												<input class="form-control" name="lastName" type="text"
													placeholder="Last Name"
													value="<%=userDetails.getLastName()%>" readonly>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<input class="form-control" name="gender" type="text"
													placeholder="Gender" value="<%=userDetails.getGender()%>"
													readonly>
											</div>
											<div class="form-group col-md-6">
												<input class="form-control" name="mobile" type="text"
													placeholder="Mobile" value="<%=userDetails.getMobile()%>"
													readonly>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-12">
												<input class="form-control" name="email" type="email"
													placeholder="Email" value="<%=userDetails.getEmail()%>"
													readonly>
											</div>
										</div>

										<!-- Shipping Address Section -->
										<div class="section-divider">Shipping Address</div>
										<div class="row">
											<div class="form-group col-md-6">
												<input class="form-control" name="address" type="text"
													placeholder="Address">
											</div>
											<div class="form-group col-md-6">
												<input class="form-control" name="city" type="text"
													placeholder="City">
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<input class="form-control" name="state" type="text"
													placeholder="State">
											</div>
											<div class="form-group col-md-6">
												<input class="form-control" name="zip" type="text"
													placeholder="Zip Code">
											</div>
										</div>

										<!-- Razorpay integration -->
										<input type="hidden" name="payment_id" id="payment_id"
											value="">
										<div class="clearfix text-center">
											<button type="button" class="btn btn-primary"
												id="rzp-button1">Pay Now</button>
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

<!-- Razorpay script -->
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
    // Razorpay configuration
    var options = {
        "key": "your_key", // Enter the Key ID generated from the Dashboard
        "amount": "<%= (int)(totalAmount * 100) %>", // Razorpay amount should be in paisa
        "currency": "INR",
        "name": "RevShop",
        "description": "Order Payment",
        "image": "/images/logo.png", // Logo of your company
        "handler": function (response){
            document.getElementById('payment_id').value = response.razorpay_payment_id;
            document.getElementById('checkout-form').submit();
        },
        "prefill": {
            "name": "<%= userDetails.getFirstName() + ' ' + userDetails.getLastName() %>",
            "email": "<%= userDetails.getEmail() %>",
            "contact": "<%= userDetails.getMobile() %>"
        },
        "theme": {
            "color": "#007bff"
        }
    };

    var rzp1 = new Razorpay(options);
    document.getElementById('rzp-button1').onclick = function(e) {
        rzp1.open();
        e.preventDefault();
    }
</script>


	<%@ include file="LoginAndRegistration/includes/footer.jsp"%>

</body>
</html>
