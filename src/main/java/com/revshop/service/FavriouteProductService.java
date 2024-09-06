package com.revshop.service;

import java.util.List;

import com.revshop.Entity.FavoriteProductsEntity;

public interface FavriouteProductService {
	boolean addProductToFavorites(FavoriteProductsEntity favorite);
    List<FavoriteProductsEntity> getFavoritesByUserId(int userId);
    boolean removeProductFromFavorites(int favoriteId);
}
