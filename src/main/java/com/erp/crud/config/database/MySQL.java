package com.erp.crud.config.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQL extends DBManager {
    Connection con;
    Statement stmt;

    public Statement connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/java_ee", "root", "");
            stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void disconnect() {
        try {
            con.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
