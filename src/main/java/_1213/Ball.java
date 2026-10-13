package _1213;

import java.util.Random;

public class Ball {
    private int x;
    private int y;

    public Ball(){
        Random r = new Random();
        this.x = r.nextInt(100);
        this.y = r.nextInt(100);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
}