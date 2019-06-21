package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedRetakeExam_16April2019.arena;

public class Gladiator {

    private String name;
    private Stat stat;
    private Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getStatPower(){
        return this.stat.getAgility()+this.stat.getFlexibility()+this.stat.getIntelligence()
                +this.stat.getSkills()+this.stat.getStrength();
    }

    public int getWeaponPower(){
        return this.weapon.getSharpness()+this.weapon.getSize()+this.weapon.getSolidity();
    }

    public int getTotalPower(){
        return getWeaponPower()+getStatPower();
    }

    @Override
    public String toString() {
        return this.name+" - "+this.getTotalPower()+"\n"
                +"  Weapon Power: "+this.getWeaponPower()+"\n"
                +"  Stat Power: "+this.getStatPower();
    }
}
