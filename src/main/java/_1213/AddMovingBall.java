package _1213;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Random;

public class AddMovingBall {
    private Pane root;

    public AddMovingBall(Pane root){
        this.root=root;
    }

    public void ballManager() {
        Circle cir = new Circle(5);
        Random r = new Random();
        double rX = r.nextInt(5,635);
        double rY = r.nextInt(5,475);
        cir.setLayoutX(rX);
        cir.setLayoutY(rY);
//                공의 위치

        KeyFrame startBall = new KeyFrame(Duration.millis(4), new EventHandler<ActionEvent>() {
            double speedX = r.nextInt(1,5);
            double speedY = r.nextInt(1,5);
//                    진행 방향의 기울기

            @Override
            public void handle(ActionEvent actionEvent) {
                moveBall();

                reflectBall();
            }

            private void reflectBall() {
                if (cir.getLayoutX() + cir.getRadius() >= 640 || cir.getLayoutX() - cir.getRadius() <= 0) {
                    speedX = -speedX;
                }
                if (cir.getLayoutY() + cir.getRadius() >= 480 || cir.getLayoutY() - cir.getRadius() <= 0) {
                    speedY = -speedY;
                }
            }

            private void moveBall() {
                cir.setLayoutX(cir.getLayoutX() + speedX);
                cir.setLayoutY(cir.getLayoutY() + speedY);
            }
        });

        Timeline movingball = new Timeline(startBall);

        movingball.setCycleCount(Animation.INDEFINITE);
        movingball.play();

        root.getChildren().add(cir);
    }
}
