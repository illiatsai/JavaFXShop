package com.teachMeSkills.shop.controllers.salesController;

import com.teachMeSkills.shop.models.Good;
import com.teachMeSkills.shop.models.Sale;
import com.teachMeSkills.shop.services.SaleService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesController {
    public SaleService saleService = new SaleService();

    public static Stage createStage;

    public void initTableSales(TableColumn nameCustomer, TableColumn telNumber, TableColumn nameSaledGood, TableColumn amountSaledGood, TableColumn resultPrice, TableColumn dateOfSale, TableView sales){
        nameCustomer.setCellValueFactory(new PropertyValueFactory<>("nameCustomer"));
        telNumber.setCellValueFactory(new PropertyValueFactory<>("telNumberCustomer"));
        nameSaledGood.setCellValueFactory(new PropertyValueFactory<>("goodSaled"));
        amountSaledGood.setCellValueFactory(new PropertyValueFactory<>("amountGoodSaled"));
        resultPrice.setCellValueFactory(new PropertyValueFactory<>("resultPrice"));
        dateOfSale.setCellValueFactory(new PropertyValueFactory<>("dateOfSale"));
        sales.getItems().clear();
        sales.getItems().addAll(saleService.listOfSales());

    }

    public void showSaleCustomers(String nameCustomer, TableView sales){
        sales.getItems().clear();
        sales.getItems().addAll(saleService.listOfSalesByCustomerName(nameCustomer));
    }


    public void searchByCustomerName(KeyEvent keyEvent, TextField searchCustomerName, TableView sales) {
        String nameCustomer = searchCustomerName.getText();
        if(nameCustomer.length() == 0){
            sales.getItems().clear();
            sales.getItems().addAll(saleService.listOfSales());
        }else{
            showSaleCustomers(nameCustomer, sales);
        }
    }

    public void showSaleGood(String nameGood, TableView sales){
        sales.getItems().clear();
        sales.getItems().addAll(saleService.listOfSalesByGoodName(nameGood));
    }


    public void searchByGoodName(KeyEvent keyEvent, TextField searchGoodName, TableView sales) {
        String nameGood = searchGoodName.getText();
        if(nameGood.length() == 0){
            sales.getItems().clear();
            sales.getItems().addAll(saleService.listOfSales());
        }else{
            showSaleGood(nameGood, sales);
        }
    }

    public void showSaleGoodPrice(String priceGood, TableView sales){
        sales.getItems().clear();
        sales.getItems().addAll(saleService.listOfSalesByGoodPrice(priceGood));
    }


    public void searchByGoodPrice(KeyEvent keyEvent, TextField searchGoodPrice, TableView sales) {
        String priceGood = searchGoodPrice.getText();
        if(priceGood.length() == 0){
            sales.getItems().clear();
            sales.getItems().addAll(saleService.listOfSales());
        }else{
            showSaleGoodPrice(priceGood, sales);
        }
    }

    public void addSale(ActionEvent actionEvent, TableView<Sale> sale) {
        try {
            createStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../../views/createSale.fxml"));
            Scene scene = new Scene(root, 358, 413);
            createStage.setScene(scene);
            createStage.setTitle("Добавление продажи");
            createStage.show();
            createStage.setOnHiding(event1 -> {
                sale.getItems().clear();
                sale.getItems().addAll(saleService.listOfSales());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeReport(ActionEvent actionEvent, TableView<Sale> sale) {
        List<Sale> salesListForReprot;
        salesListForReprot = saleService.listOfSales();
        double sumOfAllSales = 0;


        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setSelectedFile(new File("shop_report.txt"));
        int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            try {
                FileWriter fw = new FileWriter(selectedFile.getAbsolutePath());
                fw.write("СПИСОК ПРОДАЖ " + System.getProperty( "line.separator" ));
                for (int i = 0; i < salesListForReprot.size(); i++) {
                    fw.write(salesListForReprot.get(i) + "\n" + System.getProperty( "line.separator" ));
                    sumOfAllSales += salesListForReprot.get(i).getResultPrice();
                }
                fw.write(System.getProperty( "line.separator" )+ "Общая сумма продаж: " + sumOfAllSales + "$");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
