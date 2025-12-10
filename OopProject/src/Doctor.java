public class Doctor extends Person {
    private String specialization; // التخصص
    private String degree; //
    private int salary;
    private int workingHours;


    // ######constructors


    public Doctor() {
        super("",0,"","");
    }
    // basic constructor
    public Doctor(String name, int age, String phoneNumber, String address) {
        super(name, age, phoneNumber, address);
    }
    // full constructor
    public Doctor(String name, int age, String phoneNumber, String address, int workingHours, int salary, String degree, String specialization) {
        super(name, age, phoneNumber, address);
        setWorkingHours(workingHours);
        this.salary = salary;
        this.degree = degree;
        this.specialization = specialization;
    }

    // ##### getters and setters


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    // print the details of the object
    @Override
    public String toString(){
        return "\n # Doctor's details: \n" +
                "- name: " + getName() + "\n" +
                "- age: " + getAge()+"\n" +
                "- degree: " + getDegree() + "\n" +
                "- address: " + getAddress() + "\n" +
                "- phone number: " + getPhoneNumber() + "\n" +
                "- Specialization: " + getSpecialization() + "\n" +
                "- Working hours: " + getWorkingHours() + "\n" +
                "------------------------------------------";
    }
}
