package tic.tac.toe;

<<<<<<< HEAD
=======
import Controlers.ScreenAdapter;
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUpBase extends AnchorPane {

    protected final TextField txtusername;
    protected final TextField txtemail;
    protected final Button btnsignup;
    protected final Button loginscreen;
    protected final Text text;
    protected final PasswordField txtpw;

    public SignUpBase() {

        txtusername = new TextField();
        txtemail = new TextField();
        btnsignup = new Button();
        loginscreen = new Button();
        text = new Text();
        txtpw = new PasswordField();

        setId("AnchorPane");
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");
<<<<<<< HEAD
        getStylesheets().add("/CssStyle/GameStyle.css");
=======
        getStylesheets().add("/css/GameStyle.css");
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        txtusername.setAlignment(javafx.geometry.Pos.CENTER);
        txtusername.setLayoutX(250.0);
        txtusername.setLayoutY(39.0);
        txtusername.setOpacity(0.74);
        txtusername.setPromptText("Enter Username");
        txtusername.getStyleClass().add("text-signup");
<<<<<<< HEAD
        txtusername.getStylesheets().add("/CssStyle/GameStyle.css");
=======
        txtusername.getStylesheets().add("/css/GameStyle.css");
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        txtemail.setLayoutX(250.0);
        txtemail.setLayoutY(123.0);
        txtemail.setOpacity(0.74);
        txtemail.setPromptText("Email");
        txtemail.setStyle("-fx-alignment: center; -fx-font: #000000;");
        txtemail.getStyleClass().add("text-signup");
<<<<<<< HEAD
        txtemail.getStylesheets().add("/CssStyle/GameStyle.css");
=======
        txtemail.getStylesheets().add("/css/GameStyle.css");
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        btnsignup.setLayoutX(250.0);
        btnsignup.setLayoutY(329.0);
        btnsignup.setMnemonicParsing(false);
        btnsignup.getStyleClass().add("blueBtn");
<<<<<<< HEAD
        btnsignup.getStylesheets().add("/CssStyle/GameStyle.css");
        btnsignup.setText("Sign Up");
=======
        btnsignup.getStylesheets().add("/css/GameStyle.css");
        btnsignup.setText("Sign Up");
        btnsignup.setOnAction((event)->{
         ScreenAdapter.setScreen(event, new players_listBase());
        });
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        loginscreen.setLayoutX(360.0);
        loginscreen.setLayoutY(422.0);
        loginscreen.setMnemonicParsing(false);
        loginscreen.setPrefHeight(51.0);
        loginscreen.setPrefWidth(140.0);
        loginscreen.getStyleClass().add("anotherScreen");
<<<<<<< HEAD
        loginscreen.getStylesheets().add("/CssStyle/GameStyle.css");
        loginscreen.setText("Login");
        loginscreen.setTextFill(javafx.scene.paint.Color.valueOf("#66ccff"));
        loginscreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                    Scene scene = new Scene (root);
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
=======
        loginscreen.getStylesheets().add("/css/GameStyle.css");
        loginscreen.setText("Login");
        loginscreen.setTextFill(javafx.scene.paint.Color.valueOf("#66ccff"));
        loginscreen.setOnAction((event)->{
         ScreenAdapter.setScreen(event, new LoginBase());
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512
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
<<<<<<< HEAD
        txtpw.getStylesheets().add("/CssStyle/GameStyle.css");
=======
        txtpw.getStylesheets().add("/css/GameStyle.css");
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        getChildren().add(txtusername);
        getChildren().add(txtemail);
        getChildren().add(btnsignup);
        getChildren().add(loginscreen);
        getChildren().add(text);
        getChildren().add(txtpw);

    }

}
