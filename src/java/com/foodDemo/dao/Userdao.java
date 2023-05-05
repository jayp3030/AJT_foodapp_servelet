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
            
            String query = "insert into signupinfo(username,email,password) values (?,?,?)";
            
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            
            pstmt.executeUpdate();
            
            flag = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return flag;
    }
    
    // get user by useremail and user password
    
    public User getuserByEmailAndPass(String uname , String upassword){
        User user = null;
        
        try {
            String query = "select * from signupinfo where email=? and password=?";
            
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, uname);
            pstmt.setString(2, upassword);
            
            ResultSet set = pstmt.executeQuery();
            
            
            if (set.next()) {
                user = new User();
                
                user.setName(set.getString("username"));
                user.setEmail(set.getString("email"));
                user.setPassword(set.getString("password"));
//                user.setId(Integer.toString(set.getString("useid")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
}
