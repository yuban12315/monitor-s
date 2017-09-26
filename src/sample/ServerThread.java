package sample;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by HastuneMiku on 2017/8/15.
 */
public class ServerThread implements Runnable{
    private ImageView imageView;
    private boolean change=false;
    private BufferedImage image=null;
    public void setImageView(ImageView i){
        imageView=i;
    }
    public void run()  {
        try{
            String str_send="Hello Client";
            byte[]buf=new byte[65535];
            DatagramSocket ds=new DatagramSocket(3000);
            DatagramPacket dp_receive=new DatagramPacket(buf,65535);
            System.out.println("server start,listening o port 3000");
            boolean f=true;
            int count=0;
            while (f){
                count++;
                ds.receive(dp_receive);
                System.out.println("sever received data from client:");
                System.out.println(dp_receive.getLength());
                System.out.println(count);
                File outputFile=new File("Save"+count+".png");
                ByteArrayInputStream inputStream=new ByteArrayInputStream(buf);
                image= ImageIO.read(inputStream);
                print(image);
                //ImageIO.write(image,"png",outputFile);
                DatagramPacket dp_send=new DatagramPacket(str_send.getBytes(),str_send.length(),dp_receive.getAddress(),9001);
                ds.send(dp_send);
                dp_receive.setLength(65535);
            }
            ds.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void print(BufferedImage image){
        WritableImage image1=SwingFXUtils.toFXImage(image,null);
        imageView.setImage(image1);


    }

}