package atm;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Card {
    private int cardNum;
    private int pin;
    private Account account;
}
