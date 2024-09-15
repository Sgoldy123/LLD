package CarRental;

import java.time.LocalDate;

public class RentalCarApp {
    public static void main(String[] args) {

        Reservation reservation=Reservation.getInstance();
        CustomerManager customerManager=CustomerManager.getInstance();
        CarManager carManager=CarManager.getInstance();

        // create car
        carManager.createCar("MH01",CarType.SUV,1200);
        carManager.createCar("MH02",CarType.SEDAN,800);
        // create customer
        customerManager.getCustomerList().add(new Customer("customer1"));
        customerManager.getCustomerList().add(new Customer("customer2"));

        // create reservation
        reservation.createReservation(customerManager.getCustomerList().get(0), LocalDate.of(2024,9,15),
                LocalDate.of(2024,9,17),CarType.SEDAN);

        reservation.createReservation(customerManager.getCustomerList().get(0), LocalDate.of(2024,9,16),
                LocalDate.of(2024,9,20),CarType.SUV);


        reservation.createReservation(customerManager.getCustomerList().get(0), LocalDate.of(2024,9,18),
                LocalDate.of(2024,9,20),CarType.SEDAN);

        for(String car:customerManager.getCustomerList().get(0).getCustomerCarList()){
            System.out.println(car);
        }

    }
}
