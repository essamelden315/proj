package tic.tac.toe;
import Model.Player;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

 public class ShowPlayers extends Thread{
    
            private Socket mySocket;
            private DataInputStream dataInput; //listen
            private PrintStream dataOutput;
            ActionEvent event;
            LoginBase loginBase;
            players_listBase playerList;
            //ArrayList<Player> players ;
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
       
           playerList. players = new ArrayList<>();
            ObjectInputStream inStream= new ObjectInputStream(mySocket.getInputStream());
            
            playerList.players=(ArrayList<Player>) inStream.readObject();
            
            String name[]=new String[playerList.players.size()];
            
             for(int i=0;i<playerList.players.size();i++){
              name[i]= playerList.players.get(i).getName();
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
   

   }
   
    
