package _1213;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class MultiMoveBall extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("I don't know");
        Pane root = new Pane();
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();

        Button PlusCircle = new Button("+");
        PlusCircle.setLayoutX(0);
        PlusCircle.setLayoutY(0);
//        버튼 +와 그 위치

        Button MinusCircle = new Button("-");
        MinusCircle.setLayoutX(620);
        MinusCircle.setLayoutY(0);
//      버튼 -와 그 위치

        PlusCircle.setOnAction(plusCircle(root));
//        버튼 + 공 생성 및 굴리기

        MinusCircle.setOnAction(minusCircle(root));
//        버튼 - 공 삭제

        root.getChildren().addAll(PlusCircle, MinusCircle);
    }





    private static EventHandler<ActionEvent> plusCircle(Pane root) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddMovingBall newBall = new AddMovingBall(root);
                newBall.ballManager();
            }
        };
    }

    private static EventHandler<ActionEvent> minusCircle(Pane root) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (root.getChildren().size() >= 3) {
                    root.getChildren().remove(2);
                }
            }
        };
    }
}