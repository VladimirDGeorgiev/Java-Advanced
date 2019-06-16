package JavaOOp.IteratorsAndComparators.Exercises.p01ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main    {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] inputArr = (input.split("\\s+"));

        ListyIterator listyIterator = new ListyIterator();
        if (inputArr.length!=0) {
           listyIterator = new ListyIterator(inputArr);
           listyIterator.remove();
        }
         input = reader.readLine();
        while (!input.equals("END")){
            String[] data = input.split("\\s+");
            switch (data[0]){
                case "Move":
                    System.out.println(listyIterator.Move());
                    break;
                case "Print":listyIterator.Print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.HasNext());
                    break;
                default:
                    break;
            }

            input = reader.readLine();
        }
    }
}
