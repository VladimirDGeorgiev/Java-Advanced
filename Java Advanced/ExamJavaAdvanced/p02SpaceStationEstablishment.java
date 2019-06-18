package ExamJavaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02SpaceStationEstablishment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[][] galaxy = new char[n][];
        int stefanRow = -1;
        int stefanCol = -1;
        int holeRow = -1;
        int holeCol = -1;
        for (int r = 0; r < galaxy.length; r++) {
            String data = reader.readLine();
            galaxy[r] = data.toCharArray();
            if (data.contains("S")) {
                stefanRow = r;
                stefanCol = data.indexOf("S");
            }
        }
        int energy = 0;
        //logic
        while (true) {
            String direction = reader.readLine();
            //stefan move
            galaxy[stefanRow][stefanCol]='-';
            switch (direction) {
                case "up":

                    stefanRow--;
                    break;
                case "down":
                    stefanRow++;
                    break;
                case "left":
                    stefanCol--;
                    break;
                case "right":
                    stefanCol++;
                    break;
                default:
                    break;
            }
            if (isItOutOFBound(galaxy, stefanRow, stefanCol)) {
                System.out.println("Bad news, the spaceship went to the void.");
                System.out.println("Star power collected: "+energy);
                printGalaxy(galaxy);
                //out of galaxy
                break;
            }
            if (Character.isDigit(galaxy[stefanRow][stefanCol])){
                energy+=Integer.parseInt(String.valueOf(galaxy[stefanRow][stefanCol]));
                galaxy[stefanRow][stefanCol]='S';
            }else if(galaxy[stefanRow][stefanCol]=='O'){
                for (int r = 0; r < galaxy.length; r++) {
                    for (int c = 0; c < galaxy[r].length; c++) {
                        if (galaxy[r][c]=='O'){
                            if (r!=stefanRow||c!=stefanCol){
                                holeRow=r;
                                holeCol=c;
                            }
                        }
                    }
                }
                galaxy[stefanRow][stefanCol]='-';
                stefanRow=holeRow;
                stefanCol=holeCol;
                galaxy[stefanRow][stefanCol]='S';

            }
            if (energy>=50){
                System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                System.out.println("Star power collected: "+energy);
                printGalaxy(galaxy);

                break;
            }

        }


    }

    private static void printGalaxy(char[][] galaxy) {
        for (char[] chars : galaxy) {
            for (char e : chars) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    private static boolean isItOutOFBound(char[][] galaxy, int row, int col) {
        if (row<0||col<0||row>=galaxy.length||col>=galaxy.length){
            return true;
        }
        return false;
    }
}


