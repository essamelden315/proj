/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmessage;

import Controlers.ScreenAdapter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import tic.tac.toe.OnlineAndOfflineBase;


/**
 *
 * @author essam elden
 */
 public class SendMessage{
    private static Socket socket;
    private static DataInputStream ear;
    private static PrintStream mouth;
    private static String replyMsg;
   public static void send(String str){
         try {
            socket=new Socket("127.0.0.1",5006);//172.16.10.183
            ear=new DataInputStream(socket.getInputStream());
            mouth=new PrintStream(socket.getOutputStream());
            mouth.println(str);    
            replyMsg= ear.readLine();
             System.out.println("server answer ="+replyMsg);
            } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
   

    public static String getAnswer (){
     return replyMsg;
  }
    public static void logout(ActionEvent event){
      final String LOGOUT= "logout,";
      String msg=LOGOUT+"1";
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

