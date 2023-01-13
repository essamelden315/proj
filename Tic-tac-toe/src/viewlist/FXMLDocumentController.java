/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewlist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author essam elden
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ListView<String>myListView;
    
    @FXML
    private Label myLabel;
    String food[]={"pizza","pasta","cheken"};
    String selectedFood;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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

