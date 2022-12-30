package tic.tac.toe;

import Controlers.ScreenAdapter;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public  class FXMLDocumentBase extends AnchorPane {

    protected final Button btrStart;
    protected final Label label;
    protected final Bloom bloom;

    public FXMLDocumentBase() {

        btrStart = new Button();
        label = new Label();
        bloom = new Bloom();

        setId("AnchorPane");
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStyleClass().add("background");
        getStylesheets().add("/css/GameStyle.css");

        btrStart.setLayoutX(250.0);
        btrStart.setLayoutY(209.0);
        btrStart.setMnemonicParsing(false);
        btrStart.setPrefHeight(60.0);
        btrStart.setPrefWidth(364.0);
        btrStart.getStyleClass().add("blueBtn");
        btrStart.getStylesheets().add("/css/GameStyle.css");
        btrStart.setText("strart");
        btrStart.setTextFill(javafx.scene.paint.Color.valueOf("#000000ca"));
        btrStart.setFont(new Font("System Bold Italic", 10.0));

        label.setLayoutX(206.0);
        label.setLayoutY(75.0);
        label.setPrefHeight(115.0);
        label.setPrefWidth(394.0);
        label.getStyleClass().add("logo");
        label.getStylesheets().add("/css/GameStyle.css");
        label.setText("Tic-tac-toe ");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setWrapText(true);
        label.setFont(new Font("System Bold Italic", 72.0));

        label.setEffect(bloom);

        getChildren().add(btrStart);
        getChildren().add(label);
        btrStart.setOnAction((event)-> {
                   ScreenAdapter.setScreen(event, new OnlineAndOfflineBase());      
        });

    }
}
