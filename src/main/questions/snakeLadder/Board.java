package snakeLadder;

import java.util.*;

public class Board
{
    private int boardSize;
    private  Map<Integer,Jump> jumps;
    private ArrayDeque<Player> players;

    public Board(int boardSize) {
        this.boardSize=boardSize;
        jumps=new HashMap<>();
        players=new ArrayDeque<>();
    }

    public void addJumps(int start,int end){
        jumps.put(start,new Jump(start,end));
    }

    public void addPlayer(String name){
        players.addLast(new Player(name,0));
    }

    public Map<Integer, Jump> getJumps() {
        return jumps;
    }

    public ArrayDeque<Player> getPlayer() {
        return players;
    }


    public void gameStart(){

        boolean flag=true;
        String winner=null;
        while(flag){

            Player player=players.pollFirst();
            int rolledValue= Dice.diceRole();
            int cnt=1;
            while(rolledValue%6==0){
                int val=Dice.diceRole();
                rolledValue+=val;
                if(val==6){
                    cnt++;
                }
                if(cnt==3){
                    rolledValue=0;
                    break;
                }
            }
            assert player != null;
            int pos=player.getPos() +rolledValue;
            while(jumps.containsKey(pos)){
                System.out.println(player.getName() + " ' s position shifted from "+ pos+ " to " +jumps.get(pos).getEnd());
                pos=jumps.get(pos).getEnd();
            }
            if(pos>boardSize){
                players.addLast(player);
            }
            else{
                if(pos==boardSize){
                    flag=false;
                    System.out.println(player.getName() + " rolled a "+ rolledValue+" and moved from "+player.getPos()+ " to " +pos);
                    winner=player.getName();
                    break;
                }
                else{
                    System.out.println(player.getName() + " rolled a "+ rolledValue+" and moved from "+player.getPos()+ " to " +pos);
                    player.setPos(pos);
                    players.addLast(player);
                }
            }
        }

        System.out.println(winner+" wins the game");


    }

}
