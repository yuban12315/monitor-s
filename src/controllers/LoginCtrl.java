package controllers;

import dbs.Admin;
import dbs.Message;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.LoginPage;

/**
 * Created by HastuneMiku on 2017/8/18.
 */
public class LoginCtrl {
    Stage loginStage=null;
    Scene scene=null;
    public  LoginCtrl(){
       // loginStage=new Stage();
        LoginPage loginPage=new LoginPage();
        loginStage=loginPage.getStage();

        Button login=loginPage.login;
        Button cancle=loginPage.cancle;
        TextField adminNameInput=loginPage.adminNameInput;
        PasswordField passwordInput=loginPage.passwordInput;
        Text warning=loginPage.warning;

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String name=adminNameInput.getText();
                String password=passwordInput.getText();
//                warning.setFill(Color.FIREBRICK);
//                warning.setText(name+password+"1122");
                Admin admin=new Admin();
                Message message=admin.login(name,password);
                if(message.getStatus()){
                    //跳转页面
                    warning.setText("");
                    loginStage.hide();
                    new MainCtrl().start();
                }
                else {
                    warning.setFill(Color.FIREBRICK);
                    warning.setText(message.getMsg());
                }
            }
        });
        cancle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginStage.close();
            }
        });

    }
    public void start(){
        loginStage.show();
    }
}
