package snakeLadder;

import java.util.Scanner;

public class Game {
    public static void main(String []args){

        Board board=new Board(100);

        Scanner sc=new Scanner(System.in);
        int totSnake=sc.nextInt();
        while(totSnake>0){
            int s=sc.nextInt();
            int e=sc.nextInt();
            board.addJumps(s,e);
            totSnake--;
        }

        int totLadder=sc.nextInt();
        while(totLadder>0){
            int s= sc.nextInt();
            int e=sc.nextInt();
            board.addJumps(s,e);
            totLadder--;
        }

        int totPlayer=sc.nextInt();
        while(totPlayer>0){
            String playerName=sc.next();
            board.addPlayer(playerName);
            totPlayer--;
        }

       board.gameStart();

    }
}
