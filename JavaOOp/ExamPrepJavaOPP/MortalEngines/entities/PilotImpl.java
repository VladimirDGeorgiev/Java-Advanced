package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {

    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name==null){
            throw new IllegalArgumentException("Pilot name cannot be null or empty string.");
        }
        this.name = name;
    }

    @Override
    public void addMachine(Machine machine) {
        if (machine==null){
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }
        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
        //todo move da e nemodivicira6t se list
    }

    @Override
    public String report() {
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(String.format("%s - %d machines",
                this.getName(),
                this.getMachines().size()))
                .append(System.lineSeparator());;
        for (Machine machine : this.getMachines()) {
           resultStr.append("- ").append(machine.getName())
                   .append(System.lineSeparator())
                   .append(machine.toString()).
                   append(System.lineSeparator());
        }


        return resultStr.toString().trim();
    }
}
