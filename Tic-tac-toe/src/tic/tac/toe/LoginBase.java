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

public class LoginBase extends AnchorPane {

    protected final Button btnlogin;
    protected final TextField txtusername;
    protected final Button signupscreen;
    protected final Text text;
    protected final Text text0;
    protected final PasswordField txtpw;

<<<<<<< HEAD
    public LoginBase(Stage stage) {
=======
    public LoginBase() {
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        btnlogin = new Button();
        txtusername = new TextField();
        signupscreen = new Button();
        text = new Text();
        text0 = new Text();
        txtpw = new PasswordField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");
<<<<<<< HEAD
        getStylesheets().add("/CssStyle/GameStyle.css");
=======
        getStylesheets().add("/css/GameStyle.css");
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        btnlogin.setLayoutX(260.0);
        btnlogin.setLayoutY(326.0);
        btnlogin.setMnemonicParsing(false);
        btnlogin.getStyleClass().add("blueBtn");
<<<<<<< HEAD
        btnlogin.getStylesheets().add("/CssStyle/GameStyle.css");
        btnlogin.setText("Login");
=======
        btnlogin.getStylesheets().add("/css/GameStyle.css");
        btnlogin.setText("Login");
        btnlogin.setOnAction((event)->{
         ScreenAdapter.setScreen(event, new players_listBase());
        });
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        txtusername.setAlignment(javafx.geometry.Pos.CENTER);
        txtusername.setLayoutX(260.0);
        txtusername.setLayoutY(112.0);
        txtusername.setOpacity(0.74);
        txtusername.setPromptText("Enter Username");
        txtusername.getStyleClass().add("text-field");
<<<<<<< HEAD
        txtusername.getStylesheets().add("/CssStyle/GameStyle.css");
=======
        txtusername.getStylesheets().add("/css/GameStyle.css");
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        signupscreen.setLayoutX(413.0);
        signupscreen.setLayoutY(414.0);
        signupscreen.setMnemonicParsing(false);
        signupscreen.setPrefHeight(51.0);
        signupscreen.setPrefWidth(140.0);
        signupscreen.getStyleClass().add("anotherScreen");
<<<<<<< HEAD
        signupscreen.getStylesheets().add("/CssStyle/GameStyle.css");
        signupscreen.setText("Sign Up");
        signupscreen.setTextFill(javafx.scene.paint.Color.valueOf("#66ccff"));
        signupscreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                    Scene scene = new Scene (root);
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
=======
        signupscreen.getStylesheets().add("/css/GameStyle.css");
        signupscreen.setText("Sign Up");
        signupscreen.setTextFill(javafx.scene.paint.Color.valueOf("#66ccff"));
        signupscreen.setOnAction((event)->{
         ScreenAdapter.setScreen(event, new SignUpBase());
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512
        });

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(305.0);
        text.setLayoutY(445.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Don't have account?");
        text.setWrappingWidth(139.6708984375);

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setLayoutX(322.0);
        text0.setLayoutY(73.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setStyle("-fx-font-size: 30;");
        text0.getStyleClass().add("text-signup");
        text0.setText("LOGIN");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(168.6708984375);

        txtpw.setAlignment(javafx.geometry.Pos.CENTER);
        txtpw.setLayoutX(260.0);
        txtpw.setLayoutY(209.0);
        txtpw.setOpacity(0.74);
        txtpw.setPromptText("Enter password");
        txtpw.getStyleClass().add("text-field");
<<<<<<< HEAD
        txtpw.getStylesheets().add("/CssStyle/GameStyle.css");
=======
        txtpw.getStylesheets().add("/css/GameStyle.css");
>>>>>>> fc5b41bbff7c104c9177be76f97f37b7a7b66512

        getChildren().add(btnlogin);
        getChildren().add(txtusername);
        getChildren().add(signupscreen);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(txtpw);

    }


}
