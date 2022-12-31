package tic.tac.toe;

import Controlers.ScreenAdapter;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public  class OnlineAndOfflineBase extends AnchorPane {

    protected final Button btnOnline;
    protected final Label label;
    protected final Bloom bloom;
    protected final Button btnOffline;

    public OnlineAndOfflineBase() {

        btnOnline = new Button();
        label = new Label();
        bloom = new Bloom();
        btnOffline = new Button();

        setId("AnchorPane");
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");
        
        btnOnline.setLayoutX(250.0);
        btnOnline.setLayoutY(209.0);
        btnOnline.setMnemonicParsing(false);
        btnOnline.setPrefHeight(60.0);
        btnOnline.setPrefWidth(293.0);
        btnOnline.getStyleClass().add("blueBtn");
        btnOnline.getStylesheets().add("/css/GameStyle.css");
        btnOnline.setText("Online");
        btnOnline.setTextFill(javafx.scene.paint.Color.valueOf("#000000ca"));
        btnOnline.setFont(new Font("System Bold Italic", 10.0));
        btnOnline.setOnAction(( event) ->{
                ScreenAdapter.setScreen(event, new LoginBase());
            }
        );

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

        btnOffline.setLayoutX(250.0);
        btnOffline.setLayoutY(316.0);
        btnOffline.setMnemonicParsing(false);
        btnOffline.setPrefHeight(60.0);
        btnOffline.setPrefWidth(293.0);
        btnOffline.getStyleClass().add("pinkbtn");
        btnOffline.getStylesheets().add("/css/GameStyle.css");
        btnOffline.setText("Offline");
        btnOffline.setTextFill(javafx.scene.paint.Color.valueOf("#000000ca"));
        btnOffline.setFont(new Font("System Bold Italic", 10.0));
        getStylesheets().add("/css/GameStyle.css");

        getChildren().add(btnOnline);
        getChildren().add(label);
        getChildren().add(btnOffline);
         btnOffline.setOnAction((event)-> {
                   ScreenAdapter.setScreen(event, new OfflineModesBase());      
        });

    }
}
