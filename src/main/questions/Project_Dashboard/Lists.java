package Project_Dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lists {
    private String listsId;
    private String name;
    private List<Card> cardList;

    public Lists(String name) {
        this.listsId = "listsId_" + UUID.randomUUID().toString();
        this.name = name;
        this.cardList = new ArrayList<Card>();
    }
    public void addCard(Card card){
        this.cardList.add(card);
    }

    public void removeCard(Card card){
        this.cardList.remove(card);
    }

    public String getListsId() {
        return listsId;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCardList() {
        return cardList;
    }
}
