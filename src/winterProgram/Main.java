package winterProgram;

import Asteroids.AsteroidGame;
import acm.program.ConsoleProgram;

public class Main extends ConsoleProgram {

    public void startHelloWorld() {
        HelloProgram helloProgram = new HelloProgram();
        helloProgram.start();
    }

    public void startFeltBoard() {
        FeltBoard program = new FeltBoard();
        program.start();
    }

    @Override
    public void run() {
        println("Choose Program");
        println("1- Addition Calculator\n2- For Felt Board\n3- For Asteroid Game");
        int chosenGame = readInt("Your Choice: ");

        if (chosenGame == 1) {
            startHelloWorld();
            return;
        } else if (chosenGame == 2)
            startFeltBoard();
        else if (chosenGame == 3)
            new AsteroidGame().start();

        else println("No Game Chosen");

    }

    public static void main(String[] args) {
        new Main().start();

    }
}
