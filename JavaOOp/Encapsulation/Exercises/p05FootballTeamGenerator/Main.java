package JavaOOp.L05Encapsulation.Exercises.p05FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Team> teamList = new LinkedHashMap<>();

        String command = "";

        while (!"END".equals(command = reader.readLine())) {
            String[] tokens = command.split(";");
            try {
                switch (tokens[0]) {
                    case "Team":
                        Team team = new Team(tokens[1]);
                        teamList.putIfAbsent(tokens[1],team);
                        break;
                    case "Add":
                        String teamName = tokens[1];
                        if (!teamList.containsKey(teamName)){
                            throw new IllegalArgumentException(String.format("Team %s does not exist.",teamName));
                        }
                        Player player = new Player(tokens[2]
                                , Integer.parseInt(tokens[3])
                                , Integer.parseInt(tokens[4])
                                , Integer.parseInt(tokens[5])
                                , Integer.parseInt(tokens[6])
                                , Integer.parseInt(tokens[7]));
                        teamList.get(teamName).addPlayer(player);
                        break;
                    case "Remove":
                        teamList.get(tokens[1]).removePlayer(tokens[2]);
                        break;
                    case "Rating":
                        if (!teamList.containsKey(tokens[1])){
                            throw new IllegalArgumentException(String.format("Team %s does not exist.",tokens[1]));
                        }
                        System.out.println(tokens[1]+" - "+Math.round(teamList.get(tokens[1]).getRating()));
                        break;
                    default:
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
