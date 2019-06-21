package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedRetakeExam_16April2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02HelensAbduction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int energy = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        char[][] matrix = new char[n][];
        int parisRow = 0;
        int parisCol = 0;
        int helenRow = 0;
        int helenCol = 0;
        // fill the matrix and get the helen and paris index
        for (int i = 0; i < n; i++) {
            String inputData = reader.readLine();
            char[] data = inputData.toCharArray();
            matrix[i] = data;
            if (inputData.contains("H")){
                helenRow=i;
                helenCol= inputData.indexOf("H");
            }
            if (inputData.contains("P")){
                parisRow=i;
                parisCol= inputData.indexOf("P");

            }
        }
        //the game starts
        while (true){
            String[] turnData = reader.readLine().split("\\s+");
            String direction = turnData[0];
            int enemyRow = Integer.parseInt(turnData[1]);
            int enemyCol = Integer.parseInt(turnData[2]);
            //enemy spown
            matrix[enemyRow][enemyCol] = 'S';
            //Paris drop enerjy by 1
            energy--;


            //Paris move in direction
            switch (direction){
                case "up":
                    matrix[parisRow][parisCol]='-';
                    if(checkBoundries(matrix,parisRow-1)){
                        parisRow--;
                    }
                    break;
                case "down":
                    matrix[parisRow][parisCol]='-';
                    if(checkBoundries(matrix,parisRow+1)){
                        parisRow++;
                    }
                    break;
                case "left":
                    matrix[parisRow][parisCol]='-';
                    if(checkBoundries(matrix,parisCol-1)){
                        parisCol--;
                    }
                    break;
                case "right":
                    matrix[parisRow][parisCol]='-';
                    if(checkBoundries(matrix,parisCol+1)){
                        parisCol++;
                    }
                    break;
                    default:
                        break;
            }

            if (matrix[parisRow][parisCol]=='H'){
                //Paris find Helena
                matrix[parisRow][parisCol]='-';
                System.out.println("Paris has successfully abducted Helen! Energy left: "+energy);
                printMatrix(matrix);
                return;
            }else if(matrix[parisRow][parisCol]=='S'){
                energy-=2;
                if (energy<=0){
                    matrix[parisRow][parisCol]='X';
                    System.out.println(String.format("Paris died at %d;%d.",parisRow,parisCol));
                    printMatrix(matrix);
                    return;
                }else{
                    matrix[parisRow][parisCol]='P';
                }
                //Paris fight with enemy
            }else {
                //nothing happend, Paris just move
                matrix[parisRow][parisCol]='P';
            }
            if (energy<=0){
                matrix[parisRow][parisCol]='X';
                System.out.println(String.format("Paris died at %d;%d.",parisRow,parisCol));
                printMatrix(matrix);
                return;
            }

        }


    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static boolean checkBoundries(char[][] matrix, int i) {
        return i >= 0 && i < matrix.length;
    }
}
//43min