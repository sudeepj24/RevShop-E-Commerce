package com.revshop.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revshop.Entity.LoginEntity;
import com.revshop.service.LoginService;
import com.revshop.service.impl.LoginServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

	// Page paths
	private static final String LOGIN_REGISTRATION_JSP = "LoginAndRegistration/user-login.jsp";
	private static final String SUCCESS_PAGE = "OtherPages/success.jsp";
	private static final String DETAIL_REGISTRATION_JSP = "LoginAndRegistration/detail-registration.jsp";

	private final LoginService loginService = LoginServiceIMPL.getInstance();

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_REGISTRATION_JSP).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email == null || password == null) {
			forwardWithError(request, response, "Username and password are required.");
			return;
		}

		try {
			if (loginService.validate(email, password)) {
				// Retrieve user details after successful validation
				LoginEntity user = loginService.findByEmail(email);

				if (user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user); 

					// Check if it's the user's first login
					if (user.isFirstLogin()) {
						
						response.sendRedirect(DETAIL_REGISTRATION_JSP);
					} else {
						// Redirect to the success page after a normal login
						response.sendRedirect("HomeServlet");
					}
				} else {
					forwardWithError(request, response, "Failed to retrieve user details.");
				}
			} else {
				forwardWithError(request, response, "Invalid username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error during login: ", e);
			forwardWithError(request, response, "An unexpected error occurred. Please try again later.");
		}
	}

	private void forwardWithError(HttpServletRequest request, HttpServletResponse response, String errorMessage)
			throws ServletException, IOException {
		request.setAttribute("LoginerrorMessage", errorMessage);
		request.getRequestDispatcher(LOGIN_REGISTRATION_JSP).forward(request, response);
	}
}
