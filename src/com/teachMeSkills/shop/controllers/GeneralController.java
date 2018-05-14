package com.teachMeSkills.shop.controllers;

import com.teachMeSkills.shop.controllers.categoriesController.CategoriesController;
import com.teachMeSkills.shop.controllers.goodsController.GoodsController;
import com.teachMeSkills.shop.controllers.salesController.SalesController;
import com.teachMeSkills.shop.models.Good;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;


public class GeneralController {

    public GoodsController goodsController = new GoodsController();
    public CategoriesController categoriesController = new CategoriesController();
    public SalesController salesController = new SalesController();
    
    //Goods fields
    public TextField searchName;
    public TextField searchPrice;
    public TableView<Good> goods;
    public TableColumn<Good, String> nameColumn;
    public TableColumn<Good, String> descriptionColumn;
    public TableColumn<Good, Double> priceColumn;
    public TableColumn<Good, Integer> amountRemaining;
    
    //Categories fields
    public TextField searchCategoryName;
    public TextField searchCategoryAmount;
    public TableView categories;
    public TableColumn nameCategory;
    public TableColumn amountRemainingForCategory;

    public ChoiceBox newOperator;

    //Sales fields
    public TextField searchCustomerName;
    public TextField searchNameSaledGood;
    public TextField searchPriceSaledGood;
    public TableView sales;
    public TableColumn nameCustomer;
    public TableColumn telNumber;
    public TableColumn nameSaledGood;
    public TableColumn amountSaledGood;
    public TableColumn resultPrice;
    public TableColumn dateOfSale;

    //Goods methods
    public void initialize(){
        initTableGoods();
        initTableCategories();
        initTableSales();
        newOperator.getItems().addAll(">", "<", "=");
        newOperator.getSelectionModel().selectFirst();
    }

    private void initTableGoods(){
        goodsController.initTableGoods(nameColumn, descriptionColumn, priceColumn, amountRemaining, goods);
    }

    public void add(ActionEvent actionEvent) {
        goodsController.add(actionEvent, goods);
    }

    public void edit(ActionEvent actionEvent) {
        goodsController.edit(actionEvent, goods, searchName, searchPrice);
    }

    public void delete(ActionEvent actionEvent) {
        goodsController.delete(actionEvent, goods);
    }

    public void searchByName(KeyEvent keyEvent) {
        searchPrice.clear();   //поправить
        goodsController.searchByName(keyEvent, searchName, goods);
    }

    public void searchByPrice(KeyEvent keyEvent) {
        searchName.clear();   //поправить
        goodsController.searchByPrice(keyEvent, searchPrice, goods);
    }

    public void refreshGoods(Event event) {
        goodsController.refreshGoods(event, goods);
    }


    //Categories methods

    private void initTableCategories(){
        categoriesController.initTableCategories(nameCategory, amountRemainingForCategory, categories);
    }

    public void addCategory(ActionEvent actionEvent) {
        categoriesController.addCategory(actionEvent, categories);
    }

    public void editCategory(ActionEvent actionEvent) {
        categoriesController.editCategory(actionEvent, newOperator, categories, searchCategoryName, searchCategoryAmount);
    }

    public void deleteCategory(ActionEvent actionEvent) {
        categoriesController.deleteCategory(actionEvent, categories);
    }

    public void searchByCategoryName(KeyEvent keyEvent) {
        searchCategoryAmount.clear();   //поправить
        categoriesController.searchByName(keyEvent, searchCategoryName, categories);
    }

    public void searchByCategoryAmount(KeyEvent keyEvent) {
        searchCategoryName.clear();   //поправить
        categoriesController.searchByAmount(keyEvent, newOperator, searchCategoryAmount, categories);
    }

    public void refreshCategories(Event event) {
        categoriesController.refreshCategories(event, categories);
    }

    public void refreshAfterChoice(InputMethodEvent inputMethodEvent) {
        categoriesController.refreshCategories(inputMethodEvent, categories);
    }

    //Sales methods

    private void initTableSales(){
        salesController.initTableSales(nameCustomer, telNumber, nameSaledGood, amountSaledGood, resultPrice, dateOfSale, sales);
    }

    public void searchByCustomerName(KeyEvent keyEvent) {
        searchNameSaledGood.clear();   //поправить
        searchPriceSaledGood.clear();   //поправить
        salesController.searchByCustomerName(keyEvent, searchCustomerName, sales);
    }

    public void searchByNameSaledGood(KeyEvent keyEvent) {
        searchCustomerName.clear();   //поправить
        searchPriceSaledGood.clear();   //поправить
        salesController.searchByGoodName(keyEvent, searchNameSaledGood, sales);
    }

    public void searchByPriceSaledGood(KeyEvent keyEvent) {
        searchCustomerName.clear();   //поправить
        searchNameSaledGood.clear();   //поправить
        salesController.searchByGoodPrice(keyEvent, searchPriceSaledGood, sales);
    }

    public void addSale(ActionEvent actionEvent) {
        salesController.addSale(actionEvent, sales);
    }

    public void makeReport(ActionEvent actionEvent) {
        salesController.makeReport(actionEvent, sales);
    }
}

