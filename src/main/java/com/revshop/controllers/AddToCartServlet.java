package com.revshop.controllers;

import java.io.IOException;

import com.revshop.Entity.CartEntity;
import com.revshop.service.CartService;
import com.revshop.service.impl.CartServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService cartService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
		super();
		cartService = new CartServiceIMPL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get product ID and user ID from request
		String productIdParam = request.getParameter("productId");
		String userIdParam = request.getParameter("userId");

		// Parse IDs
		int productId = 0;
		int userId = 0;

		try {
			productId = Integer.parseInt(productIdParam);
			userId = Integer.parseInt(userIdParam);
		} catch (NumberFormatException e) {
			// If parsing fails, redirect to error page
			response.sendRedirect("error.jsp");
			return;
		}

		

		// Create a new CartEntity object
		CartEntity cartItem = new CartEntity();
		cartItem.setProductId(productId);
		cartItem.setUserId(userId);

		boolean success = cartService.addToCart(cartItem);

		// Redirect based on success or failure
		if (success) {
			// Redirect to HomeServlet if successful
			response.sendRedirect("HomeServlet");
		} else {
			// Redirect to an error page if failed
			response.sendRedirect("error.jsp");
		}
	}

}
