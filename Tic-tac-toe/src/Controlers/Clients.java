/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;


import static Controlers.SendMessage.send;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tic.tac.toe.LoginBase;
import tic.tac.toe.OnlineAndOfflineBase;
import tic.tac.toe.SignUpBase;
import tic.tac.toe.TicTacToe;
import tic.tac.toe.players_listBase;

/**
 *
 * @author HP
 */
public class Clients extends Thread{
    

            private Socket mySocket;
            private DataInputStream dataInput; //listen
            private PrintStream dataOutput;
            ActionEvent event;
            LoginBase loginBase;
            SignUpBase signupBase;
            Thread thread;
            static String idMsg;
            boolean work=true;
            //Stage stage;

    //Stage stage;
            
         
   public Clients(LoginBase loginBase,ActionEvent event)
   {
         

         this.event=event;
         this.loginBase=loginBase;
        try {
            mySocket=new Socket("127.0.0.1",5006);
            dataInput=new DataInputStream(mySocket.getInputStream()); //listen
            dataOutput=new PrintStream(mySocket.getOutputStream()); //talk
            //sendMessage("login.nada.nada");
            thread=new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        readMessage();
                    } catch (IOException ex) {
                        Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            
            });
            
           thread.start();  
        } catch (IOException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

              
   public void readMessage() throws IOException
   {
       
         //String serverMsg="";
        
            String serverMsg=dataInput.readLine();
             idMsg=serverMsg;
             System.out.println("Client Read:"+serverMsg);
             Platform.runLater(new Runnable() {
                 @Override
                 public void run() {
                     
                     
                     //System.out.println("Return "+returnVal);
                     if(!idMsg.equals("-1"))
                     {
                        System.out.println("Wasalt");
                        ScreenAdapter.setScreen(event, new players_listBase());
                     }
                     else
                     {
                        loginBase.pane.setVisible(true);
                        loginBase.labelError.setText("Incorrect Username or password");
                     }
                 }
             });
            
        //dataOutput.print(clientMsg);      
   }
   public void sendMessage(String clientMsg)
   {  	
       System.out.print("Client said: "+clientMsg);
       work=true;
       dataOutput.println(clientMsg);
       
   }
   public void logout(ActionEvent event) {
                try {
                    final String LOGOUT = "logout,";
                    String msg = LOGOUT + idMsg;
                    System.out.println(idMsg);
                    sendMessage(msg);
                    //thread.stop();
                    
                    //dataInput.close();
                    //dataOutput.close();
                   // mySocket.close();
                    
                    ScreenAdapter.setScreen(event, new OnlineAndOfflineBase());
                } catch (Exception ex) {
                    Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
}