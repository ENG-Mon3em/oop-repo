public class Person {

    private String name;
    private String address;
    private int age;
    private int phoneNumber;

    public Person() {
    }

    public Person(String name,int age,int phoneNumber,String address) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.age = age;
        this.address = address;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
