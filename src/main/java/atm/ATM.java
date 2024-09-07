package atm;


import atm.state.IdleState;
import atm.state.State;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ATM {

    private int thousandNotes;
    private int hunderNotes;
    private int fiveHundredNotes;
    private State state;

    public int atmBalance(){
        System.out.println("Thousand: "+thousandNotes+" five hundred: "+fiveHundredNotes+" Hundred: "+hunderNotes);
        return thousandNotes*1000+hunderNotes*100+fiveHundredNotes*500;
    }


}
