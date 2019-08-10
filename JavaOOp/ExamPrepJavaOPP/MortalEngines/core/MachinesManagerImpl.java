package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.BaseMachine;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

import static common.OutputMessages.*;

public class MachinesManagerImpl implements MachinesManager {

    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String,Pilot> pilots;
    private Map<String,Machine> machines;


    public MachinesManagerImpl(PilotFactory pilotFactory,
                               MachineFactory machineFactory,
                               Map<String, Pilot> pilots,
                               Map<String, Machine> machines) {
     this.pilotFactory = pilotFactory;
     this.machineFactory = machineFactory;
     this.pilots = pilots;
     this.machines = machines;

    }


    @Override
    public String hirePilot(String name) {

        if (this.pilots.containsKey(name)){
            return String.format(pilotExists,name);

        }else{
            Pilot pilot = this.pilotFactory.createPilot(name);
            this.pilots.put(pilot.getName(),pilot);
            return String.format(pilotHired,name);
        }
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {

        if (this.machines.containsKey(name)){
            return String.format(machineExists,name);
        }else{
            Tank tank = this.machineFactory.createTank(name, attackPoints, defensePoints);
            this.machines.put(name,tank);
            return String.format(tankManufactured,name,attackPoints,defensePoints);
        }

    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            return String.format(machineExists,name);
        }else{
            Fighter fighter = this.machineFactory.createFighter(name,attackPoints,defensePoints);
            this.machines.put(name,fighter);
            return String.format(fighterManufactured,name,attackPoints,defensePoints);
        }
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (!this.machines.containsKey(selectedMachineName)){
            return String.format(machineNotFound,selectedMachineName);
        }
        if (!this.pilots.containsKey(selectedPilotName)){
            return String.format(pilotNotFound,selectedPilotName);
        }
        if (this.machines.get(selectedMachineName).getPilot()!=null){
            return String.format(machineHasPilotAlready,selectedMachineName);
        }
        Machine machine = this.machines.get(selectedMachineName);
        Pilot pilot = this.pilots.get(selectedPilotName);
        this.pilots.get(selectedPilotName).addMachine(machine);
        this.machines.get(selectedMachineName).setPilot(pilot);
        return String.format(machineEngaged,selectedPilotName,selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if (!this.machines.containsKey(attackingMachineName)){
            return String.format(machineNotFound,attackingMachineName);
        }
        if (!this.machines.containsKey(defendingMachineName)){
            return String.format(machineNotFound,defendingMachineName);
        }
        this.machines.get(attackingMachineName).attack(defendingMachineName);

        double attackPointsMachine = this.machines.get(attackingMachineName).getAttackPoints();
        double defendPointsMachine = this.machines.get(defendingMachineName).getDefensePoints();
        double defendHealthPointsMachine = this.machines.get(defendingMachineName).getHealthPoints();

        if (attackPointsMachine>defendPointsMachine){
            if (defendHealthPointsMachine>=attackPointsMachine){
                this.machines.get(defendingMachineName).setHealthPoints(defendHealthPointsMachine-attackPointsMachine);
            }else{
                this.machines.get(defendingMachineName).setHealthPoints(0);
            }
        }
        return String.format(attackSuccessful,
                defendingMachineName,
                attackingMachineName,
                this.machines.get(defendingMachineName).getHealthPoints());

    }

    @Override
    public String pilotReport(String pilotName) {
        if (!this.pilots.containsKey(pilotName)) {
            return String.format(pilotNotFound,pilotName);
        }
        return this.pilots.get(pilotName).report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (!this.machines.containsKey(fighterName)){
            return String.format(machineNotFound,fighterName);
        }
        if (this.machines.get(fighterName).getClass().getSimpleName().equals("TankImpl")){
            return String.format(notSupportedOperation,fighterName);
        }else{
            ((Fighter) this.machines.get(fighterName)).toggleAggressiveMode();
            return String.format(fighterOperationSuccessful,fighterName);
        }
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (!this.machines.containsKey(tankName)){
            return String.format(machineNotFound,tankName);
        }
        if (!this.machines.get(tankName).getClass().getSimpleName().equals("TankImpl")){
            return String.format(notSupportedOperation,tankName);
        }else{
            ((Tank) this.machines.get(tankName)).toggleDefenseMode();
            return String.format(tankOperationSuccessful,tankName);
        }
    }
}
