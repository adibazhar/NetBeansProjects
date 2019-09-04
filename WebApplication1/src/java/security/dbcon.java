
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author virtualspace
 */
public class dbcon {

 
    
        CachedRowSet rowSet;
         Connection con=null;
          Statement stmt =null;
          ResultSet rs=null;
          PreparedStatement ps=null;
          String driver;   //"org.gjt.mm.mysql.Driver"
          String urlcon; //"jdbc:mysql://localhost:3306/database"
          String username;//select count(*) as rowcount from users where username=(?) and password=(?)
          String password;
   
    public dbcon() {
        this.driver = "org.gjt.mm.mysql.Driver";
        this.urlcon = "jdbc:mysql://localhost:3306/portal_db";
        this.username="root";
        this.password="root";
    }
    public dbcon(String driver, String urlcon, String u,String p) {
        this.driver = driver;
        this.username=u;
        this.password=p;
 
    }    
    public ResultSet sqlquery(String executesql) throws SQLException{
      
    try { 
          Class.forName(driver);
          con=DriverManager.getConnection(urlcon,username,password);
          ps=con.prepareStatement(executesql);
         // stmt=con.createStatement();
          rs=ps.executeQuery();
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(dbcon.class.getName()).log(Level.SEVERE, null, ex);
      
        }
   return rs;
    
}
    public void executesql(String executesql) throws SQLException{
    try { 
          Class.forName(driver);
          con=DriverManager.getConnection(urlcon,username,password);
          ps=con.prepareStatement(executesql);
          //stmt=con.createStatement();
          ps.execute();
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(dbcon.class.getName()).log(Level.SEVERE, null, ex);
      
        }
   //return rs;
    
}
}
