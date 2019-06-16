package JavaOOp.Generics.Exercises.p10Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        List<Tuple> tupleList = new ArrayList<>();
        String[] nameAndAddress = reader.readLine().split("\\s+");
        tupleList.add(new Tuple(nameAndAddress[0]+" "+nameAndAddress[1],nameAndAddress[2]));
        String[] nameAndBeer = reader.readLine().split("\\s+");
        tupleList.add(new Tuple(nameAndBeer[0], Integer.parseInt(nameAndBeer[1])));
        String[] intAndDouble = reader.readLine().split("\\s+");
        tupleList.add(new Tuple(Integer.parseInt(intAndDouble[0]),Double.parseDouble(intAndDouble[1])));
        tupleList.forEach(e-> System.out.println(e.getItem1()+" -> "+e.getItem2()));

    }
}
