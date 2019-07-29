package JavaOOP.L11Workshop.SystemSplit.hardware;

public class PowerHardware extends Hardware {
    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, maximumCapacity, maximumMemory);
    }

    @Override
    public void setMaximumCapacity(int maximumCapacity) {
        maximumCapacity= maximumCapacity-((maximumCapacity*3)/4);
        super.setMaximumCapacity(maximumCapacity);
    }

    @Override
    public void setMaximumMemory(int maximumMemory) {
        maximumMemory= maximumMemory+((maximumMemory*3)/4);
        super.setMaximumMemory(maximumMemory);
    }
}
