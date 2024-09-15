package Elevator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Elevator {
    private int capacity;
    private InternalButton internalButton;
    private Display display;
}
