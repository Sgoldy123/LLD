package BookingMyShow;

public class Movie {

    private int movieId;
    private String name;
    private int duration;

    public Movie(int movieId, String name, int duration) {
        this.movieId = movieId;
        this.name = name;
        this.duration = duration;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
