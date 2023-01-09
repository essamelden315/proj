package tic.tac.toe;

import Controlers.ScreenAdapter;
import Controlers.SendMessage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class players_listBase extends AnchorPane {

    protected final Button onBtn1;
    protected final Button onBtn2;
    protected final Button onBtn3;
    protected final Button onBtn4;
    protected final Label onLabel;
    protected final ImageView btnImg1;
    protected final ImageView btnImg2;
    protected final ImageView btnImg3;
    protected final ImageView btnImg4;
    protected final Button backBtn;

    public players_listBase() {

        onBtn1 = new Button();
        onBtn2 = new Button();
        onBtn3 = new Button();
        onBtn4 = new Button();
        onLabel = new Label();
        btnImg1 = new ImageView();
        btnImg2 = new ImageView();
        btnImg3 = new ImageView();
        btnImg4 = new ImageView();
        backBtn = new Button();

        setId("anchor");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");
        getStylesheets().add("/css/GameStyle.css");

        onBtn1.setId("onBtn1");
        onBtn1.setLayoutX(265.0);
        onBtn1.setLayoutY(91.0);
        onBtn1.setMnemonicParsing(false);
        onBtn1.setOpacity(0.61);
        onBtn1.setPrefHeight(58.0);
        onBtn1.setPrefWidth(156.0);
        onBtn1.getStyleClass().add("bleBtn");
        onBtn1.getStylesheets().add("/css/GameStyle.css");
        onBtn1.setText("Player 1");
        onBtn1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        onBtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SendMessage.playRequest(1);
            }
        });
        onBtn2.setId("onBtn2");
        onBtn2.setLayoutX(265.0);
        onBtn2.setLayoutY(182.0);
        onBtn2.setMnemonicParsing(false);
        onBtn2.setOpacity(0.61);
        onBtn2.setPrefHeight(51.0);
        onBtn2.setPrefWidth(167.0);
        onBtn2.getStyleClass().add("bleBtn");
        onBtn2.getStylesheets().add("/css/GameStyle.css");
        onBtn2.setText("Player 2");
        onBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                requestDialog(event);
            }
        });

        onBtn3.setId("onBtn3");
        onBtn3.setLayoutX(265.0);
        onBtn3.setLayoutY(277.0);
        onBtn3.setMnemonicParsing(false);
        onBtn3.setOpacity(0.61);
        onBtn3.setPrefHeight(25.0);
        onBtn3.setPrefWidth(52.0);
        onBtn3.getStyleClass().add("bleBtn");
        onBtn3.getStylesheets().add("/css/GameStyle.css");
        onBtn3.setText("Player 3");
        onBtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                requestDialog(event);
            }
        });

        onBtn4.setId("onBtn4");
        onBtn4.setLayoutX(265.0);
        onBtn4.setLayoutY(371.0);
        onBtn4.setMnemonicParsing(false);
        onBtn4.setOpacity(0.61);
        onBtn4.getStyleClass().add("bleBtn");
        onBtn4.getStylesheets().add("/css/GameStyle.css");
        onBtn4.setText("Player 4");
        onBtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                requestDialog(event);
            }
        });

        onLabel.setAlignment(javafx.geometry.Pos.CENTER);
        onLabel.setId("onLabel");
        onLabel.setLayoutX(306.0);
        onLabel.setPrefHeight(90.0);
        onLabel.setPrefWidth(193.0);
        onLabel.getStyleClass().add("onlabel");
        onLabel.getStylesheets().add("/css/GameStyle.css");
        onLabel.setText("Online");

        btnImg1.setFitHeight(59.0);
        btnImg1.setFitWidth(59.0);
        btnImg1.setId("btnImg1");
        btnImg1.setLayoutX(292.0);
        btnImg1.setLayoutY(102.0);
        btnImg1.setPickOnBounds(true);
        btnImg1.setPreserveRatio(true);
        btnImg1.getStyleClass().add("img");
        btnImg1.setImage(new Image(getClass().getResource("/css/photos/boy.jpeg").toExternalForm()));

        btnImg2.setFitHeight(66.0);
        btnImg2.setFitWidth(59.0);
        btnImg2.setId("btnIm2");
        btnImg2.setLayoutX(292.0);
        btnImg2.setLayoutY(193.0);
        btnImg2.setPickOnBounds(true);
        btnImg2.setPreserveRatio(true);
        btnImg2.setImage(new Image(getClass().getResource("/css/photos/girl.jpeg").toExternalForm()));

        btnImg3.setFitHeight(59.0);
        btnImg3.setFitWidth(59.0);
        btnImg3.setId("btnImg3");
        btnImg3.setLayoutX(292.0);
        btnImg3.setLayoutY(288.0);
        btnImg3.setPickOnBounds(true);
        btnImg3.setPreserveRatio(true);

        btnImg3.setImage(null);

        btnImg4.setFitHeight(59.0);
        btnImg4.setFitWidth(59.0);
        btnImg4.setId("btnImg4");
        btnImg4.setLayoutX(292.0);
        btnImg4.setLayoutY(382.0);
        btnImg4.setPickOnBounds(true);
        btnImg4.setPreserveRatio(true);
        btnImg4.getStyleClass().add("btnImg1");
        btnImg4.setImage(new Image(getClass().getResource("/css/photos/girl.jpeg").toExternalForm()));

        backBtn.setId("backBtn");
        backBtn.setLayoutX(675.0);
        backBtn.setLayoutY(400.0);
        backBtn.setMnemonicParsing(false);
        backBtn.getStyleClass().add("bckBtn");
        backBtn.getStylesheets().add("/css/GameStyle.css");
        backBtn.setText("back");
        backBtn.setOnAction((ActionEvent event) -> {
            SendMessage.logout(event);
            ScreenAdapter.setScreen(event, new OnlineAndOfflineBase());
        });
        getChildren().add(onBtn1);
        getChildren().add(onBtn2);
        getChildren().add(onBtn3);
        getChildren().add(onBtn4);
        getChildren().add(onLabel);
        getChildren().add(btnImg1);
        getChildren().add(btnImg2);
        getChildren().add(btnImg3);
        getChildren().add(btnImg4);
        getChildren().add(backBtn);

       
    }

    void requestDialog(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null, "Send a request?");
        if (a == JOptionPane.YES_OPTION) {
            ScreenAdapter.setScreen(event, new GameScreenViewBase());
        }
    }

    public players_listBase(Button onBtn1, Button onBtn2, Button onBtn3, Button onBtn4, Label onLabel, ImageView btnImg1, ImageView btnImg2, ImageView btnImg3, ImageView btnImg4, Button backBtn) {
        this.onBtn1 = onBtn1;
        this.onBtn2 = onBtn2;
        this.onBtn3 = onBtn3;
        this.onBtn4 = onBtn4;
        this.onLabel = onLabel;
        this.btnImg1 = btnImg1;
        this.btnImg2 = btnImg2;
        this.btnImg3 = btnImg3;
        this.btnImg4 = btnImg4;
        this.backBtn = backBtn;
    }

}
