/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodDemo.dao;

import com.foodDemo.etities.FoodOrder;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodOrderdao {

    private Connection con;

    public FoodOrderdao(Connection con) {
        this.con = con;
    }

    // method to save order in db
    public boolean saveOrder(FoodOrder order) {
        boolean flag = false;
        try {
            // order --> db

            String query = "insert into orderinfo(username , food_items,food_quantity,suggetions) values (?,?,?,?)";

            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, order.getName());
            pstmt.setString(2, order.getOrder());
            pstmt.setString(3, order.getQuantity());
            pstmt.setString(4, order.getSuggestion());

            pstmt.executeUpdate();

            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    // method to get order from db
    public boolean updateOrder(String name, String oldOrder, String oldQuantity, String newOrder, String newQuantity) {

        boolean flag = false;

        try {
            String query = "update orderinfo set food_items = ? , food_quantity = ? where username = ? and food_items = ? and food_quantity = ? ";

            PreparedStatement pstmt = this.con.prepareStatement(query);

            pstmt.setString(1, newOrder);
            pstmt.setString(2, newQuantity);
            pstmt.setString(3, name);
            pstmt.setString(4, oldOrder);
            pstmt.setString(5, oldQuantity);

            System.out.println(newOrder);
            System.out.println(newQuantity);
            System.out.println(name);
            System.out.println(oldOrder);
            System.out.println(oldQuantity);

            pstmt.execute();

            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    // method to delete the order
    public boolean deleteOrder(FoodOrder order) {
        boolean flag = false;

        try {

            String query = " delete from orderinfo where username = ? and food_items = ? and food_quantity = ?";

            PreparedStatement pstmt = this.con.prepareStatement(query);

            pstmt.setString(1, order.getName());
            pstmt.setString(2, order.getOrder());
            pstmt.setString(3, order.getQuantity());

            System.out.println(order.getName());
            System.out.println(order.getOrder());
            System.out.println(order.getQuantity());


            pstmt.execute();
            flag = true;
         

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
