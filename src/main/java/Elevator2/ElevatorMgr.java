package Elevator2;

import lombok.Getter;
import lombok.Setter;

import java.util.PriorityQueue;

@Getter
@Setter
public class ElevatorMgr {
    private Elevator elevator;
    private PriorityQueue<Integer> upRequest;
    private PriorityQueue<Integer> downRequest;

    public  ElevatorMgr(Elevator elevator){
        upRequest=new PriorityQueue<>();
        downRequest=new PriorityQueue<>((a,b)->b-a);
        this.elevator=elevator;
    }

    public void addNewRequest(Direction direction,int desFloor){
        if(direction==Direction.UP){
            if(elevator.getCurrentFloor()<desFloor)upRequest.add(desFloor);
            else downRequest.add(desFloor);
        }
        else{
            if(elevator.getCurrentFloor() > desFloor)downRequest.add(desFloor);
            else upRequest.add(desFloor);
        }

        processRequests();
    }

    private void processRequests(){

        // add logic like lift is moving up or down????
        //this is just assumption
        if (!upRequest.isEmpty()) {
            int nextFloor = upRequest.poll();
            elevator.pressInternalButton(nextFloor);
        } else if (!downRequest.isEmpty()) {
            int nextFloor = downRequest.poll();
            elevator.pressInternalButton(nextFloor);
        }
    }
}
