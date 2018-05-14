package com.teachMeSkills.shop.dao.goodsDao;

import com.teachMeSkills.shop.connector.ShopSqlConnection;
import com.teachMeSkills.shop.models.Category;
import com.teachMeSkills.shop.models.Good;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements IGoodsDao {
    @Override
    public List<Good> listAllGoods() {
        List<Good> listGoods = new ArrayList<>();
        try (Connection connection = ShopSqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT g.id_goods, g.goods_name, g.goods_description, g.goods_price, g.goods_remaining, c.* FROM shop.goods g LEFT JOIN categories c ON g.goods_category = c.id_category;");
            while(rs.next()) {
                Good good = new Good();
                good.setIdGood(rs.getInt("id_goods"));
                good.setNameGood(rs.getString("goods_name"));
                good.setDescriptionGood(rs.getString("goods_description"));
                good.setPriceGood(rs.getDouble("goods_price"));
                good.setAmountGoodsRemaining(rs.getInt("goods_remaining"));
                good.setCategory(new Category(rs.getInt("id_category"), rs.getString("category")));
                listGoods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listGoods;
    }

    @Override
    public void createGood(Good good) {
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "INSERT INTO shop.goods VALUES (null,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, good.getNameGood());
            statement.setString(2, good.getDescriptionGood());
            statement.setInt(3, good.getCategory().getIdCategory());
            statement.setDouble(4, good.getPriceGood());
            statement.setInt(5, good.getAmountGoodsRemaining());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateGood(Good good) {
        try (Connection connection = ShopSqlConnection.getConnection()){
            String sql = "UPDATE  goods SET goods_name = ?, goods_description = ?, goods_category = ?, goods_price = ?, goods_remaining = ? WHERE id_goods = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, good.getNameGood());
            statement.setString(2, good.getDescriptionGood());
            statement.setInt(3, good.getCategory().getIdCategory());
            statement.setDouble(4, good.getPriceGood());
            statement.setInt(5, good.getAmountGoodsRemaining());
            statement.setInt(6, good.getIdGood());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGood(Good good) {
        try (Connection connection = ShopSqlConnection. getConnection()){
            String sql = "DELETE FROM goods WHERE id_goods = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, good.getIdGood());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Good> getGoodByName(String nameGood) {
        List<Good> listByNameGoods = new ArrayList<>();
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "SELECT g.id_goods, g.goods_name, g.goods_description, g.goods_price, g.goods_remaining, c.* FROM shop.goods g LEFT JOIN categories c ON g.goods_category = c.id_category WHERE g.goods_name LIKE ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nameGood + "%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Good good = new Good();
                good.setIdGood(rs.getInt("id_goods"));
                good.setNameGood(rs.getString("goods_name"));
                good.setDescriptionGood(rs.getString("goods_description"));
                good.setPriceGood(rs.getDouble("goods_price"));
                good.setAmountGoodsRemaining(rs.getInt("goods_remaining"));
                good.setCategory(new Category(rs.getInt("id_category"), rs.getString("category")));
                listByNameGoods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listByNameGoods;
    }

    @Override
    public List<Good> getGoodByPrice(String priceGood) {
        List<Good> listByPriceGoods = new ArrayList<>();
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "SELECT g.id_goods, g.goods_name, g.goods_description, g.goods_price, g.goods_remaining, c.* FROM shop.goods g LEFT JOIN categories c ON g.goods_category = c.id_category WHERE g.goods_price LIKE ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, priceGood + "%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Good good = new Good();
                good.setIdGood(rs.getInt("id_goods"));
                good.setNameGood(rs.getString("goods_name"));
                good.setDescriptionGood(rs.getString("goods_description"));
                good.setPriceGood(rs.getDouble("goods_price"));
                good.setAmountGoodsRemaining(rs.getInt("goods_remaining"));
                good.setCategory(new Category(rs.getInt("id_category"), rs.getString("category")));
                listByPriceGoods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listByPriceGoods;

    }
}
