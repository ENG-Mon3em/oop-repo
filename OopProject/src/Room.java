public class Room {
    private int roomNumber;
    private boolean isOccupied;

    // Composition: patients in room
    private Patient[] patients = new Patient[20];
    private int patientCount = 0;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public boolean isOccupied() { return isOccupied; }

    public void occupy() { isOccupied = true; }
    public void vacate() { isOccupied = false; }

    //addPatient
    public void addPatient(Patient p) {
        if (patientCount < 20) {
            patients[patientCount++] = p;
            occupy();
        }
    }
    //listPatients
    public void listPatients() {
        System.out.println("Patients in Room " + roomNumber + ":");
        for (int i = 0; i < patientCount; i++) {
            System.out.println("- " + patients[i].getName());
        }
    }

    public void display() {
        System.out.println("Room " + roomNumber + " - " + (isOccupied ? "Occupied" : "Available"));
    }
}
