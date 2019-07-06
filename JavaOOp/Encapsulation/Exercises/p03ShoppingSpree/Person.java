package JavaOOp.L05Encapsulation.Exercises.p03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.equals("")||name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }
    public void buyProduct (Product product){
        if (product.getCost()>this.money){
            throw new IllegalArgumentException(String.format("%s can't afford %s",this.name,product.getName()));
        }
        this.products.add(product);
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()){
            return this.name+" – Nothing bought";
        }
        return this.name+" - "+ products.toString().replaceAll("[\\[\\]]","");
    }
}
