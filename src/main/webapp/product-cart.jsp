<%@ page import="java.util.List"%>
<%@ page import="com.revshop.Entity.CartEntity"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shopping Cart</title>
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
    .cart-container {
        background-color: white; /* White form background */
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2); /* Light blue shadow */
    }
    .product-line-grid {
        margin-bottom: 20px;
    }
    .product-image img {
        max-width: 100%;
        border-radius: 8px;
    }
    .product-line-info {
        margin-bottom: 10px;
        font-size: 16px;
    }
    .product-price {
        color: #007bff;
        font-weight: bold;
    }
    .btn-primary {
        background-color: #0056b3; /* Darker blue button */
        border-color: #004085;
        font-weight: 600;
        padding: 8px 16px;
        border-radius: 4px;
        width: 100%;
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
    .cart-summary {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 123, 255, 0.1); /* Light shadow */
        margin-bottom: 20px;
        max-width: 350px;
        margin: 0 auto; /* Center the summary box */
        text-align: center;
    }
    .cart-summary .summary-label {
        font-weight: bold;
        margin-bottom: 10px;
    }
    .cart-summary .value {
        font-weight: bold;
        color: #007bff;
    }
</style>
</head>

<body class="product-cart checkout-cart blog">
<%@ include file="LoginAndRegistration/includes/header.jsp" %>
    <!-- main content -->
    <div class="main-content" id="cart">
        <!-- main -->
        <div id="wrapper-site">
            <div class="container">
                <div class="row">
                    <div id="content-wrapper" class="col-12">
                        <section id="main">
                            <h1 class="title-page text-center">Shopping Cart</h1>
                            <div class="cart-container">
                                <div class="cart-overview js-cart">
                                    <ul class="cart-items">
                                        <%
                                        List<CartEntity> cartItems = (List<CartEntity>) request.getAttribute("cartItems");
                                        double grandTotal = 0;

                                        if (cartItems != null && !cartItems.isEmpty()) {
                                            for (CartEntity item : cartItems) {
                                                // Calculate the effective price after discount
                                                double priceAfterDiscount = item.getProductPrice() * (1 - item.getProductDiscount() / 100.0);
                                                // Calculate the total price for the current item
                                                double itemTotal = priceAfterDiscount * item.getQuantity();
                                                // Add to grand total
                                                grandTotal += itemTotal;
                                        %>
                                        <li class="cart-item">
                                            <div class="product-line-grid row justify-content-between">
                                                <!-- product left content: image -->
                                                <div class="product-line-grid-left col-md-2">
                                                    <span class="product-image media-middle"> 
                                                        <a href="product-detail.html?productId=<%=item.getProductId()%>">
                                                            <img class="img-fluid" src="<%=item.getImgUrl()%>" alt="<%=item.getProductName()%>">
                                                        </a>
                                                    </span>
                                                </div>
                                                <div class="product-line-grid-body col-md-6">
                                                    <div class="product-line-info">
                                                        <a class="label" href="product-detail.html?productId=<%=item.getProductId()%>" data-id_customization="0">
                                                            <%=item.getProductName()%>
                                                        </a>
                                                    </div>
                                                    <div class="product-line-info product-price">
                                                        <span class="value">RS <%=String.format("%.2f", item.getProductPrice())%></span>
                                                    </div>
                                                    <div class="product-line-info">
                                                        <span class="label-atrr">Quantity:</span> 
                                                        <span class="value"><%=item.getQuantity()%></span>
                                                    </div>
                                                    <div class="product-line-info">
                                                        <span class="label-atrr">Discount:</span> 
                                                        <span class="value"><%=item.getProductDiscount()%> %</span>
                                                    </div>
                                                </div>
                                                <div class="product-line-grid-right text-center product-line-actions col-md-4">
                                                    <div class="row">
                                                        <div class="col-md-5 col qty">
                                                            <div class="label">Qty:</div>
                                                            <div class="quantity">
                                                                <form action="CartUpdateServlet" method="post">
                                                                    <input type="hidden" name="productId" value="<%=item.getProductId()%>" />
                                                                    <input type="hidden" name="userId" value="<%=user.getUserId()%>" />
                                                                    <input type="text" name="qty" value="<%=item.getQuantity()%>" class="input-group form-control" readonly> 
                                                                    <span class="input-group-btn-vertical">
                                                                        <button class="btn btn-touchspin js-touchspin bootstrap-touchspin-up" type="submit" name="action" value="increase">+</button>
                                                                        <button class="btn btn-touchspin js-touchspin bootstrap-touchspin-down" type="submit" name="action" value="decrease">-</button>
                                                                    </span>
                                                                </form>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-5 col price">
                                                            <div class="label">Total:</div>
                                                            <div class="product-price total">
                                                                Rs.<%=String.format("%.2f", itemTotal)%>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2 col text-xs-right align-self-end">
                                                            <div class="cart-line-product-actions">
                                                                <a class="remove-from-cart" rel="nofollow" href="CartDeleteProductServlet?productId=<%=item.getProductId()%>&userId=<%=user.getUserId()%>" data-link-action="delete-from-cart"> 
                                                                    <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <%
                                            }
                                        } else {
                                        %>
                                        <li class="cart-item">
                                            <div class="alert alert-warning text-center">Your cart is empty.</div>
                                        </li>
                                        <%
                                        }
                                        %>
                                    </ul>
                                </div>
                            </div>
                            <div class="cart-summary">
                                <div class="cart-detailed-totals">
                                    <div class="cart-summary-products">
                                        <div class="summary-label">
                                            There are <%=cartItems != null ? cartItems.size() : 0%> item(s) in your cart
                                        </div>
                                    </div>
                                    <div class="cart-summary-line" id="cart-subtotal-products">
                                        <span class="label js-subtotal">Total products:</span> 
                                        <span class="value">RS. <%=String.format("%.2f", grandTotal)%></span>
                                    </div>
                                    <div class="cart-summary-line" id="cart-subtotal-shipping">
                                        <span class="label">Total Shipping:</span> 
                                        <span class="value">Free</span>
                                        <div>
                                            <small class="value"></small>
                                        </div>
                                    </div>
                                    <div class="cart-summary-line cart-total">
                                        <span class="label">Total:</span> 
                                        <span class="value">RS <%=String.format("%.2f", grandTotal)%> (tax incl.)</span>
                                    </div>
                                </div>
                                <a href="CheckoutServlet" class="btn btn-primary mt-3">Proceed to Checkout</a>
                            </div>
                        </section>
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
</body>
</html>
