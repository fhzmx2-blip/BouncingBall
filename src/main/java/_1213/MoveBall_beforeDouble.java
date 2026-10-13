//package org.example;
//
//import javafx.animation.Animation;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.scene.shape.Circle;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class MoveBall_beforeDouble extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Move Ball");
//        Circle cir = new Circle(5);
//
//        KeyValue toX = new KeyValue(cir.translateXProperty(), 320);
//        KeyFrame toXhour = new KeyFrame(Duration.seconds(5), toX);
//
//        KeyValue toY = new KeyValue(cir.translateYProperty(), 240);
//        KeyFrame toYhour = new KeyFrame(Duration.seconds(5), toY);
//
//        Timeline moveball = new Timeline(toXhour, toYhour);
//
//        moveball.getKeyFrames();
//        moveball.setCycleCount(Animation.INDEFINITE);
//        moveball.play();
//
////        Circle cir2 = new Circle(200, 200, 5);
////
////        KeyValue toX2 = new KeyValue(cir2.translateXProperty(), -320);
////        KeyFrame toXhour2 = new KeyFrame(Duration.seconds(5), toX2);
////
////        KeyValue toY2 = new KeyValue(cir2.translateYProperty(), -240);
////        KeyFrame toYhour2 = new KeyFrame(Duration.seconds(5), toY2);
////
////        Timeline moveball2 = new Timeline(toXhour2, toYhour2);
////
////        moveball2.getKeyFrames();
////        moveball2.setCycleCount(Animation.INDEFINITE);
////        moveball2.play();
//
//        StackPane root = new StackPane();
//        root.getChildren().add(cir);
////        root.getChildren().add(cir2);
//        primaryStage.setScene(new Scene(root, 640, 480));
//        primaryStage.show();
//    }
//}
