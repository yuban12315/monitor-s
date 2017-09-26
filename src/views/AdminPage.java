package views;

import dbs.Admin;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by HastuneMiku on 2017/8/21.
 */
public class AdminPage {
    private Stage stage=null;
    public Button addAdmin;
    public Button updateAdmin;
    public Button deleteAdmin;
    public Button backToMainPage;

    public Text warning;

    public TextField adminNameInput;
    public PasswordField adminPasswordInput;
    public PasswordField doubleCheckPassword;
    public TableView adminUsers;
    public AdminPage(){
        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

        /**************************************************/
        HBox hBox=new HBox(5);
        hBox.setAlignment(Pos.CENTER_LEFT);
        //gridPane.add(line,0,0);
        Label text=new Label("操作员信息");
        text.setFont(new Font("Arial",20));
        //gridPane.add(text,1,0);
        hBox.getChildren().addAll(text);
        gridPane.add(hBox,0,0);


        HBox hBox0=new HBox(5);
        hBox0.setAlignment(Pos.CENTER_RIGHT);
        Label adminName=new Label("管理员:");
        //gridPane.add(adminName,0,1);
        adminNameInput=new TextField();
        //gridPane.add(adminNameInput,1,1);
        addAdmin=new Button("添加");
        //gridPane.add(addAdmin,2,1);
        hBox0.getChildren().addAll(adminName,adminNameInput,addAdmin);
        gridPane.add(hBox0,0,1);

        HBox hBox1=new HBox(5);
        hBox1.setAlignment(Pos.CENTER_RIGHT);
        Label password=new Label("密码:");
        //gridPane.add(password,0,2);
        adminPasswordInput=new PasswordField();
       // gridPane.add(adminPasswordInput,1,2);
        updateAdmin=new Button("修改");
        //gridPane.add(updateAdmin,2,2);
        hBox1.getChildren().addAll(password,adminPasswordInput,updateAdmin);
        gridPane.add(hBox1,0,2);

        HBox hBox2=new HBox(5);
        hBox2.setAlignment(Pos.CENTER_RIGHT);
        Label passwordCheck=new Label("确认密码:");
        //gridPane.add(passwordCheck,0,3);
        doubleCheckPassword=new PasswordField();
        //gridPane.add(doubleCheckPassword,1,3);
        deleteAdmin=new Button("删除");
        //gridPane.add(deleteAdmin,2,3);
        hBox2.getChildren().addAll(passwordCheck,doubleCheckPassword,deleteAdmin);
        gridPane.add(hBox2,0,3);

        warning=new Text();
        warning.setFill(Color.FIREBRICK);
        gridPane.add(warning,0,4);
        /*****************************************************/


        HBox hBox3=new HBox();
        adminUsers=new TableView();
        adminUsers.setEditable(false);

        //nameCol.prefWidthProperty().bind(personTable.widthProperty().multiply(0.25));
        adminUsers.setMinWidth(350);
        adminUsers.setMaxWidth(350);
        TableColumn nameColumn=new TableColumn("操作员");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.prefWidthProperty().bind(adminUsers.widthProperty().multiply(0.5));

        TableColumn passwordColumn=new TableColumn("密码");
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        passwordColumn.prefWidthProperty().bind(adminUsers.widthProperty().multiply(0.5));

        adminUsers.getColumns().addAll(nameColumn,passwordColumn);
        //gridPane.add(adminUsers,0,6);
        hBox3.getChildren().add(adminUsers);
        gridPane.add(hBox3,0,5);

        HBox hBox4=new HBox(5);
        hBox4.setAlignment(Pos.CENTER);
        backToMainPage=new Button("返回主界面");
        hBox4.getChildren().add(backToMainPage);
        gridPane.add(hBox4,0,6);

        Scene scene=new Scene(gridPane,540,500);
        stage=new Stage();
        stage.setTitle("局域网监视系统-操作员管理");
        stage.setScene(scene);
        stage.setResizable(false);
    }
    public Stage getStage(){
        return  stage;
    }
}
