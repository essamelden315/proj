package tic.tac.toe.server;

import Controlers.DataAccessLayer;
import static Controlers.DataAccessLayer.retrieveOnlineList;
import Controlers.MessageHandler;
import Controlers.ScreenAdapter;
import Controlers.StartServer;
import Model.Player;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tic.tac.toe.server.ClientHandler.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class serverControlPanalBase extends AnchorPane {

    protected final Button btnStop;
    protected final Label label;
    protected final Bloom bloom;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Text text;
    protected final Text text0;
    protected final Text txtAccountNo;
    protected final Text txtOnlinePlayers;
    protected final Text txtGamesPlayed;
    protected final Text txtAccountNo0;
    MessageHandler client;
    StartServer sv; 
    int id;
    ArrayList <Player> onlineplayers = new ArrayList<Player>(); 
    
    

    public serverControlPanalBase() {
         sv = new StartServer();
        btnStop = new Button();
        label = new Label();
        bloom = new Bloom();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        text = new Text();
        text0 = new Text();
        txtAccountNo = new Text();
        txtOnlinePlayers = new Text();
        txtGamesPlayed = new Text();
        txtAccountNo0 = new Text();
        try {
            //client=new MessageHandler();
            onlineplayers = DataAccessLayer.retrieveOnlineList(id);
        } catch (SQLException ex) {
            Logger.getLogger(serverControlPanalBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(serverControlPanalBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // server= new Server();

        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1133.0);
        getStyleClass().add("background");

        btnStop.setLayoutX(420.0);
        btnStop.setLayoutY(654.0);
        btnStop.setMnemonicParsing(false);
        btnStop.setPrefHeight(60.0);
        btnStop.setPrefWidth(364.0);
        btnStop.getStyleClass().add("pinkbtn");
        btnStop.getStylesheets().add("/css/GameStyle.css");
        btnStop.setText("Stop");
        btnStop.setTextFill(javafx.scene.paint.Color.valueOf("#000000ca"));
        btnStop.setFont(new Font("System Bold Italic", 10.0));

        label.setLayoutX(261.0);
        label.setLayoutY(66.0);
        label.setPrefHeight(220.0);
        label.setPrefWidth(611.0);
        label.getStyleClass().add("logo");
        label.getStylesheets().add("/css/GameStyle.css");
        label.setText("Tic-tac-toe Server controler ");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setWrapText(true);
        label.setFont(new Font("System Bold Italic", 72.0));

        label.setEffect(bloom);

        gridPane.setLayoutX(200.0);
        gridPane.setLayoutY(306.0);
        gridPane.setPrefHeight(235.0);
        gridPane.setPrefWidth(1007.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(498.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(309.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(877.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(698.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Online Players :");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(244.8525390625);
        text.setFont(new Font("System Bold Italic", 25.0));

        GridPane.setRowIndex(text0, 1);
        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        //text0.setText("No of Played Games :");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(279.8525390625);
        text0.setFont(new Font("System Bold Italic", 25.0));

        GridPane.setRowIndex(txtAccountNo, 2);
        txtAccountNo.setFill(javafx.scene.paint.Color.WHITE);
        txtAccountNo.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtAccountNo.setStrokeWidth(0.0);
        txtAccountNo.setText("No of Accounts  :");
        txtAccountNo.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        txtAccountNo.setWrappingWidth(279.8525390625);
        txtAccountNo.setFont(new Font("System Bold Italic", 25.0));

        GridPane.setColumnIndex(txtOnlinePlayers, 1);
        txtOnlinePlayers.setFill(javafx.scene.paint.Color.WHITE);
        txtOnlinePlayers.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtOnlinePlayers.setStrokeWidth(0.0);
        /*int count;
        count = onlineplayers.size();*/
        txtOnlinePlayers.setText(String.valueOf(onlineplayers.size()));
        txtOnlinePlayers.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        txtOnlinePlayers.setWrappingWidth(244.8525390625);
        txtOnlinePlayers.setFont(new Font("System Bold Italic", 30.0));

        GridPane.setColumnIndex(txtGamesPlayed, 1);
        GridPane.setRowIndex(txtGamesPlayed, 1);
        txtGamesPlayed.setFill(javafx.scene.paint.Color.WHITE);
        txtGamesPlayed.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtGamesPlayed.setStrokeWidth(0.0);
       // txtGamesPlayed.setText("No of Played Games :");
        txtGamesPlayed.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        txtGamesPlayed.setWrappingWidth(244.8525390625);
        txtGamesPlayed.setFont(new Font("System Bold Italic", 25.0));

        GridPane.setColumnIndex(txtAccountNo0, 1);
        GridPane.setRowIndex(txtAccountNo0, 2);
        txtAccountNo0.setFill(javafx.scene.paint.Color.WHITE);
        txtAccountNo0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtAccountNo0.setStrokeWidth(0.0);
        txtAccountNo0.setText(String.valueOf(DataAccessLayer.count()));
        txtAccountNo0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        txtAccountNo0.setWrappingWidth(244.8525390625);
        txtAccountNo0.setFont(new Font("System Bold Italic", 25.0));
        getStylesheets().add("/css/GameStyle.css");
        getStylesheets().add("/css/GameStyle.css");

        getChildren().add(btnStop);
        getChildren().add(label);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(text);
        gridPane.getChildren().add(text0);
        gridPane.getChildren().add(txtAccountNo);
        gridPane.getChildren().add(txtOnlinePlayers);
        gridPane.getChildren().add(txtGamesPlayed);
        gridPane.getChildren().add(txtAccountNo0);
        getChildren().add(gridPane);
       btnStop.setOnAction((event)->{
           //ClientHandler client=new ClientHandler(event);
           //client.stopConnection();
           ScreenAdapter.setScreen(event, new FXMLDocumentBase());
           sv.stopConnection();
           
           
         
       });
       
       

    }
}
