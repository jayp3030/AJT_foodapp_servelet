/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodDemo.dao;
import com.foodDemo.etities.User;
import java.sql.*;
public class Userdao {
    private Connection con;

    public Userdao(Connection con) {
        this.con = con;
    }

    // method to save user in db
    
    public  boolean saveUser(User user){
         boolean flag = false;
        try {
            // user --> db
            
            String query = " insert into signupinfo(username,email,password) values (?,?,?)";
            
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(1, user.getPassword());
            
            int res = pstmt.executeUpdate();
            System.out.println(res);
            
            flag = true;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return flag;
    }
    
}
