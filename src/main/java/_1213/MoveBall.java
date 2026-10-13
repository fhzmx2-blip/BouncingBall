package _1213;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MoveBall extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Move Ball");
        Circle cir = new Circle(5);
        cir.setLayoutX(320);
        cir.setLayoutY(240);

        KeyFrame startBall = new KeyFrame(Duration.millis(4), new EventHandler<ActionEvent>() {

            double pmX = 1;
            double pmY = 1;

            @Override
            public void handle(ActionEvent actionEvent) {
                cir.setLayoutX(cir.getLayoutX() + pmX);
                cir.setLayoutY(cir.getLayoutY() + pmY);

                if (cir.getLayoutX() + cir.getRadius() >= 640 || cir.getLayoutX() - cir.getRadius() <= 0) {
                    pmX = -pmX;
                }
                if (cir.getLayoutY() + cir.getRadius() >= 480 || cir.getLayoutY() - cir.getRadius() <= 0) {
                    pmY = -pmY;
                }
            }
        });

        Timeline movingball = new Timeline(startBall);

        movingball.getKeyFrames();
        movingball.setCycleCount(Animation.INDEFINITE);
        movingball.play();

        Pane root = new Pane();
        root.getChildren().add(cir);
        primaryStage.setScene(new Scene(root, 640,480));
        primaryStage.show();
        }
    }


