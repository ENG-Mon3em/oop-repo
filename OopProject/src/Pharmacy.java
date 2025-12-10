public class Pharmacy {

    private String chemist;
    private int workTime;
    private medicines medicines = new medicines(); //كلاس بها الادوية المتاحة (Composition) بدون الصيدلية لن يوجد الكلاس ادوية

    public Pharmacy() {
    }

    public Pharmacy(String chemist, int workTime) {
        this.chemist = chemist;
        this.workTime = workTime;
    }

    public String getChemist() {
        return chemist;
    }

    public void setChemist(String chemist) {
        this.chemist = chemist;
    }

    public medicines getMedicines() {
        return medicines;
    }

    public void setMedicines(medicines medicines) {
        this.medicines = medicines;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "Pharmacy{" + "chemist='" + chemist + '\'' + ", workTime=" + workTime + ", medicines=" + medicines + '}';
    }
}
