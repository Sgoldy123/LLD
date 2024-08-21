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

                if (action.equals("CREATE"))addBoard(parts);
                else if(action.equals("DELETE"))deleteBoard(parts);
                else updateBoardParam(parts);
            }
        }
    }

    private static void updateBoardParam(String[] parts) {
        for(Board board : orchestrator.getBoardList()) {
            //System.out.println(board.getBoardId());
                if (parts[1].equals(board.getBoardId()) && parts[2].equals("name")) {
                    board.setName(parts[3]);
                }
                else if (parts[1].equals(board.getBoardId()) && parts[2].equals("privacy")) {
                    board.setPrivacy(Privacy.PRIVATE);
                }
                else if (parts[1].equals(board.getBoardId()) && parts[2].equals("ADD_MEMBER")) {
                        board.addUsers(new User(parts[3]));
                }
                else if (parts[1].equals(board.getBoardId()) && parts[2].equals("REMOVE_MEMBER")) {
                    for(User user : board.getUsers()) {
                        if (user.getName().equals(parts[3])) {
                            board.removeUsers(user);
                        }
                    }
                }


            }
    }

    private static void deleteBoard(String[] parts) {
        Board deleteBoard = null;
        for(Board board : orchestrator.getBoardList()) {
            if (parts[2].equals(board.getBoardId())) {
                deleteBoard = board;
            }
        }
        orchestrator.getBoardList().remove(deleteBoard);
    }

    private static void addBoard(String[] parts) {
        orchestrator.getBoardList().add(new Board(parts[2],"1"));
    }



}
