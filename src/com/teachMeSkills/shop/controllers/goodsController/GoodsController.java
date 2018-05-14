package com.teachMeSkills.shop.controllers.goodsController;

import com.teachMeSkills.shop.models.Good;
import com.teachMeSkills.shop.services.GoodService;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class GoodsController {

    public GoodService goodService = GoodService.getInstance();

    public static Stage createStage;
    public static Stage updateStage;
    public static Good updateGood;

    public void initTableGoods(TableColumn name, TableColumn description, TableColumn price, TableColumn amount, TableView goods){
        name.setCellValueFactory(new PropertyValueFactory<>("nameGood"));
        description.setCellValueFactory(new PropertyValueFactory<>("descriptionGood"));
        price.setCellValueFactory(new PropertyValueFactory<>("priceGood"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amountGoodsRemaining"));
        goods.getItems().clear();
        goods.getItems().addAll(goodService.getAllGoods());
    }

    public void showNames(String nameGood, TableView goods){
        //goods.setItems(FXCollections.observableList(goodService.getAllGoods()));
        goods.getItems().clear();
        goods.getItems().addAll(goodService.getGoodByName(nameGood));
    }

    public void showPrices(String price, TableView goods){
        //goods.setItems(FXCollections.observableList(goodService.getAllGoods()));
        goods.getItems().clear();
        goods.getItems().addAll(goodService.getGoodByPrice(price));
    }

    public void searchByName(KeyEvent keyEvent, TextField searchName, TableView goods) {
        String nameGood = searchName.getText();
        if(nameGood.length() == 0){
            goods.getItems().clear();
            goods.getItems().addAll(goodService.getAllGoods());
        }else{
            showNames(nameGood, goods);
        }
    }

    public void searchByPrice(KeyEvent keyEvent, TextField searchPrice, TableView goods) {
        String priceGood = searchPrice.getText();
        if(priceGood.length() == 0){
            goods.getItems().clear();
            goods.getItems().addAll(goodService.getAllGoods());
        }else{
            showPrices(priceGood, goods);
        }
    }

    public void add(ActionEvent actionEvent, TableView<Good> goods) {
        try {
            createStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../../views/createGood.fxml"));
            Scene scene = new Scene(root, 358, 413);
            createStage.setScene(scene);
            createStage.setTitle("Добавить");
            createStage.show();
            createStage.setOnHiding(event1 -> {
                goods.getItems().clear();
                goods.getItems().addAll(goodService.getAllGoods());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void edit(ActionEvent actionEvent, TableView<Good> goods, TextField searchName, TextField searchPrice) {
        updateGood = goods.getSelectionModel().getSelectedItem();
        if(updateGood != null){
            try {
                updateStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../../views/updateGood.fxml"));
                Scene scene = new Scene(root, 358, 413);
                updateStage.setScene(scene);
                updateStage.setTitle("Редактировать");
                updateStage.show();
                updateStage.setOnHiding(event1 -> {
                    goods.getItems().clear();
                    goods.getItems().addAll(goodService.getAllGoods());
                    String nameGood = searchName.getText();
                    String priceGood = searchPrice.getText();
                    if(nameGood.length() == 0 && priceGood.length() == 0){
                        goods.getItems().clear();
                        goods.getItems().addAll(goodService.getAllGoods());
                    }else if (nameGood.length() != 0 && priceGood.length() == 0){
                        showNames(nameGood, goods);
                    } else if (nameGood.length() == 0 && priceGood.length() != 0) {
                        showPrices(priceGood, goods);
                    } else {
                        showNames(nameGood, goods);
                        showPrices(priceGood, goods);    //тут оно выберет из всех, а не из отфильтрованых по имени ИСПРАВИТЬ
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(ActionEvent actionEvent, TableView<Good> goods) {
        Good good = goods.getSelectionModel().getSelectedItem();
        if(good != null){
            goodService.deleteGood(good);
        }
        goods.getItems().clear();
        goods.getItems().addAll(goodService.getAllGoods());
    }

    public void refreshGoods(Event event, TableView goods) {
        goods.getItems().clear();
        goods.getItems().addAll(goodService.getAllGoods());
    }
}
