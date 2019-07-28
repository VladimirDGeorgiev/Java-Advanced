package JavaOOP.L10ExceptionsAndErrorHandling.p02EnterNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            try {
                int start = Integer.parseInt(reader.readLine());
                int end = Integer.parseInt(reader.readLine());
                printNumbers(start,end);
                return;
            }catch (NumberFormatException exp){
                System.out.println("Ronge number");
            }


        }

    }
   public static void printNumbers(int start, int end){
        if(start<1||start>end||end>100){
            throw new NumberFormatException();
        }
       for (int i = start; i <=end ; i++) {
           System.out.println(i);
       }

   }
}
