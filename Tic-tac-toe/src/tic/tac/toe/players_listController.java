/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author essam elden
 */
public class players_listController implements Initializable {
    
   @FXML
    private ListView<String>myListView;
    
    @FXML
    private Label myLabel;
   
    String selectedFood;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         String food[]={"pizza","pasta","cheken"};
        myListView.getItems().addAll(food);
        
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               selectedFood = myListView.getSelectionModel().getSelectedItem();
               myLabel.setText(selectedFood);
            }
            
        
        });
    }    
}
