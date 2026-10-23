package lab3;

public final class ImmutablePerson {
    private final String idNumber;
    private final String fullName;

    public ImmutablePerson(String idNumber, String fullName) {
        if (idNumber == null || fullName == null) {
            throw new IllegalArgumentException("Fields cannot be null");
        }
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public String getIdNumber() { return idNumber; }
    public String getFullName() { return fullName; }

    public static void main(String[] args) {
        ImmutablePerson p = new ImmutablePerson("63-294810-A-18", "Nyasha Makamure");
        System.out.println("ID: " + p.getIdNumber());
        System.out.println("Name: " + p.getFullName());
    }
}
