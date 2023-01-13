package tic.tac.toe;

import Model.Player;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;

 /*public class ShowPlayers extends Thread{
    
            private Socket mySocket;
            private DataInputStream dataInput; //listen
            private PrintStream dataOutput;
            ActionEvent event;
            LoginBase loginBase;
            players_listBase playerList;
            //Stage stage;
            
         
   public ShowPlayers(players_listBase playerList)
   {
         
         this.event=event;
         this.playerList=playerList;
        try {
            mySocket=new Socket("127.0.0.1",5006);
            dataInput=new DataInputStream(mySocket.getInputStream()); //listen
            dataOutput=new PrintStream(mySocket.getOutputStream()); //talk
            //sendMessage("login.nada.nada");
            sendMessage();
            Thread thread=new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        readMessage();
                    } catch (Exception ex) {
                       ex.printStackTrace();
                    }
                }
            
            });
            
           thread.start();  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
   }
              
          
   public void readMessage() throws IOException, ClassNotFoundException
   {
       
            ArrayList<Player> players = new ArrayList<>();
            ObjectInputStream inStream= new ObjectInputStream(mySocket.getInputStream());;
            players=(ArrayList<Player>) inStream.readObject();
            String name[]=new String[players.size()];
             for(int i=0;i<players.size();i++){
              name[i]= players.get(i).getName();
             }
             Platform.runLater(new Runnable() {
                 @Override
                 public void run() {
                     // System.out.println("Return "+returnVal)
                        System.out.println("Wasalt");
                       // ScreenAdapter.setScreen(event, );
                       
                       playerList.myListView.getItems().addAll(name);
                    
                 }
             });
        //dataOutput.print(clientMsg);      
   }
   public void sendMessage()
   {   String msg ="show,1";
       dataOutput.println(msg);
   }
    
}*/