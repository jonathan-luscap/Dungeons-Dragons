package com.dnd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con = null;

    static
    {
        String url = "jdbc:mariadb://localhost:3307/dungeons_and_dragons";
        String user = "root";
        String password = "password";
        try{
            con = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return con;
    }
}
