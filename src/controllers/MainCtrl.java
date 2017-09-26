package controllers;

import dbs.SocketServer;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import tests.ImageTest;
import views.MainPage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HastuneMiku on 2017/8/21.
 */
public class MainCtrl {
    private MainPage mainPage=null;
    private Stage mainStage=null;
    private String socketTarget=null;
    public MainCtrl(){
        socketTarget=null;
    }
    public MainCtrl(String s){
        socketTarget=s;
    }

    public void start(){
        mainPage=new MainPage();
        mainStage=mainPage.getStage();
        Button changePC=mainPage.changePC;
        Button admin=mainPage.admin;
        Button cancle=mainPage.cancle;
        ImageView display=mainPage.display;


        //切换监视对象按钮（显示弹窗）
        changePC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.hide();
                new SetIPCtrl().start();
            }
        });

        //操作员管理
        admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.hide();
                new AdminCtrl().start();
            }
        });

        //退出系统
        cancle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.close();
            }
        });

        if(socketTarget!=null){
            System.out.println("Start UDP System Thread");
            //System.out.println(socketTarget);
            //code here
            SocketServer socketServer=new SocketServer();
            socketServer.setIP(socketTarget);
            socketServer.setImageView(display);
            new Thread(socketServer).start();
        }
        else {
            try {
//                WritableImage image= SwingFXUtils.toFXImage(new ImageTest().getScreenshot(),null);
//                display.setImage(image);
                BufferedImage image=ImageIO.read(new File("src/views/default.png"));
                WritableImage image1=SwingFXUtils.toFXImage(image,null);
                display.setImage(image1);
            }  catch (Exception e) {
                e.printStackTrace();
            }

        }
        mainStage.show();
    }
}
