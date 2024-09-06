package com.revshop.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.revshop.Entity.ReviewEntity;
import com.revshop.dao.ReviewDAO;
import com.revshop.service.ReviewService;

public class ReviewServiceIMPL implements ReviewService {

	private ReviewDAO reviewDAO;

	public ReviewServiceIMPL() {
		this.reviewDAO = new ReviewDAO();
	}

	@Override
	public boolean addReview(ReviewEntity review) {
		try {
			return reviewDAO.insert(review);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ReviewEntity> getReviewsByProductId(int productId) {
		try {
			return reviewDAO.getReviewsByProductId(productId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
