import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Patient> patientsList = new ArrayList<>();
    static ArrayList<Doctor> doctorsList = new ArrayList<>();
    static ArrayList<Room> roomsList = new ArrayList<>();
    static Pharmacy pharmacy = new Pharmacy("Dr. Ahmed", 8);

    public static void main(String[] args) {
        if(!login()) return;
        int choice;
        do {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1- Patients");
            System.out.println("2- Doctors");
            System.out.println("3- Rooms");
            System.out.println("4- Search Patient");
            System.out.println("5- List Patients");
            System.out.println("6- Pharmacy");
            System.out.println("0- Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice) {
                case 1: managePatients(); break;
                case 2: manageDoctors(); break;
                case 3: manageRooms(); break;
                case 4: searchPatient(); break;
                case 5: listPatients(); break;
                case 6: managePharmacy(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice"); break;
            }

        } while(choice != 0);
    }

    // /////////////////// Login ////////////
    public static boolean login() {
        System.out.println("=== Login ===");
        System.out.print("Enter username: ");
        String user = input.nextLine();
        System.out.print("Enter password: ");
        String pass = input.nextLine();

        if(user.equals("oop") && pass.equals("oop")) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed.");
            return false;
        }
    }

    // /////// Patients ///////////
    public static void managePatients() {
        int choice;
        do {
            System.out.println("\n--- Patients Menu ---");
            System.out.println("1- Add Patient");
            System.out.println("2- Remove Patient");
            System.out.println("3- Edit Patient");
            System.out.println("4- List Patients");
            System.out.println("0- Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = input.nextInt(); input.nextLine();

            switch(choice) {
                case 1: addPatient(); break;
                case 2: removePatient(); break;
                case 3: editPatient(); break;
                case 4: listPatients(); break;
                case 0: break;
                default: System.out.println("Invalid choice"); break;
            }
        } while(choice != 0);
    }

    public static void addPatient() {
        System.out.print("Enter name: "); String name = input.nextLine();
        System.out.print("Enter age: "); int age = input.nextInt(); input.nextLine();
        System.out.print("Enter phone: "); String phone = input.nextLine();
        System.out.print("Enter address: "); String addr = input.nextLine();
        System.out.print("Enter disease: "); String disease = input.nextLine();
        System.out.print("Enter condition: "); String cond = input.nextLine();

        Doctor doc = doctorsList.isEmpty() ? null : doctorsList.get(0);
        Room room = roomsList.isEmpty() ? null : roomsList.get(0);

        Patient p = new Patient(name, age, phone, addr, disease, doc, cond, room);
        patientsList.add(p);
        System.out.println("Patient added!");
    }

    public static void removePatient() {
        System.out.print("Enter patient ID to remove: "); int id = input.nextInt(); input.nextLine();
        Patient toRemove = null;
        for(Patient p : patientsList) { if(p.getPatientId() == id) { toRemove = p; break; } }
        if(toRemove != null) { patientsList.remove(toRemove); System.out.println("Patient removed."); }
        else System.out.println("Patient not found.");
    }

    public static void editPatient() {
        System.out.print("Enter patient ID to edit: "); int id = input.nextInt(); input.nextLine();
        Patient toEdit = null;
        for(Patient p : patientsList) { if(p.getPatientId() == id) { toEdit = p; break; } }
        if(toEdit != null) {
            System.out.print("Enter new disease: "); String d = input.nextLine(); toEdit.setDisease(d);
            System.out.print("Enter new condition: "); String c = input.nextLine(); toEdit.setCondition(c);
            System.out.println("Patient updated!");
        } else System.out.println("Patient not found.");
    }

    public static void listPatients() {
        System.out.println("\n--- Patients List ---");

        if(patientsList.isEmpty()) {
            System.out.println("No patients.");
            return;
        }

        ///////////////////////    Sort   //////////////////////////
        patientsList.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        for(Patient p : patientsList) {
            System.out.println(p.toString());
        }
    }


    public static void searchPatient() {
        System.out.print("Enter patient name to search: ");
        String name = input.nextLine();
        boolean found = false;
        for(Patient p : patientsList) {
            if(p.getName().equalsIgnoreCase(name)) { System.out.println(p.toString()); found = true; }
        }
        if(!found) System.out.println("Patient not found.");
    }

    // ----------------- Doctors -----------------
    public static void manageDoctors() {
        int choice;
        do {
            System.out.println("\n--- Doctors Menu ---");
            System.out.println("1- Add Doctor");
            System.out.println("2- Remove Doctor");
            System.out.println("3- Edit Doctor");
            System.out.println("4- List Doctors");
            System.out.println("0- Back to Main Menu");
            System.out.print("Enter choice: "); choice = input.nextInt(); input.nextLine();

            switch(choice) {
                case 1: addDoctor(); break;
                case 2: removeDoctor(); break;
                case 3: editDoctor(); break;
                case 4: listDoctors(); break;
                case 0: break;
                default: System.out.println("Invalid choice"); break;
            }
        } while(choice != 0);
    }

    public static void addDoctor() {
        System.out.print("Enter name: "); String name = input.nextLine();
        System.out.print("Enter age: "); int age = input.nextInt(); input.nextLine();
        System.out.print("Enter phone: "); String phone = input.nextLine();
        System.out.print("Enter address: "); String addr = input.nextLine();
        System.out.print("Enter degree: "); String deg = input.nextLine();
        System.out.print("Enter specialization: "); String spec = input.nextLine();
        System.out.print("Enter working hours: "); int hours = input.nextInt(); input.nextLine();
        System.out.print("Enter salary: "); int sal = input.nextInt(); input.nextLine();

        Doctor d = new Doctor(name, age, phone, addr, hours, sal, deg, spec);
        doctorsList.add(d);
        System.out.println("Doctor added!");
    }

    public static void removeDoctor() {
        System.out.print("Enter doctor name to remove: "); String name = input.nextLine();
        Doctor toRemove = null;
        for(Doctor d : doctorsList) { if(d.getName().equalsIgnoreCase(name)) { toRemove = d; break; } }
        if(toRemove != null) { doctorsList.remove(toRemove); System.out.println("Doctor removed."); }
        else System.out.println("Doctor not found.");
    }

    public static void editDoctor() {
        System.out.print("Enter doctor name to edit: "); String name = input.nextLine();
        Doctor toEdit = null;
        for(Doctor d : doctorsList) { if(d.getName().equalsIgnoreCase(name)) { toEdit = d; break; } }
        if(toEdit != null) {
            System.out.print("Enter new specialization: "); String spec = input.nextLine(); toEdit.setSpecialization(spec);
            System.out.println("Doctor updated!");
        } else System.out.println("Doctor not found.");
    }

    public static void listDoctors() {
        System.out.println("\n--- Doctors List ---");
        if(doctorsList.isEmpty()) System.out.println("No doctors.");
        for(Doctor d : doctorsList) System.out.println(d.toString());
    }

    // ----------------- Rooms -----------------
    public static void manageRooms() {
        int choice;
        do {
            System.out.println("\n--- Rooms Menu ---");
            System.out.println("1- Add Room");
            System.out.println("2- Remove Room");
            System.out.println("3- Edit Room");
            System.out.println("4- List Rooms");
            System.out.println("5- Search Room");
            System.out.println("0- Back to Main Menu");
            System.out.print("Enter choice: "); choice = input.nextInt(); input.nextLine();

            switch(choice) {
                case 1: addRoom(); break;
                case 2: removeRoom(); break;
                case 3: editRoom(); break;
                case 4: listRooms(); break;
                case 5: searchRoom(); break;
                case 0: break;
                default: System.out.println("Invalid choice"); break;
            }
        } while(choice != 0);
    }

    public static void addRoom() {
        System.out.print("Enter room number: "); int num = input.nextInt(); input.nextLine();
        System.out.print("Enter room type: "); String type = input.nextLine();
        System.out.print("Is room available? true/false: "); boolean state = input.nextBoolean(); input.nextLine();
        roomsList.add(new Room(num, state, type)); System.out.println("Room added!");
    }

    public static void removeRoom() {
        System.out.print("Enter room number to remove: "); int num = input.nextInt(); input.nextLine();
        Room toRemove = null;
        for(Room r : roomsList) { if(r.getRoomNumber() == num) { toRemove = r; break; } }
        if(toRemove != null) { roomsList.remove(toRemove); System.out.println("Room removed."); }
        else System.out.println("Room not found.");
    }

    public static void editRoom() {
        System.out.print("Enter room number to edit: "); int num = input.nextInt(); input.nextLine();
        Room toEdit = null;
        for(Room r : roomsList) { if(r.getRoomNumber() == num) { toEdit = r; break; } }
        if(toEdit != null) {
            System.out.print("Enter new room type: "); String type = input.nextLine(); toEdit.setRoomType(type);
            System.out.print("Enter new state true/false: "); boolean state = input.nextBoolean(); input.nextLine();
            toEdit.setRoomState(state);
            System.out.println("Room updated!");
        } else System.out.println("Room not found.");
    }

    public static void listRooms() {
        System.out.println("\n--- Rooms List ---");
        if(roomsList.isEmpty()) System.out.println("No rooms.");
        for(Room r : roomsList) System.out.println(r.toString());
    }

    public static void searchRoom() {
        System.out.print("Enter room number to search: "); int num = input.nextInt(); input.nextLine();
        boolean found = false;
        for(Room r : roomsList) { if(r.getRoomNumber() == num) { System.out.println(r.toString()); found = true; } }
        if(!found) System.out.println("Room not found.");
    }

    // ----------------- Pharmacy -----------------
    public static void managePharmacy() {
        int choice;
        do {
            System.out.println("\n--- Pharmacy Menu ---");
            System.out.println("1- Add Medicine");
            System.out.println("2- Remove Medicine");
            System.out.println("3- List Medicines");
            System.out.println("4- Search Medicine");
            System.out.println("0- Back to Main Menu");
            System.out.print("Enter choice: "); choice = input.nextInt(); input.nextLine();

            switch(choice) {
                case 1: System.out.print("Enter medicine name: "); pharmacy.addMedicine(input.nextLine()); break;
                case 2: System.out.print("Enter medicine name: "); pharmacy.removeMedicine(input.nextLine()); break;
                case 3: pharmacy.listMedicines(); break;
                case 4: System.out.print("Enter medicine name to search: "); pharmacy.searchMedicine(input.nextLine()); break;
                case 0: break;
                default: System.out.println("Invalid choice"); break;
            }
        } while(choice != 0);
    }
}
