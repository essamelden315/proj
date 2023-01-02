/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LapStore
 */
public class DataAccessLayer {
    
       /* public static String SearchbyIP(int id) throws SQLException, ClassNotFoundException{
        

        String ip = "null";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","root","root");
        Statement stmt=conn.createStatement();
        ResultSet t= stmt.executeQuery("SELECT IP FROM ACCOUNT WHERE ID"+id+")");
        if(t.next()) {
          ip = t.getString("IP");
        }

        
        
       return ip;
        }
}*/
public static String SearchbyIP(int id) throws SQLException, ClassNotFoundException{
        

        String ip = "null";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","root","root");
        Statement stmt=conn.createStatement();
        ResultSet t= stmt.executeQuery("SELECT IP FROM ACCOUNT WHERE ID="+id);
        if(t.next()) {
          ip = t.getString(5);
        }
        stmt.close();
        conn.close();
           
       return ip;
        }
}