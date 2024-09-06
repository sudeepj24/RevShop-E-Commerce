package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revshop.Entity.Entity;
import com.revshop.Entity.TransactionEntity;
import com.revshop.utility.DBConnection;

public class TransactionDAO implements DAO{

	@Override
	public boolean insert(Entity entity) {
		if (!(entity instanceof TransactionEntity)) {
			return false;
		}

		TransactionEntity transaction = (TransactionEntity) entity;

		String query = "INSERT INTO tbl_transcations (transcation_id, orderId, amount, userId, sellerId) VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
			 PreparedStatement stmt = connection.prepareStatement(query)) {

			stmt.setString(1, transaction.getTransactionId());
			stmt.setString(2, transaction.getOrderId());
			stmt.setDouble(3, transaction.getAmount());
			stmt.setInt(4, transaction.getUserId());
			stmt.setInt(5, transaction.getSellerId());

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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

}
