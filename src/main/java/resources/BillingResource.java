package resources;
import dao.BillingDao;
import entitities.Billing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/billings")
public class BillingResource {
    private BillingDao BillingDao = new BillingDao();


    @GET
    @Produces("application/json")
    public List<Billing> getAllBillings() {
        return BillingDao.getAllBillings();
    }

    @GET
    @Path("/{billingId}")
    @Produces("application/json")
    public Response getBillingById(@PathParam("billingId") int id) {
        Billing billing = BillingDao.getBillingById(id);
        if (billing == null) {
            throw new NotFoundException("Billing with ID " + id + " not found");
        }
        return Response.ok(billing).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBilling(Billing billing) {
        BillingDao.createBilling(billing);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{billingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("billingId") int id, Billing updatedBilling) {
        BillingDao.updateBilling(id, updatedBilling);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{billingId}")
    public Response deleteBilling(@PathParam("billingId") int id) {
        BillingDao.deleteBilling(id);
        return Response.noContent().build();
    }
}

