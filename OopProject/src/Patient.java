public class Patient extends Person {
    private String disease;
    private Doctor treatingDoctor;
    private String condition;
    private Room room;
    private int patientId;
    public static int patientsCount = 0;

    public Patient() {}

    public Patient(String name, int age, String phoneNumber, String address) {
        super(name, age, phoneNumber, address);
    }

    public Patient(String name, int age, String phoneNumber, String address, String disease, Doctor treatingDoctor, String condition, Room room) {
        super(name, age, phoneNumber, address);
        this.disease = disease;
        this.treatingDoctor = treatingDoctor;
        this.condition = condition;
        this.room = room;
        patientsCount++;
        this.patientId = patientsCount;
    }

    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }
    public Doctor getTreatingDoctor() { return treatingDoctor; }
    public void setTreatingDoctor(Doctor treatingDoctor) { this.treatingDoctor = treatingDoctor; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
    public int getPatientId() { return patientId; }

    @Override
    public String toString() {
        return "\nPatient: " + getName() + ", Age: " + getAge() + ", ID: " + getPatientId() +
                ", Disease: " + getDisease() + ", Condition: " + getCondition() +
                ", Doctor: " + (getTreatingDoctor() != null ? getTreatingDoctor().getName() : "None") +
                ", Room: " + (getRoom() != null ? getRoom().getRoomNumber() : "None");
    }
}
