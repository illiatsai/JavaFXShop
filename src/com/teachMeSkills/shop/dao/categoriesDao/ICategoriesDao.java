package com.teachMeSkills.shop.dao.categoriesDao;

import com.teachMeSkills.shop.models.Category;
import javafx.scene.control.ChoiceBox;

import java.util.List;

public interface ICategoriesDao {
    List<Category> getCategories();
    void createCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(Category category);
    List<Category> getCategoryByName(String nameCategory);
    List<Category> getCategoryByAmount(ChoiceBox newOperator, String amountCategory);
}
