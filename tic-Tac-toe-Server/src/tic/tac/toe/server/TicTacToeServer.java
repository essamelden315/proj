/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.server;

<<<<<<< HEAD



=======
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author User
 */
public class TicTacToeServer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {  
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

    public static void main(String[] args) {
<<<<<<< HEAD

       launch(args);  
      //new Server();
    }
    


=======
        launch(args);
        
    }
   

    
    void sendMessageToAll(String msg)
    {
        /*for(int i=0 ; i<clientsVector.size() ; i++)
        {
            clientsVector.get(i).prints.println(msg);
        }*/

    }
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1
}
