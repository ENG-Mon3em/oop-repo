import java.util.Scanner;
import java.util.Arrays;

public class MainClass {

    // 1. تعريف المصفوفات بحجم أقصى (Max Capacity)
    static final int MAX_SIZE = 50;

    static Doctor[] doctors = new Doctor[MAX_SIZE];
    static int docCount = 0; // عداد الأطباء الحالي

    static Patient[] patients = new Patient[MAX_SIZE];
    static int patCount = 0; // عداد المرضى الحالي

    static Room[] rooms = new Room[MAX_SIZE];
    static int roomCount = 0; // عداد الغرف الحالي

    static Pharmacy pharmacy;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializePharmacy();

        // إضافة بيانات تجريبية لسهولة الاختبار
        // يجب أن تكون كلاسات Doctor و Patient متاحة ليعمل هذا الجزء
        doctors[docCount++] = new Doctor("Dr. Khalid", 45, "0100", "Riyadh", 8, 20000, "MD", "Surgery");
        doctors[docCount - 1].setId(101);
        doctors[docCount++] = new Doctor("Dr. Mona", 32, "0111", "Jeddah", 6, 15000, "PhD", "Pediatrics");
        doctors[docCount - 1].setId(303);
        doctors[docCount++] = new Doctor("Dr. Ahmed", 50, "0122", "Cairo", 7, 25000, "MD", "Cardiology");
        doctors[docCount - 1].setId(202);

        int choice;
        do {
            System.out.println("\n===== Hospital System =====");
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("3. Pharmacy");
            System.out.println("4. Rooms ");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: doctorMenu(); break;
                case 2: patientMenu(); break;
                case 3: pharmacyMenu(); break;
                case 4: roomMenu(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // ================== 1. DOCTORS ==================
    public static void doctorMenu() {
        int choice;
        do {
            System.out.println("\n--- Doctors Menu ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. Remove Doctor");
            System.out.println("3. List Doctors");
            System.out.println("4. Search Doctor");
            System.out.println("5. Sort Doctors by ID"); // <--- الخيار الجديد
            System.out.println("6. Back");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addDoctor(); break;
                case 2: removeDoctor(); break;
                case 3: listDoctors(); break;
                case 4: searchDoctor(); break;
                case 5: sortDoctorsById(); break; // <--- استدعاء الدالة
                case 6: return;
            }
        } while (true);
    }

    private static void addDoctor() {
        if (docCount >= MAX_SIZE) {
            System.out.println("Error: Doctor list is full!");
            return;
        }
        System.out.println("\n[Add New Doctor]");
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        System.out.print("Address: "); String address = scanner.nextLine();
        System.out.print("Hours: "); int hours = scanner.nextInt();
        System.out.print("Salary: "); int salary = scanner.nextInt(); scanner.nextLine();
        System.out.print("Degree: "); String degree = scanner.nextLine();
        System.out.print("Specialization: "); String spec = scanner.nextLine();

        Doctor d = new Doctor(name, age, phone, address, hours, salary, degree, spec);
        System.out.print("Set ID (Integer): "); d.setId(scanner.nextInt()); scanner.nextLine();

        // الإضافة في المصفوفة وزيادة العداد
        doctors[docCount] = d;
        docCount++;
        System.out.println("Doctor added.");
    }

    private static void removeDoctor() {
        System.out.print("Enter Name to remove: ");
        String name = scanner.nextLine();
        int index = -1;

        // البحث عن الـ Index
        for (int i = 0; i < docCount; i++) {
            if (doctors[i].getName().equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Shift elements logic (إزاحة العناصر لملء الفراغ)
            for (int i = index; i < docCount - 1; i++) {
                doctors[i] = doctors[i + 1];
            }
            doctors[docCount - 1] = null; // تنظيف الخانة الأخيرة
            docCount--; // تقليل العداد
            System.out.println("Doctor removed.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    private static void listDoctors() {
        if (docCount == 0) System.out.println("No doctors.");
        for (int i = 0; i < docCount; i++) {
            System.out.println(doctors[i].toString());
        }
    }

    private static void searchDoctor() {
        System.out.print("Search Name: ");
        String name = scanner.nextLine();
        for (int i = 0; i < docCount; i++) {
            if (doctors[i].getName().equalsIgnoreCase(name)) {
                System.out.println(doctors[i].toString());
                return;
            }
        }
        System.out.println("Not found.");
    }

    // <--- الدالة الجديدة لترتيب الأطباء حسب الـ ID --->
    private static void sortDoctorsById() {
        if (docCount < 2) {
            System.out.println("Not enough doctors to sort.");
            return;
        }

        // خوارزمية الترتيب (Bubble Sort) للترتيب حسب الـ ID
        for (int i = 0; i < docCount - 1; i++) {
            for (int j = 0; j < docCount - i - 1; j++) {
                // مقارنة الأرقام: إذا كان الـ ID الحالي أكبر من التالي، قم بالتبديل
                if (doctors[j].getId() > doctors[j + 1].getId()) {
                    // تبديل الأماكن (Swap)
                    Doctor temp = doctors[j];
                    doctors[j] = doctors[j + 1];
                    doctors[j + 1] = temp;
                }
            }
        }
        System.out.println("Doctors sorted by ID successfully. Use List Doctors (option 3) to view the changes.");
    }
    // <--- نهاية الدالة الجديدة --->

    // ================== 2. PATIENTS ==================
    public static void patientMenu() {
        int choice;
        do {
            System.out.println("\n--- Patients Menu ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. List Patients");
            System.out.println("4. Search Patient");
            System.out.println("5. Back");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addPatient(); break;
                case 2: removePatient(); break;
                case 3: listPatients(); break;
                case 4: searchPatient(); break;
                case 5: return;
            }
        } while (true);
    }

    private static void addPatient() {
        if (patCount >= MAX_SIZE) {
            System.out.println("List is full!"); return;
        }
        System.out.println("\n[Add Patient]");
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        System.out.print("Address: "); String address = scanner.nextLine();
        System.out.print("Disease: "); String disease = scanner.nextLine();
        System.out.print("Condition: "); String condition = scanner.nextLine();

        // 1. Find Doctor manually from array
        Doctor assignedDoc = null;
        System.out.print("Assign Doctor (Name): ");
        String docName = scanner.nextLine();
        for(int i=0; i<docCount; i++){
            if(doctors[i].getName().equalsIgnoreCase(docName)){
                assignedDoc = doctors[i];
                break;
            }
        }

        // 2. Find Room manually from array
        Room assignedRoom = null;
        System.out.print("Assign Room (Number): ");
        int rNum = scanner.nextInt(); scanner.nextLine();
        for(int i=0; i<roomCount; i++){
            if(rooms[i].getRoomNumber() == rNum){
                assignedRoom = rooms[i];
                break;
            }
        }

        // Full Constructor usage
        Patient p = new Patient(name, age, phone, address, disease, assignedDoc, condition, assignedRoom);

        patients[patCount] = p;
        patCount++;
        System.out.println("Patient added.");
    }

    private static void removePatient() {
        System.out.print("Enter Name to remove: ");
        String name = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < patCount; i++) {
            if (patients[i].getName().equalsIgnoreCase(name)) {
                index = i; break;
            }
        }

        if (index != -1) {
            // Shift Logic
            for (int i = index; i < patCount - 1; i++) {
                patients[i] = patients[i + 1];
            }
            patients[patCount - 1] = null;
            patCount--;
            System.out.println("Patient removed.");
        } else {
            System.out.println("Not found.");
        }
    }

    private static void listPatients() {
        if (patCount == 0) System.out.println("No patients.");
        for (int i = 0; i < patCount; i++) {
            System.out.println(patients[i].toString());
        }
    }

    private static void searchPatient() {
        System.out.print("Search Name: ");
        String name = scanner.nextLine();
        for (int i = 0; i < patCount; i++) {
            if (patients[i].getName().equalsIgnoreCase(name)) {
                System.out.println(patients[i].toString());
                return;
            }
        }
        System.out.println("Not found.");
    }

    // ================== 3. PHARMACY ==================
    private static void initializePharmacy() {
        String[] meds = {"Panadol", "Aspirin", "Antibiotic"};
        medicines m = new medicines(meds);
        pharmacy = new Pharmacy("Dr. Ali", 12);
        pharmacy.setMedicines(m);
    }

    public static void pharmacyMenu() {
        int choice;
        do {
            System.out.println("\n--- Pharmacy Menu ---");
            System.out.println("1. Add Medicine");
            System.out.println("2. Remove Medicine");
            System.out.println("3. Search Medicine");
            System.out.println("4. List Medicines");
            System.out.println("5. Back");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addMedicine(); break;
                case 2: removeMedicine(); break;
                case 3: searchMedicine(); break;
                case 4: listMedicines(); break;
                case 5: return;
            }
        } while (true);
    }

    private static void addMedicine() {
        System.out.print("New Medicine Name: ");
        String newMed = scanner.nextLine();

        String[] oldArr = pharmacy.getMedicines().getAvailableMedicines();
        // إنشاء مصفوفة جديدة أكبر بـ 1
        String[] newArr = new String[oldArr.length + 1];

        // النسخ اليدوي (أو باستخدام System.arraycopy)
        for(int i=0; i<oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        newArr[newArr.length - 1] = newMed;

        pharmacy.getMedicines().setAvailableMedicines(newArr);
        System.out.println("Added.");
    }

    private static void removeMedicine() {
        System.out.print("Remove Medicine Name: ");
        String target = scanner.nextLine();

        String[] oldArr = pharmacy.getMedicines().getAvailableMedicines();
        boolean found = false;
        for(String s : oldArr) if(s.equalsIgnoreCase(target)) found = true;

        if(!found) {
            System.out.println("Not found."); return;
        }

        // إنشاء مصفوفة أصغر بـ 1
        String[] newArr = new String[oldArr.length - 1];
        int k = 0;
        for (String m : oldArr) {
            if (!m.equalsIgnoreCase(target)) {
                newArr[k++] = m;
            }
        }
        pharmacy.getMedicines().setAvailableMedicines(newArr);
        System.out.println("Removed.");
    }

    private static void searchMedicine() {
        System.out.print("Search: ");
        String s = scanner.nextLine();
        for (String m : pharmacy.getMedicines().getAvailableMedicines()) {
            if (m.equalsIgnoreCase(s)) {
                System.out.println("Available."); return;
            }
        }
        System.out.println("Not Available.");
    }

    private static void listMedicines() {
        System.out.println(Arrays.toString(pharmacy.getMedicines().getAvailableMedicines()));
    }

    // ================== 4. ROOMS ==================
    public static void roomMenu() {
        int choice;
        do {
            System.out.println("\n--- Rooms Menu ---");
            System.out.println("1. Add Room");
            System.out.println("2. Remove Room");
            System.out.println("3. List Rooms");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addRoom(); break;
                case 2: removeRoom(); break;
                case 3: listRooms(); break;
                case 4: return;
            }
        } while (true);
    }

    private static void addRoom() {
        if(roomCount >= MAX_SIZE) {
            System.out.println("Full!"); return;
        }
        System.out.print("Num: "); int num = scanner.nextInt();
        System.out.print("State (true/false): "); boolean state = scanner.nextBoolean(); scanner.nextLine();
        System.out.print("Type: "); String type = scanner.nextLine();

        rooms[roomCount] = new Room(num, state, type);
        roomCount++;
        System.out.println("Added.");
    }

    private static void removeRoom() {
        System.out.print("Room Num to remove: ");
        int num = scanner.nextInt(); scanner.nextLine();

        int index = -1;
        for(int i=0; i<roomCount; i++){
            if(rooms[i].getRoomNumber() == num){
                index = i; break;
            }
        }

        if(index != -1){
            for(int i=index; i<roomCount-1; i++){
                rooms[i] = rooms[i+1];
            }
            rooms[roomCount-1] = null;
            roomCount--;
            System.out.println("Removed.");
        } else {
            System.out.println("Not found.");
        }
    }

    private static void listRooms() {
        if(roomCount == 0) System.out.println("No rooms.");
        for(int i=0; i<roomCount; i++){
            Room r = rooms[i];
            System.out.println("Room " + r.getRoomNumber() + " [" + r.getRoomType() + "]");
        }
    }
}