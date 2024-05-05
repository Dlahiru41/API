package resources;
import dao.DoctorDao;
import entitities.Doctor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/doctors")
public class DoctorResource {
    private DoctorDao DoctorDao = new DoctorDao();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDoctor(Doctor doctor) {
        return DoctorDao.createDoctor(doctor);
    }

    @GET
    @Path("/{doctorId}")
    @Produces("application/json")
    public Response getDoctor(@PathParam("doctorId") int doctorId) {
        return DoctorDao.readDoctor(doctorId);
    }

    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) {
        return DoctorDao.updateDoctor(doctorId, updatedDoctor);
    }

    @DELETE
    @Path("/{doctorId}")
    public Response deleteDoctor(@PathParam("doctorId") int doctorId) {
        return DoctorDao.deleteDoctor(doctorId);
    }
}

