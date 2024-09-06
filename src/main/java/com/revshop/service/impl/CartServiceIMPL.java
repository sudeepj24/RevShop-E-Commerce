package com.revshop.service.impl;

import java.util.List;

import com.revshop.Entity.CartEntity;
import com.revshop.Entity.ProductEntity;
import com.revshop.dao.CartDAO;
import com.revshop.service.CartService;
import com.revshop.service.ProductService;

public class CartServiceIMPL implements CartService {

	private CartDAO cartDAO;

	private ProductService productService;

	public CartServiceIMPL() {
		this.cartDAO = new CartDAO(); // Initialize the DAO
		this.productService = new ProductServiceIMPL();
	}

	@Override
	public boolean addToCart(CartEntity cartItem) {
		ProductEntity product = productService.getProductById(cartItem.getProductId());

		cartItem.setImgUrl(product.getProductImage());
		cartItem.setProductDiscount(product.getProductDiscount());
		cartItem.setProductName(product.getProductName());
		cartItem.setProductPrice(product.getProductPrice());
		int totalPrice = (int) (product.getProductPrice() * (1 - product.getProductDiscount() / 100.0));
		cartItem.setTotalPrice(totalPrice);
		cartItem.setQuantity(1);

		return cartDAO.insert(cartItem);
	}

	@Override
	public List<CartEntity> getCart(int userId) {
		List<CartEntity> userCart = cartDAO.getCartByUserId(userId);
		return userCart;
	}

	@Override
	public boolean updateQuantity(CartEntity cart, String action) {
		boolean update = cartDAO.update(cart, action);
		return update;
	}

	@Override
	public void removeProductFromCart(int userId, int productId) {
		cartDAO.deleteProductFromCart(userId, productId);
	}

}
