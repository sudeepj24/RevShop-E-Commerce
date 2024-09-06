package com.revshop.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.revshop.Entity.ProductEntity;
import com.revshop.service.ProductService;
import com.revshop.service.impl.ProductServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProductUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductUpdateServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceIMPL();

        int productId = Integer.parseInt(request.getParameter("product_id"));
        String productName = request.getParameter("product_name");
        String productDescription = request.getParameter("product_description");
        double productPrice = Double.parseDouble(request.getParameter("product_price"));
        double productDiscount = Double.parseDouble(request.getParameter("product_discount"));
        int productStock = Integer.parseInt(request.getParameter("product_stock"));
        String productBrand = request.getParameter("product_brand");
        String productCategory = request.getParameter("product_category");
        String productTags = request.getParameter("product_tags");
        String productStatus = request.getParameter("product_status");

        // Create a ProductEntity object and set its properties
        ProductEntity product = new ProductEntity();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);
        product.setProductDiscount(productDiscount);
        product.setProductStock(productStock);
        product.setProductBrand(productBrand);
        product.setProductCategory(productCategory);
        product.setProductTags(productTags);
        product.setProductStatus(productStatus);

        // Handle file upload for product image
        Part filePart = request.getPart("product_image");
        String uploadDirectory = "C:\\Users\\Maddy\\git\\RevShop\\RevShopRevature\\src\\main\\webapp\\Static\\img\\home\\";
        String imagePath;

        if (filePart != null && filePart.getSize() > 0) {
            // Get the file name from the Part object
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // Create a path for the file
            Path filePath = Paths.get(uploadDirectory + fileName);

            // Save the file to the specified directory
            Files.copy(filePart.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Store the file path in the database
            imagePath = "Static/img/home/" + fileName;
            product.setProductImage(imagePath); // Update the image path if a new image is provided
        } else {
            // Keep the existing image path if no new image is provided
            ProductEntity existingProduct = productService.getProductById(productId);
            product.setProductImage(existingProduct.getProductImage());
        }

        // Update the product in the database
        boolean isUpdated = productService.updateProduct(product);

        if (isUpdated) {
            response.sendRedirect("ProductMaintenanceServlet");
        } else {
            response.sendRedirect("product-edit.jsp?updateSuccess=false");
        }
    }
}
