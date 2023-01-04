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
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author User
 */
public class RequestHandler {
     DataInputStream ear ;
    PrintStream ps;
     Integer id;
     
     // key for id of user and request to make a connection 
     static HashMap<Integer,RequestHandler> clinetsVector = new HashMap<>(); 


    public RequestHandler(Socket s , Integer id) {
         try {
             
            ear = new DataInputStream(s.getInputStream());
            ps= new PrintStream(s.getOutputStream());
           
            RequestHandler.clinetsVector.put(id,this);
           
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
      private void sendMessage(String msg , int ClinetId ) {
      
           clinetsVector.get(ClinetId).ps.println(msg);
       
    }
     
}
