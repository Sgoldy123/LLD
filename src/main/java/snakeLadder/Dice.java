package snakeLadder;

public class Dice
{

    public static int diceRole() {
        return (int)(Math.random() * 6) + 1;
    }

}
//0.9999*6--> (0-5.9999) ---> (int) ---> (0-5) ---> +1 ----> (1-6)
