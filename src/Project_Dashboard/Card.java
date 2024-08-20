package Project_Dashboard;

import java.util.UUID;

public class Card {
    private String cardId;
    private String name;

    private String description;

    private String userId;

    public Card(String name, String description) {
        this.cardId = "cardId_" + UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.userId = null;
    }

    public String getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }
}
