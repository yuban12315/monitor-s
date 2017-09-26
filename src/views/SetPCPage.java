package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by HastuneMiku on 2017/8/23.
 */
public class SetPCPage {
    Stage stage;
    public Button enter;
    public TextField IPInput;
    public SetPCPage(){
        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));
        //HBox hBox=new HBox(5);
        IPInput=new TextField();
        enter=new Button("确认");
        enter.setAlignment(Pos.CENTER);
        gridPane.add(IPInput,0,0);
        gridPane.add(enter,1,0);

        Scene scene=new Scene(gridPane,400,100);
        stage=new Stage();
        stage.setTitle("局域网监视系统-设置监控IP");
        stage.setScene(scene);
    }
    public Stage getStage(){
        return stage;
    }
}
