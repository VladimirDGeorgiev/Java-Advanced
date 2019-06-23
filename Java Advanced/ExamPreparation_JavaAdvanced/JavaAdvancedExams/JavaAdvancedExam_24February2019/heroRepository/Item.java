package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedExam_24February2019.heroRepository;

public class Item {
    private int strength;
    private int agility;
    private int intelligence;

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public String toString() {
        return "Item:\n" +
                "  *  Strength: "+this.strength+"\n"+
                "  *  Agility: "+this.agility+"\n"+
                "  *  Intelligence: "+this.intelligence;
    }
}
