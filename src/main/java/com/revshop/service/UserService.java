package com.revshop.service;

import com.revshop.Entity.UserEntity;

public interface UserService {
	boolean updateUserDetails(UserEntity user);
	 public UserEntity getUserById(int userId);
}
