public class Patient extends Person {
    private String disease;
    private Doctor treating_doctor; // الطبيب المتابع لهذا المريض
    private String condition; // types is [Operation, emergency, examination] > حالة المريض يحتاج عمليه ام كشف ام طوارئ
    private Room room; // غرفه المريض
    private int patient_id;
    public static int patients_count = 0;// عدد المرضى


    // ######constructors

    public Patient(){

    }

    // basic constructor
    public Patient(String name, int age, String phoneNumber, String address) {
        super(name, age, phoneNumber, address);
    }

    // without room
    public Patient(String name, int age, String phoneNumber, String address, String disease, Doctor treating_doctor, String condition) {
        super(name, age, phoneNumber, address);
        this.disease = disease;
        this.treating_doctor = treating_doctor;
        this.condition = condition;
        patients_count++;
        this.patient_id = patients_count;
    }

    //  full constructor
    public Patient(String name, int age, String phoneNumber, String address, String disease, Doctor treating_doctor, String condition, Room room) {
        super(name, age, phoneNumber, address);
        this.disease = disease;
        this.treating_doctor = treating_doctor;
        this.condition = condition;
        this.room = room;
        patients_count++;
        patient_id = patients_count;
    }

    // #####getters and setters

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Doctor getTreating_doctor() {
        return treating_doctor;
    }

    public void setTreating_doctor(Doctor treating_doctor) {
        this.treating_doctor = treating_doctor;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public static int getPatients_count() {
        return patients_count;
    }

    // print the details of the object
    @Override
    public String toString(){
        return "\n # Patient's details: \n" +
                "- name: " + getName() + "\n" +
                "- age: " + getAge()+"\n" +
                "- id: " + getPatient_id() + "\n" +
                "- address: " + getAddress() + "\n" +
                "- phone number: " + getPhoneNumber() + "\n" +
                "- Disease: " + getDisease() + "\n" +
                "- Condition: " + getCondition() + "\n" +
                "- Treating doctor: " + getTreating_doctor().getName() + "\n" +
                "- room id: " + ((getRoom() == null)? "no room" : getRoom().getRoomNumber()) + "\n" + // check if he has a room or no
                "------------------------------------------";
    }
}
