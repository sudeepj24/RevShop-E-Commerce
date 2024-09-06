package com.revshop.controllers;

import java.io.IOException;
import java.util.List;

import com.revshop.Entity.LoginEntity;
import com.revshop.Entity.ProductEntity;
import com.revshop.service.ProductService;
import com.revshop.service.impl.ProductServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ProductMaintenanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService productService;

    public ProductMaintenanceServlet() {
        super();
        this.productService = new ProductServiceIMPL();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoginEntity user = (LoginEntity) session.getAttribute("user");

        if (user != null && "seller".equals(user.getRole())) {
            int sellerId = user.getUserId();
            String category = request.getParameter("category");
            String searchQuery = request.getParameter("s");
            List<ProductEntity> products;

            if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                // Search products by keyword for the seller
                products = productService.searchProductsBySeller(searchQuery, sellerId);
            } else if (category != null && !category.isEmpty()) {
                // Filter products by category for the seller
                products = productService.getProductsByCategoryAndSeller(category, sellerId);
            } else {
                // If no category or search query is provided, show all products of the seller
                products = productService.getProductsBySellerId(sellerId);
            }

            // Set the selected category and products list in request scope
            request.setAttribute("selectedCategory", category);
            request.setAttribute("products", products);

            request.getRequestDispatcher("Seller/SellerDashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
