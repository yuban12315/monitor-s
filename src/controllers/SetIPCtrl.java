package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import views.SetPCPage;

/**
 * Created by HastuneMiku on 2017/8/23.
 */
public class SetIPCtrl {
    Stage setIPStage;
    public SetIPCtrl(){
        SetPCPage setPCPage=new SetPCPage();
        setIPStage=setPCPage.getStage();
        Button enter=setPCPage.enter;
        TextField IPInput=setPCPage.IPInput;

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String IP=IPInput.getText();
                //IP="127.0.0.1";
                new MainCtrl(IP).start();
                setIPStage.hide();
            }
        });
    }
    public void start(){
        setIPStage.show();
    }
}
