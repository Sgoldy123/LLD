package Elevator2;

import java.util.ArrayList;
import java.util.List;

public class Orchestrator
{
    public static void main(String[] args) {
        Elevator elevator1=new Elevator(0);
        ElevatorMgr elevatorMgr1=new ElevatorMgr(elevator1);

        Elevator elevator2=new Elevator(4);
        ElevatorMgr elevatorMgr2=new ElevatorMgr(elevator2);

        List<ElevatorMgr> elevatorMgrList=new ArrayList<>();
        elevatorMgrList.add(elevatorMgr1);
        elevatorMgrList.add(elevatorMgr2);

        ExternalButton externalButton=new ExternalButton(elevatorMgrList);

        System.out.println("External Button Pressed: Up at Floor 5");
        externalButton.press(Direction.UP,5);

        System.out.println("External Button Pressed: Down at Floor 1");
        externalButton.press(Direction.DOWN,1);

        System.out.println("Elevator 1 internal button ");
        elevator1.pressInternalButton(2);

        System.out.println("Elevator 2 internal button ");
        elevator2.pressInternalButton(4);
    }
}
