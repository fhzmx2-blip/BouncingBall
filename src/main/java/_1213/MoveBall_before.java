//package org.example;
//
//import javafx.animation.Animation;
//import javafx.animation.TranslateTransition;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.scene.shape.Circle;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class MoveBall_before extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Moving Ball");
//        Circle cir = new Circle(5);
//
//
//        TranslateTransition moveCir = new TranslateTransition(new Duration(1000), cir);
////        서클 생성, 애니메이션 지정
//        int cirWayX = 0;
//        int cirWayY = 0;
////        서클 이동 지점
//        int cirDiX = 1;
//        int cirDiY = 1;
////        다음 좌표값을 양수값으로 뻗을지, 음수값으로 뻗을지
//
//        moveCir.setFromX(cirWayX);
//        moveCir.setFromY(cirWayY);
//
//        moveCir.setToX(cirWayX+cirDiX);
//        moveCir.setToY(cirWayY+cirDiY);
//
////        if (cirDiX == 1){
////            cirWayX += 1;
////            if (320 <= cirWayX){
////                cirDiX = -1;
////                }
////            }
////        else {
////            cirWayX -= 1;
////            if (-320 >= cirDiX){
////                cirDiX = 1;}
////            }
//
////        X의 방향
//
//
//
//
//
//        moveCir.setAutoReverse(false);
//        moveCir.setCycleCount(Animation.INDEFINITE);
//        moveCir.play();
//
//        StackPane root = new StackPane();
//        root.getChildren().add(cir);
//        primaryStage.setScene(new Scene(root, 640, 480));
//        primaryStage.show();
//    }
//}