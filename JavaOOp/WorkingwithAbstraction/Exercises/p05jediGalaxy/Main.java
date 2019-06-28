package JavaOOp.L03WorkingwithAbstraction.Exercises.p05jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimestions = ArrayReader(scanner.nextLine());
        int x = dimestions[0];
        int y = dimestions[1];

        int[][] matrix = new int[x][y];

        fillTheMatrix(x, y, matrix);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoS = ArrayReader(command);
            int xIvo = ivoS[0];
            int yIvo = ivoS[1];
            int[] evil = ArrayReader(scanner.nextLine());
            int xEvil = evil[0];
            int yEvil = evil[1];

            while (xEvil >= 0 && yEvil >= 0) {
                if (indexCheck(matrix, xEvil, yEvil)) {
                    matrix[xEvil][yEvil] = 0;
                }
                xEvil--;
                yEvil--;
            }

            while (xIvo >= 0 && yIvo < matrix[1].length) {
                if (indexCheck(matrix, xIvo, yIvo)) {
                    sum += matrix[xIvo][yIvo];
                }

                yIvo++;
                xIvo--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static boolean indexCheck(int[][] matrix, int xE, int yE) {
        return xE >= 0 && xE < matrix.length && yE >= 0 && yE < matrix[0].length;
    }

    private static void fillTheMatrix(int x, int y, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    private static int[] ArrayReader(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
