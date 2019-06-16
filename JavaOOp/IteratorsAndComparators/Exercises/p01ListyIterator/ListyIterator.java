package JavaOOp.IteratorsAndComparators.Exercises.p01ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> elements;
    private int count=0;

    public ListyIterator(String... items) {
        this.elements = new ArrayList<>( Arrays.asList(items));
    }

    public boolean Move() {
        if (count == this.elements.size()-1) {
            return false;
        }
        count++;
        return true;
    }

    public void Print() {
        if (this.elements.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(count));
        }
    }

    public boolean HasNext() {
        if (count+1>=this.elements.size()){
            return false;
        }
return true;
    }
    public void remove(){
        this.elements.remove(0);
    }

}
