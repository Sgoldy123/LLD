package Elevator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Display {
    private Direction direction;
    private int currFloor;
}
