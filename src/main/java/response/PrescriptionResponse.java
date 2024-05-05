package response;

import dao.PatientDao;
import entitities.Patient;
import entitities.Prescription;

public class PrescriptionResponse {
    private Patient patient;
    private Prescription prescription;

    public PrescriptionResponse(Prescription prescription, Patient patient) {
        this.patient = patient;
        this.prescription = prescription;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
