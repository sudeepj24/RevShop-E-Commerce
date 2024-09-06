package com.revshop.service;

import com.revshop.Entity.LoginEntity;

public interface LoginService {
	
	public boolean saveLogin(LoginEntity login);
	public boolean emailExists(String email);
	public boolean usernameExists(String username);
	public boolean validate(String email, String password);
	LoginEntity findByEmail(String email);
	boolean updateFirstLoginFlag(String email);

}
