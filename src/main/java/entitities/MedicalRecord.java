package entitities;

import java.util.List;

public class MedicalRecord {
    private int id;
    private Patient patient;
    private List<String> diagnoses;
    private List<String> treatments;
    // Other relevant medical data

    public MedicalRecord(int id, Patient patient, List<String> diagnoses, List<String> treatments) {
        this.id = id;
        this.patient = patient;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
    }

    public MedicalRecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<String> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<String> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<String> treatments) {
        this.treatments = treatments;
    }

    // Constructors, getters, and setters

}