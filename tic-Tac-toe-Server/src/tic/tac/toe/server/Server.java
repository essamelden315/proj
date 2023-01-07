/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.server;

import Controlers.DataAccessLayer;
import Controlers.ScreenAdapter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

/**
 *
 * @author HP
 */
public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    boolean serverIsOn;
    ActionEvent event;
    ClientHandler client;
    
    public Server()
    {
        this.event=event;
        serverIsOn=true;
         try {
           // launch(args);
            serverSocket= new ServerSocket(5002);
            while(true)//3lshan me2flsh lma el client y2fl //hena hn-check lw el server Start?
            {
              clientSocket= serverSocket.accept();
              client=new ClientHandler(clientSocket);
              
            }
            
        } catch (IOException ex) {
            Logger.getLogger(TicTacToeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static String serverToDB(String clientMsg)
    {
           String[] dividedMsg=new String[3];
           int i=0;
           int j=0;
	   int x=0;
            String returnValueFromDB=null;
            while(x!=-1)
	   {
		 x=clientMsg.indexOf(".",i);
		 if(x>=0)
		 { 
                        dividedMsg[j]=clientMsg.substring(i,x);
			i=x+1;
                        j++;     
		 }	
	        }
		if(x==-1)
		{
			x=clientMsg.length();
                        dividedMsg[j]=clientMsg.substring(i,x);
		}
             if((dividedMsg[0].equals("login")))
             {
               try {
                   if(DataAccessLayer.check(dividedMsg[1], dividedMsg[2], "192.21.21")!=-1){
                       returnValueFromDB="True";
                   }
                   else{
                   returnValueFromDB="False";
                   }
                   System.out.println(returnValueFromDB);
               } catch (Exception ex) {
                   Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
               }
             } else {
             }
             //System.out.println("I'm in returnValueFromDB"+returnValueFromDB);
             return returnValueFromDB;
    }
}
