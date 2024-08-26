package Project_Dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Board {
  private String boardId;
  private String name;

  private Privacy privacy;
  private List<User> users;
  private List<Lists> lists;

  public Board(String name,String boardId) {
    this.name = name;
    this.boardId = boardId+name;
    this.privacy = Privacy.PUBLIC;
    this.users = new ArrayList<User>();
    this.lists = new ArrayList<Lists>();
  }

  public void addUsers(User user){
    this.users.add(user);
  }
  public void removeUsers(User user){
    this.users.remove(user);
  }
  public void addLists(Lists lists){
    this.lists.add(lists);
  }
  public void removeLists(Lists lists){
    this.lists.remove(lists);
  }
  public String getBoardId() {
    return boardId;
  }

  public String getName() {
    return name;
  }

  public Privacy getPrivacy() {
    return privacy;
  }

  public List<User> getUsers() {
    return users;
  }

  public List<Lists> getLists() {
    return lists;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrivacy(Privacy privacy) {
    this.privacy = privacy;
  }
}
