package com.revshop.service;

import java.util.List;

import com.revshop.Entity.CartEntity;
import com.revshop.Entity.ProductEntity;

public interface CartService {

	boolean addToCart(CartEntity cartItem);

	List<CartEntity> getCart(int userId);

	boolean updateQuantity(CartEntity cart, String action);

	public void removeProductFromCart(int userId, int productId);

}
