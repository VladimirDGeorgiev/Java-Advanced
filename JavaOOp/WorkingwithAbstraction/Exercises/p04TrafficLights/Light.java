package JavaOOp.L03WorkingwithAbstraction.Exercises.p04TrafficLights;

public enum Light {
    // red, green and yellow
    RED(0),
    GREEN(1),
    YELLOW(3);

    private int value;

    Light(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
