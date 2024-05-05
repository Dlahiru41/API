package entitities;

public class Patient extends Person {
    // Additional attribute specific to patients
    private int patientId;
    private String medicalHistory;
    private String currentHealthStatus;

    // Constructor
    public Patient(String name, String contactInformation, String address, int patientId, String medicalHistory, String currentHealthStatus) {
        // Call the constructor of the superclass (Person)
        super(name, contactInformation, address);
        this.patientId = patientId;
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }

    public Patient() {
        super();
    }

    // Getter and setter for patientId
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    // Getters and setters for additional attributes
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }

    // toString method to display the object
    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + super.getName() + '\'' +
                ", contactInformation='" +super.getContactInformation() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", currentHealthStatus='" + currentHealthStatus + '\'' +
                '}';
    }
}

