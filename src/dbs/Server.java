package dbs;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by HastuneMiku on 2017/8/23.
 */
public class Server {
    private static DatagramSocket socket=null;
    public static DatagramSocket getServer(){
        if(socket==null){
            try {
                socket=new DatagramSocket(3000);
            } catch (SocketException e) {
                e.printStackTrace();
            }
            return  socket;
        }
        else return socket;
    }
}
