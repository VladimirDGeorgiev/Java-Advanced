package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedRetakeExam_16April2019.arena;

import java.util.LinkedHashMap;
import java.util.Map;

public class FightingArena {
    private Map<String, Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new LinkedHashMap<>();
    }

    public void add(Gladiator entity) {
        this.gladiators.putIfAbsent(entity.getName(), entity);
    }

    public void remove(String name) {
        this.gladiators.remove(name);
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        Gladiator gladiator = null;
        int sum = Integer.MIN_VALUE;
        for (Gladiator value : gladiators.values()) {
            if (value.getStatPower() > sum) {
                sum = value.getStatPower();
                gladiator = value;
            }
        }
        return gladiator;
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        Gladiator gladiator = null;
        int sum = Integer.MIN_VALUE;
        for (Gladiator value : gladiators.values()) {
            if (value.getWeaponPower() > sum) {
                sum = value.getWeaponPower();
                gladiator = value;
            }
        }
        return gladiator;
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        Gladiator gladiator = null;
        int sum = Integer.MIN_VALUE;
        for (Gladiator value : gladiators.values()) {
            if (value.getTotalPower() > sum) {
                sum = value.getTotalPower();
                gladiator = value;
            }
        }
        return gladiator;
    }

    public int getCount() {
        return this.gladiators.size();
    }

    @Override
    public String toString() {
        return String.format("%s – %d gladiators are participating."
                , this.name
                ,this.getCount() );
    }
}
