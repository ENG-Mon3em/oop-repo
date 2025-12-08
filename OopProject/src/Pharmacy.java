public class Pharmacy {

    private String chemist;
    private int[] workTimes;
    private String[] medicines;

    public Pharmacy() {
    }

    public Pharmacy(String chemist, String[] medicines, int[] workTimes) {
        this.chemist = chemist;
        this.medicines = medicines;
        this.workTimes = workTimes;
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

    public int[] getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(int[] workTimes) {
        this.workTimes = workTimes;
    }
}
