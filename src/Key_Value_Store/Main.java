package Key_Value_Store;

import java.util.Scanner;

import static Key_Value_Store.Orchestrator.processCommand;

public class Main {
    public static void main(String[] args) {
        Orchestrator orchestrator = new Orchestrator();
        Thread th1 = new Thread(()->{orchestrator.processCommand("put 1 a A");});
        Thread th2 = new Thread(()->{orchestrator.processCommand("put 2 a B");});

        th1.start();
        th2.start();
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            String line = sc.nextLine();
//            processCommand(line);
//
//            //data.print();
//        }
    }
}
