package tic.tac.toe.server;

import Controlers.ScreenAdapter;
<<<<<<< HEAD
import java.net.ServerSocket;
=======
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLDocumentBase extends AnchorPane {

    protected final Button btnStart;
    protected final Label label;
    protected final Bloom bloom;
    private ServerSocket serverSocket;
<<<<<<< HEAD

=======
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1
    public FXMLDocumentBase() {

        btnStart = new Button();
        label = new Label();
        bloom = new Bloom();

        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1133.0);
        getStyleClass().add("background");

        btnStart.setLayoutX(420.0);
        btnStart.setLayoutY(346.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(60.0);
        btnStart.setPrefWidth(364.0);
        btnStart.getStyleClass().add("blueBtn");
        btnStart.getStylesheets().add("/css/GameStyle.css");
        btnStart.setText("strart");
        btnStart.setTextFill(javafx.scene.paint.Color.valueOf("#000000ca"));
        btnStart.setFont(new Font("System Bold Italic", 10.0));
 

        label.setLayoutX(261.0);
        label.setLayoutY(69.0);
        label.setPrefHeight(220.0);
        label.setPrefWidth(611.0);
        label.getStyleClass().add("logo");
        label.getStylesheets().add("/css/GameStyle.css");
        label.setText("Tic-tac-toe Server controler ");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setWrapText(true);
        label.setFont(new Font("System Bold Italic", 72.0));

        label.setEffect(bloom);
        getStylesheets().add("css/GameStyle.css");

        getChildren().add(btnStart);
        getChildren().add(label);
<<<<<<< HEAD
        btnStart.setOnAction((event) -> {

            ScreenAdapter.setScreen(event, new serverControlPanalBase());

=======
        btnStart.setOnAction((event)->{
              ScreenAdapter.setScreen(event, new serverControlPanalBase());
        try {
            serverSocket = new ServerSocket(5006);
            while(true)
            {
                Socket s = serverSocket.accept();
                System.out.println(s.getInetAddress());
                new MessageHandler(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1
        });

    }
}
