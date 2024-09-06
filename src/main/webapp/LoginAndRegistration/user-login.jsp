<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
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
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700" rel="stylesheet">
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
    .login-form {
        background-color: white; /* White form background */
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2); /* Light blue shadow */
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
    .forgot-password a {
        color: #007bff;
        text-decoration: underline;
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
</style>
</head>
<body class="user-login blog">
<%@ include file="includes/header.jsp" %>
	<%
		session.invalidate();
	%>
    <!-- main content -->
    <div class="main-content">
        <!-- main -->
        <div id="wrapper-site">
            <div id="content-wrapper" class="full-width">
                <div id="main">
                    <div class="container">
                        <h1 class="text-center title-page">Log In</h1>
                        <div class="login-form">
                            <div id="error-message"
                                style="color: red; font-weight: bold; text-align: center;">
                                <%
                                if (request.getAttribute("LoginerrorMessage") != null) {
                                %>
                                <%=request.getAttribute("LoginerrorMessage")%>
                                <%
                                }
                                %>
                            </div>
                            <br>
                            <form id="customer-form" action="/RevShopRevature/LoginServlet"
                                method="POST">
                                <div class="form-group no-gutters">
                                    <input class="form-control" name="email" type="email"
                                        placeholder="Email">
                                </div>
                                <div class="form-group no-gutters">
                                    <div class="input-group js-parent-focus">
                                        <input class="form-control js-child-focus js-visible-password"
                                            name="password" type="password" placeholder="Password">
                                    </div>
                                </div>
                                <div class="no-gutters text-center">
                                    <div class="forgot-password">
                                        <a href="user-reset-password.html" rel="nofollow"> Forgot
                                            your password? </a>
                                    </div>
                                </div>
                                <div class="clearfix text-center">
                                    <button class="btn btn-primary" data-link-action="sign-in"
                                        type="submit">Sign in</button>
                                </div>
                            </form>
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
    <%@ include file="includes/footer.jsp" %>
    
</body>
</html>
