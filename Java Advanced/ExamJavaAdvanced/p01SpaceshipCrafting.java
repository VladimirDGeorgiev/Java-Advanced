package ExamJavaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p01SpaceshipCrafting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //input
        int[] dataChemicalLiquids = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queuesLiquids = new ArrayDeque<>();
        for (int dataChemicalLiquid : dataChemicalLiquids) {
            queuesLiquids.offer(dataChemicalLiquid);
        }

        int[] dataPhysicalItems = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackItems = new ArrayDeque<>();
        for (int e : dataPhysicalItems) {
            stackItems.push(e);
        }

        //logic

        Map<String,Integer> materials= new TreeMap<>();
        materials.put("Glass",0);
        materials.put("Aluminium",0);
        materials.put("Lithium",0);
        materials.put("Carbon fiber",0);

        while (true){
            if (stackItems.isEmpty()||queuesLiquids.isEmpty()){
                break;
            }
            int sum = 0;
            int liquid = queuesLiquids.poll();
            int item = stackItems.pop();
            sum = liquid+item;

            switch (sum){
                case 25 :
                    materials.put("Glass",materials.get("Glass")+1);
                    break;
                case 50 :
                    materials.put("Aluminium",materials.get("Aluminium")+1);
                    break;
                case 75 :
                    materials.put("Lithium",materials.get("Lithium")+1);
                    break;
                case 100 :
                    materials.put("Carbon fiber",materials.get("Carbon fiber")+1);
                    break;
                    default:
                        item=item+3;
                        stackItems.push(item);
                        break;
            }

        }

        if (materials.get("Glass")>0
                &&materials.get("Aluminium")>0
                &&materials.get("Lithium")>0
                &&materials.get("Carbon fiber")>0){
            //ima gi vsi4i systawki
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }
        if (queuesLiquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            System.out.println("Liquids left: "+queuesLiquids.toString().replaceAll("[\\[\\]]",""));
        }
        if (stackItems.isEmpty()){
            System.out.println("Physical items left: none");
        }else{
            System.out.println("Physical items left: "+stackItems.toString().replaceAll("[\\[\\]]",""));
        }

     // long sumOfAluminium = materials.stream().filter(e->e.equals("Aluminium")).count();
     // long sumOfCarbon = materials.stream().filter(e->e.equals("Carbon fiber")).count();
     // long sumOfGlass = materials.stream().filter(e->e.equals("Glass")).count();
     // long sumOfLithium = materials.stream().filter(e->e.equals("Lithium")).count();
     // System.out.println("Aluminium: "+sumOfAluminium);
     // System.out.println("Carbon fiber: "+sumOfCarbon);
     // System.out.println("Glass: "+sumOfGlass);
     // System.out.println("Lithium: "+sumOfLithium);

        materials.entrySet().forEach(e->{
            System.out.println(e.getKey()+": "+e.getValue());
        });



    }
}
