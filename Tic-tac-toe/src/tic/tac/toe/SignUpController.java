/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import Controlers.Clients;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SignUpController implements Initializable {

    @FXML
    private AnchorPane background;
    @FXML
    private TextField txtusername;
    @FXML
    private TextField txtemail;
    @FXML
    private Button btnsignup;
    @FXML
    private Button loginscreen;
    @FXML
    private PasswordField txtpw;
    
    private Clients client;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void register(ActionEvent event) {
               
        String userName=txtusername.getText();
        String email=txtemail.getText();
        String pass=txtpw.getText();
        Window owner =btnsignup.getScene().getWindow();
        
        System.out.println(userName);
        System.out.println(email);
        System.out.println(pass);
        ///if empty or has special chars.
        if (userName.isEmpty()|| (!userName.matches("^[a-zA-Z0-9_]*$"))) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }

        else if (email.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your email id");
            return;
        }
        else if (pass.isEmpty()|| (!pass.matches("^[a-zA-Z0-9_]*$"))) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
           
        }
        else if  (!email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Ana fl controller");}
        else{
            String msg;
            msg= "signup,";
            msg+= userName+","+email+","+pass;
            client = new Clients (null,event);
            client.sendMessage(msg);
            
        }
        

    }

    @FXML
    private void anotherScreenButtonAction(ActionEvent event) {
          /*Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = new LoginBase();
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.show();*/
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

    

    
