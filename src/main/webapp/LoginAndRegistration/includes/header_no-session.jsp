<%@ page import="com.revshop.Entity.LoginEntity" %>
<head>
    <style>
        header {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 5px solid #0056b3;
            flex-wrap: wrap;
        }
        .logo {
            display: flex;
            align-items: center;
            margin-right: 20px; /* Added space for the logo */
        }
        .logo img {
            height: 50px;
            margin-right: 10px;
        }
        .logo h1 {
            color: white; /* Changed RevShop text to white */
            margin: 0;
        }
        .search-bar {
            flex-grow: 1;
            margin: 0 20px;
            display: flex;
            align-items: center; /* Aligns the input and button properly */
        }
        .search-bar input {
            width: 100%;
            padding: 5px 10px;
            border-radius: 20px;
            border: none;
        }
        .search-bar button {
            background-color: white;
            border: none;
            border-radius: 50%;
            padding: 5px;
            margin-left: -40px; /* Adjust to move button inside input */
            cursor: pointer;
        }
        .nav-buttons {
            display: flex;
            align-items: center;
        }
        .nav-buttons a {
            color: white;
            text-decoration: none;
            margin-left: 15px;
            font-size: 1.2rem;
            display: flex;
            align-items: center;
        }
        .nav-buttons a i {
            margin-right: 5px;
        }
        .account-dropdown {
            position: relative;
            display: inline-block;
            cursor: pointer;
        }
        .account-dropdown > a {
            display: flex;
            align-items: center;
        }
        .dropdown-icon {
            margin-left: 5px;
            font-size: 0.8rem;
        }
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #007bff;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
            top: 100%;
            left: 0;
            border-radius: 4px;
            overflow: hidden;
            margin-top: 10px;
        }
        .dropdown-content a {
            color: white;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: center;
        }
        .dropdown-content a:hover {
            background-color: #0056b3;
        }
        .category-strip {
            width: 100%;
            background-color: #f8f9fa;
            padding: 10px 0;
            text-align: center;
            border-top: 1px solid #ddd;
            margin-top: 10px;
        }
        .category-strip a {
            margin: 0 15px;
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        .show {
            display: block;
        }
    </style>
</head>

<header>
    <div class="logo">
        <a href="HomeServlet?category=Electronics">
            <img src="logo.png" alt="RevShop Logo">
            <h1>RevShop</h1>
        </a>
    </div>
    <div class="search-bar">
        <form method="get" action="HomeServlet">
            <input type="hidden" name="category">
            <input type="text" name="s" value="" placeholder="Search" autocomplete="off">
            <button type="submit">
                <i class="fa fa-search"></i>
            </button>
        </form>
    </div>
    <div class="nav-buttons">
        <a href="HomeServlet?category=Electronics"><i class="fas fa-home"></i> Home</a>
        <a href="OrderServletMain"><i class="fas fa-history"></i> Order History</a>
        <a href="FavriouteServletMain"><i class="fas fa-heart"></i> Favorites</a>
 
            <i class="fas fa-shopping-cart"></i> Cart
        </a>
        <div class="account-dropdown">
            <a href="javascript:void(0);" id="account-dropdown-toggle">
                <i class="fas fa-user"></i> Account
                <i class="fas fa-chevron-down dropdown-icon"></i> <!-- Dropdown icon -->
            </a>
            <div class="dropdown-content" id="account-dropdown-content">
             
                <a href="UserAccountServlet">My Account</a>
                <a href="CheckoutServlet">Checkout</a>
               
                <a href="ProductMaintenanceServlet">Seller Dashboard</a>
                
                <a href="LoginAndRegistration/user-login.jsp">Log Out</a>
             
              
            </div>
        </div>
    </div>
    <div class="category-strip">
        <a href="HomeServlet?category=Electronics">Electronics</a>
        <a href="HomeServlet?category=Fashion">Fashion</a>
        <a href="HomeServlet?category=Home Appliances">Home Appliance</a>
        <a href="HomeServlet?category=Books">Books</a>
        <a href="HomeServlet?category=Sports">Sports</a>
    </div>
</header>

<script>
    // Toggle dropdown visibility when Account is clicked
    document.getElementById('account-dropdown-toggle').onclick = function () {
        var dropdown = document.getElementById('account-dropdown-content');
        dropdown.classList.toggle('show');
    };

    // Close the dropdown if the user clicks outside of it
    window.onclick = function(event) {
        if (!event.target.matches('#account-dropdown-toggle') && !event.target.closest('.account-dropdown')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            for (var i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    };
</script>
