package JavaOOP.L11Workshop.SystemSplit;

import JavaOOP.L11Workshop.SystemSplit.Software.Software;
import JavaOOP.L11Workshop.SystemSplit.hardware.Hardware;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HardwareComponents {
    private Hardware hardware;
    private List<Software> softwares;

    public HardwareComponents(Hardware hardware) {
        this.hardware = hardware;
        this.softwares = new ArrayList<>();
    }

    public int expressSoftwareSize() {
        return (int) this.softwares.stream().filter(e -> e.getType().equals("ExpressSoftware")).count();
    }

    public int lightSoftwareSize() {
        return (int) this.softwares.stream().filter(e -> e.getType().equals("LightSoftware")).count();
    }

    public Hardware getHardware() {
        return hardware;
    }


    public int getSoftwaresSize() {
        return this.softwares.size();
    }

    public void addSoftware(Software softwares) {
        this.softwares.add(softwares);
    }

    public int getOperationalMemoryInUse() {
        return this.softwares.stream().mapToInt(Software::getMemoryConsumption).sum();
    }

    public int gettotalCapacityTaken() {
        return this.softwares.stream().mapToInt(Software::getCapacityConsumption).sum();
    }

    public boolean isItEnoughCapacityAndMemory(Software software) {
        int sumCapacityConsumption = this.softwares.stream().mapToInt(Software::getCapacityConsumption).sum();
        int sumMemoryConsumption = this.softwares.stream().mapToInt(Software::getMemoryConsumption).sum();
        sumCapacityConsumption += software.getCapacityConsumption();
        sumMemoryConsumption += software.getMemoryConsumption();
        if (this.hardware.getMaximumCapacity() < sumCapacityConsumption ||
                this.hardware.getMaximumMemory() < sumMemoryConsumption) {
            return false;
        }
        return true;
    }

    public String getSoftwareNames() {
        if (this.softwares.isEmpty()) {
            return "None";
        } else {
            StringBuilder str = new StringBuilder();
            List<String> collect = this.softwares.stream().map(Software::getName).collect(Collectors.toList());
            return collect.toString().replaceAll("[\\[\\]]", "");
        }
    }


    public void removeSoftware(String name) {
        this.softwares.removeIf(s -> s.getName().equals(name));
    }
}
