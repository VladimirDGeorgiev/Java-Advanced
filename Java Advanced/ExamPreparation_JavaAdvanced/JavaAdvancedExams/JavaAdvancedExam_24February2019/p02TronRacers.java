package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedExam_24February2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02TronRacers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[n][];
        int firstRow = 0;
        int firstCol = 0;
        int secondRow = 0;
        int secondCol = 0;
        for (int i = 0; i < n; i++) {
            String lineData = reader.readLine();
            matrix[i] = new String[lineData.length()];
            for (int j = 0; j < lineData.length(); j++) {
                if (lineData.charAt(j)=='f'){
                    firstRow=i;
                    firstCol=j;
                }else if (lineData.charAt(j)=='s'){
                    secondRow=i;
                    secondCol=j;
                }
                matrix[i][j] = String.valueOf(lineData.charAt(j));
            }
        }

        while (true){
            String[] direction= reader.readLine().split("\\s+");
            String firstPlayerMove =direction[0];
            String secondPlayerMove =direction[1];
            //first player turn start
            switch (firstPlayerMove){
                case "up":

                    if (firstRow-1<0){
                        firstRow=matrix.length-1;
                    }else{
                        firstRow--;
                    }
                    if (matrix[firstRow][firstCol].equals("s")){
                        matrix[firstRow][firstCol]="x";
                        printMatrix(matrix);
                        return;
                    }else{
                        matrix[firstRow][firstCol]="f";
                    }

                    break;
                case "down":
                    if (firstRow+1>=matrix.length){
                        firstRow=0;
                    }else{
                        firstRow++;
                    }
                    if (matrix[firstRow][firstCol].equals("s")){
                        matrix[firstRow][firstCol]="x";
                        printMatrix(matrix);
                        return;
                    }else{
                        matrix[firstRow][firstCol]="f";
                    }
                    break;
                case "left":
                    if (firstCol-1<0){
                        firstCol=matrix[firstRow].length-1;
                    }else{
                        firstCol--;
                    }
                    if (matrix[firstRow][firstCol].equals("s")){
                        matrix[firstRow][firstCol]="x";
                        printMatrix(matrix);
                        return;
                    }else{
                        matrix[firstRow][firstCol]="f";
                    }
                    break;
                case "right":
                    if (firstCol+1>=matrix[firstRow].length){
                        firstCol=0;
                    }else{
                        firstCol++;
                    }
                    if (matrix[firstRow][firstCol].equals("s")){
                        matrix[firstRow][firstCol]="x";
                        printMatrix(matrix);
                        return;
                    }else{
                        matrix[firstRow][firstCol]="f";
                    }
                    break;
                default:
                    break;
            }
            //end of the first player turn
            // second player turn
            switch (secondPlayerMove){
                case "up":

                    if (secondRow-1<0){
                        secondRow=matrix.length-1;
                    }else{
                        secondRow--;
                    }
                    if (matrix[secondRow][secondCol].equals("f")){
                        matrix[secondRow][secondCol]="x";
                        printMatrix(matrix);
                        return;
                    }else{
                        matrix[secondRow][secondCol]="s";
                    }

                    break;
                case "down":
                    if (secondRow+1>=matrix.length){
                        secondRow=0;
                    }else{
                        secondRow++;
                    }
                    if (matrix[secondRow][secondCol].equals("f")){
                        matrix[secondRow][secondCol]="x";
                        printMatrix(matrix);
                        return;
                    }else{
                        matrix[secondRow][secondCol]="s";
                    }
                    break;
                case "left":
                    if (secondCol-1<0){
                        secondCol=matrix[secondRow].length-1;
                    }else{
                        secondCol--;
                    }
                    if (matrix[secondRow][secondCol].equals("f")){
                        matrix[secondRow][secondCol]="x";
                        printMatrix(matrix);
                        return;
                    }else{
                        matrix[secondRow][secondCol]="s";
                    }
                    break;
                case "right":
                    if (secondCol+1>=matrix[secondRow].length){
                        secondCol=0;
                    }else{
                        secondCol++;
                    }
                    if (matrix[secondRow][secondCol].equals("f")){
                        matrix[secondRow][secondCol]="x";
                        printMatrix(matrix);
                        return;
                    }else{
                        matrix[secondRow][secondCol]="s";
                    }
                    break;
                default:
                    break;
            }
            //end of the second player turn


        }

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String e : row) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}

//30 min for this problem

