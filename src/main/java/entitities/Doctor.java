package entitities;

public class Doctor extends Person {
    // Additional attribute specific to doctors
    private int doctorId;
    private String specialization;

    // Constructor
    public Doctor(String name, String contactInformation, String address, int doctorId, String specialization) {
        // Call the constructor of the superclass (Person)
        super(name, contactInformation, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    public Doctor() {
        super();
    }


    // Getter and setter for doctorId
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    // Getter and setter for specialization
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // toString method to display the object
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", name='" +super.getName() + '\'' +
                ", contactInformation='" + super.getContactInformation() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}

