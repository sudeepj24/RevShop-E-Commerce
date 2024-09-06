package com.revshop.Entity;

public class CartEntity implements Entity {

	private int cartItemId;
	private int userId;
	private int productId;
	private String productName;
	private double productPrice;
	private Double productDiscount;
	private String imgUrl;
	private int quantity;
	private int totalPrice;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartEntity(int cartItemId, int userId, int productId, String productName, double productPrice,
			Double productDiscount, String imgUrl, int quantity, int totalPrice) {
		super();
		this.cartItemId = cartItemId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.imgUrl = imgUrl;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public CartEntity() {
		super();
	}

	@Override
	public String toString() {
		return "CartEntity [cartItemId=" + cartItemId + ", userId=" + userId + ", productId=" + productId
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", productDiscount="
				+ productDiscount + ", imgUrl=" + imgUrl + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ "]";
	}

}
