package HotelManagement;

import Elevator2.State;
import HotelManagement.customer.Customer;
import HotelManagement.customer.CustomerManager;
import HotelManagement.menu.Item;
import HotelManagement.menu.Menu;
import HotelManagement.menu.MenuItem;
import HotelManagement.payment.Payment;
import HotelManagement.payment.PaymentType;
import HotelManagement.staff.Role;
import HotelManagement.staff.Staff;
import HotelManagement.staff.StaffManager;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class OrchestratorApp {
    public static void main(String[] args) {

        // we adding and creating hotel detail.............

        //  ** menu
        Menu menu=new Menu();
        menu.setMenuItemWithCount(Item.ButterChicken,new MenuItem(Item.ButterChicken,250,10));
        menu.setMenuItemWithCount(Item.Naan,new MenuItem(Item.Naan,25,50));
        menu.setMenuItemWithCount(Item.ShahiPaneer,new MenuItem(Item.ShahiPaneer,200,15));
        menu.setMenuItemWithCount(Item.Pizza,new MenuItem(Item.Pizza,350,20));


        // ** staff
        Staff staff1=new Staff("staff1", Role.Cashier,LocalTime.of(14,0,0),LocalTime.of(23,0,0));
        Staff staff2=new Staff("staff2", Role.Waiter,LocalTime.of(14,0,0),LocalTime.of(23,0,0));
        Staff staff3=new Staff("staff3", Role.Waiter,LocalTime.of(14,0,0),LocalTime.of(23,0,0));
        Staff staff4=new Staff("staff4", Role.Manager,LocalTime.of(16,0,0),LocalTime.of(23,0,0));

        StaffManager staffManager=new StaffManager();
        staffManager.getStaffList().add(staff1); staffManager.getStaffList().add(staff2); staffManager.getStaffList().add(staff3); staffManager.getStaffList().add(staff4);

        // Hotel;
        Hotel hotel=new Hotel(menu,staffManager);

        HotelManager hotelManager=HotelManager.getInstance();
        hotelManager.getHotelList().add(hotel);


        // *** customer
        Customer customer1=new Customer("customer1",hotel);
        Customer customer2=new Customer("customer2",hotel);
        CustomerManager customerManager=hotel.getCustomerManager();
        customerManager.getCustomerList().add(customer1);
        customerManager.getCustomerList().add(customer2);

        customer1.getOrder().setOrderWithItems(Item.ShahiPaneer,2);
        customer1.getOrder().setOrderWithItems(Item.Naan,10);

        //custome go to hotel and order food without reservation
        customer1.getOrder().getBill();
        Payment payment=hotel.getPaymentFactory().getPaymentWithType(PaymentType.Cash);
        payment.makePay();

//        System.out.println("Left naan"+hotel.getMenu().getMenuItemCount().get(Item.Naan).getCount());

        // Reservation
        hotel.getReservationMgr().bookReservation(customer2,LocalDateTime.of(2024,9,25,20,0,0),LocalDateTime.of(2024,9,25,22,0,0));
        hotel.getReservationMgr().bookReservation(customer1,LocalDateTime.of(2024,9,25,21,0,0),LocalDateTime.of(2024,9,25,22,0,0));


    }
}
