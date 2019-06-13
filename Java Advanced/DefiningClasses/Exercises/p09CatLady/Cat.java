package JavaAdvance.DefiningClasses.Exercises.p09CatLady;

public class Cat {
    private String breed;
    private double characteristic;

    public Cat(String breed, double characteristic) {
        this.breed = breed;
        this.characteristic = characteristic;
    }

    public String getBreed() {
        return breed;
    }

    public double getCharacteristic() {
        return characteristic;
    }
}
