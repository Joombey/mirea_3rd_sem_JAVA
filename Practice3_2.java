package com.example.pr_4;
import java.lang.*;


public class Practice3_2 {
    public static void main(String[] args) {
        MovableRectangle s1 = new MovableRectangle(1, 1, 2, 2, 4, 4);
        System.out.println(s1);

        s1.moveDown();
        s1.moveLeft();
        System.out.println(s1);
    }
}

interface Movable{
    abstract void moveUp();
    abstract void moveDown();
    abstract void moveLeft();
    abstract void moveRight();
}

class MovablePoint implements Movable{
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    MovablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    @Override
    public void moveUp() {
        y+= ySpeed;
    }

    @Override
    public void moveDown() {
        y-= ySpeed;
    }

    @Override
    public void moveLeft() { x-=xSpeed; }

    @Override
    public void moveRight() {
        x+=xSpeed;
    }
}

class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center;

    MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius = " + radius +
                ", center = " + center +
                '}';
    }
}

class MovableRectangle implements Movable{
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1,
                            int x2, int y2,
                            int xSpeed, int ySpeed)
    {
        if(ySpeed != xSpeed){
            System.out.println("Скорости не одинаковы");
        }
        else {
            topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
            bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
        }
    }

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft= " + topLeft +
                ", bottomRight= " + bottomRight +
                '}';
    }
}