package HotelManagement.menu;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItem {

    private Item item;
    private Integer price;
    private int count;

    public MenuItem(Item item,Integer price,int count){
        this.item=item;
        this.price=price;
        this.count=count;
    }
}
