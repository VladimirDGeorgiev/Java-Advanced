package JavaOOp.L05Encapsulation.Exercises.p05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String name){
        if (!players.removeIf(e->e.getName().equals(name))) {
            throw new IllegalArgumentException(
                    String.format("Player %s is not in %s team.",name,this.name));
        }
    }

    public double getRating(){
      double sum = this.players.stream().mapToDouble(Player::overallSkillLevel).sum();
      return sum/=this.players.size();

    }
}

//    • If you receive a command to add a player to a missing team, print "Team {team name} does not exist."
//    • If you receive a command to show stats for a missing team, print "Team {team name} does not exist."