package winterProgram;

import Asteroids.SpaceShip;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

/**
 * File: FeltBoard.java
 * --------------------
 * This program offers a simple example of the acm.graphics package
 * that draws a red rectangle and a green oval.  The dimensions of
 * the rectangle are chosen so that its sides are in proportion to
 * the "golden ratio" thought by the Greeks to represent the most
 * aesthetically pleasing geometry.
 */
public class FeltBoard extends GraphicsProgram {
    private final double PHI = 1.618;
    @Override
    public void run() {

        GRect rect = new GRect(100,100,100,100);
        rect.setFilled(true);
        rect.setColor(Color.BLACK);
        add(rect);

        GOval oval = new GOval(100,95,20,20);
        oval.setFilled(true);
        oval.setFillColor(Color.blue);
        add(oval);

        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setLocation(300,100);
        add(spaceShip);



    }
}

