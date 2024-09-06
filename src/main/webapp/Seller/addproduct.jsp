<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Product</title>
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
    .container {
        display: flex;
        justify-content: space-between;
        max-width: 1200px;
        margin: 0 auto;
        padding: 20px;
        background-color: white; /* White background for the form */
        border-radius: 8px;
        box-shadow: 0px 0px 15px rgba(0, 123, 255, 0.2); /* Light blue shadow */
    }
    .form-section {
        width: 60%;
    }
    h2 {
        font-weight: 700;
        margin-bottom: 20px;
        color: #007bff;
        font-size: 28px;
    }
    p {
        margin-bottom: 20px;
        color: #666;
    }
    .form-row {
        display: flex;
        justify-content: space-between;
        margin-bottom: 20px;
    }
    .form-group {
        width: 48%;
    }
    .form-group label {
        display: block;
        margin-bottom: 8px;
        font-weight: 600;
        color: #333;
        font-size: 16px;
    }
    .form-group input, .form-group select, .form-group textarea {
        width: 100%;
        padding: 12px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 14px;
        background-color: #f9f9f9;
        transition: all 0.3s ease-in-out;
    }
    .form-group select:hover, .form-group input:focus, .form-group textarea:focus {
        border-color: #007bff;
        background-color: #fff;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
    }
    .form-group textarea {
        resize: vertical;
        height: 120px;
    }
    .checkout-btn {
        display: block;
        width: 100%;
        padding: 15px;
        background-color: #0056b3; /* Darker blue button */
        color: #fff;
        font-size: 18px;
        text-align: center;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-top: 20px;
        transition: background-color 0.3s;
    }
    .checkout-btn:hover {
        background-color: #004085; /* Even darker blue on hover */
    }
    .back-btn {
        display: inline-block;
        margin-top: 15px;
        color: #007bff;
        font-size: 16px;
        text-decoration: none;
    }
    .back-btn:hover {
        text-decoration: underline;
    }
    .cart-section {
        width: 35%;
        padding-left: 20px;
    }
    .payments h3 {
        font-weight: 700;
        margin-bottom: 15px;
        font-size: 22px;
        color: #007bff;
    }
    .payment-icons {
        margin: 15px 0;
        font-size: 24px;
        text-align: center;
        color: #aaa;
        position: relative;
    }
    #previewImage {
        width: 100%;
        height: auto;
        display: block;
        margin-top: 10px;
        border-radius: 8px;
        border: 2px solid #ddd;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        padding: 10px;
        background-color: #f9f9f9;
    }
    #removeImage {
        position: absolute;
        top: 5px;
        right: 10px;
        background-color: rgba(255, 255, 255, 0.7);
        border: none;
        font-size: 18px;
        cursor: pointer;
        display: none;
        border-radius: 50%;
        padding: 2px 6px;
        color: #007bff;
    }
</style>
</head>
<body id="product-sidebar-left" class="product-grid-sidebar-left">

<%@ include file="/LoginAndRegistration/includes/header.jsp" %>

    <div class="main-content">
        <div id="wrapper-site">
            <div id="content-wrapper" class="full-width">
                <div id="main">
                    <div class="page-home">
                        <div class="container">
                            <div class="form-section">
                                <h2>Add New Product</h2>
                                <p>Fill in the details to add a new product to the system</p>
                                <form action="/RevShopRevature/ProductAddServlet" method="POST" enctype="multipart/form-data">
                                    <div class="form-row">
                                        <div class="form-group">
                                            <label for="productName">Product Name *</label> 
                                            <input type="text" id="productName" name="product_name" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="productCategory">Category *</label> 
                                            <select id="productCategory" name="product_category" required>
                                                <option value="" disabled selected>Select Type</option>
                                                <option value="electronics">Electronics</option>
                                                <option value="fashion">Fashion</option>
                                                <option value="HomeAppliances">Home Appliances</option>
                                                <option value="Books">Books</option>
                                                <option value="Sports">Sports</option>
                                                <!-- Add more categories as needed -->
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group">
                                            <label for="productPrice">Price *</label> 
                                            <input type="number" id="productPrice" name="product_price" step="0.01" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="productDiscount">Discount</label> 
                                            <input type="number" id="productDiscount" name="product_discount" step="0.01">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group">
                                            <label for="productStock">Stock Quantity *</label> 
                                            <input type="number" id="productStock" name="product_stock" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="productBrand">Brand *</label> 
                                            <input type="text" id="productBrand" name="product_brand" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="productDescription">Product Description *</label>
                                        <textarea id="productDescription" name="product_description" required></textarea>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group">
                                            <label for="productStatus">Status *</label> 
                                            <select id="productStatus" name="product_status" required>
                                                <option value="In_Stock">In Stock</option>
                                                <option value="out_of_stock">Out of Stock</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="productTags">Tags</label> 
                                            <input type="text" id="productTags" name="product_tags" placeholder="e.g., sale, new, bestseller">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="productImage">Product Image *</label> 
                                        <input type="file" id="productImage" name="product_image" accept="image/*" required>
                                    </div>
                                    <button class="checkout-btn" type="submit">Add Product</button>
                                </form>
                                <a href="#" class="back-btn">← Back to Dashboard</a>
                            </div>

                            <div class="cart-section">
                                <div class="payments">
                                    <h3>PREVIEW IMAGE</h3>
                                    <div class="payment-icons">
                                        <img id="previewImage" src="" alt="No image uploaded">
                                        <button id="removeImage" style="display: none;">X</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        const productImageInput = document.getElementById('productImage');
        const previewImage = document.getElementById('previewImage');
        const removeImageButton = document.getElementById('removeImage');

        productImageInput.addEventListener('change', function(e) {
            const file = e.target.files[0];
            const reader = new FileReader();
            reader.onload = function() {
                previewImage.src = reader.result;
                previewImage.alt = "Product Image";
                removeImageButton.style.display = 'block';
            };
            if (file) {
                reader.readAsDataURL(file);
            }
        });

        removeImageButton.addEventListener('click', function() {
            previewImage.src = "";
            previewImage.alt = "No image uploaded";
            removeImageButton.style.display = 'none';
            productImageInput.value = ""; // Reset the file input
        });
    </script>
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
    <script>
    function validateForm() {
        const productName = document.getElementById('productName').value.trim();
        const productCategory = document.getElementById('productCategory').value;
        const productPrice = document.getElementById('productPrice').value.trim();
        const productDiscount = document.getElementById('productDiscount').value.trim();
        const productStock = document.getElementById('productStock').value.trim();
        const productBrand = document.getElementById('productBrand').value.trim();
        const productDescription = document.getElementById('productDescription').value.trim();
        const productStatus = document.getElementById('productStatus').value;
        const productTags = document.getElementById('productTags').value.trim();
        const productImage = document.getElementById('productImage').value;

        // Validate Product Name
        if (productName === '') {
            alert('Product Name is required.');
            return false;
        } else if (productName.length < 3) {
            alert('Product Name must be at least 3 characters long.');
            return false;
        }

        // Validate Product Category
        if (productCategory === '') {
            alert('Please select a Product Category.');
            return false;
        }

        // Validate Product Price
        if (productPrice === '') {
            alert('Product Price is required.');
            return false;
        } else if (isNaN(productPrice) || parseFloat(productPrice) <= 0) {
            alert('Please enter a valid Product Price.');
            return false;
        }

        // Validate Product Discount (optional field)
        if (productDiscount !== '' && (isNaN(productDiscount) || parseFloat(productDiscount) < 0 || parseFloat(productDiscount) > 100)) {
            alert('Please enter a valid Discount percentage between 0 and 100.');
            return false;
        }

        // Validate Product Stock
        if (productStock === '') {
            alert('Stock Quantity is required.');
            return false;
        } else if (!Number.isInteger(Number(productStock)) || parseInt(productStock) < 0) {
            alert('Please enter a valid Stock Quantity.');
            return false;
        }

        // Validate Product Brand
        if (productBrand === '') {
            alert('Brand is required.');
            return false;
        }

        // Validate Product Description
        if (productDescription === '') {
            alert('Product Description is required.');
            return false;
        }

        // Validate Product Status
        if (productStatus === '') {
            alert('Please select a Product Status.');
            return false;
        }

        // Validate Product Image
        if (productImage === '') {
            alert('Product Image is required.');
            return false;
        }

        // Form is valid
        return true;
    }

    // Attach the validateForm function to the form submission event
    document.querySelector('form').onsubmit = validateForm;
</script>

    <%@ include file="/LoginAndRegistration/includes/footer.jsp" %>
    
</body>
</html>
