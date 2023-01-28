package Asteroids;

import acm.graphics.GOval;

import java.awt.*;

public class Bullet extends GOval implements Constants {
    double vy;
    double vx;
    public Bullet(double angle){
        super(BULLET_SIZE,BULLET_SIZE);
        super.setFilled(true);
        super.setColor(Color.red);

        double rads = Math.toRadians(angle);
        vx =  BULLET_SIZE*-Math.sin(rads);
        vy = BULLET_SIZE*-Math.cos(rads);
    }


    public void move() {
        super.move(vx, vy);
    }
}
