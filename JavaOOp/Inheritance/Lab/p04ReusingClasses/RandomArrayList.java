package JavaOOp.L04Inheritance.Lab.p04ReusingClasses;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random rnd = new Random();
    public Object getRandomElement(){
        int index = this.rnd.nextInt(super.size());
        return super.remove(index);
    }
}
