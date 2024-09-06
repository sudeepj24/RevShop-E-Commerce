package com.revshop.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revshop.Entity.LoginEntity;
import com.revshop.Entity.UserEntity;
import com.revshop.service.UserService;
import com.revshop.service.impl.UserServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserAccountServlet
 */
public class UserAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(UserAccountServlet.class); // Logger instance
    private UserService userService;

    public UserAccountServlet() {
        super();
        this.userService = new UserServiceIMPL();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Entering doGet() method in UserAccountServlet");

        // Retrieve the session and get the logged-in user's email
        HttpSession session = request.getSession(false);
        LoginEntity loggedInUser = (LoginEntity) (session != null ? session.getAttribute("user") : null);

        if (loggedInUser != null) {
            logger.debug("User is logged in: {}", loggedInUser.getEmail());

            // Fetch user details by ID
            try {
                UserEntity userDetails = userService.getUserById(loggedInUser.getUserId());
                logger.debug("User details retrieved for user ID: {}", loggedInUser.getUserId());

                // Set the user details in the request scope to be available for JSP
                request.setAttribute("userDetails", userDetails);

                // Forward the request to the JSP page to display the user details
                request.getRequestDispatcher("LoginAndRegistration/userAccount.jsp").forward(request, response);
                logger.debug("Forwarded to LoginAndRegistration/userAccount.jsp");
            } catch (Exception e) {
                logger.error("Error retrieving user details for user ID: {}", loggedInUser.getUserId(), e);
                response.sendRedirect("LoginAndRegistration/user-login.jsp");
            }
        } else {
            // If no user is logged in, redirect to the login page
            logger.warn("No user is logged in. Redirecting to login page.");
            response.sendRedirect("LoginAndRegistration/user-login.jsp");
        }

        logger.debug("Exiting doGet() method in UserAccountServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Entering doPost() method in UserAccountServlet");
        doGet(request, response);
        logger.debug("Exiting doPost() method in UserAccountServlet");
    }
}
