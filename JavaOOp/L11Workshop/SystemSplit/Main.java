package JavaOOP.L11Workshop.SystemSplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Engine mySystem = new Engine();

        String command = "";

        while (!"System Split".equals(command= reader.readLine())){
            String[] tokens = command.split("\\(");
            String SystemCommand = tokens[0];
            tokens[1]=tokens[1].replaceAll("\\)","").trim();
            String[] parameters = tokens[1].split(", ");
            switch (SystemCommand){
                case "RegisterPowerHardware":
                    mySystem.registerPowerHardware(
                            parameters[0]
                            ,Integer.parseInt(parameters[1])
                            ,Integer.parseInt(parameters[2]));
                    break;
                case "RegisterHeavyHardware":
                    mySystem.registerHeavyHardware(
                            parameters[0]
                            ,Integer.parseInt(parameters[1])
                            ,Integer.parseInt(parameters[2]));
                    break;
                case "RegisterExpressSoftware":
                    mySystem.registerExpressSoftware(
                            parameters[0]
                            ,parameters[1]
                            ,Integer.parseInt(parameters[2])
                            ,Integer.parseInt(parameters[3]));
                    break;
                case "RegisterLightSoftware":
                    mySystem.registerLightSoftware(
                            parameters[0]
                            ,parameters[1]
                            ,Integer.parseInt(parameters[2])
                            ,Integer.parseInt(parameters[3]));
                    break;
                case "ReleaseSoftwareComponent":
                    mySystem.releaseSoftwareComponent(
                            parameters[0]
                            ,parameters[1]
                            );
                    break;
                case "Analyze":
                    System.out.println(mySystem.analyze());
                    break;
                    default:
                        break;
            }
        }
        mySystem.systemSplit();
    }
}
