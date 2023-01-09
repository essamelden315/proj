/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import Controlers.ScreenAdapter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import tic.tac.toe.OnlineAndOfflineBase;
import Model.Player;


/**
 *
 * @author essam elden
 */
 public class SendMessage{
    private static Socket socket;
    private static DataInputStream ear;
    private static PrintStream mouth;
    private static String replyMsg;
    private static ArrayList<Player> players;
    static ObjectInputStream inStream;
    
   public static void send(String str){
         try {
            socket=new Socket("127.0.0.1",5006);//172.16.10.183
            ear=new DataInputStream(socket.getInputStream());
            mouth=new PrintStream(socket.getOutputStream());
            inStream= new ObjectInputStream(socket.getInputStream());
            if(str.equals("show,")){
            mouth.println(str);
            players.addAll((Collection<? extends Player>) inStream.readObject());
            }else{
                mouth.println(str);
            replyMsg=ear.readLine();
            mouth.println(str);
            }
             System.out.println("server answer ="+replyMsg);
             
            } catch (Exception ex) {
           ex.printStackTrace();//handel el exception
        }
    }
   

    public static String getAnswer (){
     return replyMsg;
  }
    
 
    
    public static void logout(ActionEvent event){
      final String LOGOUT= "logout,";
        String msg=LOGOUT+replyMsg;
        System.out.println(msg);
        send(msg);
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
         ScreenAdapter.setScreen(event, new OnlineAndOfflineBase());
    }
     
    public static void login(String email,String pass){
        final String LOGIN= "login,";
        String msg=LOGIN+email+","+pass;
        send(msg);
    } 
    
 }

