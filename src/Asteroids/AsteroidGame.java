package Asteroids;

import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.event.KeyEvent;

public class AsteroidGame extends GraphicsProgram implements Constants {
    private Asteroid[] asteroids;
    private SpaceShip spaceShip;
    private Bullet bullet;
    private boolean isGameOver = false;

    private RandomGenerator randomGenerator = RandomGenerator.getInstance();

    @Override
    public void run() {
        setup();
        gameLoop();
    }

    private void setup() {
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        createAsteroid();
        createSpaceship();
        addKeyListeners();
//        waitForClick();
    }

    private void gameLoop() {
        while (!isGameOver) {
            moveAsteroid();
            moveSpaceShip();
            moveBullet();
            detectCollision();
            pause(DELAY);
        }
    }

    private void createAsteroid() {
        asteroids = new Asteroid[NUMBER_OF_ASTEROIDS];
        for (int i = 0; i < NUMBER_OF_ASTEROIDS; i++) {
            asteroids[i] = new Asteroid();
            double x = randomGenerator.nextDouble(0, SCREEN_WIDTH);
            double y = randomGenerator.nextDouble(0, SCREEN_HEIGHT);
            add(asteroids[i], x, y);
        }
    }

    private void createSpaceship() {
        spaceShip = new SpaceShip();
        add(spaceShip, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
    }

    private void moveAsteroid() {
        for (Asteroid asteroid : asteroids) {
            asteroid.move();
        }
    }

    private void moveBullet() {
        if (bullet != null) {
            bullet.move();
        }
    }

    private void moveSpaceShip() {

        spaceShip.move();
    }

    private void detectCollision() {
        checkForAsteroidCollisionWithWalls();
        checkForShipCollisionWithWalls();
    }

    private void checkForAsteroidCollisionWithWalls() {
        for (int i = 0; i < NUMBER_OF_ASTEROIDS; i++) {
            double x = asteroids[i].getX();
            double y = asteroids[i].getY();

            x = (x + SCREEN_WIDTH) % SCREEN_WIDTH;
            y = (y + SCREEN_HEIGHT) % SCREEN_HEIGHT;
            asteroids[i].setLocation(x, y);
        }
    }

    private void checkForShipCollisionWithWalls() {
        double x = spaceShip.getX();
        double y = spaceShip.getY();
        x = (x + SCREEN_WIDTH) % SCREEN_WIDTH;
        y = (y + SCREEN_HEIGHT) % SCREEN_HEIGHT;
        spaceShip.setLocation(x, y);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        switch (code) {
            case 37: //left
                spaceShip.rotate(5);
                break;
            case 39: //right
                spaceShip.rotate(-5);
                break;
            case 38:// up: Accelerate
                spaceShip.accelerate();
                break;
            case 40: //down
                spaceShip.desAccelerate();
                break;
            case 32: // :Fire Bullet
                fireBullet();
                break;
            default:

                break;

        }
//        super.keyPressed(keyEvent);
    }

    private void fireBullet() {
        if (bullet == null) {
            bullet = new Bullet(spaceShip.getAngle());
            add(bullet, spaceShip.getX(), spaceShip.getY());
        }
    }
}
