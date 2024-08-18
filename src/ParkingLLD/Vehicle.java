package ParkingLLD;

public class Vehicle
{
    String number;
    Type vechileType;

    public Vehicle(String number, Type vechileType) {
        this.number = number;
        this.vechileType = vechileType;
    }

    public String getNumber() {
        return number;
    }

    public Type getVechileType() {
        return vechileType;
    }
}
