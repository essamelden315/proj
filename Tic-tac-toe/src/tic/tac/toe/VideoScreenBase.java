package tic.tac.toe;

import Controlers.ScreenAdapter;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import tic.tac.toe.GameScreenViewBase;
import tic.tac.toe.OnlineAndOfflineBase;

public class VideoScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final Label label;
    protected final FlowPane flowPane;
    protected final SplitPane splitPane;
    protected final ImageView imageView0;
    protected final SplitPane splitPane0;
    protected final ImageView imageView2;
    protected final SplitPane splitPane2;
    protected final MediaView mediaView;
    String path;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    public VideoScreenBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        label = new Label();
        flowPane = new FlowPane();
        splitPane = new SplitPane();
        imageView0 = new ImageView();
        splitPane0 = new SplitPane();
        imageView2 = new ImageView();
        splitPane2 = new SplitPane();
        mediaView = new MediaView();
        file=new File("E:\\Nada\\ITI\\Java\\Labs\\Final\\Final\\proj\\Tic-tac-toe\\src\\images\\winner.mp4");
       // file=new File("/images/winner.mp4");
        media=new Media(file.toURI().toString());
        mediaPlayer=new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();

        setId("AnchorPane");
        setPrefHeight(307.0);
        setPrefWidth(301.0);

        imageView.setFitHeight(307.0);
        imageView.setFitWidth(626.0);
        imageView.setLayoutX(-7.0);
        imageView.setLayoutY(-4.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/images/VideoBackground.jpg").toExternalForm()));

        AnchorPane.setTopAnchor(borderPane, 1.0);
        borderPane.setLayoutX(1.0);
        borderPane.setLayoutY(1.0);
        borderPane.setPrefHeight(216.0);
        borderPane.setPrefWidth(301.0);

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setPrefHeight(38.0);
        label.setPrefWidth(150.0);
        label.setText("WINNER");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(36.0));
        borderPane.setTop(label);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(0.0);
        flowPane.setPrefWidth(300.0);

        splitPane.setOpacity(0.0);
        splitPane.setPrefHeight(50.0);
        splitPane.setPrefWidth(50.0);

        imageView0.setFitHeight(30.0);
        imageView0.setFitWidth(30.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/images/replay.png").toExternalForm()));
         imageView0.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {

            /*if () {
                recordGame(imageLocation1);
            }

            gameControl(event, imageLocation1, 0);*/
        });

        splitPane0.setOpacity(0.0);
        splitPane0.setPrefHeight(50.0);
        splitPane0.setPrefWidth(40.0);
       

        imageView2.setFitHeight(41.0);
        imageView2.setFitWidth(41.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("/images/logoutVideo.png").toExternalForm()));
        imageView2.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
           this.setVisible(true);
            
        });

        splitPane2.setOpacity(0.0);
        splitPane2.setPrefHeight(50.0);
        splitPane2.setPrefWidth(34.0);
        borderPane.setBottom(flowPane);

        BorderPane.setAlignment(mediaView, javafx.geometry.Pos.CENTER);
        mediaView.setFitHeight(200.0);
        mediaView.setFitWidth(200.0);
        borderPane.setCenter(mediaView);

        getChildren().add(imageView);
        flowPane.getChildren().add(splitPane);
        flowPane.getChildren().add(imageView0);
        flowPane.getChildren().add(splitPane0);
        flowPane.getChildren().add(imageView2);
        flowPane.getChildren().add(splitPane2);
        getChildren().add(borderPane);

    }
}
