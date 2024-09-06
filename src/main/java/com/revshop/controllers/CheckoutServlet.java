package com.revshop.controllers;

import java.io.IOException;
import java.util.List;

import com.revshop.Entity.CartEntity;
import com.revshop.Entity.LoginEntity;
import com.revshop.Entity.UserEntity;
import com.revshop.service.impl.CartServiceIMPL;
import com.revshop.service.impl.OrderServiceIMPL;
import com.revshop.service.impl.UserServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckoutServlet
 */
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserServiceIMPL userService;
    private CartServiceIMPL cartService;
    private OrderServiceIMPL orderService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        this.userService = new UserServiceIMPL();
        this.cartService = new CartServiceIMPL();
        this.orderService = new OrderServiceIMPL();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoginEntity loginUser = (LoginEntity) session.getAttribute("user");

        if (loginUser != null) {
            // Fetch user details
            UserEntity userDetails = userService.getUserById(loginUser.getUserId());
            request.setAttribute("userDetails", userDetails);

            // Fetch cart details
            List<CartEntity> cartItems = cartService.getCart(loginUser.getUserId());
            request.setAttribute("cartItems", cartItems);

            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoginEntity loginUser = (LoginEntity) session.getAttribute("user");

        if (loginUser != null) {
            // Fetch the current user details
            UserEntity userDetails = userService.getUserById(loginUser.getUserId());

            // Get the shipping details from the form submission
            String shippingAddress = request.getParameter("address") + ", " +
                                     request.getParameter("city") + ", " +
                                     request.getParameter("state") + ", " +
                                     request.getParameter("zip");

            // Get the Razorpay payment ID
            String paymentId = request.getParameter("payment_id");

            // Place the order
            boolean orderPlaced = orderService.placeOrder(loginUser.getUserId(), paymentId, shippingAddress);

            if (orderPlaced) {
                // Redirect to the success page
                response.sendRedirect(request.getContextPath() + "/Checkout-success.jsp");
            } else {
                // Redirect to an error page or show an error message (you can customize this)
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
