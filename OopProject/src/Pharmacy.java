public class Pharmacy {

    private String chemist;
    private int workTime;
    private String[] medicines;

    public Pharmacy() {
    }

    public Pharmacy(String chemist, String[] medicines, int workTime) {
        this.chemist = chemist;
        this.medicines = medicines;
        this.workTime = workTime;
    }

    public String getChemist() {
        return chemist;
    }

    public void setChemist(String chemist) {
        this.chemist = chemist;
    }

    public String[] getMedicines() {
        return medicines;
    }

    public void setMedicines(String[] medicines) {
        this.medicines = medicines;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}
