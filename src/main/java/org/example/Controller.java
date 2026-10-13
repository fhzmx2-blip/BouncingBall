package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    Timeline tl;
    private Map<Color, BallList> listByColor = new HashMap<>();


    public void colorSelect(ComboBox<Color> groupSelect, Color rawColor)  {
        int r = (int) Math.round(rawColor.getRed() * 255);
        int g = (int) Math.round(rawColor.getGreen() * 255);
        int b = (int) Math.round(rawColor.getBlue() * 255);
        Color fixedColor = Color.rgb(r,g,b);
        listByColor.putIfAbsent(fixedColor, new BallList());
            if (!groupSelect.getItems().contains(fixedColor)) {
            groupSelect.getItems().add(fixedColor);
            }
        groupSelect.setValue(fixedColor);
    }


    public void addBall(Pane pane, ComboBox<Color> groupSelect) {
        Color selectedColor = groupSelect.getValue();
        BallList list = listByColor.computeIfAbsent(selectedColor, k -> new BallList());
        Ball visibleBall = new Ball(5, 640,480, selectedColor);
        list.listAddBall(visibleBall);
        pane.getChildren().add(visibleBall.getCircle());
    }

    public void removeBall(Pane pane, ComboBox<Color> groupSelect){
        Color selectedColor = groupSelect.getValue();
        Ball removeball = listByColor.get(selectedColor).listRemoveBall();
        if (removeball!=null){
            pane.getChildren().remove(removeball.getCircle());
        }
    }

    public void deleteList(Pane pane, ComboBox<Color> groupSelect){
        Color selectedColor = groupSelect.getValue();
        BallList deletingList = listByColor.get(selectedColor);
        for (Ball ball : deletingList.getBallList()){
            pane.getChildren().remove(ball.getCircle());
        }
        listByColor.remove(selectedColor);
        groupSelect.getItems().remove(selectedColor);
    }


    public void onOffSwitch(ComboBox<Color> groupSelect){
        Color selectedColor = groupSelect.getValue();
        listByColor.get(selectedColor).toggleMoving();
    }

    public Controller() {
        KeyFrame kf = new KeyFrame(Duration.millis(9), e -> {
            for (BallList list : listByColor.values()){
                if (list.BallisMoving()){
                    for (Ball ball : list.getBallList()) {
                        ball.moveBall();
                    }
                }
            }
        });
        tl = new Timeline(kf);
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
    }
}
