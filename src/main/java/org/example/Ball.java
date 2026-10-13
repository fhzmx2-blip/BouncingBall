package org.example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.Random;

public class Ball {
    private int radius;
    private int width;
    private int height;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Circle circle;
    private Color color;


    public Ball(int radius, int width, int height, Color color){
        Random r = new Random();
        this.width=width;
        this.height=height;
        this.radius=radius;
        this.x = r.nextInt(this.radius, this.width-this.radius);
        this.y = r.nextInt(this.radius, this.height-this.radius);
        this.dx = r.nextInt(1,5);
        this.dy = r.nextInt(1,5);
        this.circle=new Circle(this.radius);
        this.color=color;
        this.circle.setFill(this.color);
        placeTheCircle();
    }


    public void moveBall(){
       x = x + dx;
       y = y + dy;

        if (x + radius >= width || x - radius <= 0) {
            dx = -dx;
        }
        if (y + radius >= height || y - radius <= 0) {
            dy = -dy;
        }

        placeTheCircle();
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


    private void placeTheCircle() {
        this.circle.setCenterX(this.x);
        this.circle.setCenterY(this.y);
    }

    public Circle getCircle() {
        return circle;
    }
}