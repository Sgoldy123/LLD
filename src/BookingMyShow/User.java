package BookingMyShow;

public class User {
    private int userId;
    private Location location;

    public User(int userId, Location location) {
        this.userId = userId;
        this.location = location;
    }

    public int getUserId() {
        return userId;
    }

    public Location getLocation() {
        return location;
    }
}
