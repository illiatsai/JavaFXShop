package com.teachMeSkills.shop.dao.userDao;

import com.teachMeSkills.shop.connector.ShopSqlConnection;
import com.teachMeSkills.shop.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public boolean isUserExists(User user) {
        int countOfUserFitting = 0;
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = ("SELECT * FROM shop.users WHERE login = ? AND password = ?");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.incriptPassword(user.getPassword()));
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                countOfUserFitting++;
                user.setId(rs.getInt("id_user"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countOfUserFitting == 1 ? true : false;
    }
}
