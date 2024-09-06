package com.revshop.Entity;

public class ProductEntity implements Entity {

	private int productId;
	private String productName;
	private String productDescription;
	private double productPrice;
	private double productDiscount;
	private int productStock;
	private String productBrand;
	private String productCategory;
	private String productTags;
	private String productStatus;

	private String productImage;
	private int sellerId;

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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductTags() {
		return productTags;
	}

	public void setProductTags(String productTags) {
		this.productTags = productTags;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public ProductEntity() {
		super();
	}

	public ProductEntity(int productId, String productName, String productDescription, double productPrice,
			double productDiscount, int productStock, String productBrand, String productCategory, String productTags,
			String productStatus, String productImage, int sellerId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productStock = productStock;
		this.productBrand = productBrand;
		this.productCategory = productCategory;
		this.productTags = productTags;
		this.productStatus = productStatus;
		this.productImage = productImage;
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productDiscount=" + productDiscount
				+ ", productStock=" + productStock + ", productBrand=" + productBrand + ", productCategory="
				+ productCategory + ", productTags=" + productTags + ", productStatus=" + productStatus
				+ ", productImage=" + productImage + ", sellerId=" + sellerId + "]";
	}

}
