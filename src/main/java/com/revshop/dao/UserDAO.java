package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.revshop.Entity.Entity;
import com.revshop.Entity.LoginEntity;
import com.revshop.Entity.UserEntity;
import com.revshop.utility.DBConnection;

public class UserDAO implements DAO {

    private static final Logger logger = Logger.getLogger(UserDAO.class);
    
    private static final String INSERT_USER_BASIC = "INSERT INTO tbl_user (email) VALUES (?)";
    private static final String INSERT_USER_FULL = "INSERT INTO tbl_user (firstName, lastName, gender, mobile, email, pincode, billingAddress, shippingAddress, bankAccountNo, ifsc, companyName, gstNumber, websiteUrl, productType, panNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE tbl_user SET firstName = ?, lastName = ?, gender = ?, mobile = ?, pincode = ?, billingAddress = ?, shippingAddress = ?, bankAccountNo = ?, ifsc = ?, companyName = ?, gstNumber = ?, websiteUrl = ?, productType = ?, panNumber = ? WHERE userId = ?";


    // Singleton instance
    private static UserDAO instance;

    // Private constructor to prevent instantiation
    private UserDAO() {}

    // Public method to provide access to the singleton instance
    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean insert(Entity entity) {
        logger.debug("Entering insert() method with entity: " + entity);
        
        UserEntity user = (UserEntity) entity;
        int result = 0;
        Connection connection = null; // Declare connection outside try-with-resources

        try {
            connection = DBConnection.getConnection(); // Initialize connection
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_FULL, Statement.RETURN_GENERATED_KEYS);

            connection.setAutoCommit(false);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getMobile());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPincode());
            preparedStatement.setString(7, user.getBillingAddress());
            preparedStatement.setString(8, user.getShippingAddress());
            preparedStatement.setString(9, user.getBankAccountNo());
            preparedStatement.setString(10, user.getIfsc());
            preparedStatement.setString(11, user.getCompanyName());
            preparedStatement.setString(12, user.getGstNumber());
            preparedStatement.setString(13, user.getWebsiteUrl());
            preparedStatement.setString(14, user.getProductType());
            preparedStatement.setString(15, user.getPanNumber());

            result = preparedStatement.executeUpdate();

            if (result > 0) {
                connection.commit();
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserId(generatedKeys.getInt(1));
                    }
                }
            } else {
                connection.rollback();
            }

            logger.debug("Rows affected: " + result);
        } catch (SQLException e) {
            logger.error("SQL Exception in insert() method", e);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    logger.error("SQL Exception during rollback in insert() method", ex);
                }
            }
            return false;
        } finally {
            // Ensure that the connection is closed properly
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("SQL Exception during connection close in insert() method", e);
                }
            }
        }

        logger.debug("Exiting insert() method");
        return result > 0;
    }

    @Override
    public boolean update(Entity entity) {
        logger.debug("Entering update() method with entity: " + entity);
        
        UserEntity user = (UserEntity) entity;
        int result = 0;
        Connection connection = null; // Declare connection outside try-with-resources

        try {
            connection = DBConnection.getConnection(); // Initialize connection
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);

            connection.setAutoCommit(false);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getMobile());
            preparedStatement.setString(5, user.getPincode());
            preparedStatement.setString(6, user.getBillingAddress());
            preparedStatement.setString(7, user.getShippingAddress());
            preparedStatement.setString(8, user.getBankAccountNo());
            preparedStatement.setString(9, user.getIfsc());
            preparedStatement.setString(10, user.getCompanyName());
            preparedStatement.setString(11, user.getGstNumber());
            preparedStatement.setString(12, user.getWebsiteUrl());
            preparedStatement.setString(13, user.getProductType());
            preparedStatement.setString(14, user.getPanNumber());
            preparedStatement.setInt(15, user.getUserId());

            result = preparedStatement.executeUpdate();

            if (result > 0) {
                connection.commit();
            } else {
                connection.rollback();
            }

            logger.debug("Rows affected: " + result);
        } catch (SQLException e) {
            logger.error("SQL Exception in update() method", e);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    logger.error("SQL Exception during rollback in update() method", ex);
                }
            }
            return false;
        } finally {
            // Ensure that the connection is closed properly
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("SQL Exception during connection close in update() method", e);
                }
            }
        }

        logger.debug("Exiting update() method");
        return result > 0;
    }

    @Override
    public boolean delete(int id) {
        logger.debug("Entering delete() method with id: " + id);
        // Implementation to be provided
        logger.debug("Exiting delete() method");
        return false;
    }

    @Override
    public UserEntity retrieveById(int id) {
        logger.debug("Entering retrieveById() method with id: " + id);
        
        UserEntity user = null;
        String query = "SELECT * FROM tbl_user WHERE userId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new UserEntity();
                user.setUserId(resultSet.getInt("userId"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setGender(resultSet.getString("gender"));
                user.setMobile(resultSet.getString("mobile"));
                user.setEmail(resultSet.getString("email"));
                user.setPincode(resultSet.getString("pincode"));
                user.setBillingAddress(resultSet.getString("billingAddress"));
                user.setShippingAddress(resultSet.getString("shippingAddress"));
                user.setBankAccountNo(resultSet.getString("bankAccountNo"));
                user.setIfsc(resultSet.getString("ifsc"));
                user.setCompanyName(resultSet.getString("companyName"));
                user.setGstNumber(resultSet.getString("gstNumber"));
                user.setWebsiteUrl(resultSet.getString("websiteUrl"));
                user.setProductType(resultSet.getString("productType"));
                user.setPanNumber(resultSet.getString("panNumber"));
            }

            logger.debug("Retrieved user: " + user);
        } catch (SQLException e) {
            logger.error("SQL Exception in retrieveById() method", e);
        }

        logger.debug("Exiting retrieveById() method");
        return user;
    }

    @Override
    public List<Entity> retrieveAll() {
        logger.debug("Entering retrieveAll() method");
        // Implementation to be provided
        logger.debug("Exiting retrieveAll() method");
        return null;
    }

    public int initialInsertAndGetKeys(Entity entity) {
        logger.debug("Entering initialInsertAndGetKeys() method with entity: " + entity);
        
        int userId = -1;
        Connection connection = null; // Declare connection outside try-with-resources

        try {
            connection = DBConnection.getConnection(); // Initialize connection
            PreparedStatement userPreparedStatement = connection.prepareStatement(INSERT_USER_BASIC, Statement.RETURN_GENERATED_KEYS);

            connection.setAutoCommit(false);

            LoginEntity register = (LoginEntity) entity;
            userPreparedStatement.setString(1, register.getEmail());

            int userResult = userPreparedStatement.executeUpdate();

            if (userResult > 0) {
                try (ResultSet generatedKeys = userPreparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        userId = generatedKeys.getInt(1);
                    }
                }
                connection.commit(); // Commit the transaction after successfully getting the keys
            } else {
                connection.rollback(); // Rollback if user insertion failed
            }

            logger.debug("Generated userId: " + userId);
        } catch (SQLException e) {
            logger.error("SQL Exception in initialInsertAndGetKeys() method", e);
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback on exception
                } catch (SQLException ex) {
                    logger.error("SQL Exception during rollback in initialInsertAndGetKeys() method", ex);
                }
            }
        } finally {
            // Ensure that the connection is closed properly
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("SQL Exception during connection close in initialInsertAndGetKeys() method", e);
                }
            }
        }

        logger.debug("Exiting initialInsertAndGetKeys() method");
        return userId; // Return the generated user ID
    }
}
