package com.teachMeSkills.shop.controllers.usersController;

import com.teachMeSkills.shop.Main;
import com.teachMeSkills.shop.models.User;
import com.teachMeSkills.shop.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UserController {


    UserService service = UserService.getInstance();

    public static Stage updatePassStage;


    public TextField loginField;
    public TextField passwordField;
    public Button btn_login;
    public Hyperlink forgotPassword;
    public Label loginInfo;


    public void enterApp(ActionEvent actionEvent) {
        try {
            User user = new User();
            user.setLogin(loginField.getText());
            user.setPassword(passwordField.getText());
            if(service.isUserExists(user)) {
                Stage stage = (Stage) btn_login.getScene().getWindow();
                stage.close();
                Stage mainShopStage;
                mainShopStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../../views/shop.fxml"));
                Scene scene = new Scene(root, 856, 628);
                mainShopStage.setScene(scene);
                mainShopStage.setTitle("Магазин");
                mainShopStage.show();
            } else {
                loginInfo.setText("Wrong login or password.");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openForgotPasswordForm(ActionEvent actionEvent) {
        /*try {
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
        }*/
    }
}
