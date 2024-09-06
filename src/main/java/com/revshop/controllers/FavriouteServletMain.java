package com.revshop.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revshop.Entity.FavoriteProductsEntity;
import com.revshop.Entity.LoginEntity;
import com.revshop.service.FavriouteProductService;
import com.revshop.service.impl.FavoriteProductsServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FavriouteServletMain extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(FavriouteServletMain.class);

    private FavriouteProductService favoriteService = new FavoriteProductsServiceIMPL();

    public FavriouteServletMain() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Entering doGet() method in FavriouteServletMain");

        HttpSession session = request.getSession();
        LoginEntity user = (LoginEntity) session.getAttribute("user");

        logger.debug("User retrieved from session: " + user);

        if (user != null) {
            List<FavoriteProductsEntity> favoriteItems = favoriteService.getFavoritesByUserId(user.getUserId());
            logger.debug("Favorite items retrieved: " + favoriteItems);
            request.setAttribute("favoriteItems", favoriteItems);
            request.getRequestDispatcher("favourite.jsp").forward(request, response);
        }

        response.sendRedirect("LoginAndRegistration/user-login.jsp");
        logger.debug("Exiting doGet() method in FavriouteServletMain");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
