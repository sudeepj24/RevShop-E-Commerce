package com.revshop.Entity;

public class TransactionEntity implements Entity {

	private String transactionId;
	private String orderId;
	private double amount;
	private int userId;
	private int sellerId;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public TransactionEntity(String transactionId, String orderId, double amount, int userId, int sellerId) {
		super();
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.amount = amount;
		this.userId = userId;
		this.sellerId = sellerId;
	}

	public TransactionEntity() {
		super();
	}

	@Override
	public String toString() {
		return "TranscationEntity [transactionId=" + transactionId + ", orderId=" + orderId + ", amount=" + amount
				+ ", userId=" + userId + ", sellerId=" + sellerId + "]";
	}

}
