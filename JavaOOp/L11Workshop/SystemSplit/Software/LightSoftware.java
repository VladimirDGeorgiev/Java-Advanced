package JavaOOP.L11Workshop.SystemSplit.Software;

public class LightSoftware extends Software {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
    }

    @Override
    public void setCapacityConsumption(int capacityConsumption) {
        capacityConsumption+=capacityConsumption/2;
        super.setCapacityConsumption(capacityConsumption);
    }

    @Override
    public void setMemoryConsumption(int memoryConsumption) {
        memoryConsumption-=memoryConsumption/2;
        super.setMemoryConsumption(memoryConsumption);
    }
}
