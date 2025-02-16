package snakeLadder;

import java.util.Scanner;

public class Game {
    public static void main(String []args){

        Board board=new Board(100);

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Total number pf snakes:-");
        int totSnake=sc.nextInt();
        while(totSnake>0){
            System.out.println("Enter starting and ending position of snake:-");
            int s=sc.nextInt();
            int e=sc.nextInt();
            board.addJumps(s,e);
            totSnake--;
        }
        System.out.println("Enter total number of ladders:-");
        int totLadder=sc.nextInt();
        while(totLadder>0){
            System.out.println("Enter starting and ending position of ladder:-");
            int s= sc.nextInt();
            int e=sc.nextInt();
            board.addJumps(s,e);
            totLadder--;
        }
        System.out.println("Enter total number of player:-");
        int totPlayer=sc.nextInt();
        while(totPlayer>0){
            System.out.println("Enter player name for player-" + totPlayer + ":-");
            String playerName=sc.next();
            board.addPlayer(playerName);
            totPlayer--;
        }

       board.gameStart();

    }
}
