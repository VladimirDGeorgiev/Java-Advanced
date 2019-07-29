package JavaOOP.L11Workshop.SystemSplit;

import JavaOOP.L11Workshop.SystemSplit.Software.ExpressSoftware;
import JavaOOP.L11Workshop.SystemSplit.Software.LightSoftware;
import JavaOOP.L11Workshop.SystemSplit.Software.Software;
import JavaOOP.L11Workshop.SystemSplit.hardware.Hardware;
import JavaOOP.L11Workshop.SystemSplit.hardware.HeavyHardware;
import JavaOOP.L11Workshop.SystemSplit.hardware.PowerHardware;

import java.util.LinkedHashMap;
import java.util.Map;

public class Engine {

    private Map<String, HardwareComponents> hardwareComponents;

    public Engine() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        Hardware hardware = new PowerHardware(name, capacity, memory);
        this.hardwareComponents.putIfAbsent(name, new HardwareComponents(hardware));
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        Hardware hardware = new HeavyHardware(name, capacity, memory);
        this.hardwareComponents.putIfAbsent(name, new HardwareComponents(hardware));
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        Software software = new ExpressSoftware(name, capacity, memory);
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            if (this.hardwareComponents.get(hardwareComponentName).isItEnoughCapacityAndMemory(software))
                this.hardwareComponents.get(hardwareComponentName).addSoftware(software);
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        Software software = new LightSoftware(name, capacity, memory);
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            if (this.hardwareComponents.get(hardwareComponentName).isItEnoughCapacityAndMemory(software))
                this.hardwareComponents.get(hardwareComponentName).addSoftware(software);
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.get(hardwareComponentName).removeSoftware(softwareComponentName);
        }
    }

    private int sumOfSoftwareComp() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponents::getSoftwaresSize).sum();
    }

    private int totalOperationalMemoryInUse() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponents::getOperationalMemoryInUse).sum();
    }

    private int totalCapacityTaken() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponents::gettotalCapacityTaken).sum();

    }

    private int maximumMemory() {
        return this.hardwareComponents.values().stream().mapToInt(e -> e.getHardware().getMaximumMemory()).sum();
    }

    private int maximumCapacity() {
        return this.hardwareComponents.values().stream().mapToInt(e -> e.getHardware().getMaximumCapacity()).sum();
    }

    public String analyze() {
        StringBuilder str = new StringBuilder();
        str.append("System Analysis").append(System.lineSeparator())
                .append("Hardware Components: ").append(this.hardwareComponents.size()).append(System.lineSeparator())
                .append("Software Components: ").append(this.sumOfSoftwareComp()).append(System.lineSeparator())
                .append(String.format("Total Operational Memory: %d / %d", this.totalOperationalMemoryInUse(), this.maximumMemory())).append(System.lineSeparator())
                .append(String.format("Total Capacity Taken: %d / %d", this.totalCapacityTaken(), this.maximumCapacity()));

        return str.toString();
    }

    public void systemSplit() {
        this.hardwareComponents.entrySet().stream()
                .sorted((f, s) -> s.getValue().getHardware().getType().compareTo(f.getValue().getHardware().getType()))
                .forEach(e -> {
                    System.out.println("Hardware Component - " + e.getKey());
                    System.out.println("Express Software Components - " + e.getValue().expressSoftwareSize());
                    System.out.println("Light Software Components - " + e.getValue().lightSoftwareSize());
                    System.out.println(String.format("Memory Usage: %d / %d", e.getValue().getOperationalMemoryInUse(), e.getValue().getHardware().getMaximumMemory()));
                    System.out.println(String.format("Capacity Usage: %d / %d", e.getValue().gettotalCapacityTaken(), e.getValue().getHardware().getMaximumCapacity()));
                    System.out.println("Type: " + e.getValue().getHardware().getType().substring(0, 5));
                    System.out.println("Software Components: " + e.getValue().getSoftwareNames());
                });

    }


}
