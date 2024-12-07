package RideShare;

import lombok.Getter;
import lombok.Setter;

import java.util.Vector;

@Getter
@Setter
public class User {
    private String userId;
    private Vehicle vehicle;

    public User(String userId, Vehicle vehicle) {
        this.userId = userId;
        this.vehicle = vehicle;
    }
}
