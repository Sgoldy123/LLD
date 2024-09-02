package Two_Zero_Four_Eight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int gameCount = 0;

        while (true) {
            gameCount++;
            System.out.println("Starting game number: " + gameCount);
            Game game = new Game(4);
            game.print();
            int mov = 0;

            while (true) {
                mov++;
                System.out.println("Game number: " + gameCount + " | Move number: " + mov);

                int x = (int) (Math.random() * 4); // Generates a random integer between 0 and 3

                if (x == 0) {
                    game.moveLeft();
                    System.out.println("Move: Left");
                } else if (x == 1) {
                    game.moveRight();
                    System.out.println("Move: Right");
                } else if (x == 2) {
                    game.moveUp();
                    System.out.println("Move: Up");
                } else {
                    game.moveDown();
                    System.out.println("Move: Down");
                }

                game.print();

                if (game.isLost()) {
                    System.out.println("You lost the game!");
                    break; // End the current game and start a new one
                }

                if (game.isWinner()) {
                    System.out.println("Congratulations! You won the game!");
                    return; // Exit the loop and program since the game is won
                }
            }
        }
    }
}
