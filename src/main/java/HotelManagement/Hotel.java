package HotelManagement;

import HotelManagement.customer.CustomerManager;
import HotelManagement.menu.Menu;
import HotelManagement.payment.PaymentFactory;
import HotelManagement.reservation.Reservation;
import HotelManagement.reservation.ReservationManager;
import HotelManagement.staff.StaffManager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel {
        private Menu menu;
        private StaffManager staffManager;
        private ReservationManager reservationMgr;
        private PaymentFactory paymentFactory;
        private CustomerManager customerManager;
        public Hotel(Menu menu,StaffManager staffManager){
                this.reservationMgr=new ReservationManager(10);
                this.menu=menu;
                this.staffManager=staffManager;
                this.paymentFactory=new PaymentFactory();
                this.customerManager=new CustomerManager();

        }


}
