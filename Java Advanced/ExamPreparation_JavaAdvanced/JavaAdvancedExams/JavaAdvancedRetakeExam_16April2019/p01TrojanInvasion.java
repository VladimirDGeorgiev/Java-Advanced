package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedRetakeExam_16April2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p01TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int waves = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> stackWarrior = new ArrayDeque<>();
        ArrayDeque<Integer> queuesPlate = new ArrayDeque<>();
        //Plates enter data
        int[] dataPlates = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int dataPlate : dataPlates) {
            queuesPlate.offer(dataPlate);
        }


        //waves start
        for (int i = 1; i <=waves ; i++) {

            //warrior enter
            int[] dataWarrior = Arrays.stream(reader.readLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int e : dataWarrior) {
                stackWarrior.push(e);
            }
            //3 day
            if (i % 3 == 0) {
                int buildNewPlate = Integer.parseInt(reader.readLine());
                queuesPlate.offer(buildNewPlate);
            }
            //warriar atack

            while (!stackWarrior.isEmpty()) {
                int warriar = stackWarrior.pop();
                int plate = queuesPlate.poll();
                int result = plate-warriar;
                if (result>0){
                    queuesPlate.addFirst(result);
                }else if(result<0){
                    result*=-1;
                    stackWarrior.push(result);
                }
                //Trojans win
                if (queuesPlate.isEmpty()){
                    System.out.println("The Trojans successfully destroyed the Spartan defense.");
                    System.out.println("Warriors left: "+stackWarrior.toString().replaceAll("[\\[\\]]",""));
                    return;
                }
            }

        }
        //Starta wins
        System.out.println("The Spartans successfully repulsed the Trojan attack.");
        System.out.println("Plates left: "+queuesPlate.toString().replaceAll("[\\[\\]]",""));
    }
}
