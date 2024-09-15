package Elevator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Builder
@Getter
@Setter
public class Building {
    List<Floor> floors;

    public Building(){

        for(int i=0;i<=10;i++){
            ExternalButton externalButton=ExternalButton.builder().build();
            Floor floor=Floor.builder().floorno(0).externalButton(externalButton).build();
            floors.add(floor);
        }
    }
}
