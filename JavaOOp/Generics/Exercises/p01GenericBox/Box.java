package JavaOOp.Generics.Exercises.p01GenericBox;

public class Box<T> {
    private T type;

    public Box(T type) {
        this.type = type;
    }

    @Override
    public String toString() {

        return type.getClass().getName()+": "+this.type;
    }
}
