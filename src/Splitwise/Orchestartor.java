package Splitwise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Orchestartor {

    public static void main(String args[]){



//        Balance test = sahil.getBalance();
//        test.getGetback().put(sahil,100);
//        test.getGetback().put(sahil,500);
//        for(Map.Entry<User,Integer> it: test.getGetback().entrySet()){
//            System.out.println(it.getKey().getId() +" " +it.getValue());
//        }


        User sahil = new User("Sahil");
        User soumya = new User("Soumya");
        User abhay = new User("Abhay");

        UserController userController=UserController.getUserController();
        userController.addUser(sahil);
        userController.addUser(soumya);
        userController.addUser(abhay);


        List<User> listUser=userController.getUserList();
        List<Double> share= Arrays.asList(0.0,0.2,0.8);
        Expense expense1=new Expense(sahil,1,50,listUser,Type.PERCENT,share);
        Expense expense2=new Expense(soumya,2,50,listUser,Type.PERCENT,Arrays.asList(0.4,0.6,0.0));
        Expense expense3=new Expense(abhay,3,100,listUser,Type.PERCENT,Arrays.asList(0.3,0.0,0.7));

        Balance test = sahil.getBalance();
        System.out.println("get back sahil");
        for(Map.Entry<User,Double> it: test.getGetback().entrySet()){
            System.out.println(it.getKey().getId() +" " +it.getValue());
        }

        System.out.println("get owe sahil");
        for(Map.Entry<User,Double> it: test.getGive().entrySet()){
            System.out.println(it.getKey().getId() +" " +it.getValue());
        }


        System.out.println("******************************************************************");
         test = soumya.getBalance();
        System.out.println("get back soumya");
        for(Map.Entry<User,Double> it: test.getGetback().entrySet()){
            System.out.println(it.getKey().getId() +" " +it.getValue());
        }

        System.out.println("get owe soumya");
        for(Map.Entry<User,Double> it: test.getGive().entrySet()){
            System.out.println(it.getKey().getId() +" " +it.getValue());
        }


        System.out.println("******************************************************************");
        test = abhay.getBalance();
        System.out.println("get back abhay");
        for(Map.Entry<User,Double> it: test.getGetback().entrySet()){
            System.out.println(it.getKey().getId() +" " +it.getValue());
        }

        System.out.println("get owe abhay");
        for(Map.Entry<User,Double> it: test.getGive().entrySet()){
            System.out.println(it.getKey().getId() +" " +it.getValue());
        }



    }
}
