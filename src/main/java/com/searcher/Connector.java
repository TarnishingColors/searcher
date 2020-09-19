package com.searcher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://LAPTOP-D1C28J80\\SQLEXPRESS;databaseName=example";
        String user = "LAPTOP-D1C28J80\\HP";
        String password = "";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(url, user, password);

    }

}
