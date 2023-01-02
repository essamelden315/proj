/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

<<<<<<< HEAD
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
=======
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
>>>>>>> 8d1ebd134b01909690f7809bfe8bccce411214e3
