package com.erp.crud.config.database;

import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DBManager {

    public abstract Statement connect();

    public abstract void disconnect();


    public ResultSet query(String query) {
        try {
            ResultSet rs = connect().executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void execute(String query) {
        try {
            connect().executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
