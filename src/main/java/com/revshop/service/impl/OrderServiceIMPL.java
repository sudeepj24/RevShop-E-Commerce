package com.revshop.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revshop.Entity.CartEntity;
import com.revshop.Entity.OrderEntity;
import com.revshop.Entity.TransactionEntity;
import com.revshop.dao.CartDAO;
import com.revshop.dao.OrderDAO;
import com.revshop.dao.ProductDAO;
import com.revshop.dao.TransactionDAO;
import com.revshop.dao.UserDAO;
import com.revshop.service.OrderService;
import com.revshop.utility.DBConnection;
import com.revshop.utility.EcommerceEmailUtility;

public class OrderServiceIMPL implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceIMPL.class); // Logger instance

    private OrderDAO orderDAO;
    private TransactionDAO transactionDAO;
    private CartDAO cartDAO;
    private ProductDAO productDAO;
    private UserDAO userDAO;

    public OrderServiceIMPL() {
        this.orderDAO = new OrderDAO();
        this.transactionDAO = new TransactionDAO();
        this.cartDAO = new CartDAO();
        this.productDAO = ProductDAO.getInstance();
        this.userDAO = UserDAO.getInstance();
    }

    @Override
    public boolean placeOrder(int userId, String paymentId, String shippingAddress) {
        logger.debug("Placing order for user ID: {} with payment ID: {}", userId, paymentId);
        Connection connection = null;
        boolean orderPlaced = false;

        try {
            connection = DBConnection.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Fetch cart items for the user
            List<CartEntity> cartItems = cartDAO.getCartByUserId(userId);
            logger.debug("Retrieved {} items from cart for user ID: {}", cartItems.size(), userId);

            for (CartEntity item : cartItems) {
                int sellerId = productDAO.getSellerIdByProductId(item.getProductId());

                // Create and save the order
                OrderEntity order = new OrderEntity();
                order.setOrderId("OD" + System.currentTimeMillis() + (int) (Math.random() * 10000));
                order.setUserId(userId);
                order.setSellerId(sellerId);
                order.setProductId(item.getProductId());
                order.setTranscationId(paymentId);
                order.setProductName(item.getProductName());
                order.setTotalPrice(item.getTotalPrice());
                order.setQuantity(item.getQuantity());
                order.setImgUrl(item.getImgUrl());
                order.setStatus("To Be Shipped");
                order.setShippingAddress(shippingAddress);
                orderDAO.insert(order);
                logger.debug("Order created with ID: {} for product ID: {}", order.getOrderId(), item.getProductId());

                // Save transaction details
                TransactionEntity transaction = new TransactionEntity();
                transaction.setTransactionId(paymentId);
                transaction.setOrderId(order.getOrderId());
                transaction.setAmount(order.getTotalPrice());
                transaction.setUserId(userId);
                transaction.setSellerId(sellerId);
                transactionDAO.insert(transaction);
                logger.debug("Transaction created with ID: {} for order ID: {}", paymentId, order.getOrderId());

                // Update product stock
                productDAO.updateProductStock(item.getProductId(), item.getQuantity());
                logger.debug("Product stock updated for product ID: {}", item.getProductId());

                // Remove items from the cart
                cartDAO.deleteProductFromCart(userId, item.getProductId());
                logger.debug("Product ID: {} removed from cart for user ID: {}", item.getProductId(), userId);

                // Send emails to buyer and seller
                sendOrderEmails(order, shippingAddress, item, sellerId, userId);
            }

            connection.commit();
            orderPlaced = true;
            logger.info("Order placed successfully for user ID: {} with payment ID: {}", userId, paymentId);

        } catch (SQLException e) {
            logger.error("Error placing order for user ID: {}", userId, e);
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback in case of error
                    logger.warn("Transaction rolled back for user ID: {}", userId);
                } catch (SQLException ex) {
                    logger.error("Error during transaction rollback for user ID: {}", userId, ex);
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Reset auto-commit mode
                    connection.close(); // Close the connection
                } catch (SQLException e) {
                    logger.error("Error closing connection for user ID: {}", userId, e);
                }
            }
        }

        return orderPlaced;
    }

    private void sendOrderEmails(OrderEntity order, String shippingAddress, CartEntity item, int sellerId, int userId) {
        logger.debug("Sending order emails for order ID: {} to user ID: {} and seller ID: {}", order.getOrderId(), userId, sellerId);
        String buyerEmail = userDAO.retrieveById(userId).getEmail();
        String sellerEmail = userDAO.retrieveById(sellerId).getEmail();

        if (buyerEmail != null && sellerEmail != null) {
            String buyerSubject = "Order Confirmation - " + order.getOrderId();
            String buyerMessage = "<h1>Thank you for your purchase!</h1>"
                    + "<p>Your order <b>" + order.getOrderId() + "</b> has been placed successfully.</p>"
                    + "<p>Product: " + order.getProductName() + "</p>"
                    + "<p>Quantity: " + order.getQuantity() + "</p>"
                    + "<p>Total Price: RS" + order.getTotalPrice() + "</p>"
                    + "<p>Shipping Address: " + shippingAddress + "</p>"
                    + "<p>We will notify you once your order is shipped.</p>"
                    + "<br><p>Thank you for shopping with us!</p>";

            EcommerceEmailUtility.sendOrderConfirmationToBuyer(buyerEmail, buyerSubject, buyerMessage);
            logger.info("Order confirmation email sent to buyer: {}", buyerEmail);

            String sellerSubject = "New Order Placed - " + order.getOrderId();
            String sellerMessage = "<h1>New Order Received!</h1>"
                    + "<p>Order <b>" + order.getOrderId() + "</b> has been placed by a customer.</p>"
                    + "<p>Product: " + order.getProductName() + "</p>"
                    + "<p>Quantity: " + order.getQuantity() + "</p>"
                    + "<p>Total Price: RS" + order.getTotalPrice() + "</p>"
                    + "<p>Shipping Address: " + shippingAddress + "</p>"
                    + "<br><p>Please proceed with the necessary steps to ship the order.</p>";

            EcommerceEmailUtility.sendOrderNotificationToSeller(sellerEmail, sellerSubject, sellerMessage);
            logger.info("Order notification email sent to seller: {}", sellerEmail);
        } else {
            if (buyerEmail == null) {
                logger.error("Buyer email could not be retrieved for userId: {}", userId);
            }
            if (sellerEmail == null) {
                logger.error("Seller email could not be retrieved for sellerId: {}", sellerId);
            }
        }
    }

    @Override
    public List<OrderEntity> getOrdersByUserId(int userId) {
        logger.debug("Retrieving orders for user ID: {}", userId);
        try {
            return orderDAO.getOrdersByUserId(userId);
        } catch (SQLException e) {
            logger.error("Error retrieving orders for user ID: {}", userId, e);
            return null;
        }
    }

    @Override
    public List<OrderEntity> getOrdersBySellerId(int sellerId) {
        logger.debug("Retrieving orders for seller ID: {}", sellerId);
        try {
            return orderDAO.getOrdersBySellerId(sellerId);
        } catch (SQLException e) {
            logger.error("Error retrieving orders for seller ID: {}", sellerId, e);
            return null;
        }
    }

    @Override
    public boolean updateOrderStatus(String orderId, String status) {
        logger.debug("Updating order status to '{}' for order ID: {}", status, orderId);
        try {
            boolean result = orderDAO.updateOrderStatus(orderId, status);
            if (result) {
                logger.info("Order status updated to '{}' for order ID: {}", status, orderId);
            } else {
                logger.error("Failed to update order status to '{}' for order ID: {}", status, orderId);
            }
            return result;
        } catch (SQLException e) {
            logger.error("Error updating order status to '{}' for order ID: {}", status, orderId, e);
            return false;
        }
    }
}