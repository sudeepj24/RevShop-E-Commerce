package com.revshop.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.revshop.Entity.FavoriteProductsEntity;
import com.revshop.Entity.ProductEntity;
import com.revshop.dao.FavriouteDAO;
import com.revshop.service.FavriouteProductService;
import com.revshop.service.ProductService;

public class FavoriteProductsServiceIMPL implements FavriouteProductService {
    private static final Logger logger = Logger.getLogger(FavoriteProductsServiceIMPL.class);

    private FavriouteDAO fdao = new FavriouteDAO();
    private ProductService productService = new ProductServiceIMPL();

    @Override
    public boolean addProductToFavorites(FavoriteProductsEntity favorite) {
        logger.debug("Entering addProductToFavorites() method with favorite: " + favorite);
        
        try {
            ProductEntity product = productService.getProductById(favorite.getProductId());

            logger.debug("Product retrieved: " + product);

            favorite.setImgUrl(product.getProductImage());
            favorite.setProductDiscount(product.getProductDiscount());
            favorite.setProductName(product.getProductName());
            favorite.setProductPrice(product.getProductPrice());

            boolean result = fdao.insert(favorite);
            logger.debug("Exiting addProductToFavorites() method with result: " + result);
            return result;
        } catch (Exception e) {
            logger.error("Exception in addProductToFavorites() method", e);
            return false;
        }
    }

    @Override
    public List<FavoriteProductsEntity> getFavoritesByUserId(int userId) {
        logger.debug("Entering getFavoritesByUserId() method with userId: " + userId);
        List<FavoriteProductsEntity> favorites = fdao.getFavoritesByUserId(userId);
        logger.debug("Exiting getFavoritesByUserId() method with result: " + favorites);
        return favorites;
    }

    @Override
    public boolean removeProductFromFavorites(int favoriteId) {
        logger.debug("Entering removeProductFromFavorites() method with favoriteId: " + favoriteId);
        boolean result = fdao.delete(favoriteId);
        logger.debug("Exiting removeProductFromFavorites() method with result: " + result);
        return result;
    }
}
