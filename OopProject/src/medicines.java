import java.util.Arrays;

public class medicines {

    private String[] AvailableMedicines;

    public medicines() {
    }

    public medicines(String[] availableMedicines) {
        AvailableMedicines = availableMedicines;
    }

    public String[] getAvailableMedicines() {
        return AvailableMedicines;
    }

    public void setAvailableMedicines(String[] availableMedicines) {
        AvailableMedicines = availableMedicines;
    }

    @Override
    public String toString() {
        return "medicines{" +
                "AvailableMedicines=" + Arrays.toString(AvailableMedicines) +
                '}';
    }
}
