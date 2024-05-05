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
        if(appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
        appointment.setId(idCounter++);
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
