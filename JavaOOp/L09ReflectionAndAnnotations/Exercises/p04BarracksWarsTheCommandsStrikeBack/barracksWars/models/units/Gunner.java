package JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int GUNNER_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }

}
