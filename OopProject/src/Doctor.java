public class Doctor extends Person {
    private String specialization;

    //  Composition  :     assigned patients
    private Patient[] assignedPatients = new Patient[20];
    private int patientCount = 0;

    public Doctor(String name, int age, String phoneNumber, String address, String specialization) {
        super(name, age, phoneNumber, address);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    // addPatient
    public void addPatient(Patient p) {
        if (patientCount < 20) {
            assignedPatients[patientCount++] = p;
        }
    }
        //listPatients
    public void listPatients() {
        System.out.println("Patients assigned to Dr. " + getName() + ":");
        for (int i = 0; i < patientCount; i++) {
            System.out.println("- " + assignedPatients[i].getName());
        }
    }

    @Override
    public void display() {
        System.out.println("Doctor Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Specialization: " + specialization);
    }
}
