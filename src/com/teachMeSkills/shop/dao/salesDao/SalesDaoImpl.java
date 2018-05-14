package com.teachMeSkills.shop.dao.salesDao;


import com.teachMeSkills.shop.connector.ShopSqlConnection;
import com.teachMeSkills.shop.dao.goodsDao.GoodsDaoImpl;
import com.teachMeSkills.shop.models.Category;
import com.teachMeSkills.shop.models.Good;
import com.teachMeSkills.shop.models.Sale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesDaoImpl implements ISalesDao{
    @Override
    public List<Sale> listOfSales() {
        List<Sale> salesList = new ArrayList<>();
        try(Connection connection = ShopSqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT s.*, g.* FROM shop.sales s LEFT JOIN goods g ON s.goods_saled = g.id_goods;");
            while (rs.next()) {
                Sale sale = new Sale();
                Good good = new Good();
                sale.setIdSale(rs.getInt("id_sales"));
                sale.setNameCustomer(rs.getString("name_customer"));
                sale.setTelNumberCustomer(rs.getString("tel_number_customer"));
                sale.setDateOfSale(rs.getString("date_sale"));
                sale.setAmountGoodSaled(rs.getInt("amount_goods_saled"));
                good.setIdGood(rs.getInt("id_goods"));
                good.setNameGood(rs.getString("goods_saled_name"));
                good.setAmountGoodsRemaining(rs.getInt("goods_remaining"));
                sale.setResultPrice(rs.getDouble("price_with_discont"));
                sale.setGoodSaled(good);
                salesList.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesList;
    }

    @Override
    public void addSale(Sale sale) {
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "INSERT INTO shop.sales VALUES (null,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, sale.getNameCustomer());
            statement.setString(2, sale.getTelNumberCustomer());
            statement.setInt(3, sale.getGoodSaled().getIdGood());
            statement.setString(4, sale.getGoodSaled().getNameGood());
            statement.setInt(5, sale.getAmountGoodSaled());
            statement.setString(6, sale.getDateOfSale());
            statement.setDouble(7, sale.getResultPrice());
            statement.execute();


            if(sale.getGoodSaled().getAmountGoodsRemaining() == 0) {
                String sqlDeleteGoods = "DELETE FROM shop.goods WHERE id_goods = ?";
                PreparedStatement statementDelete = connection.prepareStatement(sqlDeleteGoods);
                statementDelete.setInt(1, sale.getGoodSaled().getIdGood());
                statementDelete.execute();
            } else {
                String sqlUpdateGoods = sqlUpdateGoods = "UPDATE shop.goods SET goods_remaining = ? WHERE id_goods = ?";
                PreparedStatement statementUpdate = connection.prepareStatement(sqlUpdateGoods);
                statementUpdate.setInt(1, sale.getGoodSaled().getAmountGoodsRemaining());
                statementUpdate.setInt(2, sale.getGoodSaled().getIdGood());
                statementUpdate.execute();
            }
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Sale> listOfSalesByCustomerName(String customerName) {
        List<Sale> salesListByCustomerName = new ArrayList<>();
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "SELECT s.*, g.* FROM shop.sales s LEFT JOIN goods g ON s.goods_saled = g.id_goods having name_customer LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerName + "%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Sale sale = new Sale();
                Good good = new Good();
                sale.setIdSale(rs.getInt("id_sales"));
                sale.setNameCustomer(rs.getString("name_customer"));
                sale.setTelNumberCustomer(rs.getString("tel_number_customer"));
                sale.setDateOfSale(rs.getString("date_sale"));
                sale.setAmountGoodSaled(rs.getInt("amount_goods_saled"));
                good.setIdGood(rs.getInt("id_goods"));
                good.setNameGood(rs.getString("goods_saled_name"));
                good.setAmountGoodsRemaining(rs.getInt("goods_remaining"));
                sale.setResultPrice(rs.getDouble("price_with_discont"));
                sale.setGoodSaled(good);
                salesListByCustomerName.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesListByCustomerName;
    }

    @Override
    public List<Sale> listOfSalesByGoodName(String goodName) {
        List<Sale> salesListByGoodName = new ArrayList<>();
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "SELECT s.*, g.* FROM shop.sales s LEFT JOIN goods g ON s.goods_saled = g.id_goods having goods_saled_name LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, goodName + "%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Sale sale = new Sale();
                Good good = new Good();
                sale.setIdSale(rs.getInt("id_sales"));
                sale.setNameCustomer(rs.getString("name_customer"));
                sale.setTelNumberCustomer(rs.getString("tel_number_customer"));
                sale.setDateOfSale(rs.getString("date_sale"));
                sale.setAmountGoodSaled(rs.getInt("amount_goods_saled"));
                good.setIdGood(rs.getInt("id_goods"));
                good.setNameGood(rs.getString("goods_saled_name"));
                good.setAmountGoodsRemaining(rs.getInt("goods_remaining"));
                sale.setResultPrice(rs.getDouble("price_with_discont"));
                sale.setGoodSaled(good);
                salesListByGoodName.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesListByGoodName;
    }

    @Override
    public List<Sale> listOfSalesByGoodPrice(String goodPrice) {
        List<Sale> salesListByGoodAmount = new ArrayList<>();
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "SELECT s.*, g.* FROM shop.sales s LEFT JOIN goods g ON s.goods_saled = g.id_goods having price_with_discont LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, goodPrice + "%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Sale sale = new Sale();
                Good good = new Good();
                sale.setIdSale(rs.getInt("id_sales"));
                sale.setNameCustomer(rs.getString("name_customer"));
                sale.setTelNumberCustomer(rs.getString("tel_number_customer"));
                sale.setDateOfSale(rs.getString("date_sale"));
                sale.setAmountGoodSaled(rs.getInt("amount_goods_saled"));
                good.setIdGood(rs.getInt("id_goods"));
                good.setNameGood(rs.getString("goods_saled_name"));
                good.setAmountGoodsRemaining(rs.getInt("goods_remaining"));
                sale.setResultPrice(rs.getDouble("price_with_discont"));
                sale.setGoodSaled(good);
                salesListByGoodAmount.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesListByGoodAmount;
    }
}
