/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controlers.DataAccessLayer;
import Controlers.MessageHandler;
import Controlers.ScreenAdapter;
import java.net.ServerSocket;
import javafx.application.Platform;
import javafx.event.ActionEvent;

/**
 *
 * @author HP
 */
public class ClientHandler extends Thread{

     ServerSocket serverSocket;
     Socket clientSocket;
     DataInputStream dataInput;//listen
     PrintStream dataOutput;//talk
     boolean serverIsOn=true;
     String clientMsg=" ";
     ActionEvent event;
     Thread thread;
     
   
    public ClientHandler() {
       // this.event=event;
         try {
             serverSocket= new ServerSocket(5006);
             
             // System.out.println(Platform.isFxApplicationThread());
             thread=new Thread(new Runnable()
             {
                 @Override
                 public void run() {
                    try {
                        while(serverIsOn)
                        {
                         clientSocket= serverSocket.accept();
                         dataInput=new DataInputStream(clientSocket.getInputStream());
                         dataOutput=new PrintStream(clientSocket.getOutputStream());
                         readMessage();
                        }
                        //sendMessage();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                 
             });
             
             thread.start();
             
         } catch (IOException ex) {
             Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
     public void readMessage() throws IOException
     {
        
             clientMsg=dataInput.readLine();
             System.out.println("Client said: "+clientMsg);
             
             
             Platform.runLater(new Runnable() {
                 @Override
                 public void run() {
                            //Hena hy7sal update lel UI eny 2a2ra no. of accounts....
                 }
             });
            

             
     }
     
    
}
