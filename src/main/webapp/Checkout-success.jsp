<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Confirmation</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Basic Page Needs -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="keywords" content="Furniture, Decor, Interior">
<meta name="description" content="Furnitica - Minimalist Furniture HTML Template">
<meta name="author" content="tivatheme">
<!-- Mobile Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Vendor CSS -->
<base href="${pageContext.request.contextPath}/">
<link rel="stylesheet" href="Static/libs/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="Static/libs/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="Static/libs/nivo-slider/css/nivo-slider.css">
<link rel="stylesheet" href="Static/libs/nivo-slider/css/animate.css">
<link rel="stylesheet" href="Static/libs/nivo-slider/css/style.css">
<link rel="stylesheet" href="Static/libs/font-material/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="Static/libs/slider-range/css/jslider.css">
<link rel="stylesheet" href="Static/libs/owl-carousel/assets/owl.carousel.min.css">
<!-- Template CSS -->
<link rel="stylesheet" type="text/css" href="Static/css/style.css">
<link rel="stylesheet" type="text/css" href="Static/css/reponsive.css">
<style>
html, body {
    height: 100%;
    margin: 0;
    display: flex;
    flex-direction: column;
}

body {
    background-color: #f0f4f8; /* Light blue background */
    font-family: 'Poppins', sans-serif;
}

.main-content {
    flex: 1;
    display: flex;
    justify-content: center;
    align-items: center;
    padding-top: 50px;
    text-align: center;
}

.confirmation-message {
    background-color: white;
    padding: 50px;
    border-radius: 8px;
    box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2); /* Light blue shadow */
    display: inline-block;
    margin-top: 50px;
}

.confirmation-message h1 {
    color: #007bff; /* Blue heading */
    font-size: 36px;
    font-weight: 700;
    margin-bottom: 20px;
}

.confirmation-message p {
    font-size: 18px;
    color: #333;
    margin-bottom: 40px;
}

.confirmation-message .btn-home {
    background-color: #007bff; /* Blue button */
    color: white;
    padding: 12px 30px;
    font-size: 18px;
    border-radius: 4px;
    text-decoration: none;
    transition: background-color 0.3s;
}

.confirmation-message .btn-home:hover {
    background-color: #0056b3; /* Darker blue on hover */
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

footer {
    background-color: #007bff; /* Footer background color */
    color: white;
    padding: 20px;
    text-align: center;
}
</style>
</head>

<body>
<%@ include file="LoginAndRegistration/includes/header.jsp" %>

<div class="main-content">
    <div class="confirmation-message">
        <h1>Order Confirmed!</h1>
        <p>Thank you for your purchase. Your order has been successfully placed and is being processed.</p>
        <a href="HomeServlet" class="btn-home">Return to Home</a>
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

<%@ include file="LoginAndRegistration/includes/footer.jsp" %>

</body>
</html>
