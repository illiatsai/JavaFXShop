package com.teachMeSkills.shop.dao.categoriesDao;

import com.teachMeSkills.shop.connector.ShopSqlConnection;
import com.teachMeSkills.shop.models.Category;
import com.teachMeSkills.shop.models.Good;
import javafx.scene.control.ChoiceBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDaoImpl implements ICategoriesDao {
    @Override
    public List<Category> getCategories() {
        List<Category> categoriesList = new ArrayList<>();
        try(Connection connection = ShopSqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  categories.id_category, categories.category, SUM(goods.goods_remaining) AS summ FROM goods RIGHT JOIN categories ON id_category = goods_category GROUP BY id_category");
            while (rs.next()) {
                Category category = new Category(rs.getInt("id_category"), rs.getString("category"), rs.getInt("summ"));
                categoriesList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoriesList;
    }

    @Override
    public void createCategory(Category category) {
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "INSERT INTO shop.categories VALUES (null,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.getNameCategory());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Category category) {
        try (Connection connection = ShopSqlConnection.getConnection()){
            String sql = "UPDATE  categories SET category = ? WHERE id_category = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.getNameCategory());
            statement.setInt(2, category.getIdCategory());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(Category category) {
        try (Connection connection = ShopSqlConnection. getConnection()){
            String sqlGoods = "DELETE FROM goods WHERE goods_category = ?";
            PreparedStatement statementGoods = connection.prepareStatement(sqlGoods);
            statementGoods.setInt(1, category.getIdCategory());
            statementGoods.execute();
            String sqlCategories = "DELETE FROM categories WHERE id_category = ?";
            PreparedStatement statementCategories = connection.prepareStatement(sqlCategories);
            statementCategories.setInt(1, category.getIdCategory());
            statementCategories.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getCategoryByName(String nameCategory) {
        List<Category> categoriesList = new ArrayList<>();
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "SELECT  categories.id_category, categories.category, SUM(goods.goods_remaining) AS summ FROM goods RIGHT JOIN categories ON id_category = goods_category WHERE category LIKE ? GROUP BY id_category";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nameCategory + "%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Category category = new Category(rs.getInt("id_category"), rs.getString("category"), rs.getInt("summ"));
                categoriesList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoriesList;
    }

    @Override
    public List<Category> getCategoryByAmount(ChoiceBox newOperator, String amountCategory) {
        List<Category> listOfCategoriesByAmount = new ArrayList<>();
        try(Connection connection = ShopSqlConnection.getConnection()) {
            String sql = "SELECT  categories.id_category, categories.category, SUM(goods.goods_remaining) AS summ FROM goods RIGHT JOIN categories ON id_category = goods_category GROUP BY id_category HAVING summ > ?".replace('>', newOperator.getValue().toString().charAt(0));
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, amountCategory);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Category category = new Category(rs.getInt("id_category"), rs.getString("category"), rs.getInt("summ"));
                listOfCategoriesByAmount.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCategoriesByAmount;
    }
}
/*По умолчанию каждое SQL-выражение автоматически коммитится при выполнении statement.execute и подобных методов. Для того, чтобы открыть транзакцию сначала необходимо установить флаг autoCommit у соединения в значение false. Ну а дальше нам пригодятся всем знакомые методы commit и rollback.

connection.setAutoCommit(false);

Statement st = connection.createStatement();
try {
    st.execute("insert into user(name) values('kesha')");
    connection.commit();
} catch (SQLException e)  {
    connection.rollback();
}*/