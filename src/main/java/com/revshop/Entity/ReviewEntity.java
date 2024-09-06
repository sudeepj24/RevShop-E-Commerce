package com.revshop.Entity;

import java.util.Date;

public class ReviewEntity implements Entity {

    private int reviewId;
    private String review;
    private int stars;
    private int productId;
    private int userId;
    private String customerName;
    private String customerEmail;
    private Date reviewDate;

    public ReviewEntity() {
        super();
    }

    public ReviewEntity(int reviewId, String review, int stars, int productId, int userId, String customerName, String customerEmail, Date reviewDate) {
        this.reviewId = reviewId;
        this.review = review;
        this.stars = stars;
        this.productId = productId;
        this.userId = userId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.reviewDate = reviewDate;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "ReviewEntity [reviewId=" + reviewId + ", review=" + review + ", stars=" + stars + ", productId="
                + productId + ", userId=" + userId + ", customerName=" + customerName + ", customerEmail=" + customerEmail + ", reviewDate=" + reviewDate + "]";
    }
}
