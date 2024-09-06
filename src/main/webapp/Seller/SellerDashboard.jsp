	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page import="com.revshop.Entity.ProductEntity"%>
	<%@ page import="java.util.List"%>
	<!DOCTYPE html>
	<html lang="en">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Seller Dashboard</title>
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
	    .title-page {
	        color: #007bff; /* Blue title */
	        font-weight: 700;
	        margin-bottom: 30px;
	    }
	    .container {
	        background-color: white; /* White background for the form */
	        border-radius: 8px;
	        box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2); /* Light blue shadow */
	        padding: 20px;
	    }
	    .form-inline {
	        margin-bottom: 20px;
	    }
	    .form-control {
	        border-radius: 4px;
	        border: 1px solid #ddd;
	        padding: 10px;
	        font-size: 14px;
	        background-color: #f9f9f9;
	        transition: all 0.3s ease-in-out;
	    }
	    .form-control:focus {
	        border-color: #007bff;
	        background-color: #fff;
	        box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
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
	    .cart-item {
	        background-color: #f9f9f9;
	        padding: 15px;
	        border-radius: 8px;
	        margin-bottom: 20px;
	        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
	    }
	    .product-image img {
	        max-width: 100%;
	        border-radius: 8px;
	    }
	    .product-line-info {
	        margin-bottom: 10px;
	        font-size: 16px;
	    }
	    .product-line-info .label-atrr {
	        font-weight: 600;
	    }
	    .product-price {
	        color: #007bff;
	        font-weight: bold;
	    }
	    .remove-from-cart i {
	        color: #d9534f; /* Red color for the trash icon */
	    }
	    .edit-cart-item i {
	        color: #007bff; /* Blue color for the edit icon */
	    }
	</style>
	</head>
	<body class="product-cart checkout-cart blog">
	
	<%@ include file="/LoginAndRegistration/includes/header.jsp" %>
	
	    <!-- main content -->
	    <div class="main-content" id="cart">
	        <div id="wrapper-site">
	            <div class="container">
	                <div class="row">
	                    <!-- Sidebar -->
	                    <div class="sidebar-3 sidebar-collection col-lg-3 col-md-4 col-sm-4">
	                        <!-- Sidebar content can go here -->
	                    </div>
	
	                    <!-- Main Content -->
	                    <div id="content-wrapper" class="col-lg-9 col-md-8 col-sm-8">
	                        <section id="main">
	                            <div class="cart-grid row">
	                                <div class="col-md-12 col-xs-12 check-info">
	                                    <h1 class="title-page">Product List</h1>
	                                    <!-- Search Form -->
	                                    <form method="get" action="ProductMaintenanceServlet" class="form-inline mb-3">
	                                        <input type="hidden" name="category" value="<%=request.getAttribute("selectedCategory")%>">
	                                        <input type="text" name="s" class="form-control mr-2" placeholder="Search products">
	                                        <button type="submit" class="btn btn-primary">Search</button>
	                                        &nbsp;<a href="Seller/addproduct.jsp" class="btn btn-primary">Add Product</a>
	                                    </form>
	
	                                    <div class="cart-container">
	                                        <div class="cart-overview js-cart">
	                                            <ul class="cart-items">
	                                                <%
	                                                List<ProductEntity> products = (List<ProductEntity>) request.getAttribute("products");
	                                                if (products != null && !products.isEmpty()) {
	                                                    for (ProductEntity product : products) {
	                                                %>
	                                                <li class="cart-item" id="product-<%=product.getProductId()%>">
	                                                    <div class="product-line-grid row justify-content-between">
	                                                        <!-- Product left content: image -->
	                                                        <div class="product-line-grid-left col-md-2">
	                                                            <span class="product-image media-middle"> 
	                                                                <a href="ProductDetailsServlet?productId=<%=product.getProductId()%>">
	                                                                    <img class="img-fluid" src="<%=product.getProductImage()%>" alt="<%=product.getProductName()%>">
	                                                                </a>
	                                                            </span>
	                                                        </div>
	                                                        <div class="product-line-grid-body col-md-6">
	                                                            <div class="product-line-info">
	                                                                <a class="label" href="ProductDetailsServlet?productId=<%=product.getProductId()%>" data-id_customization="0">
	                                                                    <%=product.getProductName()%>
	                                                                </a>
	                                                            </div>
	                                                            <div class="product-line-info product-price">
	                                                                <span class="value">₹<%=product.getProductPrice()%></span>
	                                                            </div>
	                                                            <div class="product-line-info">
	                                                                <span class="label-atrr">Brand:</span> 
	                                                                <span class="value"><%=product.getProductBrand()%></span>
	                                                            </div>
	                                                            <div class="product-line-info">
	                                                                <span class="label-atrr">Discount:</span> 
	                                                                <span class="value"><%=product.getProductDiscount()%> %</span>
	                                                            </div>
	                                                        </div>
	                                                        <div class="product-line-grid-right text-center product-line-actions col-md-4">
	                                                            <div class="row">
	                                                                <div class="col-md-5 col qty">
	                                                                    <div class="label">Qty:</div>
	                                                                    <div class="quantity">
	                                                                        <input type="text" name="qty" value="<%=product.getProductStock()%>" class="input-group form-control">
	                                                                   
	                                                                    </div>
	                                                                </div>
	                                                                <div class="col-md-5 col price">
	                                                                    <div class="label">Edit:</div>
	                                                                    <div class="product-price total">
	                                                                        <a class="edit-cart-item" rel="nofollow" href="/RevShopRevature/ProductEditServlet?id=<%=product.getProductId()%>" data-link-action="edit-cart-item" data-id-product="<%=product.getProductId()%>">
	                                                                            <i class="fa fa-pencil" aria-hidden="true"></i>
	                                                                        </a>
	                                                                    </div>
	                                                                </div>
	                                                                <div class="col-md-2 col text-xs-right align-self-end">
	                                                                    <div class="cart-line-product-actions">
	                                                                        <button class="btn btn-link remove-from-cart" rel="nofollow" data-product-id="<%=product.getProductId()%>">
	                                                                            <i class="fa fa-trash-o" aria-hidden="true"></i>
	                                                                        </button>
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
	                                                <li>No products found for the selected category or search query.</li>
	                                                <%
	                                                }
	                                                %>
	                                            </ul>
	                                            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	                                            <script>
	                                                $(document).ready(function() {
	                                                    $(document).on('click', '.remove-from-cart', function(event) {
	                                                        event.preventDefault(); // Prevent the default form submission
	                                                        var productId = $(this).data('product-id');
	                                                        console.log("Delete button clicked for product ID: " + productId);
	                                                        if (!productId) {
	                                                            console.error("No product ID found.");
	                                                            return;
	                                                        }
	                                                        $.ajax({
	                                                            url: 'ProductDeleteServlet', // Use the contextPath variable here
	                                                            type: 'POST',
	                                                            data: {
	                                                                productId: productId
	                                                            },
	                                                            success: function(response) {
	                                                                console.log("Product deleted successfully: ", response);
	                                                                $('#product-' + productId).remove();
	                                                            },
	                                                            error: function(xhr, status, error) {
	                                                                console.error("Failed to delete the product: " + error);
	                                                                alert('Failed to delete the product. Please try again.');
	                                                            }
	                                                        });
	                                                    });
	                                                });
	                                            </script>
	                                        </div>
	                                    </div>
	                                    <a href="product-checkout.html" class="continue btn btn-primary pull-xs-right">Continue</a>
	                                </div>
	                            </div>
	                        </section>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <!-- back to top -->
	    <div class="back-to-top">
	        <a href="#"><i class="fa fa-long-arrow-up"></i></a>
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
	    
	        <%@ include file="/LoginAndRegistration/includes/footer.jsp" %>
	        
	</body>
	</html>
