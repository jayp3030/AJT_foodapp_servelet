
package com.foodDemo.etities;
import java.sql.*;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String cpassword;

    public User(int id, String name, String email, String password, String cpassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpassword = cpassword;
    }

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
    
    
    
}
