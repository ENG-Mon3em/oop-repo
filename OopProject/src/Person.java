import java.util.regex.Pattern;

public abstract class Person {

    private String name;
    private String address;
    private int age;
    private String phoneNumber;// String to add 0 in the first (01215348461)

    private final String phoneNumberPattern = "01\\d\\d\\d\\d\\d\\d\\d\\d\\d"; //regular expression to validate the phone number
    private final String invalidMessage = "invalid phone number ";

    public Person() {
    }

    public Person(String name,int age,String phoneNumber,String address) {
        setPhoneNumber(phoneNumber); // validate the phone number
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!Pattern.matches(phoneNumberPattern,phoneNumber)){
            System.out.println(invalidMessage);
            return;
        }
        this.phoneNumber = phoneNumber;
    }
}
