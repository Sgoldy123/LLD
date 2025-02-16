package Elevator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Floor {
     private int floorno;
     private  ExternalButton externalButton;
}
