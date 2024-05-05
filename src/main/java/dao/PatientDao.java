package dao;

import entitities.Patient;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public class PatientDao {
    // Dummy database for storing patients
    public static Map<Integer, Patient> patientDatabase = new HashMap<>();
    private int nextPatientId = 1;

    // Create a new patient
    public Response createPatient(Patient patient) {
        if (patient == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid patient data").build();
        }
        patient.setPatientId(nextPatientId++);
        patientDatabase.put(patient.getPatientId(), patient);
        return Response.status(Response.Status.CREATED).entity(patient).build();
    }

    // Read a patient by ID
    public Response readPatient(int patientId) {
        Patient patient = patientDatabase.get(patientId);
        if (patient == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
        }
        return Response.status(Response.Status.OK).entity(patient).build();
    }

    // Update an existing patient
    public Response updatePatient(int patientId, Patient updatedPatient) {
        Patient existingPatient = patientDatabase.get(patientId);
        if (existingPatient == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
        }
        // Validate and update patient data
        // For simplicity, assume all fields can be updated
        existingPatient.setName(updatedPatient.getName());
        existingPatient.setContactInformation(updatedPatient.getContactInformation());
        existingPatient.setAddress(updatedPatient.getAddress());
        existingPatient.setMedicalHistory(updatedPatient.getMedicalHistory());
        existingPatient.setCurrentHealthStatus(updatedPatient.getCurrentHealthStatus());
        return Response.status(Response.Status.OK).entity(existingPatient).build();
    }

    // Delete an existing patient
    public Response deletePatient(int patientId) {
        if (!patientDatabase.containsKey(patientId)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
        }
        patientDatabase.remove(patientId);
        return Response.status(Response.Status.OK).entity("Patient deleted successfully").build();
    }
}
