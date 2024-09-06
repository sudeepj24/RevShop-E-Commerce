package com.revshop.service.impl;

import com.revshop.Entity.Entity;
import com.revshop.Entity.UserEntity;
import com.revshop.dao.UserDAO;
import com.revshop.service.UserService;

public class UserServiceIMPL implements UserService {

    private UserDAO userDAO;

    public UserServiceIMPL() {
        this.userDAO = UserDAO.getInstance();
    }

    @Override
    public boolean updateUserDetails(UserEntity user) {
        return userDAO.update((Entity) user);
    }
    
    @Override
    public UserEntity getUserById(int userId) {
        return (UserEntity) userDAO.retrieveById(userId);
    }
}
