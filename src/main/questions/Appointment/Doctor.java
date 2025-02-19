package Appointment;

import Appointment.Speciality;

import java.util.*;

class Doctor {
    String doctorId;
    Speciality speciality;
    Set<String> freeSlots;
    Map<String, Queue<String>> bookedSlots;

    public Doctor(String doctorId, Speciality speciality) {
        this.doctorId = doctorId;
        this.speciality = speciality;
        this.freeSlots = new TreeSet<>(); // Sorted time slots
        this.bookedSlots = new HashMap<>();
    }

    public boolean addAvailability(String startTime) {
        if (freeSlots.contains(startTime) || bookedSlots.containsKey(startTime)) {
            return false; // Overlapping slots not allowed
        }
        freeSlots.add(startTime);
        return true;
    }

    public boolean isSlotAvailable(String startTime) {
        return freeSlots.contains(startTime);
    }
}
