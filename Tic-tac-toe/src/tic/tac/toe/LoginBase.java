package tic.tac.toe;


import Controlers.Clients;
import Controlers.ScreenAdapter;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
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
import Controlers.SendMessage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoginBase extends AnchorPane {

    protected final Button btnlogin;
    protected final TextField txtusername;
    protected final Button signupscreen;
    protected final Text text;
    protected final Text text0;
    public final PasswordField txtpw;
    public final Pane pane;
    protected final FlowPane flowPane;
    protected final ImageView imgError;
    public final Label labelError;
    protected final Button btnBack;
    Clients client;

   
   /* Socket socket;
    DataInputStream ear;
    PrintStream mouth;
    String email , pass;
    int a;*/

    public LoginBase() {
        
        btnlogin = new Button();
        txtusername = new TextField();
        signupscreen = new Button();
        text = new Text();
        text0 = new Text();
        txtpw = new PasswordField();
        pane = new Pane();
        flowPane = new FlowPane();
        imgError = new ImageView();
        labelError = new Label();
        btnBack = new Button();
        
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");
        getStylesheets().add("/css/GameStyle.css");
 
        pane.setVisible(false);
        btnlogin.setLayoutX(260.0);
        btnlogin.setLayoutY(326.0);
        btnlogin.setMnemonicParsing(false);
        btnlogin.getStyleClass().add("blueBtn");
        btnlogin.getStylesheets().add("/css/GameStyle.css");
        btnlogin.setText("Login");
        btnlogin.setOnAction((event)->{
            if(txtusername.getText().trim().isEmpty() || txtpw.getText().trim().isEmpty() )
            {
                 labelError.setText("Enter Your Username and Password");
                 pane.setVisible(true);
            }
            
            else{
            String userNameMessage= txtusername.getText();
            String passwordMessage= txtpw.getText();
            String loginMessage="login,";
            loginMessage+=userNameMessage+","+passwordMessage;
            System.out.println("Button: "+loginMessage);
           // SendMessage.login(userNameMessage, passwordMessage);
             //   System.out.println(SendMessage.getAnswer());
            client=new Clients("login",event);
            client.setLoginBase(this);
            client.sendMessage(loginMessage);
            // ScreenAdapter.setScreen(event, new players_listBase());
            }
        });

        txtusername.setAlignment(javafx.geometry.Pos.CENTER);
        txtusername.setLayoutX(260.0);
        txtusername.setLayoutY(112.0);
        txtusername.setOpacity(0.74);
        txtusername.setPromptText("Enter Username");
        txtusername.getStyleClass().add("text-field");
        txtusername.getStylesheets().add("/css/GameStyle.css");

        signupscreen.setLayoutX(413.0);
        signupscreen.setLayoutY(414.0);
        signupscreen.setMnemonicParsing(false);
        signupscreen.setPrefHeight(51.0);
        signupscreen.setPrefWidth(140.0);
        signupscreen.getStyleClass().add("anotherScreen");
        signupscreen.getStylesheets().add("/css/GameStyle.css");
        signupscreen.setText("Sign Up");
        signupscreen.setTextFill(javafx.scene.paint.Color.valueOf("#66ccff"));
        signupscreen.setOnAction((event)->{
         ScreenAdapter.setScreen(event, new SignUpBase());
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
        txtpw.getStylesheets().add("/css/GameStyle.css");
        
        pane.setLayoutX(300.0);
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
        
        btnBack.setLayoutX(630.0);
        btnBack.setLayoutY(382.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(60.0);
        btnBack.setPrefWidth(93.0);
        btnBack.getStyleClass().add("backBtn");
        btnBack.getStylesheets().add("/css/GameStyle.css");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#000000ca"));
        btnBack.setFont(new Font("System Bold Italic", 10.0));
        getStylesheets().add("/css/GameStyle.css");
        btnBack.setOnAction((ActionEvent event) -> {
            ScreenAdapter.setScreen(event, new OnlineAndOfflineBase());
        });
        
        getChildren().add(btnlogin);
        getChildren().add(txtusername);
        getChildren().add(signupscreen);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(txtpw);
        getChildren().add(btnBack);
        flowPane.getChildren().add(imgError);
        flowPane.getChildren().add(labelError);
        pane.getChildren().add(flowPane);
        getChildren().add(pane);

    }


}
