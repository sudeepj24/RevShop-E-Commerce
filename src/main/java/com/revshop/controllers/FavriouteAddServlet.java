package com.revshop.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.revshop.Entity.FavoriteProductsEntity;
import com.revshop.service.FavriouteProductService;
import com.revshop.service.impl.FavoriteProductsServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FavriouteAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(FavriouteAddServlet.class);

    public FavriouteAddServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.debug("Entering doPost() method in FavriouteAddServlet");

        try {
            // Retrieve parameters from the request
            String productIdParam = request.getParameter("productId");
            String userIdParam = request.getParameter("userId");

            logger.debug("Received parameters: productId=" + productIdParam + ", userId=" + userIdParam);

            if (productIdParam == null || userIdParam == null || productIdParam.isEmpty() || userIdParam.isEmpty()) {
                throw new IllegalArgumentException("Product ID or User ID is missing.");
            }

            // Parse the product ID and user ID
            int productId = Integer.parseInt(productIdParam);
            int userId = Integer.parseInt(userIdParam);

            logger.debug("Parsed productId: " + productId + ", userId: " + userId);

            // Create a FavoriteProductsEntity object
            FavoriteProductsEntity fav = new FavoriteProductsEntity();
            fav.setProductId(productId);
            fav.setUserId(userId);

            logger.debug("Created FavoriteProductsEntity: " + fav);

            // Service to handle adding the product to favorites
            FavriouteProductService favService = new FavoriteProductsServiceIMPL();

            // Add product to favorites
            boolean result = favService.addProductToFavorites(fav);
            logger.debug("Result of addProductToFavorites: " + result);

            if (result) {
                // Redirect to the favorites page or show success message
                response.sendRedirect("HomeServlet");
                logger.info("Product successfully added to favorites: productId=" + productId + ", userId=" + userId);
            } else {
                // Handle the case where the favorite could not be added
                logger.error("Failed to add product to favorites: productId=" + productId + ", userId=" + userId);
                request.setAttribute("error", "Unable to add the product to your favorites.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            logger.error("Invalid Product ID or User ID", e);
            request.setAttribute("error", "Invalid Product ID or User ID.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            logger.error("Error in input parameters", e);
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while adding the product to favorites.", e);
            request.setAttribute("error", "An unexpected error occurred while adding the product to favorites.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } finally {
            logger.debug("Exiting doPost() method in FavriouteAddServlet");
        }
    }
}
