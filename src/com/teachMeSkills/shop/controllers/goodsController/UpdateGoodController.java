package com.teachMeSkills.shop.controllers.goodsController;

import com.teachMeSkills.shop.controllers.GeneralController;
import com.teachMeSkills.shop.models.Category;
import com.teachMeSkills.shop.models.Good;
import com.teachMeSkills.shop.services.CategoryService;
import com.teachMeSkills.shop.services.GoodService;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UpdateGoodController {
    private GoodService goodService = GoodService.getInstance();
    private CategoryService categoryService = CategoryService.getInstance();
    private Good good = GoodsController.updateGood;

    public TextField nameGood;
    public TextField descriptionGood;
    public TextField priceGood;
    public TextField amountGoodsRemaining;
    public ComboBox<Category> category;

    public void initialize() {
        category.getItems().addAll(categoryService.getAllCategories());
        nameGood.setText(good.getNameGood());
        descriptionGood.setText(good.getDescriptionGood());
        priceGood.setText(String.valueOf(good.getPriceGood()));
        amountGoodsRemaining.setText(String.valueOf(good.getAmountGoodsRemaining()));
        category.setValue(good.getCategory());
    }

    public void update(ActionEvent actionEvent) {
        try{
            good.setNameGood(nameGood.getText().trim());
            good.setDescriptionGood(descriptionGood.getText().trim());
            good.setPriceGood(Double.parseDouble(priceGood.getText().trim()));
            good.setAmountGoodsRemaining(Integer.parseInt(amountGoodsRemaining.getText().trim()));
            good.setCategory(category.getValue());
            goodService.updateGood(good);
            GoodsController.updateStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
