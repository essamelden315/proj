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
import javafx.event.EventType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Window;
import javax.swing.JOptionPane;
//import tic.tac.toe.ShowPlayers;
//import static Controlers.SendMessage.showPlayers;

public class players_listBase extends BorderPane {
    
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final Label myLabel;
    protected final ImageView reloadimg;
    protected final AnchorPane anchorPane;
    protected final Button logOut;
    //protected final Button button;
    protected final ScrollPane scrollPane;
    public final ListView<String> myListView;
    String selectedFood;
    //ShowPlayers show = new ShowPlayers(this);
    
    Clients client;
    Clients client1;
    public players_listBase() {
        
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        reloadimg = new ImageView();
        myLabel = new Label();
        anchorPane = new AnchorPane();
        logOut = new Button();
        scrollPane = new ScrollPane();
        myListView = new ListView<>();
        client=new Clients("show",null);
        client.setPlayerListBase(this);
        client.sendMessage("show,");
        

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");
        getStylesheets().add("/css/GameStyle.css");

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        GridPane.setColumnIndex(myLabel, 1);
        
     
        
        GridPane.setColumnIndex(myLabel, 1);
        //BorderPane.setAlignment(myLabel, javafx.geometry.Pos.CENTER);
        myLabel.setAlignment(javafx.geometry.Pos.CENTER);
        myLabel.setPrefHeight(75.0);
        myLabel.setPrefWidth(454.0);
        myLabel.getStyleClass().add("onlabel");
        myLabel.getStylesheets().add("/css/GameStyle.css");
        myLabel.setText("Online Players");
        myLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        myLabel.setFont(new Font(24.0));
        setTop(myLabel);
        
        
        reloadimg.setFitHeight(47.0);
        reloadimg.setFitWidth(49.0);
        reloadimg.setPickOnBounds(true);
        reloadimg.setPreserveRatio(true);
        reloadimg.setImage(new Image(getClass().getResource("/css/photos/reload.png").toExternalForm()));
        reloadimg.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
        myListView.getItems().clear();
        Clients client1= new Clients("show", null);
        //client1 = new Clients("show", event);
        client1.setPlayerListBase(this);
        client1.sendMessage("show,");
        //myListView.refresh();
        ///new players_listBase();
        });
        setTop(gridPane);

        
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
        

        myListView.setFixedCellSize(70.0);
        myListView.setPrefHeight(478.0);
        myListView.setPrefWidth(793.0);
        scrollPane.setContent(myListView);
        setCenter(scrollPane);
        
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(myLabel);
        gridPane.getChildren().add(reloadimg);
        

        anchorPane.getChildren().add(logOut);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedFood = myListView.getSelectionModel().getSelectedItem().toString();
            }
        });

    }

    /*public void show() {
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

    }*/

    void requestDialog(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null, "Send a request?");
        if (a == JOptionPane.YES_OPTION) {
            ScreenAdapter.setScreen(event, new GameScreenViewBase());
        }
    }

}
