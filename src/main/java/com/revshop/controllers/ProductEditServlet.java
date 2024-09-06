package com.revshop.controllers;

import java.io.IOException;

import com.revshop.Entity.ProductEntity;
import com.revshop.service.ProductService;
import com.revshop.service.impl.ProductServiceIMPL;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductEditServlet
 */
public class ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductEditServlet() {
		super();
		this.productService = new ProductServiceIMPL();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the product ID from the request
		int productId = Integer.parseInt(request.getParameter("id"));

		// Retrieve the product using the service
		ProductEntity product = productService.getProductById(productId);

		// Check if product is not null
		if (product != null) {
			// Set the product as a request attribute
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Seller/editProduct.jsp");
			dispatcher.forward(request, response);
		} else {
			// If product not found, redirect to an error page or display a message
			response.sendRedirect("errorPage.jsp");
		}
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
