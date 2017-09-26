package tests;

import javafx.application.Application;
import javafx.stage.Stage;
import views.SetPCPage;

/**
 * Created by HastuneMiku on 2017/8/23.
 */
public class SetPCPageTest extends Application {
    public void start(Stage stage){
        Stage stage1=new  SetPCPage().getStage();
        stage1.show();
    }
    public static void main(String args[]){
        launch(args);
    }

}
