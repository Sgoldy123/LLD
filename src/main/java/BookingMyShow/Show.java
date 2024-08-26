package BookingMyShow;

import java.time.LocalDate;
import java.util.Date;

public class Show {

    private Screen screen;
    private LocalDate date;

    public Show(Screen screen, LocalDate date) {
        this.screen = screen;
        this.date = date;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDate getDate() {
        return date;
    }
}
