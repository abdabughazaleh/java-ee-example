package com.erp.crud.model;

import com.erp.crud.config.database.DBManager;
import com.erp.crud.config.database.DBWorker;
import com.erp.crud.config.database.MySQL;
import com.erp.crud.dao.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

    public List<User> getUsers() {

        List<User> users = new ArrayList<>();
        DBWorker dbWorker = (DBManager db) -> {
            try {
                db.connect();
                ResultSet rs = db.query("select  * from users order by user_id desc");
                while (rs.next()) {
                    users.add(new User(
                            Integer.parseInt(rs.getString("user_id")),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getString("fullname")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        };

        dbWorker.connect(new MySQL());
        return users;
    }

    public void delete(Integer userId) {
        DBWorker dbWorker = (DBManager db) -> {
            try {
                db.connect();
                db.execute(String.format("delete from users where user_id='%s'", userId));
            } catch (Exception e) {
                e.printStackTrace();
            }

        };

        dbWorker.connect(new MySQL());
    }

    public void addUser(User user) {
        DBWorker dbWorker = (DBManager db) -> {
            try {
                db.connect();
                db.execute(String.format("insert into users(username,password,email,fullname) " +
                                "       values('%s','%s','%s','%s')", user.getUsername(),
                        user.getPassword(),
                        user.getEmail(),
                        user.getFullname()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        };

        dbWorker.connect(new MySQL());
    }

    public void updateUser(User user) {
        DBWorker dbWorker = (DBManager db) -> {
            try {
                db.connect();
                db.execute(String.format("update users set username = '%s' ,email='%s',fullname='%s' " +
                                " where user_id='%s'",
                        user.getUsername(),
                        user.getEmail(),
                        user.getFullname(),
                        user.getUserId()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        };

        dbWorker.connect(new MySQL());
    }


    public User getUserById(Integer userId) {
        User user = new User();
        DBWorker dbWorker = (DBManager db) -> {
            try {
                db.connect();
                ResultSet rs = db.query(String.format("select *  from users where user_id='%s' ", userId));
                System.out.println(String.format("select *  from users where user_id='%s' ", userId));
                if (rs.next()) {
                    user.setUserId(Integer.parseInt(rs.getString("user_id")));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setFullname(rs.getString("fullname"));
                    user.setEmail(rs.getString("email"));
                } else {
                    throw new Exception("User Not Found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        dbWorker.connect(new MySQL());
        return user;
    }

}
