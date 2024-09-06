package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revshop.Entity.Entity;
import com.revshop.Entity.OrderEntity;
import com.revshop.utility.DBConnection;

public class OrderDAO implements DAO {

    private static final String INSERT_ORDER_SQL = 
        "INSERT INTO tbl_order (orderId, sellerId, userId, productId, transactionId, productName, totalPrice, quantity, imgUrl, status, shippingAddress) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SELECT_ORDERS_BY_USER_ID_SQL =
            "SELECT * FROM tbl_order WHERE userId = ?";

    @Override
    public boolean insert(Entity entity) throws SQLException {
        if (!(entity instanceof OrderEntity)) {
            return false;
        }

        OrderEntity order = (OrderEntity) entity;

        // Generate a unique orderId

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, order.getOrderId());
            preparedStatement.setInt(2, order.getSellerId());
            preparedStatement.setInt(3, order.getUserId());
            preparedStatement.setInt(4, order.getProductId());
            preparedStatement.setString(5, order.getTranscationId());
            preparedStatement.setString(6, order.getProductName());
            preparedStatement.setDouble(7, order.getTotalPrice());
            preparedStatement.setInt(8, order.getQuantity());
            preparedStatement.setString(9, order.getImgUrl());
            preparedStatement.setString(10, order.getStatus());
            preparedStatement.setString(11, order.getShippingAddress());

            // Execute the insert operation
            int rowsAffected = preparedStatement.executeUpdate();

            // Return true if the insert was successful, otherwise false
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Re-throw the exception to be handled by the calling service
            throw e;
        }
    }


    @Override
    public boolean update(Entity entity) throws SQLException {
        // Method implementation here...
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        // Method implementation here...
        return false;
    }

    @Override
    public Entity retrieveById(int id) throws SQLException {
        // Method implementation here...
        return null;
    }

    @Override
    public List<Entity> retrieveAll() throws SQLException {
        // Method implementation here...
        return null;
    }
    
    public List<OrderEntity> getOrdersByUserId(int userId) throws SQLException {
        List<OrderEntity> orders = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_USER_ID_SQL)) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    OrderEntity order = new OrderEntity();
                    order.setOrderId(resultSet.getString("orderId"));
                    order.setSellerId(resultSet.getInt("sellerId"));
                    order.setUserId(resultSet.getInt("userId"));
                    order.setProductId(resultSet.getInt("productId"));
                    order.setTranscationId(resultSet.getString("transactionId"));
                    order.setProductName(resultSet.getString("productName"));
                    order.setTotalPrice(resultSet.getDouble("totalPrice"));
                    order.setQuantity(resultSet.getInt("quantity"));
                    order.setImgUrl(resultSet.getString("imgUrl"));
                    order.setStatus(resultSet.getString("status"));
                    order.setShippingAddress(resultSet.getString("shippingAddress"));

                    orders.add(order);
                }
            }

        } catch (SQLException e) {
            throw e;
        }

        return orders;
    }
    
    private static final String SELECT_ORDERS_BY_SELLER_ID_SQL =
            "SELECT * FROM tbl_order WHERE sellerId = ?";
    private static final String UPDATE_ORDER_STATUS_SQL =
            "UPDATE tbl_order SET status = ? WHERE orderId = ?";

    public List<OrderEntity> getOrdersBySellerId(int sellerId) throws SQLException {
        List<OrderEntity> orders = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_SELLER_ID_SQL)) {

            preparedStatement.setInt(1, sellerId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    OrderEntity order = new OrderEntity();
                    order.setOrderId(resultSet.getString("orderId"));
                    order.setSellerId(resultSet.getInt("sellerId"));
                    order.setUserId(resultSet.getInt("userId"));
                    order.setProductId(resultSet.getInt("productId"));
                    order.setTranscationId(resultSet.getString("transactionId"));
                    order.setProductName(resultSet.getString("productName"));
                    order.setTotalPrice(resultSet.getDouble("totalPrice"));
                    order.setQuantity(resultSet.getInt("quantity"));
                    order.setImgUrl(resultSet.getString("imgUrl"));
                    order.setStatus(resultSet.getString("status"));
                    order.setShippingAddress(resultSet.getString("shippingAddress"));

                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return orders;
    }

    public boolean updateOrderStatus(String orderId, String status) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_STATUS_SQL)) {

            preparedStatement.setString(1, status);
            preparedStatement.setString(2, orderId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw e;
        }
    }
}
