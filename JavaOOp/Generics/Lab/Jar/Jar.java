package JavaOOp.Generics.Lab.Jar;

import java.util.ArrayDeque;

public class Jar<T> {

    private ArrayDeque<T> content;


    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public void add(T entity){
        this.content.push(entity);
    }
     public T remove(){
        if (this.content.size()>0){
            return  this.content.pop();
        }

        return null;
    }
}
