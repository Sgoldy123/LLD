package Project_Dashboard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static synchronized void main(String[] args) {
        Orchestrator orchestrator = Orchestrator.getOrchestrator();

        String fileName = "/Users/soumya.sasmal/Desktop/Practice/LLD/src/Project_Dashboard/input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                orchestrator.processCommand(line);
                print(orchestrator);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





    public static void print(Orchestrator orchestrator){
        List<Board> boardList = orchestrator.getBoardList();
        for(Board board: boardList){
            System.out.println("Borad name is " + board.getName() + ", id is " + board.getBoardId() + ", privacy is " + board.getPrivacy());
            System.out.println("Lists and Cards in this Board are");
            for(Lists lists : board.getLists()){
                System.out.println("Lists name is " + lists.getName() + ", id is " + lists.getListsId());
                for(Card card : lists.getCardList()){
                    System.out.println("Card name is " + card.getName() + ", id is " + card.getCardId() + ", description is " + card.getDescription());
                }
            }
            System.out.println("Users in this Board are");
            for(User user : board.getUsers()) {
                System.out.println("Lists name is " + user.getName() + ", id is " + user.getUserId() + ", email id is " + user.getMail());
            }
        }
        System.out.println("******************");
        System.out.println("*NEW INPUT**");
        System.out.println("******************");
    }


}
