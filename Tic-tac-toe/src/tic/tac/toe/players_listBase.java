package tic.tac.toe;

<<<<<<< HEAD
import Controlers.Clients;
import Controlers.ScreenAdapter;
import Model.Player;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
=======
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
<<<<<<< HEAD

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;
//import tic.tac.toe.ShowPlayers;
//import static Controlers.SendMessage.showPlayers;

public class players_listBase extends BorderPane {

    protected final Label myLabel;
    protected final AnchorPane anchorPane;
    protected final Button logOut;
    //protected final Button button;
    protected final ScrollPane scrollPane;
    public final ListView<String> myListView;
    String selectedFood;
    //ShowPlayers show = new ShowPlayers(this);
    public ArrayList<Player> players;
    Clients client;
=======
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import sendmessage.SendMessage;
public  class players_listBase extends BorderPane {

    protected final Label myLabel;
    protected final AnchorPane anchorPane;
    protected final Button button;
    protected final ScrollPane scrollPane;
    protected final ListView myListView;
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1

    public players_listBase() {
        players = new ArrayList<>();
        myLabel = new Label();
        anchorPane = new AnchorPane();
        logOut = new Button();
        scrollPane = new ScrollPane();
        myListView = new ListView<>();
        client = new Clients("show",new ActionEvent());
        client.setPlayerListBase(this);
        client.sendMessage("show,");

<<<<<<< HEAD
=======
        myLabel = new Label();
        anchorPane = new AnchorPane();
        button = new Button();
        scrollPane = new ScrollPane();
        myListView = new ListView();

>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1
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

<<<<<<< HEAD
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
=======
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
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1
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

<<<<<<< HEAD
        anchorPane.getChildren().add(logOut);
        System.out.println("befoooooooooor");
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int ans = JOptionPane.showConfirmDialog(null, "send a request");
                if (ans == JOptionPane.YES_OPTION) {
                    Thread thread = new Thread(() -> {

                        new Clients("", null).playRequest(players.get(myListView.getSelectionModel().getSelectedIndex()).getID());
                    });
                    thread.start();

                } else {
                    JOptionPane.showMessageDialog(null, "Enter a valid Number",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

=======
        anchorPane.getChildren().add(button);

    }
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1
}
