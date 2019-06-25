package ExamPreparation_JavaAdvanced.Archive_AdvancedJava_Exams.JavaAdvancedExam_10June2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] direction = reader.readLine().split(", ");
        int rowSnake = -1;
        int colSnake = -1;
        char[][] matrix = new char[n][n];

        for (int r = 0; r < n; r++) {
            char[] dataInput = reader.readLine().replaceAll(" ", "").toCharArray();
            for (int c = 0; c < n; c++) {
                matrix[r][c] = dataInput[c];
                if (dataInput[c] == 's') {
                    rowSnake = r;
                    colSnake = c;
                }
            }

        }

        int snakeLength = 1;
        int foodLeft = 0;
        for (int i = 0; i < direction.length; i++) {
            char nextPosition;
            boolean foodIsEaten = false;
            switch (direction[i]) {
                case "up":
                    if (rowSnake - 1 < 0) {
                        nextPosition = matrix[n - 1][colSnake];
                        matrix[n - 1][colSnake]='*';
                        rowSnake = n - 1;
                    } else {
                        nextPosition = matrix[rowSnake - 1][colSnake];
                        matrix[rowSnake - 1][colSnake]='*';
                        rowSnake--;
                    }
                    if (nextPosition == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else if (nextPosition == 'f') {
                        snakeLength++;
                        foodIsEaten = true;

                    }
                    break;
                case "down":
                    if (rowSnake + 1 >= n) {
                        nextPosition = matrix[0][colSnake];
                        matrix[0][colSnake]='*';
                        rowSnake = 0;
                    } else {
                        nextPosition = matrix[rowSnake + 1][colSnake];
                        matrix[rowSnake+1][colSnake]='*';
                        rowSnake++;
                    }
                    if (nextPosition == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else if (nextPosition == 'f') {
                        snakeLength++;
                        foodIsEaten = true;
                    }

                    break;
                case "left":
                    if (colSnake - 1 < 0) {
                        nextPosition = matrix[rowSnake][n-1];
                        matrix[rowSnake][n-1]='*';
                        colSnake = n-1;
                    } else {
                        nextPosition = matrix[rowSnake ][colSnake-1];
                        matrix[rowSnake][colSnake-1]='*';
                        colSnake--;
                    }
                    if (nextPosition == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else if (nextPosition == 'f') {
                        snakeLength++;
                        foodIsEaten = true;
                    }
                    break;
                case "right":
                    if (colSnake + 1 >= n) {
                        nextPosition = matrix[rowSnake][0];
                        matrix[rowSnake][0]='*';
                        colSnake = 0;
                    } else {
                        nextPosition = matrix[rowSnake ][colSnake+1];
                        matrix[rowSnake][colSnake+1]='*';
                        colSnake++;
                    }
                    if (nextPosition == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else if (nextPosition == 'f') {
                        snakeLength++;
                        foodIsEaten = true;
                    }
                    break;
                default:
                    break;
            }
            if (foodIsEaten) {
                foodLeft=0;
                boolean itHaveMoreFood = false;
                for (char[] row : matrix) {
                    for (char element : row) {
                        if (element == 'f') {
                            itHaveMoreFood = true;
                            foodLeft++;
                        }
                    }
                }
                if (!itHaveMoreFood) {
                    System.out.println("You win! Final snake length is " + snakeLength);
                    return;
                }
            }
        }
        System.out.println("You lose! There is still " + foodLeft + " food to be eaten.");
    }
}
