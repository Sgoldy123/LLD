package OnlineAuction;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ItemManager {

    private Map<String,Item> items;
    private ItemManager(){
        items=new HashMap<>();
    }
    private static ItemManager itemManager=new ItemManager();

    public  static ItemManager getInstance(){
        return itemManager;
    }

    public void addItem(Item item){
        items.put(item.getItemid(),item);
    }


}
