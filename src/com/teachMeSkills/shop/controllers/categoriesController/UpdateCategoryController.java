package com.teachMeSkills.shop.controllers.categoriesController;

import com.teachMeSkills.shop.models.Category;
import com.teachMeSkills.shop.services.CategoryService;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class UpdateCategoryController {
    private CategoryService categoryService = CategoryService.getInstance();
    private Category category = CategoriesController.updateCategory;

    public TextField nameCategory;

    public void initialize() {
        nameCategory.setText(category.getNameCategory());
    }

    public void updateCategory(ActionEvent actionEvent) {
        try{
            category.setNameCategory(nameCategory.getText());
            categoryService.updateCategory(category);
            CategoriesController.updateStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
