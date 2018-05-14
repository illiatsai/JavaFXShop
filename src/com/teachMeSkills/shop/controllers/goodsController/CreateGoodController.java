package com.teachMeSkills.shop.controllers.goodsController;

import com.teachMeSkills.shop.controllers.GeneralController;
import com.teachMeSkills.shop.models.Category;
import com.teachMeSkills.shop.models.Good;
import com.teachMeSkills.shop.services.CategoryService;
import com.teachMeSkills.shop.services.GoodService;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreateGoodController {
    private GoodService goodService = GoodService.getInstance();
    private CategoryService categoryService = CategoryService.getInstance();

    public TextField nameGood;
    public TextField descriptionGood;
    public TextField priceGood;
    public TextField amountGoodsRemaining;
    public ComboBox<Category> category;

    public void initialize(){
        category.getItems().addAll(categoryService.getAllCategories());
    }

    public void create(ActionEvent actionEvent) {
        try{
            Good good = new Good();
            good.setNameGood(nameGood.getText().trim());
            good.setDescriptionGood(descriptionGood.getText().trim());
            good.setPriceGood(Double.parseDouble(priceGood.getText().trim()));
            good.setAmountGoodsRemaining(Integer.parseInt(amountGoodsRemaining.getText().trim()));
            good.setCategory(category.getValue());
            goodService.createGood(good);
            GoodsController.createStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
