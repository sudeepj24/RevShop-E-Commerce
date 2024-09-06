package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revshop.Entity.Entity;
import com.revshop.Entity.FavoriteProductsEntity;
import com.revshop.utility.DBConnection;

public class FavriouteDAO implements DAO {
    private static final Logger logger = Logger.getLogger(FavriouteDAO.class);

    @Override
    public boolean insert(Entity entity) {
        logger.debug("Entering insert() method with entity: " + entity);
        
        if (entity instanceof FavoriteProductsEntity) {
            FavoriteProductsEntity favorite = (FavoriteProductsEntity) entity;
            String query = "INSERT INTO tbl_favorites (user_id, product_id, product_name, product_price, product_discount, img_url) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setInt(1, favorite.getUserId());
                stmt.setInt(2, favorite.getProductId());
                stmt.setString(3, favorite.getProductName());
                stmt.setDouble(4, favorite.getProductPrice());
                stmt.setDouble(5, favorite.getProductDiscount() != null ? favorite.getProductDiscount() : 0.0);
                stmt.setString(6, favorite.getImgUrl());

                int rowsAffected = stmt.executeUpdate();
                logger.debug("Rows affected: " + rowsAffected);
                return rowsAffected > 0;

            } catch (SQLException e) {
                logger.error("SQL Exception in insert() method", e);
                return false;
            }
        }
        logger.debug("Entity is not an instance of FavoriteProductsEntity");
        return false;
    }

    @Override
    public boolean update(Entity entity) {
        logger.debug("Entering update() method with entity: " + entity);
        // Implementation here...
        logger.debug("Exiting update() method");
        return false;
    }

    @Override
    public boolean delete(int id) {
        logger.debug("Entering delete() method with id: " + id);
        
        String query = "DELETE FROM tbl_favorites WHERE favi_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            logger.debug("Rows affected: " + rowsAffected);
            return rowsAffected > 0;

        } catch (SQLException e) {
            logger.error("SQL Exception in delete() method", e);
            return false;
        }
    }

    @Override
    public Entity retrieveById(int id) {
        logger.debug("Entering retrieveById() method with id: " + id);
        // Implementation here...
        logger.debug("Exiting retrieveById() method");
        return null;
    }

    @Override
    public List<Entity> retrieveAll() {
        logger.debug("Entering retrieveAll() method");
        // Implementation here...
        logger.debug("Exiting retrieveAll() method");
        return null;
    }

    public List<FavoriteProductsEntity> getFavoritesByUserId(int userId) {
        logger.debug("Entering getFavoritesByUserId() method with userId: " + userId);
        
        List<FavoriteProductsEntity> favoriteItems = new ArrayList<>();
        String query = "SELECT * FROM tbl_favorites WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FavoriteProductsEntity favoriteItem = new FavoriteProductsEntity();
                    favoriteItem.setFav_id(rs.getInt("favi_id"));
                    favoriteItem.setUserId(rs.getInt("user_id"));
                    favoriteItem.setProductId(rs.getInt("product_id"));
                    favoriteItem.setProductName(rs.getString("product_name"));
                    favoriteItem.setProductPrice(rs.getDouble("product_price"));
                    favoriteItem.setProductDiscount(rs.getDouble("product_discount"));
                    favoriteItem.setImgUrl(rs.getString("img_url"));

                    favoriteItems.add(favoriteItem);
                }
            }
        } catch (SQLException e) {
            logger.error("SQL Exception in getFavoritesByUserId() method", e);
        }

        logger.debug("Exiting getFavoritesByUserId() method with result: " + favoriteItems);
        return favoriteItems;
    }
}
