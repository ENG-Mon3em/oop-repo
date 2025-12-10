import java.util.ArrayList;

public class Pharmacy {
    private String chemist;
    private int workTime;
    private ArrayList<Medicine> medicines;

    public Pharmacy() {
        medicines = new ArrayList<>();
    }

    public Pharmacy(String chemist, int workTime) {
        this.chemist = chemist;
        this.workTime = workTime;
        medicines = new ArrayList<>();
    }

    public void addMedicine(String name) { medicines.add(new Medicine(name)); }

    public void removeMedicine(String name) {
        medicines.removeIf(m -> m.getName().equalsIgnoreCase(name));
    }

    public void listMedicines() {
        System.out.println("=== Medicines in Pharmacy ===");
        if(medicines.isEmpty()) System.out.println("No medicines available.");
        for(Medicine m : medicines) System.out.println(m);
    }

    public void searchMedicine(String name) {
        boolean found = false;
        for(Medicine m : medicines) {
            if(m.getName().equalsIgnoreCase(name)) { found = true; break; }
        }
        if(found) System.out.println(name + " is available.");
        else System.out.println(name + " is NOT available.");
    }
}
