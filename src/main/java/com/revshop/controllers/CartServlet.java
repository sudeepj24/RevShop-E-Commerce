package com.revshop.controllers;

import java.io.IOException;
import java.util.List;

import com.revshop.Entity.CartEntity;
import com.revshop.Entity.ProductEntity;
import com.revshop.service.CartService;
import com.revshop.service.impl.CartServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get userId from request parameters
		String userIdParam = request.getParameter("userId");
		int userId = 0;
		
		
		if (userIdParam != null && !userIdParam.isEmpty()) {
			try {
				userId = Integer.parseInt(userIdParam);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				// Handle error if userId is not a valid integer
			}
		}
		else {
			response.sendRedirect("LoginAndRegistration/user-login.jsp");
			return;
		}

		if (userId > 0) {
			CartService c = new CartServiceIMPL();
			List<CartEntity> cart = c.getCart(userId);

			// Forward the cart data to a JSP for display (not implemented here)
			request.setAttribute("cartItems", cart);
			request.getRequestDispatcher("/product-cart.jsp").forward(request, response);
		} else {
			// Handle the case where userId is invalid or not provided
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid or missing user ID.");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
