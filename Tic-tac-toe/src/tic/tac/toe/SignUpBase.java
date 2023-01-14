package tic.tac.toe;

import Controlers.Clients;
import Controlers.ScreenAdapter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SignUpBase extends AnchorPane {

    protected final TextField txtusername;
    protected final TextField txtemail;
    protected final Button btnsignup;
    protected final Button loginscreen;
    protected final Text text;
    protected final PasswordField txtpw;
    public final Pane pane;
    protected final FlowPane flowPane;
    protected final ImageView imgError;
    public final Label labelError;
    Clients client;

    public SignUpBase() {

        txtusername = new TextField();
        txtemail = new TextField();
        btnsignup = new Button();
        loginscreen = new Button();
        text = new Text();
        txtpw = new PasswordField();
        pane = new Pane();
       labelError = new Label();
        flowPane = new FlowPane();
        imgError = new ImageView();
        
         
        setId("AnchorPane");
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");
        getStylesheets().add("/css/GameStyle.css");

        txtusername.setAlignment(javafx.geometry.Pos.CENTER);
        txtusername.setLayoutX(250.0);
        txtusername.setLayoutY(39.0);
        txtusername.setOpacity(0.74);
        txtusername.setPromptText("Enter Username");
        txtusername.getStyleClass().add("text-signup");
        txtusername.getStylesheets().add("/css/GameStyle.css");

        txtemail.setLayoutX(250.0);
        txtemail.setLayoutY(123.0);
        txtemail.setOpacity(0.74);
        txtemail.setPromptText("Email");
        txtemail.setStyle("-fx-alignment: center; ");
        txtemail.getStyleClass().add("text-signup");
        txtemail.getStylesheets().add("/css/GameStyle.css");
        
        
        pane.setVisible(false);
        btnsignup.setLayoutX(250.0);
        btnsignup.setLayoutY(329.0);
        btnsignup.setMnemonicParsing(false);
        btnsignup.getStyleClass().add("blueBtn");
        btnsignup.getStylesheets().add("/css/GameStyle.css");
        btnsignup.setText("Sign Up");
        btnsignup.setOnAction((event)->{
                           
        String userName=txtusername.getText();
        String email=txtemail.getText();
        String pass=txtpw.getText();
        Window owner =btnsignup.getScene().getWindow();
        
        System.out.println(userName);
        System.out.println(email);
        System.out.println(pass);
        ///if empty or has special chars.
        if (userName.isEmpty()|| (!userName.matches("^[a-zA-Z0-9_]*$"))) {
            /*showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;*/

             labelError.setText("Please Enter Username used(a-zA-Z0-9)");
             pane.setVisible(true);
        }
         

        else if (email.isEmpty()) {
            labelError.setText("Please Enter Email");
             pane.setVisible(true);
          
        }
        else if (pass.isEmpty()|| (!pass.matches("^[a-zA-Z0-9_]*$"))) {
            labelError.setText("Please Enter Password used(a-zA-Z0-9)");
             pane.setVisible(true);
          
           
        }

        else if  (!email.matches("^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{1,6}$")){
            labelError.setText("Please Enter a valid e mail");
                pane.setVisible(true);
        }

        else{
            String msg;
            msg= "signup,";
            msg+= userName+","+email+","+pass;
            client = new Clients ("signup",event);
            client.setSignupBase(this);
            client.sendMessage(msg);
            
        }
        });

        loginscreen.setLayoutX(360.0);
        loginscreen.setLayoutY(422.0);
        loginscreen.setMnemonicParsing(false);
        loginscreen.setPrefHeight(51.0);
        loginscreen.setPrefWidth(140.0);
        loginscreen.getStyleClass().add("anotherScreen");
        loginscreen.getStylesheets().add("/css/GameStyle.css");
        loginscreen.setText("Login");
        loginscreen.setTextFill(javafx.scene.paint.Color.valueOf("#66ccff"));
        loginscreen.setOnAction((event)->{
         ScreenAdapter.setScreen(event, new LoginBase());
        });

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(299.0);
        text.setLayoutY(453.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Have account?");
        text.setWrappingWidth(97.6708984375);

        txtpw.setAlignment(javafx.geometry.Pos.CENTER);
        txtpw.setLayoutX(250.0);
        txtpw.setLayoutY(209.0);
        txtpw.setOpacity(0.74);
        txtpw.setPromptText("Enter password");
        txtpw.getStyleClass().add("text-signup");
        txtpw.getStylesheets().add("/css/GameStyle.css");
        
        pane.setLayoutX(280.0);
        pane.setLayoutY(275.0);
        pane.setPrefHeight(51.0);
        pane.setPrefWidth(435.0);

        flowPane.setLayoutY(-4.0);
        flowPane.setPrefHeight(52.0);
        flowPane.setPrefWidth(435.0);

        imgError.setFitHeight(20.0);
        imgError.setFitWidth(20.0);
        imgError.setPickOnBounds(true);
        imgError.setPreserveRatio(true);
        imgError.setImage(new Image(getClass().getResource("/images/error.png").toExternalForm()));

        labelError.setPrefHeight(33.0);
        labelError.setPrefWidth(401.0);
        labelError.setTextFill(javafx.scene.paint.Color.valueOf("#f70012"));
        labelError.setFont(new Font("System Bold", 14.0));
        

        getChildren().add(txtusername);
        getChildren().add(txtemail);
        getChildren().add(btnsignup);
        getChildren().add(loginscreen);
        getChildren().add(text);
        getChildren().add(txtpw);
        flowPane.getChildren().add(imgError);
        flowPane.getChildren().add(labelError);
        pane.getChildren().add(flowPane);
        getChildren().add(pane);
        

    }
       /* private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }*/

}
