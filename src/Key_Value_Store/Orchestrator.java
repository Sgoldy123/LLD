package Key_Value_Store;

import java.util.Scanner;

public class Orchestrator {
    private static Data data = Data.getData();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            processCommand(line);

            //data.print();
        }
    }

    public static synchronized void processCommand(String line){
        String[] inputArray = line.split(" ");
        if(inputArray[0].equals("put"))data.putKey(inputArray);
        else if(inputArray[0].equals("get"))data.getKey(inputArray);
        else if(inputArray[0].equals("delete"))data.deleteKey(inputArray);
        else if(inputArray[0].equals("search"))data.searchKeyVal(inputArray);
    }
}
