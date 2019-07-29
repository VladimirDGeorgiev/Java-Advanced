package JavaOOP.L11Workshop.SystemSplit.hardware;

public abstract class Hardware {
    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;

    public Hardware(String name, int maximumCapacity, int maximumMemory) {
        this.setName(name);
        this.setType(this.getClass().getSimpleName());
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }
}
