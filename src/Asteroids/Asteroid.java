package Asteroids;

import acm.graphics.GRect;

import acm.util.RandomGenerator;

import java.awt.*;

public class Asteroid extends GRect implements Constants {
    private int vx;
    private int vy;
    private RandomGenerator randomGenerator = RandomGenerator.getInstance();

    public Asteroid() {
        super(ASTEROID_SIZE, ASTEROID_SIZE);
        vx = randomGenerator.nextInt(-2, +2);
        vy = randomGenerator.nextInt(-2, +2);
        super.setFilled(true);
        super.setColor(Color.BLACK);

    }

    public void move() {
        super.move(vx, vy);
    }
}
