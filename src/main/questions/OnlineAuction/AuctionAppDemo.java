package OnlineAuction;

import java.time.LocalDate;

public class AuctionAppDemo {

    public static void main(String[] args) {
        UserManager userManager=UserManager.getInstance();
        User user1=userManager.register("user1","12345");
        User user2=userManager.register("user2","123456");
        User user3=userManager.register("user3","1234567");

        Item item1=new Item("item1","item 1 it is...",1500,1500, LocalDate.of(2024,10,16));
        Item item2=new Item("item2","item 2 it is...",2000,2000, LocalDate.of(2024,10,16));
        ItemManager itemManager=ItemManager.getInstance();
        itemManager.addItem(item1);
        itemManager.addItem(item2);


        Mediator mediator=Mediator.getInstance();
        mediator.placeBid("user1","item1",2000);
        System.out.println("item1 "+item1.getNewBidPrice());


        mediator.placeBid("user2","item1",2200);
        System.out.println("item1 "+item1.getNewBidPrice());

        mediator.placeBid("user3","item1",2300);
        System.out.println("item1 "+item1.getNewBidPrice());
    }
}
