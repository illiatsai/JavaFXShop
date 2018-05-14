package com.teachMeSkills.shop.dao.userDao;



import com.teachMeSkills.shop.models.User;

import java.util.List;

public interface IUserDao {
    boolean isUserExists(User user);
}
