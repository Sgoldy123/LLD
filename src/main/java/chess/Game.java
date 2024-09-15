package chess;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        ChessBoard chessBoard=ChessBoard.getInstance();
        chessBoard.printChessBoard();
        Deque<User> users=new ArrayDeque<>();
        users.offerLast(new User("A","White"));
        users.offerLast(new User("B","Black"));
        Scanner sc=new Scanner(System.in);
        while(true){
            User user = users.pollFirst();
            String userInput=sc.next();
            String []input=userInput.split(" ");

            if(chessBoard.isValidate(input[0],input[1],user)){

                chessBoard.update(input[0],input[1]);
                chessBoard.printChessBoard();


            }
            else {
                System.out.println("Enter your move again, previous one is invalid");
                users.offerFirst(user);
            }
            if(chessBoard.isWin(user.getPieceColor())){
                System.out.println(user.getUserId()+" won the match!!");
                break;
            }
        }
    }
}
