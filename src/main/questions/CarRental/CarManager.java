package CarRental;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CarManager {
    private List<Car> carList = new ArrayList<>();  // Correctly initialize carList
    private static CarManager carManager = new CarManager();  // Singleton

    private CarManager() {
        // carList is initialized when declared above
    }

    public static CarManager getInstance() {
        return carManager;
    }

    public void createCar(String carNo, CarType carType, double pricePerDay) {
     Car car=Car.builder().carno(carNo).carType(carType).pricePerDay(pricePerDay).bookings(new ArrayList<>()).build();
     carList.add(car);
    }

    public List<Car> getCarWithType(CarType carType, LocalDate newStartDate, LocalDate newEndDate) {
        List<Car> filteredCars = new ArrayList<>();  // Filter cars here
        for(Car car:carList){
            if(car.getCarType()==carType){
                List<Booking> bookingList=car.getBookings();
                boolean isAvailable=true;
                for(Booking booking:bookingList){
                    if(newStartDate.isAfter(booking.getEndDate()) || newEndDate.isBefore(booking.getStartDate())){

                    }else {
                        isAvailable=false;
                        break;
                    }
                }
                if(isAvailable)filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
