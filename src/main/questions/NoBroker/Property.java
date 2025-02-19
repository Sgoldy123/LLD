package NoBroker;

import java.util.List;

class Property {
     static int nextId = 1;
    int id;
    String title;
    String location;
    double price;
    String listingType; // Sell/Rent
    double size; // in sq. ft.
    String rooms; // 1BHK, 2BHK, etc.
    boolean isAvailable;
    User seller;
    List<String> nearbyLocations;

    public Property(String title,User seller, String location, double price, String listingType, double size, String rooms, List<String> nearbyLocations) {
        this.id = nextId++;
        this.title = title;
        this.location = location;
        this.price = price;
        this.listingType = listingType;
        this.size = size;
        this.rooms = rooms;
        this.isAvailable = true;
        this.nearbyLocations = nearbyLocations;
        this.seller = seller;
    }

    public void markSold() {
        isAvailable = false;
    }

    @Override
    public String toString() {
        return id + "\t" + title + "\t" + location + "\t" + price + "\t" + size + "sqft\t" + rooms + "\t" + (isAvailable ? listingType : "Sold");
    }
}
