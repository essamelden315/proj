/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class StartServer {
    ServerSocket serverSocket;
     Thread thread ;
     boolean isStart;
    public StartServer() {
        isStart=true;
        MessageHandler.isStarted=true;
        
         thread = new Thread(()->{
            try {
                serverSocket = new ServerSocket(5006);
                while(isStart)
                {
                    
                        Socket s = serverSocket.accept();
                        new MessageHandler(s);
                    
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         
        
        
        });
        thread.start();
    }
    public void stopConnection() {

        try {
             MessageHandler.isStarted=false;
            isStart=false;
             
            serverSocket.close();
            thread.stop();
        } catch (IOException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
