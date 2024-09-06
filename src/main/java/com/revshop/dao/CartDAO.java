package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revshop.Entity.CartEntity;
import com.revshop.Entity.Entity;
import com.revshop.utility.DBConnection;

public class CartDAO implements DAO {

	@Override
	public boolean insert(Entity entity) {
		if (entity instanceof CartEntity) {
			CartEntity cartItem = (CartEntity) entity;
			String query = "INSERT INTO tbl_cart (user_id, productName, productPrice, productDiscount, imgUrl, totalPrice, quantity,product_id) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

			try (Connection conn = DBConnection.getConnection();
					PreparedStatement stmt = conn.prepareStatement(query)) {

				stmt.setInt(1, cartItem.getUserId());
				stmt.setString(2, cartItem.getProductName());
				stmt.setDouble(3, cartItem.getProductPrice());
				stmt.setDouble(4, cartItem.getProductDiscount());
				stmt.setString(5, cartItem.getImgUrl());
				stmt.setDouble(6, cartItem.getTotalPrice());
				stmt.setInt(7, cartItem.getQuantity());
				stmt.setInt(8, cartItem.getProductId());

				int rowsAffected = stmt.executeUpdate();

				if (rowsAffected > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean update(Entity entity) {
		// TODO Auto-generated method stub
		return false;
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

	public List<CartEntity> getCartByUserId(int userId) {
		List<CartEntity> cartItems = new ArrayList<>();
		String query = "SELECT * FROM tbl_cart WHERE user_id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setInt(1, userId);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					CartEntity cartItem = new CartEntity();
					cartItem.setCartItemId(rs.getInt("cart_id"));
					cartItem.setUserId(rs.getInt("user_id"));
					cartItem.setProductName(rs.getString("productName"));
					cartItem.setProductPrice(rs.getDouble("productPrice"));
					cartItem.setProductDiscount(rs.getDouble("productDiscount"));
					cartItem.setImgUrl(rs.getString("imgUrl"));
					cartItem.setTotalPrice(rs.getInt("totalPrice"));
					cartItem.setProductId(rs.getInt("product_Id"));
					cartItem.setQuantity(rs.getInt("quantity"));

					cartItems.add(cartItem);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cartItems;
	}

	public boolean update(Entity entity, String action) {
		if (entity instanceof CartEntity) {
			CartEntity cartItem = (CartEntity) entity;
			String query = "";

			if ("increase".equals(action)) {
				query = "UPDATE tbl_cart SET quantity = quantity + 1 WHERE user_id = ? AND product_id = ?";
			} else if ("decrease".equals(action)) {
				// First, check if the current quantity is 1
				query = "SELECT quantity FROM tbl_cart WHERE user_id = ? AND product_id = ?";

				try (Connection conn = DBConnection.getConnection();
						PreparedStatement stmt = conn.prepareStatement(query)) {

					stmt.setInt(1, cartItem.getUserId());
					stmt.setInt(2, cartItem.getProductId());

					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						int currentQuantity = rs.getInt("quantity");

						if (currentQuantity == 1) {
							// If quantity is 1, call the delete method
							deleteProductFromCart(cartItem.getUserId(), cartItem.getProductId());
							return true; // Product has been deleted
						} else {
							// If quantity is more than 1, decrease the quantity
							query = "UPDATE tbl_cart SET quantity = quantity - 1 WHERE user_id = ? AND product_id = ? AND quantity > 1";
						}
					} else {
						return false; // No such product found in the cart
					}
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			} else {
				return false; // Unsupported action
			}

			// Execute the update if applicable
			try (Connection conn = DBConnection.getConnection();
					PreparedStatement stmt = conn.prepareStatement(query)) {

				stmt.setInt(1, cartItem.getUserId());
				stmt.setInt(2, cartItem.getProductId());

				int rowsAffected = stmt.executeUpdate();
				return rowsAffected > 0;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean deleteProductFromCart(int userId, int productId) {
		String query = "DELETE FROM tbl_cart WHERE user_id = ? AND product_id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setInt(1, userId);
			stmt.setInt(2, productId);

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0; // Returns true if the product was deleted, otherwise false

		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Return false if there was an exception
		}
	}
}
