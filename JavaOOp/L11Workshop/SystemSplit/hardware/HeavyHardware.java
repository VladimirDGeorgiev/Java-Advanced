package JavaOOP.L11Workshop.SystemSplit.hardware;

public class HeavyHardware extends Hardware {
    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, maximumCapacity, maximumMemory);
    }

    @Override
    public void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity*2);
    }

    @Override
    public void setMaximumMemory(int maximumMemory) {
        maximumMemory= maximumMemory-(maximumMemory/4);
        super.setMaximumMemory(maximumMemory);
    }
}
