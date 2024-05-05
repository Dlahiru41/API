package entitities;

import java.util.Date;

public class Appointment {
    private int id;
    private Date dateTime;
    private Patient patient;
    private Doctor doctor;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }


    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public long getPatientId() {
        return patient.getPatientId();
    }


    public long getDoctorId() {
        return doctor.getDoctorId();
    }

}
