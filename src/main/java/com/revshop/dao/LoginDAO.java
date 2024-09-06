package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revshop.Entity.Entity;
import com.revshop.Entity.LoginEntity;
import com.revshop.utility.DBConnection;

public class LoginDAO implements DAO {
    private static final String INSERT_LOGIN_SQL = "INSERT INTO tbl_login (username, email, password, isFirstLogin, role, userid) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String CHECK_EMAIL_SQL = "SELECT * FROM tbl_login WHERE email = ?";
    private static final String CHECK_USERNAME_SQL = "SELECT * FROM tbl_login WHERE username = ?";

    // Singleton instance
    private static LoginDAO instance;

    // UserDAO instance
    private UserDAO rd = UserDAO.getInstance();

    // Private constructor to prevent instantiation
    private LoginDAO() {}

    // Public method to provide access to the singleton instance
    public static LoginDAO getInstance() {
        if (instance == null) {
            synchronized (LoginDAO.class) {
                if (instance == null) {
                    instance = new LoginDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean insert(Entity entity) {
        boolean isSaved = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement loginPreparedStatement = connection.prepareStatement(INSERT_LOGIN_SQL)) {
             
            connection.setAutoCommit(false);
            LoginEntity login = (LoginEntity) entity;

            // Get the userId by inserting the basic information into tbl_user
            int userId = rd.initialInsertAndGetKeys(login);

            if (userId != -1) {
                // Insert login details using the generated userId
                loginPreparedStatement.setString(1, login.getUserName());
                loginPreparedStatement.setString(2, login.getEmail());
                loginPreparedStatement.setString(3, login.getPassword());
                loginPreparedStatement.setBoolean(4, login.isFirstLogin());
                loginPreparedStatement.setString(5, login.getRole());
                loginPreparedStatement.setInt(6, userId);

                int loginResult = loginPreparedStatement.executeUpdate();
                if (loginResult > 0) {
                    isSaved = true;
                    connection.commit(); // Commit if successful
                } else {
                    connection.rollback(); // Rollback if unsuccessful
                }
            } else {
                connection.rollback(); // Rollback if user ID generation failed
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean update(Entity entity) {
        LoginEntity loginEntity = (LoginEntity) entity;
        String query = "UPDATE tbl_login SET email = ?, password = ?, isFirstLogin = ?, role = ?, username = ? WHERE loginId = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, loginEntity.getEmail());
            preparedStatement.setString(2, loginEntity.getPassword());
            preparedStatement.setBoolean(3, loginEntity.isFirstLogin());
            preparedStatement.setString(4, loginEntity.getRole());
            preparedStatement.setString(5, loginEntity.getUserName());
            preparedStatement.setInt(6, loginEntity.getLoginId());

            int result = preparedStatement.executeUpdate();
            return result > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Entity retrieveById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Entity> retrieveAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public LoginEntity findByEmail(String email) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_EMAIL_SQL)) {

            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractLoginEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LoginEntity findByUsername(String username) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USERNAME_SQL)) {

            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractLoginEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Extracts a LoginEntity object from a ResultSet
    private LoginEntity extractLoginEntity(ResultSet resultSet) throws SQLException {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setLoginId(resultSet.getInt("loginId"));  // Extracting loginId from ResultSet
        loginEntity.setUserName(resultSet.getString("username"));
        loginEntity.setEmail(resultSet.getString("email"));
        loginEntity.setPassword(resultSet.getString("password"));
        loginEntity.setFirstLogin(resultSet.getBoolean("isFirstLogin"));
        loginEntity.setRole(resultSet.getString("role"));
        loginEntity.setUserId(resultSet.getInt("userid"));
        return loginEntity;
    }

}
