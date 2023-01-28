package Asteroids;

import acm.graphics.GPolygon;

public class SpaceShip extends GPolygon implements Constants {
    private double vx;
    private double vy;
    private double angle = -90;


    public double getAngle() {
        return angle;
    }

    public SpaceShip() {
        super();
        super.addVertex(0, SPACESHIP_SIZE);
        super.addVertex(SPACESHIP_SIZE / 2, -SPACESHIP_SIZE / 2);
        super.addVertex(0, 0);
        super.addVertex(-SPACESHIP_SIZE / 2, -SPACESHIP_SIZE / 2);
    }

    public void move() {
        super.move(vx, vy);
    }


    public void rotate(double delta) {
        super.rotate(delta);
        angle += delta;
    }

    public void accelerate() {
        double rads = Math.toRadians(angle);
        vx += Math.sin(rads);
        vy += Math.cos(rads);
    }

    public void desAccelerate() {
        double rads = Math.toRadians(angle);
        vx -= Math.sin(rads);
        vy -= Math.cos(rads);
    }
}
