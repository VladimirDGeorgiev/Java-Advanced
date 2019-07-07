package JavaOOp.L05Encapsulation.Exercises.p04PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        try {
            DoughModifiers flourTypeModifiers = DoughModifiers.valueOf(flourType);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            DoughModifiers bakingTechniqueModifiers = DoughModifiers.valueOf(bakingTechnique);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight<1||weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories (){
        DoughModifiers flourTypeModifiers = DoughModifiers.valueOf(this.flourType);
        DoughModifiers bakingTechniqueModifiers = DoughModifiers.valueOf(this.bakingTechnique);

        return (2*this.weight)*flourTypeModifiers.getValue()*bakingTechniqueModifiers.getValue();
    }

}
