package com.revshop.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revshop.Entity.LoginEntity;
import com.revshop.service.LoginService;
import com.revshop.service.impl.LoginServiceIMPL;
import com.revshop.utility.BCryptPasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
	}

	private static final Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);

    // Page paths
    private static final String LOGIN_REGISTRATION_JSP = "LoginAndRegistration/user-register.jsp";
    private static final String SUCCESS_PAGE = "OtherPages/Success.jsp";
    private static final String ERROR_PAGE = "OtherPages/Error.jsp";
    private static final String LOGIN_PAGE = "LoginAndRegistration/user-login.jsp";
    

    private final LoginService loginService = LoginServiceIMPL.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(LOGIN_REGISTRATION_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userType = request.getParameter("userType");
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (userName == null || email == null || password == null || userType == null) {
            request.setAttribute("RegistererrorMessage", "All fields are required.");
            request.getRequestDispatcher(LOGIN_REGISTRATION_JSP).forward(request, response);
            return;
        }

        String hashedPassword = BCryptPasswordUtil.hashPassword(password);

        LoginEntity registration = new LoginEntity();
        registration.setEmail(email);
        registration.setUserName(userName);
        registration.setFirstLogin(true);
        registration.setPassword(hashedPassword);
        registration.setRole(userType);

        try {
            if (loginService.emailExists(registration.getEmail())) {
                forwardWithError(request, response, "Email already exists. Please use a different email.");
                return;
            }

            if (loginService.usernameExists(registration.getUserName())) {
                forwardWithError(request, response, "Username already exists. Please choose a different username.");
                return;
            }

            boolean result = loginService.saveLogin(registration);
            if (result) {
                response.sendRedirect(LOGIN_PAGE);
            } else {
                response.sendRedirect(ERROR_PAGE);
            }
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error("Error during registration: ", e);
            forwardWithError(request, response, "An unexpected error occurred. Please try again later.");
        }
    }

    private void forwardWithError(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        request.setAttribute("RegistererrorMessage", errorMessage);
        request.getRequestDispatcher(LOGIN_REGISTRATION_JSP).forward(request, response);
    }

}
