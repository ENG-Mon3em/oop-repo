import java.util.Scanner;

public class MainClass {
    static Scanner input = new Scanner(System.in);

    //  Arrays
    static Patient[] patients = new Patient[20];
    static int patientCount = 0;
    static Doctor[] doctors = new Doctor[20];
    static int doctorCount = 0;
    static Room[] rooms = new Room[20];
    static int roomCount = 0;
    static Pharmacy pharmacy = new Pharmacy();

    public static void main(String[] args) {
        if (!login()) return;

        //////// Rooms
        rooms[0] = new Room(1);
        rooms[1] = new Room(2);
        rooms[2] = new Room(3);
        rooms[3] = new Room(4);
        rooms[4] = new Room(5);
        roomCount = 5;

        /////// Doctors
        doctors[0] = new Doctor("Dr. Ahmed", 45, "0101111111", "Cairo", "Cardiology");
        doctors[1] = new Doctor("Dr. Sara", 38, "0102222222", "Cairo", "Neurology");
        doctors[2] = new Doctor("Dr. Ali", 50, "0103333333", "Giza", "Pediatrics");
        doctors[3] = new Doctor("Dr. Mona", 42, "0104444444", "Giza", "Orthopedics");
        doctors[4] = new Doctor("Dr. Khaled", 47, "0105555555", "Cairo", "Dermatology");
        doctorCount = 5;

        int choice;
        do {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1- Patients");
            System.out.println("2- List Doctors ");
            System.out.println("3- List Rooms ");
            System.out.println("4- Pharmacy");
            System.out.println("5- Reserve a room for the patient");
            System.out.println("6- Assign Doctor and Medicine to Patient");
            System.out.println("0- Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: patientsMenu(); break;
                case 2: listDoctors(); break;
                case 3: listRooms(); break;
                case 4: pharmacyMenu(); break;
                case 5: assignPatientToRoom(); break;
                case 6: assignDoctorAndMedicine(); break;
                case 0: System.out.println("Exiting program..."); break;
                default: System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    ////  Login
    public static boolean login() {
        System.out.print("Enter username: ");
        String user = input.nextLine();
        System.out.print("Enter password: ");
        String pass = input.nextLine();
        if (user.equals("123") && pass.equals("123")) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed.");
            return false;
        }
    }

    ////  Patients Menu
    public static void patientsMenu() {
        int ch;
        do {
            System.out.println("\n--- Patients Menu ---");
            System.out.println("1- Add Patient");
            System.out.println("2- Remove Patient");
            System.out.println("3- Edit Patient");
            System.out.println("4- List Patients");
            System.out.println("5- Search Patient");
            System.out.println("0- Back to Main Menu");
            System.out.print("Enter choice: ");
            ch = input.nextInt();
            input.nextLine();

            switch (ch) {
                case 1: addPatient(); break;
                case 2: removePatient(); break;
                case 3: editPatient(); break;
                case 4: sortPatientsManual(); break;
                case 5: searchPatientManual(); break;
                case 0: System.out.println("Returning to Main Menu..."); break;
                default: System.out.println("Invalid choice.");
            }

        } while (ch != 0);
    }

    //// Add Patient
    public static void addPatient() {
        if (patientCount >= 20) { System.out.println("Patient list is full!"); return; }

        System.out.print("Enter Patient Name: ");
        String name = input.nextLine();
        System.out.print("Age: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("Phone: ");
        String phone = input.nextLine();
        System.out.print("Address: ");
        String addr = input.nextLine();
        System.out.print("Disease: ");
        String disease = input.nextLine();

        Patient p = new Patient(name, age, phone, addr, disease);
        p.addTreatment("Initial Checkup");
        patients[patientCount++] = p;
        System.out.println("Patient added successfully.");
    }

    /////     Remove Patient
    public static void removePatient() {
        System.out.print("Enter Patient Name to Remove: ");
        String name = input.nextLine();
        boolean found = false;

        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getName().equalsIgnoreCase(name)) {
                // shift left
                for (int j = i; j < patientCount - 1; j++) {
                    patients[j] = patients[j + 1];
                }
                patients[--patientCount] = null;
                System.out.println("Patient removed successfully.");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Patient not found.");
    }

    ///// Edit Patient
    public static void editPatient() {
        System.out.print("Enter Patient Name to Edit: ");
        String name = input.nextLine();
        Patient toEdit = null;

        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getName().equalsIgnoreCase(name)) {
                toEdit = patients[i];
                break;
            }
        }

        if (toEdit != null) {
            System.out.print("New Name: ");
            toEdit.setName(input.nextLine());
            System.out.print("New Age: ");
            toEdit.setAge(input.nextInt());
            input.nextLine();
            System.out.print("New Phone: ");
            toEdit.setPhoneNumber(input.nextLine());
            System.out.print("New Address: ");
            toEdit.setAddress(input.nextLine());
            System.out.print("New Disease: ");
            toEdit.setDisease(input.nextLine());
            System.out.println("Patient updated successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    //// sort by ID
    public static void sortPatientsManual() {
        for (int i = 0; i < patientCount - 1; i++) {
            for (int j = i + 1; j < patientCount; j++) {
                if (patients[i].getId() > patients[j].getId()) {
                    Patient temp = patients[i];
                    patients[i] = patients[j];
                    patients[j] = temp;
                }
            }
        }
        System.out.println("Patients sorted by ID:");
        for (int i = 0; i < patientCount; i++) {
            System.out.println(patients[i].toString());
        }
    }

    //// Searching
    public static void searchPatientManual() {
        System.out.print("Enter Patient Name to Search: ");
        String name = input.nextLine();
        boolean found = false;

        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getName().equalsIgnoreCase(name)) {
                System.out.println(patients[i].toString());
                found = true;
            }
        }
        if (!found) System.out.println("Patient not found.");
    }

    ////  List Doctors
    public static void listDoctors() {
        System.out.println("=== Doctors List ===");
        for (int i = 0; i < doctorCount; i++) {
            System.out.println((i+1) + "- " + doctors[i].getName() + ", Specialization: " + doctors[i].getSpecialization());
        }
    }

    ////  List Rooms
    public static void listRooms() {
        System.out.println("=== Rooms List ===");
        for (int i = 0; i < roomCount; i++) {
            System.out.println("Room " + rooms[i].getRoomNumber() + " - " + (rooms[i].isOccupied() ? "Occupied" : "Available"));
        }
    }

    ////  Pharmacy Menu
    public static void pharmacyMenu() {
        System.out.println("1- Add Medicine");
        System.out.println("2- List Medicines");
        int ch = input.nextInt();
        input.nextLine();
        if (ch == 1) {
            System.out.print("Enter Medicine Name: ");
            String med = input.nextLine();
            pharmacy.addMedicine(med);
        } else if (ch == 2) {
            pharmacy.listMedicines();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    ////  Assign Patient to Room
    public static void assignPatientToRoom() {
        if (patientCount == 0 || roomCount == 0) { System.out.println("No patients or rooms available."); return; }

        System.out.print("Enter Patient Name: ");
        String pname = input.nextLine();
        Patient patient = null;
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getName().equalsIgnoreCase(pname)) { patient = patients[i]; break; }
        }
        if (patient == null) { System.out.println("Patient not found."); return; }

        System.out.print("Enter Room Number: ");
        int rnum = input.nextInt();
        input.nextLine();
        Room room = null;
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getRoomNumber() == rnum) { room = rooms[i]; break; }
        }
        if (room == null) { System.out.println("Room not found."); return; }

        room.addPatient(patient);
        patient.setAssignedRoom("" + rnum);
        System.out.println("Patient " + patient.getName() + " assigned to Room " + rnum);
    }

    //// Assign Doctor and Medicine
    public static void assignDoctorAndMedicine() {
        if (patientCount == 0 || doctorCount == 0) { System.out.println("No patients or doctors available."); return; }

        System.out.print("Enter Patient Name: ");
        String pname = input.nextLine();
        Patient patient = null;
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getName().equalsIgnoreCase(pname)) { patient = patients[i]; break; }
        }
        if (patient == null) { System.out.println("Patient not found."); return; }

        System.out.print("Enter Doctor Name: ");
        String dname = input.nextLine();
        Doctor doctor = null;
        for (int i = 0; i < doctorCount; i++) {
            if (doctors[i].getName().equalsIgnoreCase(dname)) { doctor = doctors[i]; break; }
        }
        if (doctor == null) { System.out.println("Doctor not found."); return; }

        patient.assignDoctor(doctor);

        System.out.print("Enter Medicine Name: ");
        String med = input.nextLine();
        patient.addMedicine(med);
        pharmacy.addMedicine(med);
        System.out.println("Assigned doctor " + doctor.getName() + " and medicine " + med + " to patient " + patient.getName());
    }
}
