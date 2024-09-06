package com.revshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.revshop.Entity.Entity;
import com.revshop.Entity.ProductEntity;
import com.revshop.dao.ProductDAO;
import com.revshop.service.ProductService;

public class ProductServiceIMPL implements ProductService {

	private ProductDAO pdao = ProductDAO.getInstance();

	@Override
	public boolean saveProduct(ProductEntity entity) {
		return pdao.insert(entity);
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		List<Entity> entities = pdao.retrieveAll();
		List<ProductEntity> products = new ArrayList<>();

		for (Entity entity : entities) {
			if (entity instanceof ProductEntity) {
				products.add((ProductEntity) entity);
			}
		}

		return products;
	}

	@Override
	public boolean deleteProduct(int id) {
		// Use the ProductDAO instance to delete the product by ID
		ProductDAO productDAO = ProductDAO.getInstance();
		return productDAO.delete(id);
	}

	@Override
	public ProductEntity getProductById(int id) {
		// Use the ProductDAO instance to retrieve the product by ID
		Entity entity = pdao.retrieveById(id);

		// Check if the retrieved entity is an instance of ProductEntity
		if (entity instanceof ProductEntity) {
			return (ProductEntity) entity;
		} else {
			return null; // Return null if the entity is not a ProductEntity
		}
	}
	
	@Override
	public boolean updateProduct(ProductEntity entity) {
	    return pdao.update(entity);
	}


	@Override
	public List<ProductEntity> getProductsByCategory(String category) {
	    List<Entity> entities = pdao.retrieveByCategory(category);
	    List<ProductEntity> products = new ArrayList<>();

	    for (Entity entity : entities) {
	        if (entity instanceof ProductEntity) {
	            products.add((ProductEntity) entity);
	        }
	    }

	    return products;
	}
	
	@Override
	public List<ProductEntity> searchProducts(String keyword) {
	    List<Entity> entities = pdao.searchProducts(keyword);
	    List<ProductEntity> products = new ArrayList<>();

	    for (Entity entity : entities) {
	        if (entity instanceof ProductEntity) {
	            products.add((ProductEntity) entity);
	        }
	    }

	    return products;
	}
	
	@Override
	public List<ProductEntity> getProductsBySellerId(int sellerId) {
	    List<Entity> entities = pdao.retrieveBySellerId(sellerId);
	    List<ProductEntity> products = new ArrayList<>();

	    for (Entity entity : entities) {
	        if (entity instanceof ProductEntity) {
	            products.add((ProductEntity) entity);
	        }
	    }

	    return products;
	}
	
	@Override
	public List<ProductEntity> getProductsByCategoryAndSeller(String category, int sellerId) {
	    List<Entity> entities = pdao.retrieveByCategoryAndSeller(category, sellerId);
	    List<ProductEntity> products = new ArrayList<>();

	    for (Entity entity : entities) {
	        if (entity instanceof ProductEntity) {
	            products.add((ProductEntity) entity);
	        }
	    }

	    return products;
	}

	@Override
	public List<ProductEntity> searchProductsBySeller(String keyword, int sellerId) {
	    List<Entity> entities = pdao.searchProductsBySeller(keyword, sellerId);
	    List<ProductEntity> products = new ArrayList<>();

	    for (Entity entity : entities) {
	        if (entity instanceof ProductEntity) {
	            products.add((ProductEntity) entity);
	        }
	    }

	    return products;
	}




}
