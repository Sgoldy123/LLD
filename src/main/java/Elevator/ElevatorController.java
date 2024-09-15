package Elevator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ElevatorController {
    private int totFloor=10;
    private List<Elevator> elevatorList;

    public Elevator assignElevator( Direction direction, int currFloor){
        Elevator assignedElevator=null;
        if(direction==Direction.UP) {
            for (Elevator elevator : elevatorList) {
                if (direction == elevator.getDisplay().getDirection() && currFloor > elevator.getDisplay().getCurrFloor()) {
                    if (assignedElevator == null) {
                        assignedElevator = elevator;
                    } else {
                        if (assignedElevator.getDisplay().getCurrFloor() < elevator.getDisplay().getCurrFloor()) {
                            assignedElevator = elevator;
                        }
                    }
                }
            }
            if(assignedElevator==null){
                for (Elevator elevator : elevatorList) {
                    if (direction == elevator.getDisplay().getDirection() && currFloor < elevator.getDisplay().getCurrFloor()) {
                        if (assignedElevator == null) {
                            assignedElevator = elevator;
                        } else {
                            if (totFloor-assignedElevator.getDisplay().getCurrFloor() > totFloor- elevator.getDisplay().getCurrFloor()) {
                                assignedElevator = elevator;
                            }
                        }
                    }
                }
            }

        }
        else{
            for (Elevator elevator : elevatorList) {
                if (direction == elevator.getDisplay().getDirection() && currFloor < elevator.getDisplay().getCurrFloor()) {
                    if (assignedElevator == null) {
                        assignedElevator = elevator;
                    } else {
                        if (assignedElevator.getDisplay().getCurrFloor() > elevator.getDisplay().getCurrFloor()) {
                            assignedElevator = elevator;
                        }
                    }
                }
            }
            if(assignedElevator==null){
                for (Elevator elevator : elevatorList) {
                    if (direction == elevator.getDisplay().getDirection() && currFloor > elevator.getDisplay().getCurrFloor()) {
                        if (assignedElevator == null) {
                            assignedElevator = elevator;
                        }
                        else {
                            if (assignedElevator.getDisplay().getCurrFloor() > elevator.getDisplay().getCurrFloor()) {
                                assignedElevator = elevator;
                            }
                        }
                    }
                }
            }
        }

        return assignedElevator;

    }
}
