package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedExam_24February2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p01ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> stackCommands = new ArrayDeque<>();
        ArrayDeque<String> hallQueues = new ArrayDeque<>();

        int capacity = Integer.parseInt(reader.readLine());
        String[] data = reader.readLine().split("\\s+");
        for (int i = 0; i < data.length; i++) {
            stackCommands.push(data[i]);
        }

        List<Integer> reservation = new ArrayList<>();

        while (!stackCommands.isEmpty()){
            String currentCommand = stackCommands.peek();

            if (Character.isDigit(currentCommand.charAt(0))){
                int number = Integer.parseInt(currentCommand);
                if (hallQueues.isEmpty()){
                    stackCommands.pop();
                    continue;
                }
                int sum = reservation.stream().mapToInt(e->e).sum();
                if (sum+number<=capacity){
                    reservation.add(number);
                    stackCommands.pop();
                    continue;
                }else{
                    printHall(hallQueues.poll(),reservation);
                    reservation.clear();
                }


            }else{
                hallQueues.offer(currentCommand);
                stackCommands.pop();
            }


        }

    }

    private static void printHall(String hall, List<Integer> reservation) {

        System.out.println(hall+" -> "+reservation.toString().replaceAll("[\\[\\]]",""));

    }
}
