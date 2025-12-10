public class MainClass {
    public static void main(String[] args) {
        Patient[] patients = new Patient[5];
        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient();
        }
        Doctor[] doctors = new Doctor[5];
        for (int i = 0; i < doctors.length; i++) {
            doctors[i] = new Doctor();
        }
        Person x = new Patient();
        doctors[3].setName("mohamed");
        patients[3].setName("mohsen");
        patients[2].setName("mohamed");
        System.out.println(Patient.search(doctors, "mohamed"));
    }
}
