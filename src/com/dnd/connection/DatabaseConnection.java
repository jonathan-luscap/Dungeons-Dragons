package com.dnd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con = null;

    static
    {
        String url = "jdbc:mysql://172.18.0.1:3306/dungeons_and_dragons";
        String user = "gameMaster";
        String password = "gameMaster";
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
