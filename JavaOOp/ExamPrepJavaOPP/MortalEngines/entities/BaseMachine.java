package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot ;
    private double attackPoints;
    private double defensePoints ;
    private double healthPoints ;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.setHealthPoints(healthPoints);
        this.targets = new ArrayList<>();
        this.pilot=null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name==null){
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }
        this.name=name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot==null){
            throw new NullPointerException("Pilot cannot be null.");
        }
        this.pilot=pilot;

    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints=healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return this.targets;
        //todo moje i da trqbva da nepromenq6tase kolekciq
    }

    @Override
    public void attack(String target) {
        if (target==null||target.trim().isEmpty()){
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }

        this.targets.add(target);
        //todo moje targeta da ne trqbva da se povtarq
    }

    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    protected void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(" *Type: ").append(this.getClass().getSimpleName().replaceAll("Impl",""));
        str.append(System.lineSeparator());
        str.append(String.format(" *Health: %.2f",this.getHealthPoints()).replaceAll(",","."));
        str.append(System.lineSeparator());
        str.append(String.format(" *Attack: %.2f",this.getAttackPoints()).replaceAll(",","."));
        str.append(System.lineSeparator());
        str.append(String.format(" *Defense: %.2f",this.getDefensePoints()).replaceAll(",","."));
        str.append(System.lineSeparator());
        if(this.getTargets().size()==0){
            str.append(" *Targets: None");
            str.append(System.lineSeparator());
        }else{
            str.append(" *Targets: ");
            str.append(this.getTargets().toString().replaceAll("[\\[\\]]",""));
            str.append(System.lineSeparator());
        }
        return str.toString();
    }
}
