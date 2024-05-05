package resources;
import dao.MedicalRecordDao;
import entitities.MedicalRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/medicalrecords")
@Produces(MediaType.APPLICATION_JSON)
public class MedicalRecordResource {
    private MedicalRecordDao MedicalRecordDao = new MedicalRecordDao();

    @GET
    @Produces("application/json")
    public List<MedicalRecord> getAllMedicalRecords() {
        return MedicalRecordDao.getAllMedicalRecords();
    }

    @GET
    @Path("/{recordId}")
    @Produces("application/json")
    public Response getMedicalRecordById(@PathParam("recordId") int id) {
        MedicalRecord medicalRecord = MedicalRecordDao.getMedicalRecordById(id);
        if (medicalRecord == null) {
            throw new NotFoundException("Medical record with ID " + id + " not found");
        }
        return Response.ok(medicalRecord).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecordDao.createMedicalRecord(medicalRecord);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{recordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicalRecord(@PathParam("recordId") int id, MedicalRecord updatedMedicalRecord) {
        MedicalRecordDao.updateMedicalRecord(id, updatedMedicalRecord);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{recordId}")
    public Response deleteMedicalRecord(@PathParam("recordId") int id) {
        MedicalRecordDao.deleteMedicalRecord(id);
        return Response.noContent().build();
    }
}