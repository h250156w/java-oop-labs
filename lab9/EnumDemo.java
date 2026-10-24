package lab9;

enum Severity {
    LOW("Minor issue, system operating normally."),
    MEDIUM("Moderate issue, monitoring required."),
    HIGH("Critical failure, immediate intervention needed!");

    private final String description;

    Severity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        Severity level = Severity.HIGH;

        switch (level) {
            case LOW -> System.out.println("Status: Low - " + level.getDescription());
            case MEDIUM -> System.out.println("Status: Medium - " + level.getDescription());
            case HIGH -> System.out.println("Status: High - " + level.getDescription());
        }
    }
}
