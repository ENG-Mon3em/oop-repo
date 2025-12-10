public class Doctor extends Person {
    private String specialization;
    private String degree;
    private int salary;
    private int workingHours;

    public Doctor() {}

    public Doctor(String name, int age, String phoneNumber, String address) {
        super(name, age, phoneNumber, address);
    }

    public Doctor(String name, int age, String phoneNumber, String address, int workingHours, int salary, String degree, String specialization) {
        super(name, age, phoneNumber, address);
        this.workingHours = workingHours;
        this.salary = salary;
        this.degree = degree;
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
    public int getWorkingHours() { return workingHours; }
    public void setWorkingHours(int workingHours) { this.workingHours = workingHours; }

    @Override
    public String toString() {
        return "\nDoctor: " + getName() + ", Age: " + getAge() + ", Degree: " + getDegree() +
                ", Specialization: " + getSpecialization() + ", Phone: " + getPhoneNumber();
    }
}
