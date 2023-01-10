/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controlers;

 

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
            //Stage stage;


   public Clients(ActionEvent event)
   {

         this.event=event;
         this.loginBase=loginBase;
        try {
            mySocket=new Socket("127.0.0.1",5002);
            dataInput=new DataInputStream(mySocket.getInputStream()); //listen
            dataOutput=new PrintStream(mySocket.getOutputStream()); //talk
            //sendMessage("login.nada.nada");
            Thread thread=new Thread(new Runnable(){
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

         String serverMsg=" ";

            serverMsg=dataInput.readLine();
            final String message=serverMsg;
             System.out.println("Client Read: "+serverMsg);
             Platform.runLater(new Runnable() {
                 @Override
                 public void run() {
                     // System.out.println("Return "+returnVal);
                     if(message.equals("True"))
                     {
                        System.out.println("Wasalt");
                        ScreenAdapter.setScreen(event, new players_listBase());
                     }
                     /*else
                     {
                        loginBase.pane.setVisible(true);
                        loginBase.labelError.setText("Incorrect Username or password");
                     }*/
                 }
             });
        //dataOutput.print(clientMsg);      
   }
   public void sendMessage(String clientMsg)
   {      
       dataOutput.println(clientMsg);
   }

}