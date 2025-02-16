package Elevator2;

import java.util.List;

public class ExternalButton {

    private List<ElevatorMgr> elevatorMgrList;
    public ExternalButton(List<ElevatorMgr> elevatorMgrList) {
        this.elevatorMgrList = elevatorMgrList;
    }

    public void press(Direction direction, int floorNo) {
        for (ElevatorMgr elevatorMgr : elevatorMgrList) {
            //here just randomply assign floor to elevator
            if(elevatorMgr.getElevator().getDirection()==direction){
                elevatorMgr.addNewRequest(direction,floorNo);
                break;
            }

        }
    }
}
