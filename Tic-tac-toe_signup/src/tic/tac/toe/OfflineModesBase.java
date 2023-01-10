package tic.tac.toe;

import Controlers.ScreenAdapter;
import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class OfflineModesBase extends AnchorPane {

    protected final Button btnOfflineSinglePlayer;
    protected final Label label;
    protected final Bloom bloom;
    protected final Button btnOfflineMultiPlayers;
    protected final Button btnBack;

    public OfflineModesBase() {

        btnOfflineSinglePlayer = new Button();
        label = new Label();
        bloom = new Bloom();
        btnOfflineMultiPlayers = new Button();
        btnBack = new Button();

        setId("AnchorPane");
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");

        btnOfflineSinglePlayer.setLayoutX(250.0);
        btnOfflineSinglePlayer.setLayoutY(209.0);
        btnOfflineSinglePlayer.setMnemonicParsing(false);
        btnOfflineSinglePlayer.setPrefHeight(60.0);
        btnOfflineSinglePlayer.setPrefWidth(293.0);
        btnOfflineSinglePlayer.getStyleClass().add("blueBtn");
        btnOfflineSinglePlayer.getStylesheets().add("/css/GameStyle.css");
        btnOfflineSinglePlayer.setText("VS Computer");
        btnOfflineSinglePlayer.setTextFill(javafx.scene.paint.Color.valueOf("#000000ca"));
        btnOfflineSinglePlayer.setFont(new Font("System Bold Italic", 10.0));

       label.setLayoutX(206.0);
        label.setLayoutY(75.0);
        label.setPrefHeight(92.0);
        label.setPrefWidth(389.0);
        label.getStyleClass().add("logo");
        label.getStylesheets().add("/css/GameStyle.css");
        label.setText("Tic-tac-toe ");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setWrapText(true);
        label.setFont(new Font("System Bold Italic", 72.0));

        label.setEffect(bloom);

        btnOfflineMultiPlayers.setLayoutX(250.0);
        btnOfflineMultiPlayers.setLayoutY(316.0);
        btnOfflineMultiPlayers.setMnemonicParsing(false);
        btnOfflineMultiPlayers.setPrefHeight(60.0);
        btnOfflineMultiPlayers.setPrefWidth(293.0);
        btnOfflineMultiPlayers.getStyleClass().add("pinkbtn");
        btnOfflineMultiPlayers.getStylesheets().add("/css/GameStyle.css");
        btnOfflineMultiPlayers.setText("2 Players");
        btnOfflineMultiPlayers.setTextFill(javafx.scene.paint.Color.valueOf("#000000ca"));
        btnOfflineMultiPlayers.setFont(new Font("System Bold Italic", 10.0));

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

        getChildren().add(btnOfflineSinglePlayer);
        getChildren().add(label);
        getChildren().add(btnOfflineMultiPlayers);
        getChildren().add(btnBack);
         btnBack.setOnAction((event) -> {
           
                 ScreenAdapter.setScreen(event, new OnlineAndOfflineBase());
        });
         btnOfflineSinglePlayer.setOnAction((event)->{
         ScreenAdapter.setScreen(event, new GameScreenViewBase());
         
         });
         btnOfflineMultiPlayers.setOnAction((event)->{
          ScreenAdapter.setScreen(event, new GameScreenViewBase());
         });
         

    }
}
