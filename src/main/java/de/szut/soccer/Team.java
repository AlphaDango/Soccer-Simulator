package de.szut.soccer;

import java.util.ArrayList;
import java.util.Random;

public class Team {
    private String name;
    private Coach coach;
    private Goalkeeper goalkeeper;
    private ArrayList<Player> squad;

    public Team(String name, Coach coach, Goalkeeper goalkeeper){
        this.name = name;
        this.coach = coach;
        this.goalkeeper = goalkeeper;
        squad = new ArrayList<>();
    }

    public void addPlayer(Player player){
        squad.add(player);
    }

    public int getTotalMotivation(){
        int sum = 0;
        for(Player p: squad)
            sum += p.getMotivation();
        return (sum + goalkeeper.getMotivation())/(squad.size()+1);
    }

    public int getTotalForce(){
        int sum = 0;
        for(int i = 0; i<10 || i<squad.size(); i++){
            sum += squad.get(i).getForce();
        }
        if(squad.size() < 10)
            return (sum + goalkeeper.getForce())/(squad.size()+1);
        else
            return (sum + goalkeeper.getForce())/11;

    }

    public String toString(){
        String out =    "***"+this.name+"***"
                        +"\nTrainer: " + coach.getName()
                        +"\nTorwart: " + goalkeeper.getName();
        for(Player p: squad)
            out += "\nSpieler: " + p.getName();
        return out;
    }

    public String getName() {
        return name;
    }

    public Player getPlayer(int index){
        if(index > squad.size()-1 || index < 0)
            throw new IllegalArgumentException("Given Index is out of bounds!");
        return squad.get(index);
    }

    public Player getRandomPlayer(){
        int bound;
        if(squad.size() < 10)
            bound = squad.size();
        else bound = 10;
        return squad.get(new Random().nextInt(bound));
    }

    public Goalkeeper getGoalkeeper(){
        return goalkeeper;
    }

    public Coach getCoach(){
        return coach;
    }
}
