/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import Model.Player;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import tic.tac.toe.LoginBase;
import tic.tac.toe.OnlineAndOfflineBase;
import tic.tac.toe.SignUpBase;
import tic.tac.toe.players_listBase;

/**
 *
 * @author HP
 */
public class Clients extends Thread {

    private Socket mySocket;
    private DataInputStream dataInput; //listen
    private PrintStream dataOutput;
    ActionEvent event;
    private LoginBase loginBase;
    private SignUpBase signupBase;
    private players_listBase playerListBase;
    Thread thread;
    static String idMsg;
    String fromPage;
    boolean work = true;
   
    //Stage stage;

    public void setLoginBase(LoginBase loginBase) {
        this.loginBase = loginBase;
    }

    public void setSignupBase(SignUpBase signupBase) {
        this.signupBase = signupBase;
    }

    public void setPlayerListBase(players_listBase playerListBase) {
        this.playerListBase = playerListBase;
    }

    //Stage stage;
    public Clients(String fromPage, ActionEvent event) {
        System.out.println("page"+fromPage);
        this.event = event;
        this.fromPage=fromPage;
        try {
            mySocket = new Socket("127.0.0.1", 5006);
            dataInput = new DataInputStream(mySocket.getInputStream()); //listen
            dataOutput = new PrintStream(mySocket.getOutputStream()); //talk
            //sendMessage("login.nada.nada");
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                       if(fromPage.equals("show"))
                       {
                          readMessageObject(); 
                       }
                       else{
                           readMessage(); 
                       }
                    } catch (IOException ex) {
                        Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });

            thread.start();
        } catch (IOException ex) {
            
                 JOptionPane.showMessageDialog(null, "Check your connection");
                
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readMessage() throws IOException {

        //String serverMsg="";
        String serverMsg = dataInput.readLine();
        idMsg = serverMsg;
        System.out.println("Client Read:" + serverMsg);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                 if(idMsg.equals("0")){
                    ScreenAdapter.setScreen(event, new LoginBase());
                }
                 else if(idMsg.equals("-12"))
                 {
                    signupBase.pane.setVisible(true);
                    signupBase.labelError.setText("Email is Invalid");
                 }
                //System.out.println("Return "+returnVal);
                else if (!idMsg.equals("-1")) {
                    System.out.println("Wasalt");
                    ScreenAdapter.setScreen(event, new players_listBase());
                }
                else if(idMsg.equals("-1")){
                    loginBase.pane.setVisible(true);
                    loginBase.labelError.setText("Incorrect Username or password");
                }
            }
        });

        //dataOutput.print(clientMsg);      
    }
     public void readMessageObject() throws IOException, ClassNotFoundException
   {
       
            ArrayList<Player> players = new ArrayList<>();
            ObjectInputStream inStream= new ObjectInputStream(mySocket.getInputStream());;
            players=(ArrayList<Player>) inStream.readObject();
            String name[]=new String[players.size()];
            System.out.println("OnlineObject");
             for(int i=0;i<players.size();i++){
              name[i]= players.get(i).getName();
             }
             Platform.runLater(new Runnable() {
                 @Override
                 public void run() {
                     // System.out.println("Return "+returnVal)
                        System.out.println("Wasalt");
                       // ScreenAdapter.setScreen(event, );
                       
                       playerListBase.myListView.getItems().addAll(name);
                    
                 }
             });
        //dataOutput.print(clientMsg);      
   }

    public void sendMessage(String clientMsg) {
        System.out.println(idMsg);
       
        //System.out.print("Client said: " + clientMsg+idMsg);
        if(fromPage.equals("show"))
        {
             String sendMsg= clientMsg+idMsg;
             dataOutput.println(sendMsg);
        }
        else{
             dataOutput.println(clientMsg);
        }
        

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

    /*public void showPlayers() {
        ObjectInputStream inStream = null;
        try {
            ArrayList<Player> players = new ArrayList<>();
            inStream = new ObjectInputStream(mySocket.getInputStream());
            players = (ArrayList<Player>) inStream.readObject();
            String name[] = new String[players.size()];
            for (int i = 0; i < players.size(); i++) {
                name[i] = players.get(i).getName();
            }   Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    // System.out.println("Return "+returnVal)
                    System.out.println("Wasalt");
                    // ScreenAdapter.setScreen(event, );
                    
                    playerList.myListView.getItems().addAll(name);
                    
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                inStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }*/
   
}

