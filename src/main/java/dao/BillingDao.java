package dao;

import entitities.Billing;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillingDao {
    public static Map<Integer, Billing> billingMap = new HashMap<>();
    private static int idCounter = 1;

    public List<Billing> getAllBillings() {
        return new ArrayList<>(billingMap.values());
    }

    public Billing getBillingById(int id) {
        return billingMap.get(id);
    }

    public void createBilling(Billing billing) {
        billing.setId(idCounter++);
        billingMap.put(billing.getId(), billing);
    }

    public void updateBilling(int id, Billing updatedBilling) {
        if (!billingMap.containsKey(id)) {
            throw new NotFoundException("Billing with ID " + id + " not found");
        }
        updatedBilling.setId(id);
        billingMap.put(id, updatedBilling);
    }

    public void deleteBilling(int id) {
        if (!billingMap.containsKey(id)) {
            throw new NotFoundException("Billing with ID " + id + " not found");
        }
        billingMap.remove(id);
    }
}
