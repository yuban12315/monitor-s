package controllers;

import dbs.Admin;
import dbs.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.adminUser;
import views.AdminPage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by HastuneMiku on 2017/8/21.
 */
public class AdminCtrl {
    private ObservableList<adminUser> adminData = FXCollections.observableArrayList();
    private Stage adminStage;
    TableView adminUsers;
    Admin admin;
    Text warning;

    public AdminCtrl() {
        admin = new Admin();
        AdminPage adminPage = new AdminPage();
        adminStage = adminPage.getStage();

        Button addAdminBtn = adminPage.addAdmin;
        Button updateAdminBtn = adminPage.updateAdmin;
        Button deleteAdminBtn = adminPage.deleteAdmin;
        Button backToMainPage = adminPage.backToMainPage;
        adminUsers = adminPage.adminUsers;
        TextField adminNameInput = adminPage.adminNameInput;
        PasswordField adminPasswordInput = adminPage.adminPasswordInput;
        PasswordField doubleCheckPassword = adminPage.doubleCheckPassword;

        warning = adminPage.warning;
        refreshTableView();

        //添加（注册）操作员
        addAdminBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = adminNameInput.getText();
                String password = adminPasswordInput.getText();
                String doubleCheck = doubleCheckPassword.getText();
                Message message = admin.register(name, password, doubleCheck);
                if (!message.getStatus()) {
                    warning.setText(message.getMsg());
                } else {
                    refreshTableView();
                }
            }
        });

        //修改
        updateAdminBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = adminNameInput.getText();
                String password = adminPasswordInput.getText();
                String doubleCheck = doubleCheckPassword.getText();
                if (!password.equals(doubleCheck)) {
                    warning.setText("password need to be equal");
                    return;
                }
                Message message = admin.resetPassword(name, password);
                if (!message.getStatus()) {
                    warning.setText(message.getMsg());
                } else {
                    refreshTableView();
                }
            }
        });

        //删除
        deleteAdminBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name =adminNameInput.getText();
                Message message=admin.deleteAdmin(name);
                if (!message.getStatus()) {
                    warning.setText(message.getMsg());
                } else {
                    refreshTableView();
                }
            }
        });

        adminUsers.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                adminUser selectedUser = (adminUser) newSelection;
                String name = selectedUser.getName();
                String password = selectedUser.getPassword();
                adminNameInput.setText(name);
                adminPasswordInput.setText(password);
                doubleCheckPassword.clear();
            }
        });

        backToMainPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                adminStage.hide();
                new MainCtrl().start();
            }
        });

    }

    public void start() {
        adminStage.show();
    }

    public void refreshTableView() {
        try {
            adminData.clear();
            List<Map<String, Object>> lists = admin.getAdminUser();
            Iterator<Map<String, Object>> it = lists.iterator();
            for (; it.hasNext(); ) {
                Map<String, Object> map = it.next();
                String name = (String) map.get("name");
                String password = (String) map.get("password");

                adminUser adminUser1 = new adminUser(name, password);
                //System.out.println(adminUser1);
                adminData.add(adminUser1);

            }
        } catch (Exception e) {
            warning.setFill(Color.FIREBRICK);
            warning.setText(e.getMessage());
        }
        adminUsers.setItems(adminData);
    }
}

