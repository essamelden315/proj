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
import Controlers.ScreenAdapter;
import javafx.application.Platform;
import javafx.event.ActionEvent;

/**
 *
 * @author HP
 */
public class ClientHandler extends Thread{

     Socket clientSocket;
     DataInputStream dataInput;//listen
     PrintStream dataOutput;//talk
     boolean serverIsOn;
     String clientMsg=" ";
     ActionEvent event;
     Thread thread;
     
   
    public ClientHandler(Socket socket) {
        this.event=event;
         try {
             serverIsOn=true;
             clientSocket=socket;
             dataInput=new DataInputStream(clientSocket.getInputStream());
             dataOutput=new PrintStream(clientSocket.getOutputStream());
             // System.out.println(Platform.isFxApplicationThread());
             thread=new Thread(new Runnable()
             {
                 @Override
                 public void run() {
                    try {
                        readMessage();
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
                   sendMessage();
                 }
             });
             /*while((clientMsg=dataInput.readLine())!=" ")
             {
                 Platform.runLater(new Runnable() {
                 @Override
                 public void run() {
                    // ScreenAdapter.setScreen(event, new FXMLDocumentBase());
                   //updat ui
                 }
             });
             }*/
                
     }
     
     public void sendMessage()
     {
          String returnDatabase=" ";
         returnDatabase=Server.serverToDB(clientMsg);
         System.out.println("returnDatabase"+returnDatabase);
         if(returnDatabase.equals("True"))
         {
             dataOutput.println("True");
         }
         else
         {
             dataOutput.println("False");
         }
             
     }
}
