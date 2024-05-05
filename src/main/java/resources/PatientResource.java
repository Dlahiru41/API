package resources;
import dao.PatientDao;
import entitities.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/patients")
public class PatientResource {
    private PatientDao PatientDao = new PatientDao();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPatient(Patient patient) {
        return PatientDao.createPatient(patient);
    }

    @GET
    @Path("/{patientId}")
    @Produces("application/json")
    public Response getPatient(@PathParam("patientId") int patientId) {
        return PatientDao.readPatient(patientId);
    }

    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("patientId") int patientId, Patient updatedPatient) {
        return PatientDao.updatePatient(patientId, updatedPatient);
    }

    @DELETE
    @Path("/{patientId}")
    public Response deletePatient(@PathParam("patientId") int patientId) {
        return PatientDao.deletePatient(patientId);
    }
}