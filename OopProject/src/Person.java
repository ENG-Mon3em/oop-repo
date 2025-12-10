// ==================== Abstract Class ====================
public abstract class Person {
    private String name;
    private int age;
    private String phoneNumber;
    private String address;

    public Person(String name, int age, String phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // ==================== Getters & Setters ====================
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }

    // Abstract
    public abstract void display(); // Override مطلوب في كل subclass
}
