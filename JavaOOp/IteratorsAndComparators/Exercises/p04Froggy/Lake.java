package JavaOOp.IteratorsAndComparators.Exercises.p04Froggy;

import java.util.Iterator;

public class Lake implements Iterable {
    private int[] lake;

    public Lake(int[] lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer>{
        private int index;

        @Override
        public boolean hasNext() {
            if (lake.length%2!=0){
                if (this.index == lake.length+1) {
                    index = 1;
                }
            }else {
                if (this.index == lake.length) {
                    index = 1;
                }
            }
                return this.index < lake.length;
        }

        @Override
        public Integer next() {
            index+=2;
            return lake[index-2];
        }
    }

}
