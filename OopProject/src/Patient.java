public class Patient extends Person {
    private String disease;
    private Doctor treatingDoctor; // الطبيب المتابع لهذا المريض
    private String condition; // types is [Operation, emergency, examination] > حالة المريض يحتاج عمليه ام كشف ام طوارئ
    private Room room; // غرفه المريض
    private int patientId;
    public static int patientsCount = 0;// عدد المرضى


    // ######constructors

    public Patient(){
        super("",0,"","");
    }

    // basic constructor
    public Patient(String name, int age, String phoneNumber, String address) {
        super(name, age, phoneNumber, address);
    }

    // without room
    public Patient(String name, int age, String phoneNumber, String address, String disease, Doctor treatingDoctor, String condition) {
        super(name, age, phoneNumber, address);
        this.disease = disease;
        this.treatingDoctor = treatingDoctor;
        this.condition = condition;
        patientsCount++;
        this.patientId = patientsCount;
    }

    //  full constructor
    public Patient(String name, int age, String phoneNumber, String address, String disease, Doctor treatingDoctor, String condition, Room room) {
        super(name, age, phoneNumber, address);
        this.disease = disease;
        this.treatingDoctor = treatingDoctor;
        this.condition = condition;
        this.room = room;
        patientsCount++;
        patientId = patientsCount;
    }

    // #####getters and setters

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Doctor getTreatingDoctor() {
        return treatingDoctor;
    }

    public void setTreatingDoctor(Doctor treatingDoctor) {
        this.treatingDoctor = treatingDoctor;
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public static int getPatientsCount() {
        return patientsCount;
    }

    // print the details of the object
    @Override
    public String toString(){
        return "\n # Patient's details: \n" +
                "- name: " + getName() + "\n" +
                "- age: " + getAge()+"\n" +
                "- id: " + getPatientId() + "\n" +
                "- address: " + getAddress() + "\n" +
                "- phone number: " + getPhoneNumber() + "\n" +
                "- Disease: " + getDisease() + "\n" +
                "- Condition: " + getCondition() + "\n" +
                "- Treating doctor: " + ((getTreatingDoctor() == null)? "no doctor added" : getTreatingDoctor().getName()) + "\n" +
                "- room id: " + ((getRoom() == null)? "no room" : getRoom().getRoomNumber()) + "\n" + // check if he has a room or no
                "------------------------------------------";
    }
}
