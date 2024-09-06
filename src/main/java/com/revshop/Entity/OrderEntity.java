package com.revshop.Entity;

public class OrderEntity implements Entity {

	private String orderId;
	private int sellerId;
	private int userId;
	private int productId;
	private String transcationId;
	private String productName;
	private double totalPrice;
	private String shippingAddress;
	private int quantity;
	private String imgUrl;
	private String status;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTranscationId() {
		return transcationId;
	}

	public void setTranscationId(String transcationId) {
		this.transcationId = transcationId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderEntity(String orderId, int sellerId, int userId, int productId, String transcationId,
			String productName, double totalPrice, String shippingAddress, int quantity, String imgUrl, String status) {
		super();
		this.orderId = orderId;
		this.sellerId = sellerId;
		this.userId = userId;
		this.productId = productId;
		this.transcationId = transcationId;
		this.productName = productName;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
		this.quantity = quantity;
		this.imgUrl = imgUrl;
		this.status = status;
	}

	public OrderEntity() {
		super();
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", sellerId=" + sellerId + ", userId=" + userId + ", productId="
				+ productId + ", transcationId=" + transcationId + ", productName=" + productName + ", totalPrice="
				+ totalPrice + ", shippingAddress=" + shippingAddress + ", quantity=" + quantity + ", imgUrl=" + imgUrl
				+ ", status=" + status + "]";
	}

}
