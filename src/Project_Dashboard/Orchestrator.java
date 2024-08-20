package Project_Dashboard;

import java.util.ArrayList;
import java.util.List;

public class Orchestrator {
    private static Orchestrator orchestrator = new Orchestrator();

    private List<Board> boardList ;

    private List<User> userList;

    public List<Board> getBoardList() {
        return boardList;
    }
    public List<User> getuserList() {
        return userList;
    }

    public Orchestrator(){
        this.boardList = new ArrayList<Board>();
        this.userList = new ArrayList<User>();
    }
    public static Orchestrator getOrchestrator(){
        return orchestrator;
    }


    static void processCommand(String command) {
        if (command.startsWith("BOARD")) {
            String[] parts = command.split(" ");
            if (parts.length >= 2) {
                String action = parts[1];

                switch (action) {
                    case "CREATE":
                        addBoard(parts);
                        break;
                    case "DELETE":
                        deleteBoard(parts);
                        break;
                    default:
                        updateBoardParam(parts);
                        break;
                }
            }
        }
    }

    private static void updateBoardParam(String[] parts) {
        for(Board board : orchestrator.getBoardList()) {
                if (parts[2].equals(board.getBoardId()) && parts[3] == "name") {
                    board.setName(parts[4]);
                }
                else if (parts[2].equals(board.getBoardId()) && parts[3] == "privacy") {
                    board.setName(parts[4]);
                }
                else if (parts[2].equals(board.getBoardId()) && parts[3] == "ADD_MEMBER") {
                        board.addUsers(new User(parts[4]));
                }
                else if (parts[2].equals(board.getBoardId()) && parts[3] == "REMOVE_MEMBER") {
                    for(User user : board.getUsers()) {
                        if (user.getName().equals(parts[4])) {
                            board.removeUsers(user);
                        }
                    }
                }


            }
    }

    private static void deleteBoard(String[] parts) {
        for(Board board : orchestrator.getBoardList()) {
            if (parts[2].equals(board.getBoardId())) {
                orchestrator.getBoardList().remove(board);
            }
        }
    }

    private static void addBoard(String[] parts) {
        orchestrator.getBoardList().add(new Board(parts[2]));
    }



}
