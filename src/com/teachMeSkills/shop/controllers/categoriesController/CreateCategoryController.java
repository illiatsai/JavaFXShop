package com.teachMeSkills.shop.controllers.categoriesController;

import com.teachMeSkills.shop.controllers.goodsController.GoodsController;
import com.teachMeSkills.shop.models.Category;
import com.teachMeSkills.shop.models.Good;
import com.teachMeSkills.shop.services.CategoryService;
import com.teachMeSkills.shop.services.GoodService;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateCategoryController {
    public Label label;
    private CategoryService categoryService = CategoryService.getInstance();

    public TextField nameCategory;

    public void createCategory(ActionEvent actionEvent) {
        try{
            Category category = new Category();
            if(!nameCategory.getText().trim().equals("")){
                category.setNameCategory(nameCategory.getText().trim());
            } else {
                label.setText("Введите название категории.");
                return;
            }
            categoryService.createCategory(category);
            CategoriesController.createStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
