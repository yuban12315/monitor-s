package sample;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane pane=new Pane();
        ImageView imageView=new ImageView();
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);
        imageView.setPreserveRatio(true);

        StackPane root = new StackPane();
        root.getChildren().addAll(imageView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);

        ServerThread serverThread =new ServerThread();
        serverThread.setImageView(imageView);
        primaryStage.show();
        new Thread(serverThread).start();
        System.out.println("初始化界面成功");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
