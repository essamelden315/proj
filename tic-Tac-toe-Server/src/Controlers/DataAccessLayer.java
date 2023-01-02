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

/**
 *
 * @author essam elden
 */
public class DataAccessLayer  {
    int check (String email ,String pass , String ip) throws Exception
    {
        int id =-1;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"root","root");
        PreparedStatement prestate = conn.prepareStatement("select id from account where email=? and pass =?");
        prestate.setString(1, email);
        prestate.setString(2, pass);
        ResultSet result = prestate.executeQuery();
        if(result.next()){
            id = Integer.parseInt(result.getString(1));
            prestate = conn.prepareStatement("update account set state =? , ip =? where id ="+id);
            prestate.setString(1, "online");
            prestate.setString(2, ip);
        }
        prestate.close();
        conn.close();
        return id;
    }
}
