package JavaOOp.Generics.Exercises.p11Threeuple;

public class Threeuple<E1,E2,E3> {
    private E1 item1;
    private E2 item2;
    private E3 item3;

    public Threeuple(E1 item1, E2 item2, E3 item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public Threeuple() {
    }

    public E1 getItem1() {
        return item1;
    }

    public void setItem1(E1 item1) {

        this.item1 = item1;
    }

    public E2 getItem2() {

        return item2;
    }

    public void setItem2(E2 item2) {
        this.item2 = item2;
    }

    public E3 getItem3() {
        return item3;
    }

    public void setItem3(E3 item3) {
        this.item3 = item3;
    }
    //@Override
    //    public String toString() {
    //        StringBuilder sb = new StringBuilder();
    //        return sb.append(this.firstItem).append( " -> ").append(this.secondItem).append(" -> ").append(this.thirdItem).toString();
    //    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(this.item1).append(" -> ")
                .append(this.item2).append(" -> ")
                .append(this.item3).toString();
    }
}
