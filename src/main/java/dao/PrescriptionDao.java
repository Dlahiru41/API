package dao;

import entitities.Prescription;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrescriptionDao {
    public static Map<Integer, Prescription> prescriptionMap = new HashMap<>();
    private static int idCounter = 1;

    public List<Prescription> getAllPrescriptions() {
        return new ArrayList<>(prescriptionMap.values());
    }

    public Prescription getPrescriptionById(int id) {
        return prescriptionMap.get(id);
    }

    public void createPrescription(Prescription prescription) {
        prescription.setId(idCounter++);
        prescriptionMap.put(prescription.getId(), prescription);
    }

    public void updatePrescription(int id, Prescription updatedPrescription) {
        if (!prescriptionMap.containsKey(id)) {
            throw new NotFoundException("Prescription with ID " + id + " not found");
        }
        updatedPrescription.setId(id);
        prescriptionMap.put(id, updatedPrescription);
    }

    public void deletePrescription(int id) {
        if (!prescriptionMap.containsKey(id)) {
            throw new NotFoundException("Prescription with ID " + id + " not found");
        }
        prescriptionMap.remove(id);
    }
}
