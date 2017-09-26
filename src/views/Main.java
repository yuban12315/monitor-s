package views;

import controllers.LoginCtrl;
import javafx.application.Application;

import javafx.stage.Stage;


/**
 * Created by HastuneMiku on 2017/8/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception{
//        primaryStage.setTitle("Monitor桌面监控");
//        primaryStage.show();
        new LoginCtrl().start();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
