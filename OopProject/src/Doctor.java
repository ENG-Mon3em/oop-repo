import java.util.regex.Pattern;

public class Doctor extends Person {
    private String specialization; // التخصص
    private String degree; //
    private int salary;
    private String working_hours;
    private final String working_hours_pattern = "\\d\\d:\\d\\d - \\d\\d:\\d\\d";
    private final String invalid_message = "invalid \"working hours\" the pattern is \"00:00 - 00:00\" ";


    // ######constructors


    public Doctor() {
    }
    // basic constructor
    public Doctor(String name, int age, String phoneNumber, String address) {
        super(name, age, phoneNumber, address);
    }
    // full constructor
    public Doctor(String name, int age, String phoneNumber, String address, String working_hours, int salary, String degree, String specialization) {
        super(name, age, phoneNumber, address);
        setWorking_hours(working_hours);
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

    public String getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(String working_hours) {
        if (!Pattern.matches( working_hours_pattern,working_hours)){
            System.out.println(invalid_message);
            return;
        }
        this.working_hours = working_hours;
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
                "- Working hours: " + getWorking_hours() + "\n" +
                "------------------------------------------";
    }
}
