/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import Model.Player;
import tic.tac.toe.server.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author essam elden
 */
public class DataAccessLayer {

//public static int count =0;
    public static int check(String email, String pass, String ip) throws Exception {
        int id = -1;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
        // PreparedStatement prestate = conn.prepareStatement("select id from account where NAME=? and PASS =?");
        PreparedStatement prestate = conn.prepareStatement("select id from account where EMAIL=? and PASS =? and state != ?"); //and state= offline
        prestate.setString(1, email);
        prestate.setString(2, pass);
        prestate.setString(3, "online");
        ResultSet result = prestate.executeQuery();
        if (result.next()) {
            id = Integer.parseInt(result.getString(1));
            prestate = conn.prepareStatement("update account set state =? , ip =? where id =" + id);
            prestate.setString(1, "online");
            prestate.setString(2, ip);
            prestate.executeQuery();
        }
        prestate.close();
        conn.close();
        System.out.println("id in check method " + id);
        return id;
    }

    public static ArrayList<Player> retrieveOnlineList(int id) throws SQLException, ClassNotFoundException {

        int result = 0;
        ArrayList<Player> onlinePlayersList = new ArrayList<>();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
        Statement preparedStatement = conn.createStatement();
        String queryString = new String("SELECT ID,NAME FROM ACCOUNT WHERE STATE='online' and id  !=" + id);
        ResultSet rs = preparedStatement.executeQuery(queryString);

        while (rs.next()) {
            Player playerRetrieved = new Player(rs.getInt(1), rs.getString(2));
            /*playerRetrieved.setID(rs.getInt(1));
          playerRetrieved.setName(rs.getString(2)); */
            onlinePlayersList.add(playerRetrieved);
        }
        preparedStatement.close();
        conn.close();

        return onlinePlayersList;

    }

    public static int count() {
        int result = 0;
        try {
                        
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
            Statement preparedStatement = conn.createStatement();
            String queryString = new String("SELECT * from Account");
            ResultSet rs = preparedStatement.executeQuery(queryString);
            
            while (rs.next()) {
                result++;
            }
            preparedStatement.close();
            conn.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int addPlayer(String name, String email, String password) throws ClassNotFoundException, SQLException {
        int id = 1;
        int reply = -12;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
        //Statement stmt = conn.createStatement();
        PreparedStatement stmt = conn.prepareStatement("select * From ACCOUNT where EMAIL =?");
        stmt.setString(1, email);
        ResultSet t = stmt.executeQuery();

        if (!t.next()) {
            stmt = conn.prepareStatement("select * From ACCOUNT");
            t = stmt.executeQuery();
            while (t.next()) {

                if (id < t.getInt(1)) {
                    id = t.getInt(1);
                }
            }
            id++;
            stmt.executeUpdate("INSERT INTO ACCOUNT (ID,NAME,EMAIL,PASS,STATE)"
                    + "VALUES (" + id + ",'" + name + "','" + email + "','" + password + "','offline') ");
            reply = 0;

        } else {
            id = -1;
        }

        stmt.close();
        conn.close();
        return reply;
    }

    public static void logout(int id) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
            PreparedStatement prestate = conn.prepareStatement("update account set state =? where id =" + id);
            prestate.setString(1, "offline");
            prestate.executeUpdate();
            prestate.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
