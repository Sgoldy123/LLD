package Elevator2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Elevator {
    private Direction direction;
    private State state;
    private InternalButton internalButton;
    private int currentFloor;

    public Elevator( int currentFloor) {
        this.direction = Direction.NONE;
        this.state = State.IDLE;
        this.internalButton = new InternalButton();
        this.currentFloor = currentFloor;
    }

    public void pressInternalButton(int desFloor){
           internalButton.pressInternalButton(desFloor);
           processRequest(desFloor);
    }

    private void processRequest(int desFloor){
            if(desFloor > currentFloor){
                direction=Direction.UP;
                while(currentFloor<desFloor){
                    currentFloor++;
                    System.out.println("Lift At: "+currentFloor);
                    try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                }

            }
            else{
                direction=Direction.DOWN;
                while (currentFloor>desFloor ){
                    currentFloor--;
                    System.out.println("Lift At: "+currentFloor);
                    try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }

    }
}
