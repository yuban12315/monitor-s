package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by HastuneMiku on 2017/8/22.
 */
public class adminUser {
    private final StringProperty name;
    private final StringProperty password;
    public adminUser(String name,String password){
        this.name=new SimpleStringProperty(name);
        this.password=new SimpleStringProperty(password);
    }
    public void print(){
        System.out.println(name+"000"+password);
    }


    public String getName(){
        return name.get();
    }
    public String getPassword(){
        return password.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
    public void setPassword(String password){
        this.password.set(password);
    }
}
