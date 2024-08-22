package Key_Value_Store;

import java.util.Scanner;

public class Orchestrator {
    private static Data data = Data.getData();


    public synchronized static void processCommand(String line){

        String[] inputArray = line.split(" ");
        if(inputArray[0].equals("put"))data.putKey(inputArray);
        else if(inputArray[0].equals("get"))data.getKey(inputArray);
        else if(inputArray[0].equals("delete"))data.deleteKey(inputArray);
        else if(inputArray[0].equals("search"))data.searchKeyVal(inputArray);

        try{
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        data.print();
        System.out.println("_______NEW OUTPUT___________");
        //Thread.sleep(2);
    }
}
