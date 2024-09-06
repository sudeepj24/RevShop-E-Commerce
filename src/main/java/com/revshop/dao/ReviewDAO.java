package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revshop.Entity.Entity;
import com.revshop.Entity.ReviewEntity;
import com.revshop.utility.DBConnection;

public class ReviewDAO implements DAO {

    private static final String INSERT_REVIEW_SQL = 
        "INSERT INTO tbl_review (review, stars, productId, userId, customerName, customerEmail, reviewDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_REVIEWS_BY_PRODUCT_ID = 
        "SELECT * FROM tbl_review WHERE productId = ?";

    @Override
    public boolean insert(Entity entity) throws SQLException {
        if (!(entity instanceof ReviewEntity)) {
            return false;
        }

        ReviewEntity review = (ReviewEntity) entity;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REVIEW_SQL)) {

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, review.getReview());
            preparedStatement.setInt(2, review.getStars());
            preparedStatement.setInt(3, review.getProductId());
            preparedStatement.setInt(4, review.getUserId());
            preparedStatement.setString(5, review.getCustomerName());
            preparedStatement.setString(6, review.getCustomerEmail());
            preparedStatement.setDate(7, new java.sql.Date(review.getReviewDate().getTime())); // Use current date

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<ReviewEntity> getReviewsByProductId(int productId) throws SQLException {
        List<ReviewEntity> reviews = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEWS_BY_PRODUCT_ID)) {

            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ReviewEntity review = new ReviewEntity();
                    review.setReviewId(resultSet.getInt("review_id"));
                    review.setReview(resultSet.getString("review"));
                    review.setStars(resultSet.getInt("stars"));
                    review.setProductId(resultSet.getInt("productId"));
                    review.setUserId(resultSet.getInt("userId"));
                    review.setCustomerName(resultSet.getString("customerName"));
                    review.setCustomerEmail(resultSet.getString("customerEmail"));
                    review.setReviewDate(resultSet.getDate("reviewDate"));

                    reviews.add(review);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return reviews;
    }

    @Override
    public boolean update(Entity entity) throws SQLException {
        // Implement the update logic if required
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        // Implement the delete logic if required
        return false;
    }

    @Override
    public Entity retrieveById(int id) throws SQLException {
        // Implement the retrieve by ID logic if required
        return null;
    }

    @Override
    public List<Entity> retrieveAll() throws SQLException {
        // Implement the retrieve all logic if required
        return null;
    }
}
