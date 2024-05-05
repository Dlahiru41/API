package dao;

import entitities.Appointment;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentDao {
    public static Map<Integer, Appointment> appointmentMap = new HashMap<>();
    private static int idCounter = 1;

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointmentMap.values());
    }

    public Appointment getAppointmentById(int id) {
        return appointmentMap.get(id);
    }

    public Response createAppointment(Appointment appointment) {
        // Check if the doctor with the specified ID exists
        if (!DoctorDao.doctorDatabase.containsKey(appointment.getDoctorId())) {
            return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
//            throw new NotFoundException("Doctor with ID " + appointment.getDoctorId() + " not found");
        }

        // Check if the patient with the specified ID exists
        if (!PatientDao.patientDatabase.containsKey(appointment.getPatientId())) {
            return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
//            throw new NotFoundException("Patient with ID " + appointment.getPatientId() + " not found");
        }

        // If both doctor and patient exist, proceed with creating the appointment
        appointmentMap.put(appointment.getId(), appointment);
        return Response.status(Response.Status.CREATED).entity(appointment).build();
    }

    public void updateAppointment(int id, Appointment updatedAppointment) {
        if (!appointmentMap.containsKey(id)) {
            throw new NotFoundException("Appointment with ID " + id + " not found");
        }
        updatedAppointment.setId(id);
        appointmentMap.put(id, updatedAppointment);
    }

    public void deleteAppointment(int id) {
        if (!appointmentMap.containsKey(id)) {
            throw new NotFoundException("Appointment with ID " + id + " not found");
        }
        appointmentMap.remove(id);
    }
}
