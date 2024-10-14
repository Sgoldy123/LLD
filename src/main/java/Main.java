import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static  class Pair{
        long k1;
        int k2;
        Pair(int k1,int k2){
            this.k1=k1;
            this.k2=k2;
        }
        @Override
        public int hashCode(){
            return Objects.hash(k1,k2);
        }

        @Override
        public boolean equals(Object o){
            if(o==this)return true;
            if(o==null || getClass() !=o.getClass())return false;
            Pair p=(Pair) o;
            return p.k1==this.k1 && p.k2==this.k2;
        }
    }
    public static void main(String[] args) {


        Map<Pair,Integer> mp =new HashMap<>();

        mp.put(new Pair(10,1),12);
        mp.put(new Pair(11,2),10);
        mp.put(new Pair(10,1),1002);

        for(Map.Entry<Pair,Integer> it:mp.entrySet())
        {
            System.out.println(" - "+it.getKey().k1+" "+it.getKey().k2 +" -- "+it.getValue());
        }

        System.out.println(mp.get(new Pair(10,1)));


    }
}