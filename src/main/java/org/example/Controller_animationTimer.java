//package org.example;
//
//import javafx.animation.AnimationTimer;
//import javafx.scene.layout.Pane;
//
//import java.util.ArrayList;
//
//public class Controller_animationTimer {
//    ArrayList<Ball> ballList = new ArrayList<>();
//
//    public void addBall(Pane pane) {
//        Ball visibleBall = new Ball(5, 640,480);
//        ballList.add(visibleBall);
//        pane.getChildren().add(visibleBall.getCircle());
//    }
//
//    public void removeBall(Pane pane){
//        if (ballList.size()>0){
//            Ball removeball = ballList.remove(0);
//            pane.getChildren().remove(removeball.getCircle());
//        }
//    }
//
//    public void listViewer(Pane pane){
//        System.out.println(ballList.size());
//    }
//
//    public Controller() {
//        bounceBallAnimation();
//    }
//
//
//
//
//    private void bounceBallAnimation() {
//        AnimationTimer movingcircle = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                for (Ball ball : ballList) {
//                    ball.moveBall();
//                }
//            }
//        };
//        movingcircle.start();
//    }
//
//
//}
