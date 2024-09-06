package com.revshop.controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import com.revshop.Entity.LoginEntity;
import com.revshop.Entity.ReviewEntity;
import com.revshop.service.impl.ReviewServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ReviewAddServlet
 */
public class ReviewAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewServiceIMPL reviewService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewAddServlet() {
		super();
		this.reviewService = new ReviewServiceIMPL();
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
		HttpSession session = request.getSession();
        LoginEntity user = (LoginEntity) session.getAttribute("user");
        if(user==null)
        {
        	response.sendRedirect("LoginAndRegistration/user-login.jsp");
        	return;
        }

		// Get form data
		String reviewText = request.getParameter("review");
		int stars = Integer.parseInt(request.getParameter("rating"));
		int productId = Integer.parseInt(request.getParameter("product_id"));
		String customerName = request.getParameter("name");
		String customerEmail = request.getParameter("email");
		Date reviewDate = Date.valueOf(LocalDate.now());

		// Create ReviewEntity object
		ReviewEntity review = new ReviewEntity();
		review.setReview(reviewText);
		review.setStars(stars);
		review.setProductId(productId);
		review.setUserId(user.getUserId());
		review.setCustomerName(customerName);
		review.setCustomerEmail(customerEmail);
		review.setReviewDate(reviewDate);

		// Save the review using the service
		boolean success = reviewService.addReview(review);

		if (success) {
			response.sendRedirect("ProductDetailsServlet?productId=" + productId); // Redirect to product detail page
		} else {
			response.sendRedirect("error.jsp"); // Redirect to an error page in case of failure
		}
	}

}
