package dbs;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by HastuneMiku on 2017/8/17.
 */
//admin类 负责管理员的登录、注册顿号，修改昵称
public class Admin {
    //注册
    public Message register(String name, String password,String password2) {
        try {
            if (name.length() < 1) {
                throw new Exception("name is required");
            }
            if (password.length() < 1) {
                throw new Exception("password is required");
            }
            if(!password.equals(password2)){
                throw new Exception("password need to be equal");
            }
            MongoCollection<Document> collection = MongoDB.getCollection();
            Document document=collection.find(eq("name",name)).first();
            if(document!=null){
                throw new Exception("admin "+name+" is already existed");
            }
            document = new Document("name", name).append("password", password);
            collection.insertOne(document);
            //System.out.println(collection.count());

        } catch (Exception e) {
            Message message=new Message();
            message.setStatus(false);
            message.setMsg(e.getMessage());
            return message;
        }
        Message message=new Message();
        message.setStatus(true);
        message.setMsg("register success");
        return message;
    }

    //登录
    public Message login(String name, String password) {
        try {
            if (name.length() < 1) {
                throw new Exception("name is required");
            }
            if (password.length() < 1) {
                throw new Exception("password is required");
            }
            MongoCollection<Document> collection = MongoDB.getCollection();
            Document doc = collection.find(eq("name", name)).first();
            if (doc == null) {
                throw new Exception("admin " + name + " is not existed");
            }
            String _password = doc.getString("password");
            if (!password.equals(_password)) {
                throw new Exception("password wrong");
            }
        } catch (Exception e) {
            Message message = new Message();
            message.setStatus(false);
            message.setMsg(e.getMessage());
            //e.printStackTrace();
            return message;
        }
        Message message = new Message();
        message.setStatus(true);
        message.setMsg("login success");
        return message;
    }

    //展示所有管理员
    public List getAdminUser(){
        List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();
        try {
            MongoCollection<Document>collection=MongoDB.getCollection();
            MongoCursor<Document> docs=collection.find().iterator();
            String name,password;
            Document doc;
            while (docs.hasNext()){
                Map<String,Object>map=new HashMap<String, Object>();
                doc=docs.next();
                //System.out.println(doc.toJson());
                name=doc.getString("name");
                password=doc.getString("password");
                map.put("name",name);
                map.put("password",password);
                list.add(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

    //重置密码
    public Message resetPassword(String name,String password){
        try {
            if(name.length()<1){
                throw new Exception("name is required");
            }
            if(password.length()<1){
                throw new Exception("password is required");
            }
            MongoCollection<Document>collection=MongoDB.getCollection();
            collection.updateOne(eq("name",name),new Document("$set",new Document("password",password)));
        }catch (Exception e){
            Message message=new Message();
            message.setStatus(false);
            message.setMsg(e.getMessage());
            return message;
        }
        Message message=new Message();
        message.setStatus(true);
        message.setMsg("reset password success");
        return message;
    }

    //删除管理员
    public Message deleteAdmin(String name){
        try {
            MongoCollection<Document>collection=MongoDB.getCollection();
            collection.findOneAndDelete(eq("name",name));
        }catch (Exception e){
            Message message=new Message();
            message.setStatus(false);
            message.setMsg(e.getMessage());
            return message;
        }
        Message message=new Message();
        message.setStatus(true);
        message.setMsg("delete admin success");
        return message;
    }
}
