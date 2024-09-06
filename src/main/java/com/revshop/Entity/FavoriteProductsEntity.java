package com.revshop.Entity;

public class FavoriteProductsEntity implements Entity{

	private int fav_id;
	private int userId;
	private int productId;
	private String productName;
	private double productPrice;
	private Double productDiscount;
	private String imgUrl;

	public int getFav_id() {
		return fav_id;
	}

	public void setFav_id(int fav_id) {
		this.fav_id = fav_id;
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

	public FavoriteProductsEntity(int fav_id, int userId, int productId, String productName, double productPrice,
			Double productDiscount, String imgUrl) {
		super();
		this.fav_id = fav_id;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.imgUrl = imgUrl;
	}

	public FavoriteProductsEntity() {
		super();
	}

	@Override
	public String toString() {
		return "FavoriteProductsEntity [fav_id=" + fav_id + ", userId=" + userId + ", productId=" + productId
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", productDiscount="
				+ productDiscount + ", imgUrl=" + imgUrl + "]";
	}

}
