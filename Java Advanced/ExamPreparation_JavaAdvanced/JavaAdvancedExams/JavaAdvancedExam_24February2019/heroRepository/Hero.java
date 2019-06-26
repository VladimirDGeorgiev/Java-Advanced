package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedExam_24February2019.heroRepository;

public class Hero {
    private String name;
    private int level;
    private Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return String.format("Hero: %s – %d",this.name,this.level)+"\n"+
                "  *  Strength: "+this.item.getStrength()+"\n"+
                "  *  Agility: "+this.item.getAgility()+"\n"+
                "  *  Intelligence: "+this.item.getIntelligence();
    }
}
