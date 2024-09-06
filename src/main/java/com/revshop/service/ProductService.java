package com.revshop.service;

import java.util.List;

import com.revshop.Entity.ProductEntity;

public interface ProductService {

	public boolean saveProduct(ProductEntity entity);

	List<ProductEntity> getAllProducts();

	public boolean deleteProduct(int id);

	ProductEntity getProductById(int id);

	public boolean updateProduct(ProductEntity entity);

	public List<ProductEntity> getProductsByCategory(String category);

	public List<ProductEntity> searchProducts(String keyword);

	List<ProductEntity> getProductsBySellerId(int sellerId);

	public List<ProductEntity> getProductsByCategoryAndSeller(String category, int sellerId);

	public List<ProductEntity> searchProductsBySeller(String keyword, int sellerId);

}
