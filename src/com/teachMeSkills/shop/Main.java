package com.teachMeSkills.shop;

import com.teachMeSkills.shop.controllers.usersController.UserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/login.fxml"));
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Магазин");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void stop(){

    }
}
