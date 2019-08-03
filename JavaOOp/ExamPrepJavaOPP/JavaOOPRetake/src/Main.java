import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerController controller = new ManagerControllerImpl();

        while (true){
            String[] token = scanner.nextLine().split("\\s+");
            try {
                switch (token[0]) {
                    case "AddPlayer":
                        System.out.println(controller.addPlayer(token[1], token[2]));
                        break;
                    case "AddCard":
                        System.out.println(controller.addCard(token[1], token[2]));
                        break;
                    case "AddPlayerCard":
                        System.out.println(controller.addPlayerCard(token[1], token[2]));
                        break;
                    case "Fight":
                        System.out.println(controller.fight(token[1], token[2]));
                        break;
                    case "Report":
                        System.out.println(controller.report());
                        break;
                    case "Exit":
                        return;
                    default:
                        break;
                }
            }catch (IllegalArgumentException exp){
                System.out.println(exp.getMessage());
            }


        }
    }
}
