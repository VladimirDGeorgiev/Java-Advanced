package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedSampleExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02Sneaking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //input data
        int n = Integer.parseInt(reader.readLine());
        char[][] matrix = new char[n][];
        int samRow = -1;
        int samCol = -1;
        int nikoladzeRow = -1;
        int nikoladzeCol = -1;
        for (int r = 0; r < matrix.length; r++) {
            String charRow = reader.readLine();
            matrix[r]=new char[charRow.length()];
            for (int c = 0; c < charRow.length(); c++) {
                matrix[r][c] = charRow.charAt(c);
                if (charRow.charAt(c) == 'S') {
                    samRow = r;
                    samCol = c;
                }
                if (charRow.charAt(c) == 'N') {
                    nikoladzeRow = r;
                    nikoladzeCol = c;
                }
            }
        }
        String samMoves = reader.readLine();
        //program logic
        for (int turn = 0; turn < samMoves.length(); turn++) {
            //array temp copy
            char[][] tempMatrix = new char[matrix.length][];
            System.arraycopy(matrix, 0, tempMatrix, 0, matrix.length);
            //enemy move
            enemyMove(matrix, tempMatrix);
            //is the enemy kill Sam
            if (isTheEnemyKillSam(samRow, samCol, tempMatrix)) return;
            //Sam moves
            switch (samMoves.charAt(turn)) {
                case 'U':
                    tempMatrix[samRow][samCol]='.';
                    samRow--;
                    tempMatrix[samRow][samCol]='S';
                    break;
                case 'D':
                    tempMatrix[samRow][samCol]='.';
                    samRow++;
                    tempMatrix[samRow][samCol]='S';
                    break;
                case 'L':
                    tempMatrix[samRow][samCol]='.';
                    samCol--;
                    tempMatrix[samRow][samCol]='S';
                    break;
                case 'R':
                    tempMatrix[samRow][samCol]='.';
                    samCol++;
                    tempMatrix[samRow][samCol]='S';
                    break;
             //   case 'W':
             //       break;
                default:
                    break;
            }
            //If Sam is reaches the same row as Nikoladze
            if (samRow==nikoladzeRow){
                tempMatrix[nikoladzeRow][nikoladzeCol]='X';
                System.out.println("Nikoladze killed!");
                printMatrix(tempMatrix);
                return;
            }

            System.arraycopy(tempMatrix, 0, matrix, 0, matrix.length);
        }


    }

    private static boolean isTheEnemyKillSam(int samRow, int samCol, char[][] tempMatrix) {
        for (int c = 0; c < tempMatrix[samRow].length; c++) {
            if (tempMatrix[samRow][c] == 'b' && c < samCol) {
                tempMatrix[samRow][samCol] = 'X';
                System.out.println(String.format("Sam died at %d, %d", samRow, samCol));
                printMatrix(tempMatrix);
                return true;
            } else if (tempMatrix[samRow][c] == 'd' && c > samCol) {
                tempMatrix[samRow][samCol] = 'X';
                System.out.println(String.format("Sam died at %d, %d", samRow, samCol));
                printMatrix(tempMatrix);
                return true;
            }
        }
        return false;
    }

    private static void enemyMove(char[][] matrix, char[][] tempMatrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'b') {
                    if (c == matrix[r].length - 1) {
                        tempMatrix[r][matrix[r].length - 1] = 'd';
                    } else {
                        tempMatrix[r][c] = '.';
                        tempMatrix[r][c + 1] = 'b';
                    }
                    break;
                } else if (matrix[r][c] == 'd') {
                    if (c == 0) {
                        tempMatrix[r][0] = 'b';
                    } else {
                        tempMatrix[r][c] = '.';
                        tempMatrix[r][c - 1] = 'd';
                    }
                    break;
                }
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char e : chars) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

}
