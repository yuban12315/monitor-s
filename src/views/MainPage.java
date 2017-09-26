package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by HastuneMiku on 2017/8/19.
 */
public class MainPage {

    private Stage stage;
    private Scene scene;
    public Button cancle;
    public Button admin;
    public Button changePC;
    public ImageView display;
    public MainPage(){
        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

        display=new ImageView();
        display.setFitWidth(1600);
        display.setFitHeight(900);
        gridPane.add(display,0,1);

        VBox vBox=new VBox(5);
        //vBox.setAlignment(Pos.BOTTOM_RIGHT);
        changePC=new Button("选择监视对象");
        admin=new Button("操作员管理");
        cancle=new Button("退出系统");
        vBox.getChildren().addAll(changePC,admin,cancle);

        gridPane.add(vBox,1,1);
        scene=new Scene(gridPane,1900,1000);
        stage=new Stage();
        stage.setTitle("Monitor局域网监控系统-主界面");
        stage.setScene(scene);
    }
    public Stage getStage() {
        return stage;
    }
}
