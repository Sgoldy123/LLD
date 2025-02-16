package OnlineAuction;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Item {
    private String itemid;
    private String itemDescription;
    private double startingPrice;
    private double newBidPrice;
    private LocalDate lastAuctionDate;

    public Item(String itemid, String itemDescription, double startingPrice, double newBidPrice, LocalDate lastAuctionDate) {
        this.itemid = itemid;
        this.itemDescription = itemDescription;
        this.startingPrice = startingPrice;
        this.newBidPrice = newBidPrice;
        this.lastAuctionDate = lastAuctionDate;
    }
}
