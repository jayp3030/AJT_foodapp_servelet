package com.foodDemo.helper;

import java.sql.*;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection() {

        try {

            // driver class load 
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creating connection 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp" ,"root" , "shadow_ivy3030");
            

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return con;
    }

}
