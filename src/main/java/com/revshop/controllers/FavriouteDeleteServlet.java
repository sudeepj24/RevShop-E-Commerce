package com.revshop.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.revshop.service.FavriouteProductService;
import com.revshop.service.impl.FavoriteProductsServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FavriouteDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(FavriouteDeleteServlet.class);

    private FavriouteProductService favoriteService = new FavoriteProductsServiceIMPL();

    public FavriouteDeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.debug("Entering doGet() method in FavriouteDeleteServlet");

        String favoriteIdStr = request.getParameter("favoriteId");
        logger.debug("Received parameter: favoriteId=" + favoriteIdStr);

        if (favoriteIdStr != null) {
            try {
                int favoriteId = Integer.parseInt(favoriteIdStr);
                logger.debug("Parsed favoriteId: " + favoriteId);

                boolean isDeleted = favoriteService.removeProductFromFavorites(favoriteId);
                logger.debug("Result of removeProductFromFavorites: " + isDeleted);

                if (isDeleted) {
                    logger.info("Successfully removed product from favorites with favoriteId=" + favoriteId);
                    response.sendRedirect("FavriouteServletMain");
                } else {
                    logger.error("Failed to remove product from favorites with favoriteId=" + favoriteId);
                    request.setAttribute("errorMessage", "Unable to remove the product from favorites.");
                    request.getRequestDispatcher("favorites").forward(request, response);
                }
            } catch (NumberFormatException e) {
                logger.error("Invalid favorite product ID: " + favoriteIdStr, e);
                request.setAttribute("errorMessage", "Invalid favorite product ID.");
                request.getRequestDispatcher("FavriouteServletMain").forward(request, response);
            }
        } else {
            logger.warn("No favoriteId parameter provided. Redirecting to FavriouteServletMain.");
            response.sendRedirect("FavriouteServletMain");
        }

        logger.debug("Exiting doGet() method in FavriouteDeleteServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
