package CarRental;

import BookingMyShow.Location;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Reservation {

    private CarManager carManager;
    private static Reservation reservation=new Reservation();
    private Reservation(){
        carManager=CarManager.getInstance();
    }

    public static Reservation getInstance(){
        return reservation;
    }

    public synchronized void createReservation(Customer customer, LocalDate startDate, LocalDate endDate,CarType carType){
        List<Car>  carList=carManager.getCarWithType(carType,startDate,endDate);
        Car selectedCar=null;
        double price=Double.MAX_VALUE;
        for(Car car:carList) {
            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
            if (price > car.getPricePerDay() * (double) (daysBetween)) {
                price = car.getPricePerDay() * (double) (daysBetween);
                selectedCar=car;
            }
        }
        if(selectedCar==null){
            System.out.println("Car is not available in this slot - " +"-"+customer.getCustomerId());

            return;
        }
        selectedCar.getBookings().add(new Booking(customer,startDate,endDate));
        System.out.println(selectedCar.getCarno() +" is booked!!"+"-"+customer.getCustomerId());
        customer.getCustomerCarList().add(selectedCar.getCarno());
    }

}
