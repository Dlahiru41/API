package entitities;

public class Person {
    // Attributes
    private String name;
    private String contactInformation;
    private String address;

    // Constructor
    public Person(String name, String contactInformation, String address) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.address = address;
    }
    public Person(){}

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString method to display the object
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
