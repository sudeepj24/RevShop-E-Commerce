package com.revshop.controllers;

import java.io.IOException;
import java.util.List;

import com.revshop.Entity.ProductEntity;
import com.revshop.service.ProductService;
import com.revshop.service.impl.ProductServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductService productService = new ProductServiceIMPL();

        // Retrieve the selected category from the request
        String category = request.getParameter("category");
        String searchQuery = request.getParameter("s");
        List<ProductEntity> products;

        // Check if a search query or category is provided
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            // If a search query is provided, search by keyword
            products = productService.searchProducts(searchQuery);
        } else if (category != null && !category.isEmpty()) {
            // If a category is provided, filter by category
            products = productService.getProductsByCategory(category);
        } else {
            // If no category is selected, set a default category
            category = "Electronics"; // Set your default category here
            products = productService.getProductsByCategory(category);
        }

        // Set the selected category in the request scope so that the UI can reflect it
        request.setAttribute("selectedCategory", category);

        // Set the products list in the request scope
        request.setAttribute("products", products);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
