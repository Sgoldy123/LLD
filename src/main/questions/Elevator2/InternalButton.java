package Elevator2;

import lombok.Getter;
import lombok.Setter;

import java.util.PriorityQueue;

@Getter
@Setter
public class InternalButton {
    private int desFloor;

    public void pressInternalButton(int desFloor){
        this.desFloor=desFloor;
    }
}
