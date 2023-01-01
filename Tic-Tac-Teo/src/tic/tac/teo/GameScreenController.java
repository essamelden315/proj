/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GameScreenController implements Initializable {

    @FXML
    private ImageView myBackground;
    @FXML
    private Rectangle rectangleLocation1;
    @FXML
    private Rectangle rectangleLocation4;
    @FXML
    private Rectangle rectangleLocation7;
    @FXML
    private Rectangle rectangleLocation2;
    @FXML
    private Rectangle rectangleLocation5;
    @FXML
    private Rectangle rectangleLocation8;
    @FXML
    private Rectangle rectangleLocation3;
    @FXML
    private Rectangle rectangleLocation6;
    @FXML
    private Rectangle rectangleLocation9;
    @FXML
    private BorderPane location1;
    @FXML
    private ImageView imageLocation1;
    @FXML
    private BorderPane location2;
    @FXML
    private ImageView imageLocation2;
    @FXML
    private BorderPane location3;
    @FXML
    private ImageView imageLocation3;
    @FXML
    private BorderPane location4;
    @FXML
    private ImageView imageLocation4;
    @FXML
    private BorderPane location5;
    @FXML
    private ImageView imageLocation5;
    @FXML
    private BorderPane location6;
    @FXML
    private ImageView imageLocation6;
    @FXML
    private BorderPane location7;
    @FXML
    private ImageView imageLocation7;
    @FXML
    private BorderPane location8;
    @FXML
    private ImageView imageLocation8;
    @FXML
    private BorderPane location9;
    @FXML
    private ImageView imageLocation9;
    @FXML
    private Rectangle framePlayer2;
    @FXML
    private Rectangle framePlayer1;
    @FXML
    private Label labelPlayer2;
    @FXML
    private Label labelPlayer1;
    @FXML
    private Text scorePlayer1;
    @FXML
    private Text scorePlayer2;
    @FXML
    private ImageView recordImage;
    @FXML
    private ImageView exitImage;
    @FXML
    private Pane lineStrightFrom2To8;
    @FXML
    private Line lineCrossFrom1To9;
    @FXML
    private Line lineCrossFrom3To7;
    @FXML
    private Line lineStrightFrom3To9;
    @FXML
    private Line lineStrightFrom4To6;
    @FXML
    private Pane lineStrightFrom2To81;
    @FXML
    private Line lineStrightFrom1To7;
    @FXML
    private Line lineStrightFrom1To3;
    @FXML
    private Line lineStrightFrom7To9;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
