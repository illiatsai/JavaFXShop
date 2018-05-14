package com.teachMeSkills.shop.controllers.categoriesController;

import com.teachMeSkills.shop.models.Category;
import com.teachMeSkills.shop.services.CategoryService;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesController {
    public CategoryService categoryService = CategoryService.getInstance();

    public static Stage createStage;
    public static Stage updateStage;
    public static Category updateCategory;

    public void initTableCategories(TableColumn name, TableColumn amountRemainingForCategory, TableView categories){
        name.setCellValueFactory(new PropertyValueFactory<>("nameCategory"));
        amountRemainingForCategory.setCellValueFactory(new PropertyValueFactory<>("amountRemainingForCategory"));
        categories.getItems().clear();
        categories.getItems().addAll(categoryService.getAllCategories());

    }


    public void showCategoryNames(String nameCategory, TableView categories){
        //goods.setItems(FXCollections.observableList(goodService.getAllGoods()));
        categories.getItems().clear();
        categories.getItems().addAll(categoryService.listCategoriesByName(nameCategory));
    }

    public void showCategoryAmounts(ChoiceBox newOperator, String amount, TableView categories){
        //goods.setItems(FXCollections.observableList(goodService.getAllGoods()));
        categories.getItems().clear();
        categories.getItems().addAll(categoryService.listCategoriesByAmount(newOperator, amount));
    }

    public void searchByName(KeyEvent keyEvent, TextField searchCategoryName, TableView categories) {
        String nameCategory = searchCategoryName.getText();
        if(nameCategory.length() == 0){
            categories.getItems().clear();
            categories.getItems().addAll(categoryService.getAllCategories());
        }else{
            showCategoryNames(nameCategory, categories);
        }
    }

    public void searchByAmount(KeyEvent keyEvent, ChoiceBox newOperator, TextField searchCategoryAmount, TableView categories) {
        String amountCategory = searchCategoryAmount.getText();
        if(amountCategory.length() == 0){
            categories.getItems().clear();
            categories.getItems().addAll(categoryService.getAllCategories());
        }else{
            showCategoryAmounts(newOperator, amountCategory, categories);
        }
    }

    public void addCategory(ActionEvent actionEvent, TableView<Category> categories) {
        try {
            createStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../../views/createCategory.fxml"));
            Scene scene = new Scene(root, 358, 413);
            createStage.setScene(scene);
            createStage.setTitle("Добавление категории");
            createStage.show();
            createStage.setOnHiding(event1 -> {
                categories.getItems().clear();
                categories.getItems().addAll(categoryService.getAllCategories());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editCategory(ActionEvent actionEvent, ChoiceBox newOperator, TableView<Category> categories, TextField searchCategoryName, TextField searchCategoryAmount) {
        updateCategory = categories.getSelectionModel().getSelectedItem();
        if(updateCategory != null){
            try {
                updateStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../../views/updateCategory.fxml"));
                Scene scene = new Scene(root, 358, 413);
                updateStage.setScene(scene);
                updateStage.setTitle("Редактирование категорию");
                updateStage.show();
                updateStage.setOnHiding(event1 -> {
                    categories.getItems().clear();
                    categories.getItems().addAll(categoryService.getAllCategories());
                    String nameCategory = searchCategoryName.getText();
                    String amountCategory = searchCategoryAmount.getText();
                    if(nameCategory.length() == 0 && amountCategory.length() == 0){
                        categories.getItems().clear();
                        categories.getItems().addAll(categoryService.getAllCategories());
                    }else if (nameCategory.length() != 0 && amountCategory.length() == 0){
                        showCategoryNames(nameCategory, categories);
                    } else if (nameCategory.length() == 0 && amountCategory.length() != 0) {
                        showCategoryAmounts(newOperator, amountCategory, categories);
                    } else {
                        showCategoryNames(nameCategory, categories);
                        showCategoryAmounts(newOperator, amountCategory, categories);    //тут оно выберет из всех, а не из отфильтрованых по имени ИСПРАВИТЬ
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteCategory(ActionEvent actionEvent, TableView<Category> categories) {
        Category category = categories.getSelectionModel().getSelectedItem();
        if(category != null){
            categoryService.deleteCategory(category);
        }
        categories.getItems().clear();
        categories.getItems().addAll(categoryService.getAllCategories());
    }

    public void refreshCategories(Event event, TableView categories) {
        categories.getItems().clear();
        categories.getItems().addAll(categoryService.getAllCategories());
    }
}
