package Appointment;

public class Main {
    public static void main(String[] args) {
        BookingManager manager = new BookingManager();
        manager.registerDoctor("Curious", Speciality.CARDIOLOGIST);
        manager.markAvailability("Curious", "9:30-10:00", "12:30-13:00");

        manager.registerDoctor("Dreadful", Speciality.DERMATOLOGIST);
        manager.markAvailability("Dreadful", "10:30-11:00");

        manager.showAvailableBySpeciality(Speciality.CARDIOLOGIST);
        System.out.println(manager.bookAppointment("PatientA", "Curious", "12:30-13:00"));
        manager.showTrendingDoctor();
    }
}
