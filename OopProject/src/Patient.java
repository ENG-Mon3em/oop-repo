public class Patient extends Person {

    private int id;
    private String disease;
    private String condition;
    private String assignedDoctor;
    private String assignedRoom;
    private static int counter = 1;

    // Composition   :     treatment history
    private String[] treatments = new String[20];
    private int treatmentCount = 0;

    public Patient(String name, int age, String phoneNumber, String address, String disease) {
        super(name, age, phoneNumber, address);
        this.id = counter++;
        this.disease = disease;
        this.condition = "None";
        this.assignedDoctor = "None";
        this.assignedRoom = "None";
    }

    public int getId() { return id; }
    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getAssignedDoctor() { return assignedDoctor; }
    public void setAssignedDoctor(String doctor) { this.assignedDoctor = doctor; }

    public String getAssignedRoom() { return assignedRoom; }
    public void setAssignedRoom(String room) { this.assignedRoom = room; }

    /// addTreatment
    public void addTreatment(String treatment) {
        if (treatmentCount < 20) {
            treatments[treatmentCount++] = treatment;
        }
    }
    /// listTreatments
    public void listTreatments() {
        System.out.println("Treatment History for " + getName() + ":");
        for (int i = 0; i < treatmentCount; i++) {
            System.out.println("- " + treatments[i]);
        }
    }

    //// Assign Doctor
    public void assignDoctor(Doctor doctor) {
        this.assignedDoctor = doctor.getName();
        doctor.addPatient(this);
    }

    public void addMedicine(String medicine) { addTreatment(medicine); }

    @Override
    public void display() {
        System.out.println(
                "Patient: " + getName() +
                        ", Age: " + getAge() +
                        ", ID: " + id +
                        ", Disease: " + disease +
                        ", Condition: " + condition +
                        ", Doctor: " + assignedDoctor +
                        ", Room: " + assignedRoom
        );
    }

    @Override
    public String toString() {
        return "Patient: " + getName() +
                ", Age: " + getAge() +
                ", ID: " + id +
                ", Disease: " + disease +
                ", Condition: " + condition +
                ", Doctor: " + assignedDoctor +
                ", Room: " + assignedRoom;
    }
}
