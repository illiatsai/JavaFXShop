package com.teachMeSkills.shop.services;

import com.teachMeSkills.shop.dao.userDao.UserDaoImpl;
import com.teachMeSkills.shop.models.User;

public class UserService implements IUserService {
    private static UserService service = new UserService();
    private UserDaoImpl dao = new UserDaoImpl();

    private UserService() {

    }

    public static UserService getInstance() {
        return service;
    }

    @Override
    public boolean isUserExists(User user) {
        return dao.isUserExists(user);
    }
}
