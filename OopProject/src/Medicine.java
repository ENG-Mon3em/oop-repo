public class Medicine {
    private String name;

    public Medicine(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() { return name; }
}
