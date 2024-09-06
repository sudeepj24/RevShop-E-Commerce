<%@ page import="com.revshop.Entity.ProductEntity"%>
<%@ page import="java.util.List"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
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
    .product-container {
        margin-top: 30px;
    }
    .product-miniature {
        border: 1px solid #ddd;
        border-radius: 8px;
        background-color: #fff;
        padding: 15px;
        transition: box-shadow 0.3s ease-in-out;
        box-shadow: 0 0 10px rgba(0, 123, 255, 0.1);
    }
    .product-miniature:hover {
        box-shadow: 0 0 15px rgba(0, 123, 255, 0.2);
    }
    .thumbnail-container img {
        max-width: 100%;
        height: auto;
        margin: 0 auto;
        display: block;
    }
    .product-title a {
        color: #007bff; /* Blue link color */
        font-weight: 600;
        text-decoration: none;
    }
    .product-title a:hover {
        text-decoration: underline;
    }
    .product-price-and-shipping .price {
        color: #28a745; /* Green price color */
        font-weight: bold;
        font-size: 18px;
    }
    .product-buttons {
        margin-top: 15px;
    }
    .product-buttons .add-to-cart, .product-buttons .addToWishlist, .product-buttons .quick-view {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        padding: 10px;
        margin-right: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    .product-buttons .add-to-cart:hover, .product-buttons .addToWishlist:hover, .product-buttons .quick-view:hover {
        background-color: #0056b3; /* Darker blue on hover */
    }
    .toast {
        visibility: hidden;
        min-width: 250px;
        margin-left: -125px;
        background-color: #333;
        color: #fff;
        text-align: center;
        border-radius: 2px;
        padding: 16px;
        position: fixed;
        z-index: 1;
        left: 50%;
        bottom: 30px;
        font-size: 17px;
    }
    .toast.show {
        visibility: visible;
        -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
        animation: fadein 0.5s, fadeout 0.5s 2.5s;
    }
    @-webkit-keyframes fadein {
        from {bottom: 0; opacity: 0;}
        to {bottom: 30px; opacity: 1;}
    }
    @keyframes fadein {
        from {bottom: 0; opacity: 0;}
        to {bottom: 30px; opacity: 1;}
    }
    @-webkit-keyframes fadeout {
        from {bottom: 30px; opacity: 1;}
        to {bottom: 0; opacity: 0;}
    }
    @keyframes fadeout {
        from {bottom: 30px; opacity: 1;}
        to {bottom: 0; opacity: 0;}
    }
</style>
</head>

<body id="product-sidebar-left" class="product-grid-sidebar-left">
    <div id="toast" class="toast"></div>
    <%@ include file="LoginAndRegistration/includes/header.jsp" %>

    <!-- main content -->
    <div class="main-content">
        <div id="wrapper-site">
            <div id="content-wrapper" class="full-width">
                <div id="main">
                    <div class="page-home">
                        <div class="container">
                            <div class="content">
                                <div class="row">
                                    <%
                                    List<ProductEntity> products = (List<ProductEntity>) request.getAttribute("products");
                                    %>
                                    <div class="col-sm-8 col-lg-9 col-md-8 product-container">
                                        <h1>All Products</h1>
                                        <div class="tab-content product-items">
                                            <div id="grid" class="related tab-pane fade in active show">
                                                <div class="row">
                                                    <%
                                                    for (ProductEntity product : products) {
                                                    %>
                                                    <div class="item text-center col-md-4">
                                                        <div class="product-miniature js-product-miniature item-one first-item">
                                                            <div class="thumbnail-container border">
                                                                <a href="ProductDetailsServlet?productId=<%=product.getProductId()%>">
                                                                    <img class="img-fluid" src="<%=product.getProductImage()%>" alt="<%=product.getProductName()%>">
                                                                </a>
                                                            </div>
                                                            <div class="product-description">
                                                                <div class="product-groups">
                                                                    <div class="product-title">
                                                                        <a href="ProductDetailsServlet?productId=<%=product.getProductId()%>"><%=product.getProductName()%></a>
                                                                    </div>
                                                                    <div class="product-group-price">
                                                                        <div class="product-price-and-shipping">
                                                                            <span class="price">RS <%=product.getProductPrice()%></span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="product-buttons d-flex justify-content-center">
                                                                    <%
                                                                    if (user != null) {
                                                                    %>
                                                                    <form action="AddToCartServlet" method="post" class="formAddToCart">
                                                                        <input type="hidden" name="productId" value="<%=product.getProductId()%>">
                                                                        <input type="hidden" name="userId" value="<%=user.getUserId()%>">
                                                                        <button class="add-to-cart" type="submit">
                                                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                        </button>
                                                                    </form>
                                                                    <a class="addToWishlist" href="FavriouteAddServlet?productId=<%=product.getProductId()%>&userId=<%=user.getUserId()%>" data-rel="<%=product.getProductId()%>">
                                                                        <i class="fa fa-heart" aria-hidden="true"></i>
                                                                    </a>
                                                                    <%
                                                                    } else {
                                                                    %>
                                                                    <a class="addToWishlist" href="LoginAndRegistration/user-login.jsp" data-rel="<%=product.getProductId()%>">
                                                                        <i class="fa fa-heart" aria-hidden="true"></i>
                                                                    </a>
                                                                    <%
                                                                    }
                                                                    %>
                                                                    <a href="ProductDetailsServlet?productId=<%=product.getProductId()%>" class="quick-view hidden-sm-down">
                                                                        <i class="fa fa-eye" aria-hidden="true"></i>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <%
                                                    }
                                                    %>
                                                </div>
                                            </div>
                                            <div id="list" class="related tab-pane fade">
                                                <div class="row">
                                                    <%
                                                    for (ProductEntity product : products) {
                                                    %>
                                                    <div class="item col-md-12">
                                                        <div class="product-miniature js-product-miniature item-one first-item">
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <div class="thumbnail-container border">
                                                                        <a href="ProductDetailsServlet?productId=<%=product.getProductId()%>">
                                                                            <img class="img-fluid" src="<%=product.getProductImage()%>" alt="<%=product.getProductName()%>">
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-8">
                                                                    <div class="product-description">
                                                                        <div class="product-groups">
                                                                            <div class="product-title">
                                                                                <a href="ProductDetailsServlet?productId=<%=product.getProductId()%>"><%=product.getProductName()%></a>
                                                                                <span class="info-stock">
                                                                                    <i class="fa fa-check-square-o" aria-hidden="true"></i>
                                                                                    In Stock
                                                                                </span>
                                                                            </div>
                                                                            <div class="product-group-price">
                                                                                <div class="product-price-and-shipping">
                                                                                    <span class="price">RS <%=product.getProductPrice()%></span>
                                                                                </div>
                                                                            </div>
                                                                            <div class="description">
                                                                                <%=product.getProductDescription()%>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-buttons d-flex">
                                                                            <%
                                                                            if (user != null) {
                                                                            %>
                                                                            <form action="AddToCartServlet" method="post" class="formAddToCart">
                                                                                <input type="hidden" name="productId" value="<%=product.getProductId()%>">
                                                                                <input type="hidden" name="userId" value="<%=user.getUserId()%>">
                                                                                <button class="add-to-cart" type="submit">
                                                                                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    Add to cart
                                                                                </button>
                                                                            </form>
                                                                            <a class="addToWishlist" href="FavriouteAddServlet?productId=<%=product.getProductId()%>&userId=<%=user.getUserId()%>" data-rel="<%=product.getProductId()%>">
                                                                                <i class="fa fa-heart" aria-hidden="true"></i>
                                                                            </a>
                                                                            <%
                                                                            } else {
                                                                            %>
                                                                            <a class="addToWishlist" href="LoginAndRegistration/user-login.jsp" data-rel="<%=product.getProductId()%>">
                                                                                <i class="fa fa-heart" aria-hidden="true"></i>
                                                                            </a>
                                                                            <%
                                                                            }
                                                                            %>
                                                                            <a href="ProductDetailsServlet?productId=<%=product.getProductId()%>" class="quick-view hidden-sm-down">
                                                                                <i class="fa fa-eye" aria-hidden="true"></i>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <%
                                                    }
                                                    %>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end col-md-9-1 -->
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
        <a href="#"><i class="fa fa-long-arrow-up"></i></a>
    </div>

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
    
    <%@ include file="LoginAndRegistration/includes/footer.jsp"%>
</body>
</html>
