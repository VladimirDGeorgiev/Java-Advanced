package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedExam_16June2019_Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p02MakeASalad {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //read input
        String[] vegetables = reader.readLine().split("\\s+");
        int[] calorie = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<String> queuesVegetables = new ArrayDeque<>();
        ArrayDeque<Integer> stackCalorie = new ArrayDeque<>();

        for (String vegetable : vegetables) {
            queuesVegetables.offer(vegetable);
        }
        for (int e : calorie) {
            stackCalorie.push(e);
        }
        //logic
        int salad=0 ;
        while (!stackCalorie.isEmpty() || !queuesVegetables.isEmpty()) {
            if (salad<=0) {
                salad = stackCalorie.peek();
            }
            String food = queuesVegetables.poll();
            switch (food) {
                case "tomato":
                    salad-=80;
                    break;
                case "carrot":
                    salad-=136;
                    break;
                case "lettuce":
                    salad-=109;
                    break;
                case "potato":
                    salad-=215;
                    break;
                default:
                    break;
            }
            if (salad<=0||queuesVegetables.isEmpty()){
                System.out.print(stackCalorie.pop()+" ");
            }
            if (stackCalorie.isEmpty()){
                System.out.println();
                while (!queuesVegetables.isEmpty()){
                    System.out.print(queuesVegetables.poll()+" ");
                }
                break;
            }
            if (queuesVegetables.isEmpty()){
                System.out.println();
                while (!stackCalorie.isEmpty()){
                    System.out.print(stackCalorie.pop()+" ");
                }
            }

        }

    }
}
