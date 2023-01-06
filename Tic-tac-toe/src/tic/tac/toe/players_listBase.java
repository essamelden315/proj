package tic.tac.toe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import sendmessage.SendMessage;
public  class players_listBase extends BorderPane {

    protected final Label myLabel;
    protected final AnchorPane anchorPane;
    protected final Button button;
    protected final ScrollPane scrollPane;
    protected final ListView myListView;

    public players_listBase() {

        myLabel = new Label();
        anchorPane = new AnchorPane();
        button = new Button();
        scrollPane = new ScrollPane();
        myListView = new ListView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");
        getStylesheets().add("/css/GameStyle.css");

        BorderPane.setAlignment(myLabel, javafx.geometry.Pos.CENTER);
        myLabel.setAlignment(javafx.geometry.Pos.CENTER);
        myLabel.setPrefHeight(75.0);
        myLabel.setPrefWidth(454.0);
        myLabel.getStyleClass().add("onlabel");
        myLabel.getStylesheets().add("/css/GameStyle.css");
        myLabel.setText("Label");
        myLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        myLabel.setFont(new Font(24.0));
        setTop(myLabel);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(80.0);
        anchorPane.setPrefWidth(793.0);

        button.setLayoutX(662.0);
        button.setLayoutY(4.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(49.0);
        button.setPrefWidth(117.0);
        button.getStyleClass().add("onbackBtn");
        button.getStylesheets().add("/css/GameStyle.css");
        button.setText("Log Out");
        button.setOnAction((ActionEvent event) -> {
           SendMessage.logout(event);
        });
        setBottom(anchorPane);

        BorderPane.setAlignment(scrollPane, javafx.geometry.Pos.CENTER);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(199.0);
        scrollPane.setPrefWidth(426.0);

        myListView.setFixedCellSize(50.0);
        myListView.setPrefHeight(478.0);
        myListView.setPrefWidth(793.0);
        scrollPane.setContent(myListView);
        setCenter(scrollPane);

        anchorPane.getChildren().add(button);

    }
}
