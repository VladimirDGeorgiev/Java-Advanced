package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {





    private boolean aggressiveMode;


    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 200);
        this.setAggressiveModeTrue();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.aggressiveMode){
        setAggressiveModeFalse();
        }else{
           setAggressiveModeTrue();
        }
    }


    private void setAggressiveModeTrue() {
        this.aggressiveMode = true;
        super.setAttackPoints(super.getAttackPoints() + 50);
        super.setDefensePoints(super.getDefensePoints() - 25);
    }

    private void setAggressiveModeFalse() {
        this.aggressiveMode = false;
        super.setAttackPoints(super.getAttackPoints() - 50);
        super.setDefensePoints(super.getDefensePoints() + 25);
    }




    @Override
    public String toString() {
        String str  ="";
        if (this.getAggressiveMode()){
            str="ON";
        }else{
            str = "OFF";
        }
        return super.toString()+String.format(" *Aggressive Mode(%s)",str);
    }
}
