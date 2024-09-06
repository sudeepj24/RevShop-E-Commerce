<%@ page import="java.util.List"%>
<%@ page import="com.revshop.Entity.FavoriteProductsEntity"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Favorite Products</title>
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

.cart-container {
	background-color: white; /* White form background */
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2);
	/* Light blue shadow */
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
	padding: 10px 20px;
	border-radius: 4px;
	width: 100%;
	margin-top: 20px;
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
</style>
</head>

<%@ include file="LoginAndRegistration/includes/header.jsp"%>

<body class="product-cart checkout-cart blog">
	<!-- main content -->
	<div class="main-content" id="cart">
		<!-- main -->
		<div id="wrapper-site">
			<div class="container">
				<div class="row">
					<div id="content-wrapper" class="col-12">
						<section id="main">
							<h1 class="title-page text-center">Favorite Products</h1>
							<div class="cart-container">
								<div class="cart-overview js-cart">
									<ul class="cart-items">
										<%
										List<FavoriteProductsEntity> favoriteItems = (List<FavoriteProductsEntity>) request.getAttribute("favoriteItems");

										if (favoriteItems != null && !favoriteItems.isEmpty()) {
											for (FavoriteProductsEntity item : favoriteItems) {
										%>
										<li class="cart-item">
											<div class="product-line-grid row justify-content-between">
												<!-- product left content: image -->
												<div class="product-line-grid-left col-md-2">
													<span class="product-image media-middle"> <a
														href="ProductDetailsServlet?productId=<%=item.getProductId()%>">
															<img class="img-fluid" src="<%=item.getImgUrl()%>"
															alt="<%=item.getProductName()%>">
													</a>
													</span>
												</div>
												<div class="product-line-grid-body col-md-6">
													<div class="product-line-info">
														<a class="label"
															href="ProductDetailsServlet?productId=<%=item.getProductId()%>"
															data-id_customization="0"> <%=item.getProductName()%>
														</a>
													</div>
													<div class="product-line-info product-price">
														<span class="value">Rs. <%=String.format("%.2f", item.getProductPrice())%></span>
													</div>
													<div class="product-line-info">
														<span class="label-atrr">Discount:</span> <span
															class="value"><%=item.getProductDiscount()%> %</span>
													</div>
												</div>
												<div
													class="product-line-grid-right text-center product-line-actions col-md-4">
													<div class="row">
														<div class="col-md-5 col price">
															<div class="label">Total Price</div>
															<div class="product-price total">
																<%=String.format("%.2f", item.getProductPrice() * (1 - item.getProductDiscount() / 100.0))%>
															</div>
														</div>
														<div class="col-md-2 col text-xs-right align-self-end">
															<div class="cart-line-product-actions">
																<a class="remove-from-cart" rel="nofollow"
																	href="FavriouteDeleteServlet?favoriteId=<%=item.getFav_id()%>"
																	data-link-action="delete-from-cart"> <i
																	class="fa fa-trash-o" aria-hidden="true"></i>
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
											<div class="alert alert-warning text-center">You have
												no favorite products.</div>
										</li>
										<%
										}
										%>
									</ul>
								</div>
							</div>
							<a href="HomeServlet" class="btn btn-primary mt-3">Continue
								Shopping</a>
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

	<%@ include file="LoginAndRegistration/includes/footer.jsp"%>
</body>
</html>
