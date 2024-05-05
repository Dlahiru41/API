package dao;

import entitities.MedicalRecord;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalRecordDao {
    public static Map<Integer, MedicalRecord> medicalRecordMap = new HashMap<>();
    private static int idCounter = 1;

    public List<MedicalRecord> getAllMedicalRecords() {
        if(medicalRecordMap.size()==0){

        }
        return new ArrayList<>(medicalRecordMap.values());
    }

    public MedicalRecord getMedicalRecordById(int id) {
        return medicalRecordMap.get(id);
    }

    public void createMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecord.setId(idCounter++);
        medicalRecordMap.put(medicalRecord.getId(), medicalRecord);
    }

    public void updateMedicalRecord(int id, MedicalRecord updatedMedicalRecord) {
        if (!medicalRecordMap.containsKey(id)) {
            throw new NotFoundException("Medical record with ID " + id + " not found");
        }
        updatedMedicalRecord.setId(id);
        medicalRecordMap.put(id, updatedMedicalRecord);
    }

    public void deleteMedicalRecord(int id) {
        if (!medicalRecordMap.containsKey(id)) {
            throw new NotFoundException("Medical record with ID " + id + " not found");
        }
        medicalRecordMap.remove(id);
    }
}
