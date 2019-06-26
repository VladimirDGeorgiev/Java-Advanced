package ExamPreparation_JavaAdvanced.JavaAdvancedExams.JavaAdvancedExam_16June2019_Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01TheGarden {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        char[][] garden = new char[n][];

        for (int i = 0; i < garden.length; i++) {
            garden[i] = reader.readLine().replaceAll(" ", "").toCharArray();
        }
        int harvestCarrots = 0;
        int harvestPotatos = 0;
        int harvestLettuce = 0;
        int harmedVegetables = 0;

        String commands = "";
        while (!"End of Harvest".equals(commands = reader.readLine())) {
            String[] data = commands.split("\\s+");

            if ("Harvest".equals(data[0])) {
                int row = Integer.parseInt(data[1]);
                int col = Integer.parseInt(data[2]);
                if (checkIndex(garden, row, col)) {
                    if (garden[row][col] == 'L') {
                        harvestLettuce++;
                    } else if (garden[row][col] == 'P') {
                        harvestPotatos++;
                    } else if (garden[row][col] == 'C') {
                        harvestCarrots++;
                    }
                    if (garden[row][col] != ' ') {
                        garden[row][col] = ' ';
                    }
                }

            } else if ("Mole".equals(data[0])) {
                int row = Integer.parseInt(data[1]);
                int col = Integer.parseInt(data[2]);
                String direction = data[3];
                if (checkIndex(garden, row, col)) {
                    //може да има проблем ако по роловете има празо място
                    switch (direction) {
                        case "up":
                            for (int i = row; i >= 0; i-=2) {
                                if (garden[i][col] == 'L' ||
                                        garden[i][col] == 'P' ||
                                        garden[i][col] == 'C') {
                                    harmedVegetables++;
                                    garden[i][col] = ' ';

                                }
                            }
                            break;
                        case "down":
                            for (int i = row; i < garden.length; i+=2) {
                                if (garden[i][col] == 'L' ||
                                        garden[i][col] == 'P' ||
                                        garden[i][col] == 'C') {
                                    harmedVegetables++;
                                    garden[i][col] = ' ';

                                }
                            }
                            break;
                        case "left":
                            for (int i = col; i >= 0; i-=2) { // може да брадяса i=i-2
                                if (garden[row][i] == 'L' ||
                                        garden[row][i] == 'P' ||
                                        garden[row][i] == 'C') {
                                    harmedVegetables++;
                                    garden[row][i] = ' ';

                                }
                            }
                            break;
                        case "right":
                            for (int i = col; i < garden[row].length; i+=2) { // може да брадяса i=i-2
                                if (garden[row][i] == 'L' ||
                                        garden[row][i] == 'P' ||
                                        garden[row][i] == 'C') {
                                    harmedVegetables++;
                                    garden[row][i] = ' ';

                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        for (char[] row : garden) {
            for (char e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        System.out.println("Carrots: " + harvestCarrots);
        System.out.println("Potatoes: " + harvestPotatos);
        System.out.println("Lettuce: " + harvestLettuce);
        System.out.println("Harmed vegetables: " + harmedVegetables);


    }

    private static boolean checkIndex(char[][] garden, int row, int col) {
        if (row < 0 || row >= garden.length || col < 0 || col >= garden[row].length) {
            return false;
        }
        return true;
    }
}
