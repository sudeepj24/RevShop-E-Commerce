package com.revshop.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revshop.service.ProductService;
import com.revshop.service.impl.ProductServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDeleteServlet
 */
public class ProductDeleteServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ProductDeleteServlet.class);
	private static final long serialVersionUID = 1L;
	private ProductService productService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDeleteServlet() {
		super();
		this.productService = new ProductServiceIMPL();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productIdStr = request.getParameter("productId");

		try {
			int productId = Integer.parseInt(productIdStr);
			ProductService productService = new ProductServiceIMPL();

			boolean isDeleted = productService.deleteProduct(productId);

			if (isDeleted) {
				response.setStatus(HttpServletResponse.SC_OK); // 200 OK
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500 Internal Server Error
			}
		} catch (NumberFormatException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500 Internal Server Error
		}
	}

}
