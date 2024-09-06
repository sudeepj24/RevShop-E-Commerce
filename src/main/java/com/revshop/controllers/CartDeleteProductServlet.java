package com.revshop.controllers;

import java.io.IOException;

import com.revshop.service.CartService;
import com.revshop.service.impl.CartServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartDeleteProductServlet
 */
public class CartDeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartDeleteProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		int userId = Integer.parseInt(request.getParameter("userId"));

		CartService cartService = new CartServiceIMPL();

		// Call the service method to remove the product from the cart
		cartService.removeProductFromCart(userId, productId);

		// Redirect back to the cart page to show the updated cart
		response.sendRedirect("CartServlet?userId="+userId);
	}

}
