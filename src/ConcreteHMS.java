
// This concrete class for making operations in our Hospital Management System. Implements Interface.

public class ConcreteHMS implements HMSComponent {

    private String patientID; // Every patient has an unique ID number.
    private String surname; // Patient's surname.
    private String name; // Patient's name.
    private String address; // Patient's address.
    private String phone_number; // Patient's phone number.

    public ConcreteHMS(String patientID, String name, String surname, String address, String phone_number) {
        // Constructor with five attributes.
        this.patientID = patientID;
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }


    public ConcreteHMS(String patientID) {
        // Constructor with paitent ID.
        this.patientID = patientID;
    }


    public ConcreteHMS(String patientID, String name) {
        // Constructor with two attributes patient ID and patient's name .
        this.patientID = patientID;
        this.name = name;
    }

    // Getters and Setters.
    public String getPatientID() { return patientID; }
    public void setPatientID(String patientID) { this.patientID = patientID; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone_number() { return phone_number; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    @Override
    public void newPatient() {
        // Method for add new patient to Hospital Management System. Also overrides method.
        String output = "Patient " + patientID + " " + name + " " + "added";
        String[] liste = {output};
        String[] liste2 = new String[4];
        liste2[0] = patientID; liste2[1] = getName() + " " + getSurname();
        liste2[2] = getPhone_number() ; liste2[3] = "Address: " + getAddress();
        HMSDecorator.write_data.add(liste);
        HoldData.data_patient.add(liste2);
    }

    @Override
    public void remove() {
        // Method for removing patient.
    }
}
