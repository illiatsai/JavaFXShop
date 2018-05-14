package com.teachMeSkills.shop.services;

import com.teachMeSkills.shop.models.Category;
import javafx.scene.control.ChoiceBox;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(Category category);
    List<Category> listCategoriesByName(String name);
    List<Category> listCategoriesByAmount(ChoiceBox newOperator, String amount);
}
