package Appointment;

import java.util.*;

class BookingManager {
    Map<String, Doctor> doctors = new HashMap<>();
    Map<String, Patient> patients = new HashMap<>();
    Map<String, Appointment> appointments = new HashMap<>();
    Map<String, List<Appointment>> doctorAppointments = new HashMap<>();
    Map<String, List<Appointment>> patientAppointments = new HashMap<>();
    Map<Speciality, List<Doctor>> specialityDoctors = new HashMap<>();
    Map<String, Integer> doctorAppointmentCount = new HashMap<>(); // For trending doctor

    public void registerDoctor(String doctorId, Speciality speciality) {
        if (doctors.containsKey(doctorId)) {
            System.out.println("Doctor already registered!");
            return;
        }
        Doctor doctor = new Doctor(doctorId, speciality);
        doctors.put(doctorId, doctor);
        specialityDoctors.computeIfAbsent(speciality, k -> new ArrayList<>()).add(doctor);
        System.out.println("Welcome Dr. " + doctorId + "!");
    }

    public void markAvailability(String doctorId, String... slots) {
        if (!doctors.containsKey(doctorId)) {
            System.out.println("Doctor not found!");
            return;
        }
        Doctor doctor = doctors.get(doctorId);
        for (String slot : slots) {
            if (!doctor.addAvailability(slot)) {
                System.out.println("Failed to mark slot: " + slot);
            }
        }
        System.out.println("Done Doc!");
    }

    public void showAvailableBySpeciality(Speciality speciality) {
        if (!specialityDoctors.containsKey(speciality)) {
            System.out.println("No doctors available.");
            return;
        }
        for (Doctor doctor : specialityDoctors.get(speciality)) {
            for (String slot : doctor.freeSlots) {
                System.out.println("Dr." + doctor.doctorId + ": (" + slot + ")");
            }
        }
    }

    public String bookAppointment(String patientId, String doctorId, String startTime) {
        if (!patients.containsKey(patientId)) {
            patients.put(patientId, new Patient(patientId)); // Auto-register patient
        }
        if (!doctors.containsKey(doctorId)) {
            return "Doctor not found!";
        }

        Doctor doctor = doctors.get(doctorId);
        if (!doctor.isSlotAvailable(startTime)) {
            doctor.bookedSlots.computeIfAbsent(startTime, k -> new LinkedList<>()).add(patientId);
            return "Slot full! Added to waitlist.";
        }

        // Create Appointment
        String appointmentId = UUID.randomUUID().toString();
        Appointment appointment = new Appointment(appointmentId, doctorId, patientId, startTime);
        appointments.put(appointmentId, appointment);

        doctor.freeSlots.remove(startTime);
        doctor.bookedSlots.put(startTime, new LinkedList<>(List.of(patientId)));

        doctorAppointments.computeIfAbsent(doctorId, k -> new ArrayList<>()).add(appointment);
        patientAppointments.computeIfAbsent(patientId, k -> new ArrayList<>()).add(appointment);
        doctorAppointmentCount.put(doctorId, doctorAppointmentCount.getOrDefault(doctorId, 0) + 1);

        return "Booked. Booking id: " + appointmentId;
    }

    public void cancelAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            System.out.println("Booking ID not found!");
            return;
        }
        Appointment appointment = appointments.remove(appointmentId);
        Doctor doctor = doctors.get(appointment.doctorId);
        doctorAppointmentCount.put(appointment.doctorId, doctorAppointmentCount.get(appointment.doctorId) - 1);

        Queue<String> waitlist = doctor.bookedSlots.get(appointment.startTime);
        if (waitlist != null && !waitlist.isEmpty()) {
            String nextPatient = waitlist.poll();
            bookAppointment(nextPatient, appointment.doctorId, appointment.startTime);
        } else {
            doctor.freeSlots.add(appointment.startTime);
        }
        System.out.println("Booking Cancelled");
    }

    public void showTrendingDoctor() {
        String trendingDoctor = Collections.max(doctorAppointmentCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Trending Doctor: Dr. " + trendingDoctor);
    }
}
