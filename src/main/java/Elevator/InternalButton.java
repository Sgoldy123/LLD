package Elevator;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.PriorityQueue;

@Builder
@Getter
@Setter
public class InternalButton {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public void pressButton(int currFloor,int destinationFloor,Direction direction){

        if(direction==Direction.UP){
            if(currFloor<destinationFloor){
                minHeap.add(destinationFloor);
            }
            else{
                maxHeap.add(destinationFloor);
            }
        }
        else{
            if(currFloor > destinationFloor){
                maxHeap.add(destinationFloor);
            }
            else {
                minHeap.add(destinationFloor);
            }
        }

    }


}
