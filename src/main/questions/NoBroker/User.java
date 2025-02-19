package NoBroker;

import java.util.ArrayList;
import java.util.List;

class User {
    String name;
    boolean isActive;
    List<Property> shortlistedProperties;

    public User(String name) {
        this.name = name;
        this.isActive = false;
        this.shortlistedProperties = new ArrayList<>();
    }

    public void login() {
        isActive = true;
    }

    public void logout() {
        isActive = false;
    }

    public void shortlistProperty(Property property) {
        shortlistedProperties.add(property);
    }

    public List<Property> getShortlistedProperties() {
        return shortlistedProperties;
    }
}
