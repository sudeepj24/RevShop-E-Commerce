<%@ page import="java.util.List"%>
<%@ page import="com.revshop.Entity.UserEntity" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Account</title>
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

.title-page {
	color: #007bff; /* Blue heading color */
	font-weight: 700;
	margin-bottom: 30px;
	text-align: center;
}

.content {
	background-color: white;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2); /* Light blue shadow */
}

.table th, .table td {
	font-size: 16px;
	color: #333;
	padding: 10px;
}

.table th {
	width: 200px;
	color: #007bff; /* Blue heading for table */
	text-align: left;
	font-weight: 600;
}

.breadcrumb-bg {
	background-color: #e9ecef;
	padding: 10px 0;
}

.breadcrumb a {
	color: #007bff; /* Blue breadcrumb links */
	text-decoration: none;
}

.breadcrumb a:hover {
	text-decoration: underline;
}
</style>
</head>

<body class="product-cart checkout-cart blog">
   
   <%@ include file="includes/header.jsp" %>
   
    <!-- main content -->
    <div class="main-content">
        <div class="wrap-banner">



            <div class="account head-account">
                <div class="container">
                    <div id="main">
                        <h1 class="title-page">My Account</h1>
                        <div class="content" id="block-history">
                            <table class="std table">
                                <tbody>
                                    <%
                                        UserEntity userDetails = (UserEntity) request.getAttribute("userDetails");
                                        if (userDetails != null) {
                                    %>
                                    <tr>
                                        <th class="first_item">My Name :</th>
                                        <td><%= userDetails.getFirstName() %> <%= userDetails.getLastName() %></td>
                                    </tr>
                                    <tr>
                                        <th class="first_item">Email :</th>
                                        <td><%= userDetails.getEmail() %></td>
                                    </tr>
                                    <tr>
                                        <th class="first_item">Address :</th>
                                        <td><%= userDetails.getBillingAddress() %></td>
                                    </tr>
                                    <tr>
                                        <th class="first_item">Postal/Zip Code :</th>
                                        <td><%= userDetails.getPincode() %></td>
                                    </tr>
                                    <tr>
                                        <th class="first_item">Phone :</th>
                                        <td><%= userDetails.getMobile() %></td>
                                    </tr>
                                    <tr>
                                        <th class="first_item">Gender :</th>
                                        <td><%= userDetails.getGender() %></td>
                                    </tr>
                                    <%
                                        } else {
                                    %>
                                    <tr>
                                        <td colspan="2">No user details available.</td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
     <%@ include file="includes/footer.jsp" %>
</body>
</html>
