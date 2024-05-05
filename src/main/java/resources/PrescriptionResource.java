package resources;
import dao.PrescriptionDao;
import entitities.Prescription;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/prescriptions")
public class PrescriptionResource {
    private PrescriptionDao PrescriptionDao = new PrescriptionDao();


    @GET
    @Produces("application/json")
    public List<Prescription> getAllPrescriptions() {
        return PrescriptionDao.getAllPrescriptions();
    }

    @GET
    @Path("/{prescriptionId}")
    @Produces("application/json")
    public Response getPrescriptionById(@PathParam("prescriptionId") int id) {
        Prescription prescription = PrescriptionDao.getPrescriptionById(id);
        if (prescription == null) {
            throw new NotFoundException("Prescription with ID " + id + " not found");
        }
        return Response.ok(prescription).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPrescription(Prescription prescription) {
        PrescriptionDao.createPrescription(prescription);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("prescriptionId") int id, Prescription updatedPrescription) {
        PrescriptionDao.updatePrescription(id, updatedPrescription);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{prescriptionId}")
    public Response deletePrescription(@PathParam("prescriptionId") int id) {
        PrescriptionDao.deletePrescription(id);
        return Response.noContent().build();
    }
}
