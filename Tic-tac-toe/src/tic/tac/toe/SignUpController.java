/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import Controlers.Clients;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author LapStore
 */
public class SignUpController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void anotherScreenButtonAction(ActionEvent event) throws Exception
    {
        /*Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = new LoginBase();
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.show();*/
    }

    @FXML
    private TextField txtusername;
     @FXML
    private TextField txtemail;
     @FXML
    private PasswordField txtpw;
     @FXML
    private Button btnsignup; 
     
    private Clients client;
     
    @FXML
    public void register(ActionEvent event) throws SQLException, IOException {
            
        Window owner = btnsignup.getScene().getWindow();

        System.out.println(txtusername.getText());
        System.out.println(txtemail.getText());
        System.out.println(txtpw.getText());
        ///if empty or has special chars.
        if (txtusername.getText().isEmpty()|| (!txtusername.getText().matches("^[a-zA-Z0-9_]*$"))) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }

        else if (txtemail.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your email id");
            return;
        }
        else if (txtpw.getText().isEmpty()|| (!txtpw.getText().matches("^[a-zA-Z0-9_]*$"))) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
           
        }
        else if  (!txtemail.getText().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a correct email");}
        else{
            String msg;
            msg= "signup,";
            msg+= txtusername.getText()+","+txtemail.getText()+","+txtpw.getText();
            client = new Clients (null,event);
            client.sendMessage(msg);
            
        }
        

   
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    private boolean IsMatch(String text, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}