package dao;

import entitities.Doctor;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public class DoctorDao {
    // Dummy database for storing doctors
    public static Map<Integer, Doctor> doctorDatabase = new HashMap<>();
    private int nextDoctorId = 1;

    // Create a new doctor
    public Response createDoctor(Doctor doctor) {
        if (doctor == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid doctor data").build();
        }
//        doctor.setDoctorId(nextDoctorId++);
        doctorDatabase.put(doctor.getDoctorId(), doctor);
        return Response.status(Response.Status.CREATED).entity(doctor).build();
    }

    // Read a doctor by ID
    public Response readDoctor(int doctorId) {
        Doctor doctor = doctorDatabase.get(doctorId);
        if (doctor == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
        }
        return Response.status(Response.Status.OK).entity(doctor).build();
    }

    // Update an existing doctor
    public Response updateDoctor(int doctorId, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorDatabase.get(doctorId);
        if (existingDoctor == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
        }
        // Validate and update doctor data
        // For simplicity, assume all fields can be updated
        existingDoctor.setName(updatedDoctor.getName());
        existingDoctor.setContactInformation(updatedDoctor.getContactInformation());
        existingDoctor.setAddress(updatedDoctor.getAddress());
        existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
        return Response.status(Response.Status.OK).entity(existingDoctor).build();
    }

    // Delete an existing doctor
    public Response deleteDoctor(int doctorId) {
        if (!doctorDatabase.containsKey(doctorId)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
        }
        doctorDatabase.remove(doctorId);
        return Response.status(Response.Status.OK).entity("Doctor deleted successfully").build();
    }
}
