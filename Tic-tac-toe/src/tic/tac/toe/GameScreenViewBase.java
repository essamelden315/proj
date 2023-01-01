package tic.tac.toe;

import Controlers.GameHandler;
import Controlers.ScreenAdapter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameScreenViewBase extends AnchorPane {
    private boolean gameTurn; 
    protected final ImageView myBackground;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final Rectangle rectangleLocation1;
    protected final Rectangle rectangleLocation4;
    protected final Rectangle rectangleLocation7;
    protected final Rectangle rectangleLocation2;
    protected final Rectangle rectangleLocation5;
    protected final Rectangle rectangleLocation8;
    protected final Rectangle rectangleLocation3;
    protected final Rectangle rectangleLocation6;
    protected final Rectangle rectangleLocation9;
    protected final BorderPane location1;
    protected final ImageView imageLocation1;
    protected final BorderPane location2;
    protected final ImageView imageLocation2;
    protected final BorderPane location3;
    protected final ImageView imageLocation3;
    protected final BorderPane location4;
    protected final ImageView imageLocation4;
    protected final BorderPane location5;
    protected final ImageView imageLocation5;
    protected final BorderPane location6;
    protected final ImageView imageLocation6;
    protected final BorderPane location7;
    protected final ImageView imageLocation7;
    protected final BorderPane location8;
    protected final ImageView imageLocation8;
    protected final BorderPane location9;
    protected final ImageView imageLocation9;
    protected final Rectangle framePlayer2;
    protected final Rectangle framePlayer1;
    protected final Label labelPlayer2;
    protected final Label labelPlayer1;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Label label;
    protected final Label scorePlayer1;
    protected final Label scorePlayer2;
    protected final Label label0;
    protected final FlowPane flowPane;
    protected final ImageView recordImage;
    protected final Pane pane;
    protected final ImageView exitImage;
    protected final Button ExitBtn;
    private Stage stage;

    public GameScreenViewBase() {
         GameHandler.board = new String[9];
        gameTurn= false;
        this.stage=stage;
        myBackground = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        
        rectangleLocation1 = new Rectangle();
        rectangleLocation4 = new Rectangle();
        rectangleLocation7 = new Rectangle();
        rectangleLocation2 = new Rectangle();
        rectangleLocation5 = new Rectangle();
        rectangleLocation8 = new Rectangle();
        rectangleLocation3 = new Rectangle();
        rectangleLocation6 = new Rectangle();
        rectangleLocation9 = new Rectangle();
        
        location1 = new BorderPane();
        imageLocation1 = new ImageView();
        
        location2 = new BorderPane();
        imageLocation2 = new ImageView();
        
        location3 = new BorderPane();
        imageLocation3 = new ImageView();
        
        location4 = new BorderPane();
        imageLocation4 = new ImageView();
        
        location5 = new BorderPane();
        imageLocation5 = new ImageView();
        
        location6 = new BorderPane();
        imageLocation6 = new ImageView();
        
        location7 = new BorderPane();
        imageLocation7 = new ImageView();
        
        location8 = new BorderPane();
        imageLocation8 = new ImageView();
        
        location9 = new BorderPane();
        imageLocation9 = new ImageView();
        
        framePlayer1 = new Rectangle();
        framePlayer2 = new Rectangle();
        
        labelPlayer1 = new Label();
        labelPlayer2 = new Label();
        
        imageView0 = new ImageView();
        imageView = new ImageView();
        
        label0 = new Label();
        label = new Label();
        
        scorePlayer1 = new Label();
        scorePlayer2 = new Label();
        
        flowPane = new FlowPane();
        recordImage = new ImageView();
        pane = new Pane();
        exitImage = new ImageView();
        
        ExitBtn = new Button();
        
        setId("AnchorPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(478.0);
        setPrefWidth(793.0);
        getStylesheets().add("/css/GameStyle.css");
        myBackground.setFitHeight(478.0);
        myBackground.setFitWidth(478.0);
        myBackground.setLayoutX(-17.0);
        myBackground.setLayoutY(-6.0);
        myBackground.setPickOnBounds(true);
        myBackground.setPreserveRatio(true);
        myBackground.getStyleClass().add("background");
       
  
        
        gridPane.setLayoutX(221.0);
        gridPane.setLayoutY(73.0);
        gridPane.setPrefHeight(263.0);
        gridPane.setPrefWidth(296.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(112.0);
        columnConstraints.setPrefWidth(112.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(5.0);
        columnConstraints0.setPrefWidth(5.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(112.0);
        columnConstraints1.setPrefWidth(112.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(5.0);
        columnConstraints2.setPrefWidth(5.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMinWidth(112.0);
        columnConstraints3.setPrefWidth(112.0);

        rowConstraints.setMaxHeight(109.0);
        rowConstraints.setMinHeight(109.0);
        rowConstraints.setPrefHeight(109.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(5.0);
        rowConstraints0.setMinHeight(5.0);
        rowConstraints0.setPrefHeight(5.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(109.0);
        rowConstraints1.setMinHeight(109.0);
        rowConstraints1.setPrefHeight(109.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(5.0);
        rowConstraints2.setMinHeight(5.0);
        rowConstraints2.setPrefHeight(5.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(109.0);
        rowConstraints3.setMinHeight(109.0);
        rowConstraints3.setPrefHeight(109.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        
        
        rectangleLocation1.getStyleClass().add("squareGame");
        rectangleLocation1.setHeight(109.0);
        rectangleLocation1.setWidth(112.0);

        GridPane.setRowIndex(rectangleLocation4, 2);
        rectangleLocation4.getStyleClass().add("squareGame");
        rectangleLocation4.setHeight(109.0);
        rectangleLocation4.setWidth(112.0);
        

        GridPane.setRowIndex(rectangleLocation7, 4);
        rectangleLocation7.getStyleClass().add("squareGame");
        rectangleLocation7.setHeight(109.0);
        rectangleLocation7.setWidth(112.0);
     
        GridPane.setColumnIndex(rectangleLocation2, 2);
        rectangleLocation2.getStyleClass().add("squareGame");
        rectangleLocation2.setHeight(109.0);
        rectangleLocation2.setWidth(112.0);
      
        GridPane.setColumnIndex(rectangleLocation5, 2);
        GridPane.setRowIndex(rectangleLocation5, 2);
        rectangleLocation5.getStyleClass().add("squareGame");
        rectangleLocation5.setHeight(109.0);
        rectangleLocation5.setWidth(112.0);
  
        GridPane.setColumnIndex(rectangleLocation8, 2);
        GridPane.setRowIndex(rectangleLocation8, 4);
        rectangleLocation8.getStyleClass().add("squareGame");
        rectangleLocation8.setHeight(109.0);
        rectangleLocation8.setWidth(112.0);
       

        GridPane.setColumnIndex(rectangleLocation3, 4);
        rectangleLocation3.getStyleClass().add("squareGame");
        rectangleLocation3.setHeight(109.0);
        rectangleLocation3.setWidth(112.0);
       
        
        GridPane.setColumnIndex(rectangleLocation6, 4);
        GridPane.setRowIndex(rectangleLocation6, 2);
        rectangleLocation6.getStyleClass().add("squareGame");
        rectangleLocation6.setHeight(109.0);
        rectangleLocation6.setWidth(112.0);
    
        GridPane.setColumnIndex(rectangleLocation9, 4);
        GridPane.setRowIndex(rectangleLocation9, 4);
        rectangleLocation9.getStyleClass().add("squareGame");
        rectangleLocation9.setHeight(109.0);
        rectangleLocation9.setWidth(112.0);
     

        location1.setPrefHeight(200.0);
        location1.setPrefWidth(200.0);

        BorderPane.setAlignment(imageLocation1, javafx.geometry.Pos.CENTER);
        imageLocation1.setFitHeight(77.0);
        imageLocation1.setFitWidth(77.0);
        imageLocation1.setPickOnBounds(true);
        location1.setCenter(imageLocation1);
        
        imageLocation1.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
             String turn;
            if(gameTurn){ 
                imageLocation1.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));
                gameTurn=false;
                turn="X";
            }
            else{
                 imageLocation1.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));
                 gameTurn=true;
                 turn="O"; 
            }
            imageLocation1.setDisable(true);
            GameHandler.board[0]=turn;
            System.out.println(GameHandler.checkWinner());
             if(GameHandler.checkWinner().equals("O")||GameHandler.checkWinner().equals("X")){
             imageLocation1.setDisable(true);
             imageLocation2.setDisable(true);
             imageLocation3.setDisable(true);
             imageLocation4.setDisable(true);
             imageLocation5.setDisable(true);
             imageLocation6.setDisable(true);
             imageLocation7.setDisable(true);
             imageLocation8.setDisable(true);
             imageLocation9.setDisable(true);
             Alert a1 = new Alert(AlertType.NONE,
             GameHandler.checkWinner()+" win",ButtonType.APPLY);
             a1.show();
             ScreenAdapter.setScreen(event,new GameScreenViewBase());
         }
           event.consume();
        });

        GridPane.setColumnIndex(location2, 2);
        location2.setPrefHeight(200.0);
        location2.setPrefWidth(200.0);

        BorderPane.setAlignment(imageLocation2, javafx.geometry.Pos.CENTER);
        imageLocation2.setFitHeight(77.0);
        imageLocation2.setFitWidth(77.0);
        imageLocation2.setPickOnBounds(true);
        imageLocation2.setPreserveRatio(true);
        location2.setCenter(imageLocation2);
        imageLocation2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            String turn;
            if(gameTurn){ 
                imageLocation2.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));
                gameTurn=false;
                turn="X";
            }
            else{
                 imageLocation2.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));
                 gameTurn=true;
                 turn="O";
            }
            imageLocation2.setDisable(true);
            GameHandler.board[1]=turn;
           System.out.println(GameHandler.checkWinner());
              if(GameHandler.checkWinner().equals("O")||GameHandler.checkWinner().equals("X")){
             imageLocation1.setDisable(true);
             imageLocation2.setDisable(true);
             imageLocation3.setDisable(true);
             imageLocation4.setDisable(true);
             imageLocation5.setDisable(true);
             imageLocation6.setDisable(true);
             imageLocation7.setDisable(true);
             imageLocation8.setDisable(true);
             imageLocation9.setDisable(true);
             Alert a1 = new Alert(AlertType.NONE,
             GameHandler.checkWinner()+" win",ButtonType.APPLY);
             a1.show();
             ScreenAdapter.setScreen(event,new GameScreenViewBase());
         }
            event.consume();
        });

        GridPane.setColumnIndex(location3, 4);
        location3.setPrefHeight(200.0);
        location3.setPrefWidth(200.0);

        BorderPane.setAlignment(imageLocation3, javafx.geometry.Pos.CENTER);
        imageLocation3.setFitHeight(77.0);
        imageLocation3.setFitWidth(77.0);
        imageLocation3.setPickOnBounds(true);
        imageLocation3.setPreserveRatio(true);
        location3.setCenter(imageLocation3);
        imageLocation3.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
             String turn;
            if(gameTurn){ 
                imageLocation3.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));
                gameTurn=false;
                turn="X";
            }
            else{
                 imageLocation3.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));
                 gameTurn=true;
                 turn="O";
                 
            }
            imageLocation3.setDisable(true);
            GameHandler.board[2]=turn;
            System.out.println(GameHandler.checkWinner());
             if(GameHandler.checkWinner().equals("O")||GameHandler.checkWinner().equals("X")){
             imageLocation1.setDisable(true);
             imageLocation2.setDisable(true);
             imageLocation3.setDisable(true);
             imageLocation4.setDisable(true);
             imageLocation5.setDisable(true);
             imageLocation6.setDisable(true);
             imageLocation7.setDisable(true);
             imageLocation8.setDisable(true);
             imageLocation9.setDisable(true);
             Alert a1 = new Alert(AlertType.NONE,
             GameHandler.checkWinner()+" win",ButtonType.APPLY);
             a1.show();
             ScreenAdapter.setScreen(event,new GameScreenViewBase());
         }
            event.consume();
        });

        GridPane.setRowIndex(location4, 2);
        location4.setPrefHeight(200.0);
        location4.setPrefWidth(200.0);

        BorderPane.setAlignment(imageLocation4, javafx.geometry.Pos.CENTER);
        imageLocation4.setFitHeight(77.0);
        imageLocation4.setFitWidth(77.0);
        imageLocation4.setPickOnBounds(true);
        imageLocation4.setPreserveRatio(true);
        location4.setCenter(imageLocation4);
        imageLocation4.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
             String turn;
            if(gameTurn){ 
                imageLocation4.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));
                gameTurn=false;
                turn="X";
            }
            else{
                 imageLocation4.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));
                 gameTurn=true;
                 turn="O";
                 
            }
            imageLocation4.setDisable(true);
            GameHandler.board[3]=turn;
           System.out.println(GameHandler.checkWinner());
             if(GameHandler.checkWinner().equals("O")||GameHandler.checkWinner().equals("X")){
             imageLocation1.setDisable(true);
             imageLocation2.setDisable(true);
             imageLocation3.setDisable(true);
             imageLocation4.setDisable(true);
             imageLocation5.setDisable(true);
             imageLocation6.setDisable(true);
             imageLocation7.setDisable(true);
             imageLocation8.setDisable(true);
             imageLocation9.setDisable(true);
             Alert a1 = new Alert(AlertType.NONE,
             GameHandler.checkWinner()+" win",ButtonType.APPLY);
             a1.show();
             ScreenAdapter.setScreen(event,new GameScreenViewBase());
         }
            event.consume();
        });

        GridPane.setColumnIndex(location5, 2);
        GridPane.setRowIndex(location5, 2);
        location5.setPrefHeight(200.0);
        location5.setPrefWidth(200.0);

        BorderPane.setAlignment(imageLocation5, javafx.geometry.Pos.CENTER);
        imageLocation5.setFitHeight(77.0);
        imageLocation5.setFitWidth(77.0);
        imageLocation5.setPickOnBounds(true);
        imageLocation5.setPreserveRatio(true);
        location5.setCenter(imageLocation5);
        imageLocation5.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            String turn;
            if(gameTurn){ 
                imageLocation5.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));
                gameTurn=false;
                turn="X";
            }
            else{
                 imageLocation5.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));
                 gameTurn=true;
                 turn="O";
                 
            }
            imageLocation5.setDisable(true);
            GameHandler.board[4]=turn;
            System.out.println(GameHandler.checkWinner());
              if(GameHandler.checkWinner().equals("O")||GameHandler.checkWinner().equals("X")){
             imageLocation1.setDisable(true);
             imageLocation2.setDisable(true);
             imageLocation3.setDisable(true);
             imageLocation4.setDisable(true);
             imageLocation5.setDisable(true);
             imageLocation6.setDisable(true);
             imageLocation7.setDisable(true);
             imageLocation8.setDisable(true);
             imageLocation9.setDisable(true);
             Alert a1 = new Alert(AlertType.NONE,
             GameHandler.checkWinner()+" win",ButtonType.APPLY);
             a1.show();
             ScreenAdapter.setScreen(event,new GameScreenViewBase());
         }
            event.consume();
        });

        GridPane.setColumnIndex(location6, 4);
        GridPane.setRowIndex(location6, 2);
        location6.setPrefHeight(200.0);
        location6.setPrefWidth(200.0);

        BorderPane.setAlignment(imageLocation6, javafx.geometry.Pos.CENTER);
        imageLocation6.setFitHeight(77.0);
        imageLocation6.setFitWidth(77.0);
        imageLocation6.setPickOnBounds(true);
        imageLocation6.setPreserveRatio(true);
        location6.setCenter(imageLocation6);
        imageLocation6.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            String turn;
            if(gameTurn){ 
                imageLocation6.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));
                gameTurn=false;
                turn="X";
            }
            else{
                 imageLocation6.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));
                 gameTurn=true;
                 turn="O";
                 
            }
            imageLocation6.setDisable(true);
            GameHandler.board[5]=turn;
            System.out.println(GameHandler.checkWinner());
              if(GameHandler.checkWinner().equals("O")||GameHandler.checkWinner().equals("X")){
             imageLocation1.setDisable(true);
             imageLocation2.setDisable(true);
             imageLocation3.setDisable(true);
             imageLocation4.setDisable(true);
             imageLocation5.setDisable(true);
             imageLocation6.setDisable(true);
             imageLocation7.setDisable(true);
             imageLocation8.setDisable(true);
             imageLocation9.setDisable(true);
             Alert a1 = new Alert(AlertType.NONE,
             GameHandler.checkWinner()+" win",ButtonType.APPLY);
             a1.show();
             ScreenAdapter.setScreen(event,new GameScreenViewBase());
         }
            event.consume();
        });

        GridPane.setRowIndex(location7, 4);
        location7.setPrefHeight(200.0);
        location7.setPrefWidth(200.0);
       

        BorderPane.setAlignment(imageLocation7, javafx.geometry.Pos.CENTER);
        imageLocation7.setFitHeight(77.0);
        imageLocation7.setFitWidth(77.0);
        imageLocation7.setPickOnBounds(true);
        imageLocation7.setPreserveRatio(true);
        location7.setCenter(imageLocation7);
         imageLocation7.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
             String turn;
            if(gameTurn){ 
                imageLocation7.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));
                gameTurn=false;
                turn="X";
            }
            else{
                 imageLocation7.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));
                 gameTurn=true;
                 turn="O";
                 
            }
            imageLocation7.setDisable(true);
            GameHandler.board[6]=turn;
            System.out.println(GameHandler.checkWinner());
              if(GameHandler.checkWinner().equals("O")||GameHandler.checkWinner().equals("X")){
             imageLocation1.setDisable(true);
             imageLocation2.setDisable(true);
             imageLocation3.setDisable(true);
             imageLocation4.setDisable(true);
             imageLocation5.setDisable(true);
             imageLocation6.setDisable(true);
             imageLocation7.setDisable(true);
             imageLocation8.setDisable(true);
             imageLocation9.setDisable(true);
             Alert a1 = new Alert(AlertType.NONE,
             GameHandler.checkWinner()+" win",ButtonType.APPLY);
             a1.show();
             ScreenAdapter.setScreen(event,new GameScreenViewBase());
         }
            event.consume();
        });

        GridPane.setColumnIndex(location8, 2);
        GridPane.setRowIndex(location8, 4);
        location8.setPrefHeight(200.0);
        location8.setPrefWidth(200.0);

        BorderPane.setAlignment(imageLocation8, javafx.geometry.Pos.CENTER);
        imageLocation8.setFitHeight(77.0);
        imageLocation8.setFitWidth(77.0);
        imageLocation8.setPickOnBounds(true);
        imageLocation8.setPreserveRatio(true);
        location8.setCenter(imageLocation8);
         imageLocation8.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            String turn;
            if(gameTurn){ 
                imageLocation8.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));
                gameTurn=false;
                turn="X";
            }
            else{
                 imageLocation8.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));
                 gameTurn=true;
                 turn="O";
                 
            }
            GameHandler.board[7]=turn;
            System.out.println(GameHandler.checkWinner());
            imageLocation8.setDisable(true);
              if(GameHandler.checkWinner().equals("O")||GameHandler.checkWinner().equals("X")){
             imageLocation1.setDisable(true);
             imageLocation2.setDisable(true);
             imageLocation3.setDisable(true);
             imageLocation4.setDisable(true);
             imageLocation5.setDisable(true);
             imageLocation6.setDisable(true);
             imageLocation7.setDisable(true);
             imageLocation8.setDisable(true);
             imageLocation9.setDisable(true);
             Alert a1 = new Alert(AlertType.NONE,
             GameHandler.checkWinner()+" win",ButtonType.APPLY);
             a1.show();
             ScreenAdapter.setScreen(event,new GameScreenViewBase());
         }
            event.consume();
        });

        GridPane.setColumnIndex(location9, 4);
        GridPane.setRowIndex(location9, 4);
        location9.setPrefHeight(200.0);
        location9.setPrefWidth(200.0);

        BorderPane.setAlignment(imageLocation9, javafx.geometry.Pos.CENTER);
        imageLocation9.setFitHeight(77.0);
        imageLocation9.setFitWidth(77.0);
        imageLocation9.setPickOnBounds(true);
        imageLocation9.setPreserveRatio(true);
        location9.setCenter(imageLocation9);
         imageLocation9.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            String turn;
            if(gameTurn){ 
                imageLocation9.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));
                gameTurn=false;
                turn="X";
            }
            else{
                 imageLocation9.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));
                 gameTurn=true;
                 turn="O";
                 
            }
            GameHandler.board[8]=turn;
            System.out.println(GameHandler.checkWinner());
            imageLocation9.setDisable(true);
              if(GameHandler.checkWinner().equals("O")||GameHandler.checkWinner().equals("X")){
             imageLocation1.setDisable(true);
             imageLocation2.setDisable(true);
             imageLocation3.setDisable(true);
             imageLocation4.setDisable(true);
             imageLocation5.setDisable(true);
             imageLocation6.setDisable(true);
             imageLocation7.setDisable(true);
             imageLocation8.setDisable(true);
             imageLocation9.setDisable(true);
             Alert a1 = new Alert(AlertType.NONE,
             GameHandler.checkWinner()+" win",ButtonType.APPLY);
             a1.show();
             ScreenAdapter.setScreen(event,new GameScreenViewBase());
         }
            event.consume();
        });
        
         

        framePlayer2.setArcHeight(41.0);
        framePlayer2.setArcWidth(41.0);
        framePlayer2.setBlendMode(javafx.scene.effect.BlendMode.SCREEN);
        framePlayer2.setFill(javafx.scene.paint.Color.valueOf("#f2da67"));
        framePlayer2.setHeight(162.0);
        framePlayer2.setLayoutX(605.0);
        framePlayer2.setLayoutY(98.0);
        framePlayer2.setOpacity(0.75);
        framePlayer2.setStroke(javafx.scene.paint.Color.WHITE);
        framePlayer2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        framePlayer2.setWidth(144.0);

        framePlayer1.setArcHeight(41.0);
        framePlayer1.setArcWidth(41.0);
        framePlayer1.setBlendMode(javafx.scene.effect.BlendMode.LIGHTEN);
        framePlayer1.setFill(javafx.scene.paint.Color.valueOf("#c6448b"));
        framePlayer1.setHeight(162.0);
        framePlayer1.setLayoutX(40.0);
        framePlayer1.setLayoutY(97.0);
        framePlayer1.setStroke(javafx.scene.paint.Color.WHITE);
        framePlayer1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        framePlayer1.setWidth(144.0);

        labelPlayer1.getStyleClass().add("labelGame");
        labelPlayer1.setLayoutX(65.0);
        labelPlayer1.setLayoutY(108.0);
        labelPlayer1.setText("Player 1");
        labelPlayer1.setFont(new Font("Agency FB Bold", 32.0));
        
        labelPlayer2.getStyleClass().add("labelGame");
        labelPlayer2.setLayoutX(635.0);
        labelPlayer2.setLayoutY(109.0);
        labelPlayer2.setText("Player 2");
        labelPlayer2.setFont(new Font("Agency FB Bold", 32.0));
       
        
        
        label.getStyleClass().add("labelScore");
        label.setLayoutX(620.0);
        label.setLayoutY(274.0);
        label.setFont(new Font("Agency FB Bold", 50.0));
        label.setText("score");
       
        
        scorePlayer1.getStyleClass().add("labelScore");
        scorePlayer1.setLayoutX(630.0);
        scorePlayer1.setLayoutY(359.0);
        scorePlayer1.setText("1");
        scorePlayer1.setFont(new Font("Agency FB Bold", 50.0));
        
        label0.getStyleClass().add("labelScore");
        label0.setLayoutX(668.0);
        label0.setLayoutY(359.0);
        label0.setText(":");
        label0.setFont(new Font("System Bold", 38.0));
        
        scorePlayer2.getStyleClass().add("labelScore");
        scorePlayer2.setLayoutX(700.0);
        scorePlayer2.setLayoutY(359.0);
        scorePlayer2.setText("0");
        scorePlayer2.setFont(new Font("Agency FB Bold", 50.0));

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(64.0);
        imageView.setLayoutX(645.0);
        imageView.setLayoutY(176.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/images/close.png").toExternalForm()));

        imageView0.setFitHeight(64.0);
        imageView0.setFitWidth(80.0);
        imageView0.setLayoutX(82.0);
        imageView0.setLayoutY(174.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/images/circle.png").toExternalForm()));

       
        flowPane.setLayoutX(600.0);
        flowPane.setLayoutY(14.0);
        flowPane.setPrefHeight(41.0);
        flowPane.setPrefWidth(112.0);

        recordImage.setFitHeight(53.0);
        recordImage.setFitWidth(42.0);
        recordImage.setPickOnBounds(true);
        recordImage.setPreserveRatio(true);
        recordImage.setImage(new Image(getClass().getResource("/images/record.png").toExternalForm()));

        pane.setPrefHeight(42.0);
        pane.setPrefWidth(10.0);

        
        exitImage.setFitHeight(53.0);
        exitImage.setFitWidth(42.0);
        exitImage.setPickOnBounds(true);
        exitImage.setPreserveRatio(true);
        exitImage.setImage(new Image(getClass().getResource("/images/logout.png").toExternalForm()));
        exitImage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            ScreenAdapter.setScreen(event, new OfflineModesBase());
            event.consume();
        }
       /* public void handle(ActionEvent event) {
            ScreenAdapter.setScreen(event, new OnlineAndOfflineBase());
            event.consume();
        }*/
       });
      
        getChildren().add(myBackground);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        
        gridPane.getChildren().add(rectangleLocation1);
        gridPane.getChildren().add(rectangleLocation4);
        gridPane.getChildren().add(rectangleLocation7);
        gridPane.getChildren().add(rectangleLocation2);
        gridPane.getChildren().add(rectangleLocation5);
        gridPane.getChildren().add(rectangleLocation8);
        gridPane.getChildren().add(rectangleLocation3);
        gridPane.getChildren().add(rectangleLocation6);
        gridPane.getChildren().add(rectangleLocation9);
        
        gridPane.getChildren().add(location1);
        gridPane.getChildren().add(location2);
        gridPane.getChildren().add(location3);
        gridPane.getChildren().add(location4);
        gridPane.getChildren().add(location5);
        gridPane.getChildren().add(location6);
        gridPane.getChildren().add(location7);
        gridPane.getChildren().add(location8);
        gridPane.getChildren().add(location9);
        flowPane.getChildren().add(recordImage);
        flowPane.getChildren().add(pane);
        flowPane.getChildren().add(exitImage);
        
        getChildren().add(gridPane);
        getChildren().add(framePlayer2);
        getChildren().add(framePlayer1);
        getChildren().add(labelPlayer2);
        getChildren().add(labelPlayer1);
        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(label);
        getChildren().add(scorePlayer1);
        getChildren().add(scorePlayer2);
        getChildren().add(label0);
        getChildren().add(flowPane);
        getChildren().add(ExitBtn);

    }
}
