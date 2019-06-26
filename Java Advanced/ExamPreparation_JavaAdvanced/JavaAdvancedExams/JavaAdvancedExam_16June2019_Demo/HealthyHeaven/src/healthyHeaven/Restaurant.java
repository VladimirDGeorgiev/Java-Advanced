package healthyHeaven;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {

    private Map<String,Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data = new LinkedHashMap<>();
    }

    public void add(Salad salad) {
        this.data.putIfAbsent(salad.getName(),salad);
    }

    public boolean buy(String name) {
        if (this.data.containsKey(name)) {
            this.data.remove(name);
            return true;
        }
        return false;
    }

    // public String getHealthiestSalad(){
    //     int index = -1;
    //     int sum = Integer.MAX_VALUE;
    //     for (int i = 0; i < this.data.size(); i++) {
    //        if (this.data.get(i).getTotalCalories()<sum){
    //            sum=this.data.get(i).getTotalCalories();
    //            index=i;
    //        }
    //     }

    //         return this.data.get(index).getName();


    // }

    public String getName() {
        return name;
    }

    public Salad getHealthiestSalad() {
        String healthiestSalad = "";
        int lowestCalories = Integer.MAX_VALUE;

        for (Salad salad : this.data.values()) {
            int currentCalories = salad.getTotalCalories();
            if (currentCalories < lowestCalories) {
                healthiestSalad = salad.getName();
                lowestCalories = currentCalories;
            }
        }
        return this.data.get(healthiestSalad);
    }

    public String generateMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append(String.format("%s have %d salads:",
                this.getName(), this.data.size()))
                .append(System.lineSeparator());

        for (Salad salad : this.data.values()) {
            menu.append(salad.toString()).append(System.lineSeparator());
        }
        return menu.toString().trim();
    }

}
