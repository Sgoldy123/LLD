package Two_Zero_Four_Eight;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int[][] tiles;
    private int n;
    public Game(int n){
        this.n = n;
        tiles = new int[n][n];
        int i1 = (int)(Math.random()*n);
        int j1 = (int)(Math.random()*n);
        tiles[i1][j1] = 2;

        int i2 = (int)(Math.random()*n);
        int j2 = (int)(Math.random()*n);
        if(i1==i2 && j1==j2)i2=(i2+1)%n;
        tiles[i1][j1] = 2;
    }
    public void print(){
        //System.out.println("kdkdk");
        //System.out.println(n);
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(tiles[i][j] + "_");
            }
            System.out.println();
        }
        System.out.println();
        return;
    }
   public void putRandom(){
        boolean flag = false;
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(tiles[i][j]==0){
                   flag = true;
                   break;
               }
           }
       }
        while(flag){
            int i1 = (int)(Math.random()*n);
            int j1 = (int)(Math.random()*n);
            if(tiles[i1][j1] == 0){
                tiles[i1][j1] = 2;
                break;
            }
        }
   }
   public boolean isWinner(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(tiles[i][j]==2048)return true;
            }
        }
        return false;
   }
    public boolean isLost(){
        //row
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(tiles[i][j]==tiles[i][j+1]){
                    return false;
                }
            }
        }
        //col
        for(int j=0;j<n;j++){
            for(int i=0;i<n-1;i++){
                if(tiles[i][j]==tiles[i+1][j]){
                    return false;
                }
            }
        }
        //no empty space
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(tiles[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
    public void moveLeft(){
        for(int i = 0;i < n;i++){
            List<Integer> nonZeroList = new ArrayList<>();
            for(int j = 0 ;j < n ;j++){
               if(tiles[i][j]!=0) nonZeroList.add(tiles[i][j]);
            }
            int k = 0;
            int index = 0;
            while(k<nonZeroList.size()){
                if(k+1 < nonZeroList.size() && nonZeroList.get(k)==nonZeroList.get(k+1)){
                    tiles[i][index++] = nonZeroList.get(k)+nonZeroList.get(k+1);
                    k+=2;
                }
                else{
                    tiles[i][index++] = nonZeroList.get(k);
                    k++;
                }
            }
            while(index<n)tiles[i][index++]=0;
        }
        putRandom();
        if(isWinner()){
            System.out.println("You have won the game");
            return;
        }
        if(isLost()){
            System.out.println("You have lost the game");
            return;
        }

        print();
    }

    public void moveRight(){
        for(int i = 0;i < n;i++){
            List<Integer> nonZeroList = new ArrayList<>();
            for(int j = n-1 ;j >= 0 ;j--){
                if(tiles[i][j]!=0) nonZeroList.add(tiles[i][j]);
            }
            int k = 0;
            int index = n-1;
            while(k<nonZeroList.size()){
                if(k+1 < nonZeroList.size() && nonZeroList.get(k)==nonZeroList.get(k+1)){
                    tiles[i][index--] = nonZeroList.get(k)+nonZeroList.get(k+1);
                    k+=2;
                }
                else{
                    tiles[i][index--] = nonZeroList.get(k);
                    k++;
                }
            }
            while(index>=0)tiles[i][index--]=0;
        }
        putRandom();
        if(isWinner()){
            System.out.println("You have won the game");
            return;
        }
        if(isLost()){
            System.out.println("You have lost the game");
            return;
        }

        print();
    }
    public void moveUp(){
        for(int j = 0;j < n;j++){
            List<Integer> nonZeroList = new ArrayList<>();
            for(int i = 0 ;i < n ;i++){
                if(tiles[i][j]!=0) nonZeroList.add(tiles[i][j]);
            }
            int k = 0;
            int index = 0;
            while(k<nonZeroList.size()){
                if(k+1 < nonZeroList.size() && nonZeroList.get(k)==nonZeroList.get(k+1)){
                    tiles[index++][j] = nonZeroList.get(k)+nonZeroList.get(k+1);
                    k+=2;
                }
                else{
                    tiles[index++][j] = nonZeroList.get(k);
                    k++;
                }
            }
            while(index<n)tiles[index++][j]=0;
        }
        putRandom();
        if(isWinner()){
            System.out.println("You have won the game");
            return;
        }
        if(isLost()){
            System.out.println("You have lost the game");
            return;
        }

        print();
    }
    public void moveDown(){
        for(int j = 0;j < n;j++){
            List<Integer> nonZeroList = new ArrayList<>();
            for(int i = n-1 ;i >= 0 ;i--){
                if(tiles[i][j]!=0) nonZeroList.add(tiles[i][j]);
            }
            int k = 0;
            int index = n-1;
            while(k<nonZeroList.size()){
                if(k+1 < nonZeroList.size() && nonZeroList.get(k)==nonZeroList.get(k+1)){
                    tiles[index--][j] = nonZeroList.get(k)+nonZeroList.get(k+1);
                    k+=2;
                }
                else{
                    tiles[index--][j] = nonZeroList.get(k);
                    k++;
                }
            }
            while(index>=0)tiles[index--][j]=0;
        }
        putRandom();
        if(isWinner()){
            System.out.println("You have won the game");
            return;
        }
        if(isLost()){
            System.out.println("You have lost the game");
            return;
        }

        print();
    }
}
