public class Pharmacy {
    //// Aggregation  :  Medicines
    private String[] medicines = new String[50];
    private int medicineCount = 0;

    public void addMedicine(String name) {
        if (medicineCount < 50) {
            medicines[medicineCount++] = name;
            System.out.println(name + " added to pharmacy.");
        } else {
            System.out.println("Pharmacy is full!");
        }
    }

    public void listMedicines() {
        System.out.println("Medicines in Pharmacy:");
        for (int i = 0; i < medicineCount; i++) {
            System.out.println("- " + medicines[i]);
        }
    }
}
