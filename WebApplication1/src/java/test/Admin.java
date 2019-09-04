/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.dbcon;

/**
 *
 * @author adib.a
 */
public class Admin {
      private int id;
   private String username;
   private String password;

    public Admin() {
    }

    public Admin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int checklogin(String u, String p) {
        int ResultCount = 0;
        try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            String sql = "select count(*) as rowcount from admin where username=('" + u.trim() + "') and password=('" + p.trim() + "') ";
            dbcon con = new dbcon();
            rs = con.sqlquery(sql);
            rs.next();
            ResultCount = rs.getInt("rowcount");
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ResultCount;
    }
}
