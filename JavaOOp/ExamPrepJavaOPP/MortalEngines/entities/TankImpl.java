package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {


    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 100);
        this.setDefenseModeTrue();
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.defenseMode){
            this.setDefenseModeFalse();
        }else{
            this.setDefenseModeTrue();
        }
    }



    private void setDefenseModeTrue() {
        this.defenseMode = true;
        super.setAttackPoints(super.getAttackPoints() - 40);
        super.setDefensePoints(super.getDefensePoints() + 30);
    }

    private void setDefenseModeFalse() {
        this.defenseMode = false;
        super.setAttackPoints(super.getAttackPoints() + 40);
        super.setDefensePoints(super.getDefensePoints() - 30);
    }


    @Override
    public String toString() {
        String str  ="";
        if (this.getDefenseMode()){
            str="ON";
        }else{
            str = "OFF";
        }
        return super.toString()+String.format(" *Defense Mode(%s)",str);
    }
}
