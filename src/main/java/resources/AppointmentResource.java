package resources;
import dao.AppointmentDao;
import entitities.Appointment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/appointments")
public class AppointmentResource {
    private AppointmentDao AppointmentDao = new AppointmentDao();


    @GET
    @Produces("application/json")
    public List<Appointment> getAllAppointments() {
        return AppointmentDao.getAllAppointments();
    }

    @GET
    @Path("/{appointmentId}")
    @Produces("application/json")
    public Response getAppointmentById(@PathParam("appointmentId") int id) {
        Appointment appointment = AppointmentDao.getAppointmentById(id);
        if (appointment == null) {
//            throw new NotFoundException("Appointment with ID " + id + " not found");
            return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
        }
        return Response.ok(appointment).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAppointment(Appointment appointment) {
        AppointmentDao.createAppointment(appointment);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("appointmentId") int id, Appointment updatedAppointment) {
        AppointmentDao.updateAppointment(id, updatedAppointment);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{appointmentId}")
    public Response deleteAppointment(@PathParam("appointmentId") int id) {
        AppointmentDao.deleteAppointment(id);
        return Response.noContent().build();
    }
}
