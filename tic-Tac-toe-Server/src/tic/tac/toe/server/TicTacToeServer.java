/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.server;

import java.sql.SQLException;
import java.util.ArrayList;
import tic.tac.toe.server.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Controlers.*;
/**
 *
 * @author User
 */
public class TicTacToeServer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {        
       /* String ip=new String();
        ip=DataAccessLayer.SearchbyIP(3);
        System.out.println(ip);*/
        Parent root =new FXMLDocumentBase();  
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe Server ");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //launch(args);
        ArrayList<Player> online=new ArrayList<>();
        online=DataAccessLayer.retrieveOnlineList();
        for(int i=0;i<online.size();i++)
        {
            System.out.println("ID: "+online.get(i).getID());
            System.out.println("Name: "+online.get(i).getName());
        }
    }
    
   
}
