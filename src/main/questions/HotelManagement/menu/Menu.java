package HotelManagement.menu;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
public class Menu {
    private Map<Item, MenuItem> menuItemCount;
    public Menu(){
        menuItemCount=new HashMap<>();
    }

    public void setMenuItemWithCount(Item item,MenuItem menuItem){
        menuItemCount.put(item,menuItem);
    }
}
