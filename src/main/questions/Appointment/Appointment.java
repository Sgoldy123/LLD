package Appointment;

class Appointment {
    String id;
    String doctorId;
    String patientId;
    String startTime;

    public Appointment(String id, String doctorId, String patientId, String startTime) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.startTime = startTime;
    }
}
