package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedExam_24February2019.heroRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class HeroRepository {
    private Map<String,Hero> data;

    public HeroRepository() {
        this.data = new LinkedHashMap<>();
    }

    public void add(Hero entity){
        this.data.putIfAbsent(entity.getName(),entity);
    }

    public void  remove(String name){
        this.data.remove(name);
    }

    public Hero getHeroWithHighestStrength(){
      int maxStrength = Integer.MIN_VALUE;
      String nameOfTheBest = "";
        for (Map.Entry<String, Hero> stringHeroEntry : this.data.entrySet()) {
            if (stringHeroEntry.getValue().getItem().getStrength()>maxStrength){
                maxStrength=stringHeroEntry.getValue().getItem().getStrength();
                nameOfTheBest=stringHeroEntry.getKey();
            }
        }
        return this.data.get(nameOfTheBest);
    }

    public Hero getHeroWithHighestAgility(){
        int maxAgility = Integer.MIN_VALUE;
        String nameOfTheBest = "";
        for (Map.Entry<String, Hero> stringHeroEntry : this.data.entrySet()) {
            if (stringHeroEntry.getValue().getItem().getAgility()>maxAgility){
                maxAgility=stringHeroEntry.getValue().getItem().getAgility();
                nameOfTheBest=stringHeroEntry.getKey();
            }
        }
        return this.data.get(nameOfTheBest);
    }

    public Hero getHeroWithHighestIntelligence(){
        int maxIntelligence = Integer.MIN_VALUE;
        String nameOfTheBest = "";
        for (Map.Entry<String, Hero> stringHeroEntry : this.data.entrySet()) {
            if (stringHeroEntry.getValue().getItem().getIntelligence()>maxIntelligence){
                maxIntelligence=stringHeroEntry.getValue().getItem().getIntelligence();
                nameOfTheBest=stringHeroEntry.getKey();
            }
        }
        return this.data.get(nameOfTheBest);
    }

    public int getCount(){
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Hero value : data.values()) {
            result.append(value).append("\n");

        }
        return result.toString().trim();
    }
}
