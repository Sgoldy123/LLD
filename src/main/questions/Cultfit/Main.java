import java.util.*;
import java.util.concurrent.*;

class User {
    String userId;
    String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

class Center {
    String centerId;
    String city;
    String location;
    double latitude;
    double longitude;
    Map<String, Workout> workouts;

    public Center(String centerId, String city, String location, double latitude, double longitude) {
        this.centerId = centerId;
        this.city = city;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.workouts = new HashMap<>();
    }

    public void addWorkout(String workoutType, int seats, int waitingListSize) {
        workouts.put(workoutType, new Workout(workoutType, seats, waitingListSize));
    }

    public void addSlot(String workoutType, String slotTime) {
        Workout workout = workouts.get(workoutType);
        if (workout != null) {
            workout.addSlot(slotTime);
        }
    }

    public void removeSlot(String workoutType, String slotTime) {
        Workout workout = workouts.get(workoutType);
        if (workout != null) {
            workout.removeSlot(slotTime);
        }
    }
}

class Workout {
    String workoutType;
    int seats;
    int waitingListSize;
    Map<String, Slot> slots;

    public Workout(String workoutType, int seats, int waitingListSize) {
        this.workoutType = workoutType;
        this.seats = seats;
        this.waitingListSize = waitingListSize;
        this.slots = new HashMap<>();
    }

    public void addSlot(String slotTime) {
        slots.put(slotTime, new Slot(slotTime, seats, waitingListSize));
    }

    public void removeSlot(String slotTime) {
        slots.remove(slotTime);
    }
}

class Slot {
    String slotTime;
    int availableSeats;
    int waitingListSize;
    Queue<User> waitingList;
    Set<User> bookedUsers;

    public Slot(String slotTime, int seats, int waitingListSize) {
        this.slotTime = slotTime;
        this.availableSeats = seats;
        this.waitingListSize = waitingListSize;
        this.waitingList = new LinkedList<>();
        this.bookedUsers = new HashSet<>();
    }

    public synchronized boolean bookSlot(User user) {
        if (availableSeats > 0) {
            bookedUsers.add(user);
            availableSeats--;
            return true;
        } else if (waitingList.size() < waitingListSize) {
            waitingList.add(user);
            return false;
        }
        return false;
    }

    public synchronized void cancelSlot(User user) {
        if (bookedUsers.remove(user)) {
            availableSeats++;
            if (!waitingList.isEmpty()) {
                User nextUser = waitingList.poll();
                bookedUsers.add(nextUser);
                availableSeats--;
                System.out.println("User " + nextUser.name + " has been promoted from the waiting list.");
            }
        } else {
            waitingList.remove(user);
        }
    }
}

class Booking {
    String bookingId;
    User user;
    Center center;
    String workoutType;
    String slotTime;
    Date date;

    public Booking(String bookingId, User user, Center center, String workoutType, String slotTime, Date date) {
        this.bookingId = bookingId;
        this.user = user;
        this.center = center;
        this.workoutType = workoutType;
        this.slotTime = slotTime;
        this.date = date;
    }
}

class FlipFitService {
    Map<String, User> users;
    Map<String, Center> centers;
    Map<String, Booking> bookings;

    public FlipFitService() {
        this.users = new HashMap<>();
        this.centers = new HashMap<>();
        this.bookings = new HashMap<>();
    }

    public void registerUser(String userId, String name) {
        users.put(userId, new User(userId, name));
    }

    public void addCenter(String centerId, String city, String location, double latitude, double longitude) {
        centers.put(centerId, new Center(centerId, city, location, latitude, longitude));
    }

    public void addWorkoutToCenter(String centerId, String workoutType, int seats, int waitingListSize) {
        Center center = centers.get(centerId);
        if (center != null) {
            center.addWorkout(workoutType, seats, waitingListSize);
        }
    }

    public void addSlotToWorkout(String centerId, String workoutType, String slotTime) {
        Center center = centers.get(centerId);
        if (center != null) {
            center.addSlot(workoutType, slotTime);
        }
    }

    public void removeSlotFromWorkout(String centerId, String workoutType, String slotTime) {
        Center center = centers.get(centerId);
        if (center != null) {
            center.removeSlot(workoutType, slotTime);
        }
    }

    public List<String> getAvailableSlots(String centerId, String workoutType) {
        Center center = centers.get(centerId);
        if (center != null) {
            Workout workout = center.workouts.get(workoutType);
            if (workout != null) {
                List<String> availableSlots = new ArrayList<>();
                for (Map.Entry<String, Slot> entry : workout.slots.entrySet()) {
                    if (entry.getValue().availableSeats > 0) {
                        availableSlots.add(entry.getKey());
                    }
                }
                return availableSlots;
            }
        }
        return Collections.emptyList();
    }

    public boolean bookSlot(String userId, String centerId, String workoutType, String slotTime, Date date) {
        User user = users.get(userId);
        Center center = centers.get(centerId);
        if (user != null && center != null) {
            Workout workout = center.workouts.get(workoutType);
            if (workout != null) {
                Slot slot = workout.slots.get(slotTime);
                if (slot != null) {
                    boolean booked = slot.bookSlot(user);
                    if (booked) {
                        String bookingId = UUID.randomUUID().toString();
                        bookings.put(bookingId, new Booking(bookingId, user, center, workoutType, slotTime, date));
                        return true;
                    } else {
                        System.out.println("User " + user.name + " has been added to the waiting list.");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void cancelSlot(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            Center center = booking.center;
            Workout workout = center.workouts.get(booking.workoutType);
            if (workout != null) {
                Slot slot = workout.slots.get(booking.slotTime);
                if (slot != null) {
                    slot.cancelSlot(booking.user);
                    bookings.remove(bookingId);
                }
            }
        }
    }

    public List<Booking> viewUserBookings(String userId, Date date) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.user.userId.equals(userId) && booking.date.equals(date)) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }

    public List<String> recommendSlots(String centerId, String slotTime, String workoutType, String userId, String rankingType) {
        // Implement recommendation logic based on rankingType (time/distance)
        return Collections.emptyList();
    }
}

public class Main {
    public static void main(String[] args) {
        FlipFitService flipFit = new FlipFitService();

        // Register users
        flipFit.registerUser("U1", "Alice");
        flipFit.registerUser("U2", "Bob");

        // Add centers
        flipFit.addCenter("C1", "Bangalore", "Bellandur", 12.935, 77.678);
        flipFit.addCenter("C2", "Bangalore", "Koramangala", 12.934, 77.629);

        // Add workouts to centers
        flipFit.addWorkoutToCenter("C1", "Weights", 10, 5);
        flipFit.addWorkoutToCenter("C1", "Yoga", 15, 5);

        // Add slots to workouts
        flipFit.addSlotToWorkout("C1", "Weights", "6:00 AM");
        flipFit.addSlotToWorkout("C1", "Weights", "7:00 AM");
        flipFit.addSlotToWorkout("C1", "Yoga", "6:00 PM");

        // Book slots
        flipFit.bookSlot("U1", "C1", "Weights", "6:00 AM", new Date());
        flipFit.bookSlot("U2", "C1", "Weights", "6:00 AM", new Date());

        // View user bookings
        List<Booking> aliceBookings = flipFit.viewUserBookings("U1", new Date());
        for (Booking booking : aliceBookings) {
            System.out.println("Booking ID: " + booking.bookingId + ", Center: " + booking.center.location + ", Workout: " + booking.workoutType + ", Slot: " + booking.slotTime);
        }

        // Cancel slot
        flipFit.cancelSlot(aliceBookings.get(0).bookingId);

        // Recommend slots
        List<String> recommendedSlots = flipFit.recommendSlots("C1", "6:00 AM", "Weights", "U1", "time");
        System.out.println("Recommended slots: " + recommendedSlots);
    }
}