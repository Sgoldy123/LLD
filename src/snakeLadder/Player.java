package snakeLadder;

public class Player {
    private String name;
    private int pos;

    public Player(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }


    public void setPos(int pos){
        this.pos=pos;
    }
}
