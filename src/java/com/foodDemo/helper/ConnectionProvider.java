package com.foodDemo.helper;

import java.sql.*;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection() {

        try {

            if (con == null) {
                // driver class load 
                Class.forName("com.mysql.jdbc.Driver");

                // creating connection 
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp", "root@localhost", "shadow_ivy3030");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
 
        return con;
    }

}
