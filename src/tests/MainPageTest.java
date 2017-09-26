package tests;

import controllers.LoginCtrl;
import controllers.MainCtrl;
import javafx.application.Application;
import javafx.stage.Stage;
import views.MainPage;

/**
 * Created by HastuneMiku on 2017/8/19.
 */
public class MainPageTest extends Application {
    public void start(Stage primaryStage)throws Exception{

//        primaryStage=new MainPage().getStage();
//        primaryStage.show();
        new MainCtrl("183.175.11.191").start();
        //new MainCtrl().start();
    }
    public static void main(String args[]){
        launch(args);
    }
}
