package com.revshop.controllers;

import java.io.IOException;
import java.util.List;

import com.revshop.Entity.LoginEntity;
import com.revshop.Entity.OrderEntity;
import com.revshop.service.impl.OrderServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderServiceIMPL orderService = new OrderServiceIMPL();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginEntity loginUser = (LoginEntity) session.getAttribute("user");

		if (loginUser != null) {
			if ("seller".equals(loginUser.getRole())) {
				// Handle seller
				List<OrderEntity> orders = orderService.getOrdersBySellerId(loginUser.getUserId());
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("showOrders.jsp").forward(request, response);
			} else {
				// Handle buyer
				List<OrderEntity> orders = orderService.getOrdersByUserId(loginUser.getUserId());
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("showOrders.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("LoginAndRegistration/user-login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("updateStatus".equals(action)) {
			String orderId = request.getParameter("orderId");
			String status = request.getParameter("status");
			orderService.updateOrderStatus(orderId, status);
		}
		doGet(request, response);
	}
}
