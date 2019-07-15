package JavaOOP.L08SOLID.enumerations;

public enum ReportLevel {
    INFO(0),
    WARNING(1),
    ERROR(2),
    CRITICAL(3),
    FATAL(4);

    private int value;

    ReportLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
