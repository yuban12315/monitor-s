package dbs;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;

/**
 * Created by HastuneMiku on 2017/8/23.
 */
public class SocketServer implements Runnable{
    ImageView imageView=null;
    BufferedImage image;
    boolean flag;
    byte[] temp=null;
    int index_next=0;

    public void setIP(String IP) {
        this.IP = IP;
    }

    String IP=null;
    public void setImageView(ImageView imageView){
        this.imageView=imageView;
    }


    public void run(){
        try {
            //String str_send="Hello Client";
            byte[]buf=new byte[65535];
            DatagramSocket ds=Server.getServer();
            DatagramPacket dp_receive=new DatagramPacket(buf,65535);
            System.out.println("server start,listening o port 3000");
            boolean f=true;
            int count=0;
            this.IP="/"+this.IP;
            flag=false;
            while (f){
                count++;
                ds.receive(dp_receive);
                //System.out.println(IP);
                if(checkIP(dp_receive.getAddress().toString())){
                    //System.out.println("sever received data from client:"+dp_receive.getLength());
//                    System.out.println(IP);
//                    ByteArrayInputStream inputStream=new ByteArrayInputStream(buf);
//                    image= ImageIO.read(inputStream);
//                    print(image);
                    convert(buf);
//                    if(flag){
//                        flag=false;
//                        System.out.println("打印图片");
//                        index_next=0;
//                        //print(image);
//                    }
                    //ImageIO.write(image,"png",outputFile);
                    //DatagramPacket dp_send=new DatagramPacket(str_send.getBytes(),str_send.length(),dp_receive.getAddress(),9001);
                   // ds.send(dp_send);
                    dp_receive.setLength(65535);
                } else {
                    System.out.println("sss");
                    continue;
                }
            }
            ds.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void print(BufferedImage image){
        WritableImage image1= SwingFXUtils.toFXImage(image,null);
        imageView.setImage(image1);
    }
    private boolean checkIP(String ip){
        return this.IP.equals(ip);
    }

    private int toInt(byte[]bytes){
        /*ByteBuffer wrapped = ByteBuffer.wrap(arr); // big-endian by default
short num = wrapped.getShort(); // 1*/
        ByteBuffer wrapped=ByteBuffer.wrap(bytes);
        return wrapped.getInt();
    }

    private void convert(byte[]data) throws Exception{
        int index,numOfBlock,m_length,allLength;
        byte[]t=new byte[4];
        System.arraycopy(data,0,t,0,4);
        index=toInt(t);
        System.arraycopy(data,4,t,0,4);
        numOfBlock=toInt(t);
        System.arraycopy(data,8,t,0,4);
        m_length=toInt(t);
        System.arraycopy(data,12,t,0,4);
        allLength=toInt(t);
        System.out.println(numOfBlock+" : "+index+" , "+allLength+" : "+m_length);
        if(temp==null){
            temp=new byte[allLength];
        }
        System.arraycopy(data,16,temp,index*50000,m_length);
        if(index==numOfBlock){

            flag=true;
            System.out.println(temp.length);
            System.out.println("打印图片");
           // print(image);
            ByteArrayInputStream inputStream=new ByteArrayInputStream(temp);
            image= ImageIO.read(inputStream);
            print(image);
            temp=null;
        }
    }
}
