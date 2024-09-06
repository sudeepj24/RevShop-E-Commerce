package com.revshop.service;

import java.util.List;

import com.revshop.Entity.ReviewEntity;

public interface ReviewService {

	boolean addReview(ReviewEntity review);

	List<ReviewEntity> getReviewsByProductId(int productId);
}
