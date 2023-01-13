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
     
     static HashMap<Integer,RequestHandler> clinetsHashMap = new HashMap<>(); 

    public RequestHandler(Socket s , Integer id) {
         try {
             
            ear = new DataInputStream(s.getInputStream());
            ps= new PrintStream(s.getOutputStream());
            RequestHandler.clinetsHashMap.put(id,this);
           
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
      public static void sendMessage(String msg , int competitorId, int senderId ) {
     
           clinetsHashMap.get(competitorId).ps.println(msg+","+senderId);
           
    }
      public static void removeOFflinePlayer(int senderId ) {
      
          //             clinetsHashMap.get(senderId).ear.close();
          clinetsHashMap.get(senderId).ps.close();
          clinetsHashMap.remove(senderId);
           
           
           
       
    }
         
}
