package HotelManagement.customer;

import HotelManagement.Hotel;
import HotelManagement.menu.Item;
import HotelManagement.menu.MenuItem;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Order {
    private Map<Item, MenuItem> orderList;
    private  Hotel hotel;
    public Order(Hotel hotel){
        this.orderList=new HashMap<>();
        this.hotel=hotel;
    }

    public void setOrderWithItems(Item item, Integer cnt){
        if(hotel.getMenu().getMenuItemCount().get(item).getCount()>=cnt){
            MenuItem menuItem=hotel.getMenu().getMenuItemCount().get(item);
            menuItem.setCount(menuItem.getCount()-cnt);
            hotel.getMenu().getMenuItemCount().put(item,menuItem);
            orderList.put(item,new MenuItem(item,menuItem.getPrice(),cnt));
        }
        else{
            System.out.println("your count is greater than left items");
        }

    }

    public String getBill(){
        StringBuilder stringBuilder=new StringBuilder();
        Integer totalAmount=0;
        for(Map.Entry<Item,MenuItem> it:orderList.entrySet()){
            stringBuilder.append(it.getKey()+" - "+it.getValue().getPrice()+"\n");
            totalAmount+=it.getValue().getPrice()*it.getValue().getCount();
        }
        stringBuilder.append("Total Bill: "+ totalAmount +"\n");
        return stringBuilder.toString();
    }
}
