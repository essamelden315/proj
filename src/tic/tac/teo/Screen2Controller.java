/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.teo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author essam elden
 */
public class Screen2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void returnhandleButtonAction(ActionEvent event) throws IOException {
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        players_listBase root = new players_listBase(stage);
        Scene  scene= new Scene(root);       
        stage.setScene(scene);
        stage.show();
    }
}
