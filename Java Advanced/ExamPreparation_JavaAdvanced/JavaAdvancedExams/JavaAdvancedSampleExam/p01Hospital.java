package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedSampleExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class p01Hospital {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,List<String>> departmentRoomsMap = new LinkedHashMap<>();
        Map<String, List<String>> doctorsWithPatientsMap = new LinkedHashMap<>();

        String command = "";
        while (!"Output".equals(command= reader.readLine())){
            String[] tokens = command.split("\\s+");
            String department = tokens[0];
            String doctor = tokens[1]+" "+tokens[2];
            String patient = tokens[3];
            departmentRoomsMap.putIfAbsent(department,new ArrayList<>());
            if (departmentRoomsMap.get(department).size()<60){
                departmentRoomsMap.get(department).add(patient);
                doctorsWithPatientsMap.putIfAbsent(doctor,new ArrayList<>());
                doctorsWithPatientsMap.get(doctor).add(patient);
            }
        }

        while (!"End".equals(command= reader.readLine())){
            String[] tokens = command.split("\\s+");
            if (tokens.length==2&&Character.isDigit(tokens[1].charAt(0))){
                int roomNumber = Integer.parseInt(tokens[1]);
                int endIndex = roomNumber*3;
                int startIndex = endIndex-3;
                if (departmentRoomsMap.containsKey(tokens[0])&&departmentRoomsMap.get(tokens[0]).size()>=endIndex){
                        List<String> temp = departmentRoomsMap.get(tokens[0]).subList(startIndex, endIndex);
                        temp.sort(Comparator.naturalOrder());
                        temp.forEach(System.out::println);
                }
            }else if (tokens.length==2&&doctorsWithPatientsMap.containsKey(tokens[0]+" "+ tokens[1])){
                List<String> temp = doctorsWithPatientsMap.get(tokens[0]+" "+ tokens[1]);
                temp.sort(Comparator.naturalOrder());
                temp.forEach(System.out::println);
            } else if (departmentRoomsMap.containsKey(tokens[0])){
                departmentRoomsMap.get(tokens[0]).forEach(System.out::println);
            }

        }
    }
}
