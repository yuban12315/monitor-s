package views;

import dbs.Admin;
import dbs.Message;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by HastuneMiku on 2017/8/18.
 */
public class LoginPage {
    private Scene scene;
    private Stage stage;
    public TextField adminNameInput;
    public PasswordField passwordInput;
    public Button login;
    public Button cancle;
    public Text warning;
    public LoginPage(){
        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

//        Text text=new Text("局域网桌面监视系统");
//        text.setFont(Font.font("Courier New",FontWeight.NORMAL,20));
//        gridPane.add(text,0,0,3,1);

        Label adminName=new Label("管理员:");
        gridPane.add(adminName,0,1);
        adminNameInput=new TextField();
        gridPane.add(adminNameInput,1,1);

        Label password=new Label("密码:");
        gridPane.add(password,0,2);
        passwordInput=new PasswordField();
        gridPane.add(passwordInput,1,2);

        HBox hBox=new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        login=new Button("登录");
        cancle=new Button("取消");
        hBox.getChildren().add(login);
        hBox.getChildren().add(cancle);
        gridPane.add(hBox,1,4);

        warning=new Text();
        gridPane.add(warning,1,6);

        //处理登录


        scene=new Scene(gridPane,500,300);
        //stage.setScene(scene);
        stage=new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Monitor局域网监控系统-登录");
    }
    public Stage getStage(){
        return  stage;
    }
}
