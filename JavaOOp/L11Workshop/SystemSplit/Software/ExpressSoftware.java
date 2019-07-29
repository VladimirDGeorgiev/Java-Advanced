package JavaOOP.L11Workshop.SystemSplit.Software;

public class ExpressSoftware extends  Software {
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
    }

    @Override
    public void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption*2);
    }
}
