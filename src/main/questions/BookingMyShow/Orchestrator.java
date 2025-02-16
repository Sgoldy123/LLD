package BookingMyShow;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Orchestrator {

    public static void main(String[] args) {

        TheaterMgr theaterMgr=TheaterMgr.getInstance();
        Location mumLocation=new Location("Mumbai");
        Location blrLocation=new Location("Bengalore");
        // ********* create user
        User user1=new User(1,new Location("Mumbai"));
        User user2=new User(2,new Location("Bengalore"));

        // ********* create Movie
        Movie movie1=new Movie(1,"A",2);
        Movie movie2=new Movie(2,"B",2);
        Movie movie3=new Movie(3,"c",3);

        // ********* create Screen
        Screen screen1=new Screen(1,movie1,new Seats(),10,250);
        Screen screen2=new Screen(2,movie1,new Seats(),11,350);
        Screen screen3=new Screen(3,movie2,new Seats(),15,150);
        Screen screen4=new Screen(4,movie3,new Seats(),17,250);

        // ********** create show
        LocalDate today = LocalDate.now();
        Show show1=new Show(screen1, today);
        Show show2=new Show(screen2,today.plusDays(1));
        Show show3=new Show(screen3,today.plusDays(1));
        Theater theater1=new Theater(1);
        theater1.getShows().add(show1);
        theater1.getShows().add(show2);
        theater1.getShows().add(show3);


        Show show4=new Show(screen4,today.plusDays(2));
        Theater theater2=new Theater(2);
        theater2.getShows().add(show1);
        theater2.getShows().add(show2);
        theater2.getShows().add(show3);
        theater2.getShows().add(show4);

        theaterMgr.addTheater(mumLocation,theater1);
        theaterMgr.addTheater(mumLocation,theater2);


        List<Theater> mumbaiTheaters=theaterMgr.getAllTheaterWithLocation(mumLocation);

//        System.out.println("Mumbai Theater");
//        for(Theater theater : mumbaiTheaters){
//            List<Show> shows=theater.getShows();
//            for(Show show:shows){
//                System.out.println("Theater id:" + theater.getTheaterId()+" Show & screen: "+ show.getScreen().getScreenId()+" Movies "+ show.getScreen().getMovie().getName()+
//                        " Timing: "+show.getScreen().getStartTime()+" Duration:" + show.getScreen().getMovie().getDuration());
//            }
//        }

        for(int ii=0;ii<2;ii++) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a Location");
            Location userLocation = null;
            String loc = sc.next();
            if (loc.equals("Mumbai")) {
                userLocation = mumLocation;
            } else {
                userLocation = blrLocation;
            }

            System.out.println("Theaters List and select one");
            for (Theater theater : theaterMgr.getAllTheaterWithLocation(userLocation)) {
                System.out.println("Theater id: " + theater.getTheaterId());
            }
            int userSelectedTheater = sc.nextInt();
            System.out.println("Show List & select one");
            for (Show show : theaterMgr.getTheater(userSelectedTheater, userLocation).getShows()) {
                System.out.println("Shows: " + show.getScreen().getScreenId() + " " + " Timing: " + show.getScreen().getStartTime() + " Duration:" + show.getScreen().getMovie().getDuration());
            }

            int userSelectedScreen = sc.nextInt();

            System.out.println("Available seat for screen: " + userSelectedScreen);
            Seats seat = theaterMgr.getTheater(userSelectedTheater, userLocation).getShow(userSelectedScreen).getScreen().getSeat();
            for (int i = 0; i < seat.getSeatList().size(); i++) {
                if (seat.getSeatList().get(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("");
            System.out.println("select seat");
            int userSelectedSeatNum = sc.nextInt();

            Ticket ticket = new Ticket(1, 1, userSelectedScreen, userSelectedTheater);
            if (!ticket.isPaymentDone()) {
                ticket.setPaymentDone(true);
                Screen screen = theaterMgr.getTheater(userSelectedTheater, userLocation).getShow(userSelectedScreen).getScreen();
                screen.bookSeat(userSelectedSeatNum);
                ticket.setSeatNum(userSelectedSeatNum);
            }


            System.out.println("Available seat for screen: " + userSelectedScreen);
            Seats seat2 = theaterMgr.getTheater(userSelectedTheater, userLocation).getShow(userSelectedScreen).getScreen().getSeat();
            for (int i = 0; i < seat2.getSeatList().size(); i++) {
                if (seat.getSeatList().get(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("");
        }

    }
}
