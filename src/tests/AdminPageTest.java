package tests;

import controllers.AdminCtrl;
import javafx.application.Application;
import javafx.stage.Stage;
import views.AdminPage;

/**
 * Created by HastuneMiku on 2017/8/21.
 */
public class AdminPageTest extends Application {
    public void  start(Stage stage){
        new AdminCtrl().start();
        //Stage stage1=new AdminPage().getStage();
        //stage1.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
