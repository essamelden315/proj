/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import tic.tac.toe.server.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DataAccessLayer {
    
    public static ArrayList<Player> retrieveOnlineList() throws SQLException, ClassNotFoundException
    {
       {
        int result=0;
        ArrayList<Player> onlinePlayersList=new ArrayList<>();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","root","root");
        Statement preparedStatement=con.createStatement();
        String queryString =new String("SELECT ID,NAME FROM ACCOUNT WHERE STATE='online'");
        ResultSet rs= preparedStatement.executeQuery(queryString) ;
          
        while(rs.next())
        {
          Player playerRetrieved=new Player(rs.getInt(1),rs.getString(2));
          /*playerRetrieved.setID(rs.getInt(1));
          playerRetrieved.setName(rs.getString(2)); */
          onlinePlayersList.add(playerRetrieved);
        }
        con.close();                                     
        preparedStatement.close();
        return onlinePlayersList;   
    }
    }
    
    
}