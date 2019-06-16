package JavaOOp.Generics.Exercises.p11Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Threeuple> tupleList = new LinkedHashSet<>();
        String[] nameAndAddress = reader.readLine().split("\\s+");
        tupleList.add(new Threeuple(
                nameAndAddress[0]+" "+nameAndAddress[1]
                ,nameAndAddress[2]
                ,nameAndAddress[3]));
        String[] nameAndBeer = reader.readLine().split("\\s+");
        boolean drungOrNot = nameAndBeer[2].equals("drunk");

        tupleList.add(
                new Threeuple(nameAndBeer[0]
                        ,Integer.parseInt(nameAndBeer[1])
                        ,drungOrNot));
        String[] intAndDouble = reader.readLine().split("\\s+");
        tupleList.add(new Threeuple(intAndDouble[0]
                ,Double.parseDouble(intAndDouble[1])
                ,intAndDouble[2]));
        for (Threeuple threeuple : tupleList) {
            System.out.println(threeuple.toString());
        }

      // tupleList.forEach(e-> System.out.println(e.getItem1()+" -> "+e.getItem2()+" -> "+e.getItem3()));

    }
}

