package com.revshop.service.impl;

import com.revshop.Entity.LoginEntity;
import com.revshop.dao.LoginDAO;
import com.revshop.service.LoginService;
import com.revshop.utility.BCryptPasswordUtil;

public class LoginServiceIMPL implements LoginService {

    private final LoginDAO logindao = LoginDAO.getInstance();
    
    private static LoginServiceIMPL instance;
    
    private LoginServiceIMPL(){};
    
    public static LoginServiceIMPL getInstance() {
        if (instance == null) { // First check
            synchronized (LoginServiceIMPL.class) { // Lock class object
                if (instance == null) { // Second check
                    instance = new LoginServiceIMPL(); // Create instance
                }
            }
        }
        return instance;
    }

    @Override
    public boolean saveLogin(LoginEntity login) {
        try {
            return logindao.insert(login);
        } catch (Exception e) {
            System.err.println("Error saving login details: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean emailExists(String email) {
        try {
            return logindao.findByEmail(email) != null;
        } catch (Exception e) {
            System.err.println("Error checking if email exists: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean usernameExists(String username) {
        try {
            return logindao.findByUsername(username) != null;
        } catch (Exception e) {
            System.err.println("Error checking if username exists: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean validate(String email, String password) {
        try {
            LoginEntity loginDetails = logindao.findByEmail(email);
            if (loginDetails == null) {
                return false; // Username does not exist
            }

            String storedHashedPassword = loginDetails.getPassword();
            return BCryptPasswordUtil.checkPassword(password, storedHashedPassword);

        } catch (Exception e) {
            System.err.println("Error validating user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public LoginEntity findByEmail(String email) {
        try {
            return logindao.findByEmail(email);
        } catch (Exception e) {
            System.err.println("Error finding user by email: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public boolean updateFirstLoginFlag(String email) {
		LoginEntity user = findByEmail(email);
		user.setFirstLogin(false);
		return logindao.update(user);
	}
}
