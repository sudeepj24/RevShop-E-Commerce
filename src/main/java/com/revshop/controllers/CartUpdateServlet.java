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
 * Servlet implementation class CartUpdateServlet
 */
public class CartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		String action = request.getParameter("action");
        int productId = Integer.parseInt(request.getParameter("productId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        CartService cartService = new CartServiceIMPL();
        CartEntity cart = new CartEntity();
        cart.setProductId(productId);
        cart.setUserId(userId);

        cartService.updateQuantity(cart, action);

        // Redirect back to the cart page to show the updated cart
        response.sendRedirect("CartServlet?userId="+userId);
	}

}
