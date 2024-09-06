<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
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
    .register-form {
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
    .register-form .form-group select,
    .register-form .form-group input {
        margin-bottom: 15px;
    }
    .register-form .mt-3 a {
        color: #007bff;
        text-decoration: underline;
    }
</style>
</head>
<body class="user-login blog">
<%@ include file="includes/header.jsp" %>
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
                                    <h1 class="text-center title-page">Create Account</h1>
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
                                    <form id="customer-form" class="js-customer-form"
                                        action="/RevShopRevature/RegistrationServlet" method="POST" onsubmit="return validateForm()">
                                        <div>
                                            <div class="form-group">
                                                <div>
                                                    <select class="form-control" name="userType" id="userType">
                                                        <option value="" disabled selected>Select Account Type</option>
                                                        <option value="buyer">Buyer</option>
                                                        <option value="seller">Seller</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div>
                                                    <input class="form-control" id="username" name="username" type="text"
                                                        placeholder="Username">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div>
                                                    <input class="form-control" id="email" name="email" type="email"
                                                        placeholder="Email">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div>
                                                    <div class="input-group js-parent-focus">
                                                        <input class="form-control js-child-focus js-visible-password"
                                                            id="password" name="password" type="password" placeholder="Password">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clearfix">
                                            <div>
                                                <button class="btn btn-primary" data-link-action="sign-in"
                                                    type="submit">Create Account</button>
                                            </div>
                                        </div>
                                        <div class="mt-3">
                                            <p>
                                                Already have an account? <a href="user-login.html">Sign in</a>
                                            </p>
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
        var userType = document.getElementById('userType').value;
        var username = document.getElementById('username').value.trim();
        var email = document.getElementById('email').value.trim();
        var password = document.getElementById('password').value.trim();

        // Validate Account Type
        if (userType === '') {
            alert('Please select an Account Type.');
            return false;
        }

        // Validate Username
        if (username === '') {
            alert('Please enter a Username.');
            return false;
        } else if (username.length < 3 || username.length > 15) {
            alert('Username must be between 3 and 15 characters.');
            return false;
        }

        // Validate Email
        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (email === '') {
            alert('Please enter your Email.');
            return false;
        } else if (!emailPattern.test(email)) {
            alert('Please enter a valid Email address.');
            return false;
        }

        // Validate Password
        var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,}$/;
        if (password === '') {
            alert('Please enter a Password.');
            return false;
        } else if (!passwordPattern.test(password)) {
            alert('Password must be at least 6 characters long and include at least one lowercase letter, one uppercase letter, and one number.');
            return false;
        }

        // If all validations pass, allow form submission
        return true;
    }
</script>
  
    <%@ include file="includes/footer.jsp" %>
</body>
</html>
