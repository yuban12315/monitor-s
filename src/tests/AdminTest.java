package tests;

import dbs.Admin;
import dbs.Message;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by HastuneMiku on 2017/8/17.
 */
public class AdminTest {
    public static void main(String args[]){
        String name="admin1";
        String password="123456";

        Admin admin=new Admin();
//        Message message=admin.resetPassword(name,password);
//        message.println();
//        List<Map<String,Object>> list=admin.getAdminUser();
//        Iterator<Map<String, Object>> it=list.iterator();
//        for(;it.hasNext();) {
//            Map<String, Object> map2 =it.next();
//            String name1=(String) map2.get("name");
//            Object age= map2.get("password");
//            System.out.println("name=" +name1+ "\nage="+ age);
//        }
        //admin.register(name,password,password);
        admin.deleteAdmin(name);
    }
}
