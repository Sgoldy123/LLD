package NoBroker;

import java.util.*;

class PropertyHuntSystem {
    Map<String, User> users;
    List<Property> properties;
    User currentUser;

    public PropertyHuntSystem() {
        this.users = new HashMap<>();
        this.properties = new ArrayList<>();
        this.currentUser = null;
    }

    public void register(String name) {
        if (users.containsKey(name)) {
            System.out.println("NoBroker.User already exists.");
        } else {
            users.put(name, new User(name));
            System.out.println("NoBroker.User " + name + " registered.");
        }
    }

    public void login(String name) {
        if (users.containsKey(name)) {
            currentUser = users.get(name);
            currentUser.login();
            System.out.println("Welcome " + name);
        } else {
            System.out.println("NoBroker.User not found.");
        }
    }

    public void logout() {
        if (currentUser != null) {
            currentUser.logout();
            System.out.println("Logged out " + currentUser.name);
            currentUser = null;
        } else {
            System.out.println("No user logged in.");
        }
    }

    public void listProperty(String title, String location, double price, String listingType, double size, String rooms, List<String> nearbyLocations) {
        if (currentUser != null) {
            Property property = new Property(title, location, price, listingType, size, rooms, nearbyLocations);
            properties.add(property);
            System.out.println("Listing created successfully.");
        } else {
            System.out.println("You aren't logged in.");
        }
    }

    public void search(String location, double minPrice, double maxPrice, String listingType, double minSize, double maxSize, String rooms, String sortBy) {
        List<Property> results = new ArrayList<>();
        for (Property property : properties) {
            if (property.isAvailable &&
                    (location == null || property.location.equalsIgnoreCase(location) || property.nearbyLocations.contains(location)) &&
                    (minPrice == -1 || property.price >= minPrice) &&
                    (maxPrice == -1 || property.price <= maxPrice) &&
                    (listingType == null || property.listingType.equalsIgnoreCase(listingType)) &&
                    (minSize == -1 || property.size >= minSize) &&
                    (maxSize == -1 || property.size <= maxSize) &&
                    (rooms == null || property.rooms.equalsIgnoreCase(rooms))) {
                results.add(property);
            }
        }

        if (sortBy != null) {
            if (sortBy.equalsIgnoreCase("price")) {
                results.sort(Comparator.comparingDouble(p -> p.price));
            } else if (sortBy.equalsIgnoreCase("size")) {
                results.sort(Comparator.comparingDouble(p -> p.size));
            }
        }

        System.out.println("Id\tTitle\tLocation\tPrice\tSize\tRooms\tAvailableFor");
        for (Property property : results) {
            System.out.println(property);
        }
    }

    public void shortlistProperty(int propertyId) {
        if (currentUser != null) {
            Property property = findPropertyById(propertyId);
            if (property != null) {
                currentUser.shortlistProperty(property);
                System.out.println("Shortlisted.");
            } else {
                System.out.println("NoBroker.Property not found.");
            }
        } else {
            System.out.println("You aren't logged in.");
        }
    }

    public void viewShortlisted() {
        if (currentUser != null) {
            List<Property> shortlisted = currentUser.getShortlistedProperties();
            System.out.println("Id\tTitle\tLocation\tPrice\tSize\tRooms\tAvailableFor\tStatus");
            for (Property property : shortlisted) {
                System.out.println(property);
            }
        } else {
            System.out.println("You aren't logged in.");
        }
    }

    public void viewListed() {
        if (currentUser != null) {
            System.out.println("Id\tTitle\tLocation\tPrice\tSize\tRooms\tAvailableFor");
            for (Property property : properties) {
                if (property.seller.name.equalsIgnoreCase(currentUser.name)) {
                    System.out.println(property);
                }
            }
        } else {
            System.out.println("You aren't logged in.");
        }
    }

    public void markSold(int propertyId) {
        if (currentUser != null) {
            Property property = findPropertyById(propertyId);
            if (property != null && property.location.equalsIgnoreCase(currentUser.name)) {
                property.markSold();
                System.out.println("NoBroker.Property marked as sold.");
            } else {
                System.out.println("NoBroker.Property not found or not listed by you.");
            }
        } else {
            System.out.println("You aren't logged in.");
        }
    }

    private Property findPropertyById(int propertyId) {
        for (Property property : properties) {
            if (property.id == propertyId) {
                return property;
            }
        }
        return null;
    }
}
