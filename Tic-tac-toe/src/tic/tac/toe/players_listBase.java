package tic.tac.toe;

import Controlers.Clients;
import Controlers.ScreenAdapter;

import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import Controlers.SendMessage;
import static Controlers.SendMessage.send;
import Model.Player;
import javax.swing.JOptionPane;
import tic.tac.toe.ShowPlayers;
//import static Controlers.SendMessage.showPlayers;

public class players_listBase extends BorderPane {

    protected final Label myLabel;
    protected final AnchorPane anchorPane;
    protected final Button logOut;
    //protected final Button button;
    protected final ScrollPane scrollPane;
    public final ListView<String> myListView;
    String selectedFood;
    ShowPlayers show = new ShowPlayers(this);
    Clients client=new Clients(null,null);
    public players_listBase(String id) {

        myLabel = new Label();
        anchorPane = new AnchorPane();
        logOut = new Button();
        scrollPane = new ScrollPane();
        myListView = new ListView<>();

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

        logOut.setLayoutX(662.0);
        logOut.setLayoutY(4.0);
        logOut.setMnemonicParsing(false);
        logOut.setPrefHeight(49.0);
        logOut.setPrefWidth(117.0);
        logOut.getStyleClass().add("onbackBtn");
        logOut.getStylesheets().add("/css/GameStyle.css");
        logOut.setText("Log Out");
        logOut.setOnAction((ActionEvent event) -> {
           
            client.logout(event);
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

        anchorPane.getChildren().add(logOut);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedFood = myListView.getSelectionModel().getSelectedItem().toString();
                myLabel.setText(selectedFood);
            }
        });

    }

    public void show() {
        ArrayList<Player> items = new ArrayList<>();
        //.addAll(SendMessage.showPlayers());
        String name[] = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            name[i] = items.get(i).getName();
        }

        myListView.getItems().addAll(name);

        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedFood = myListView.getSelectionModel().getSelectedItem().toString();
                myLabel.setText(selectedFood);
            }
        });

    }

    void requestDialog(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null, "Send a request?");
        if (a == JOptionPane.YES_OPTION) {
            ScreenAdapter.setScreen(event, new GameScreenViewBase());
        }
    }

}
