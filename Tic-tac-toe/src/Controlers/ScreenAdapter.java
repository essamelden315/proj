/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import com.sun.javafx.scene.control.skin.Utils;
import java.awt.Event;
import java.util.EventObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class ScreenAdapter {

 
    
    public static void setScreen(EventObject event , Parent root ) {
            
             Scene scene = new Scene(root);
                 Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                 stage.setScene(scene);
                 stage.show();
    
    
    
    }
    
}
