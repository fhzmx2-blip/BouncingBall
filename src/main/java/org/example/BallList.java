package org.example;

import java.util.ArrayList;

public class BallList {
    private ArrayList<Ball> ballList = new ArrayList<>();
    private boolean BallisMoving = true;

    public void listAddBall(Ball ball) {
        ballList.add(ball);
    }

    public Ball listRemoveBall() {
        if (ballList.size()>0) {
            return ballList.remove(0);
        }
        return null;
    }

    public ArrayList<Ball> getBallList() {
        return ballList;
    }

    public void toggleMoving(){
        this.BallisMoving = !this.BallisMoving;
    }

    public boolean BallisMoving(){
        return BallisMoving;
    }
}
