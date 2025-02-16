package OnlineAuction;

import java.time.LocalDate;

public class Mediator {

    private ItemManager itemManager = ItemManager.getInstance();
    private UserManager userManager = UserManager.getInstance();

    private Mediator() {}

    private static Mediator mediator = new Mediator();

    public static Mediator getInstance() {
        return mediator;
    }

    public void placeBid(String userId, String itemId, double price) {

        User user = userManager.getUsers().get(userId);
        Item item = itemManager.getItems().get(itemId);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        if (LocalDate.now().isAfter(item.getLastAuctionDate())) {
            System.out.println("Auction date has passed. No more bids allowed.");
            return; // Stop further processing if the auction has ended
        }

        // Synchronize only the critical section where the item bid is updated
        synchronized (item) {
            if (item.getNewBidPrice() < price) {
                System.out.println("Bid placed successfully by " + userId);
                item.setNewBidPrice(price);
                userManager.notifyAllUser(user, item);
            } else {
                System.out.println("New bid price must be higher than the current highest bid.");
            }
        }
    }
}
