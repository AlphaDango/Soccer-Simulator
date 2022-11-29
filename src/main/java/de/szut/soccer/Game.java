package de.szut.soccer;

public class Game {
    private Team home;
    private Team away;
    private int goalsAway;
    private int goalsHome;

    public Game(Team home, Team away){
        if(home == null || away == null)
            throw new IllegalArgumentException("None of the teams can be null!");
        this.away = away;
        this.home = home;
        goalsHome = 0;
        goalsAway = 0;
    }

    public void incrementHomeGoals(){
        goalsHome++;
    }

    public void incrementAwayGoals(){
        goalsAway++;
    }

    @Override
    public String toString() {
        return home.getName() + " " + goalsHome + " - " +goalsAway+ " " + away.getName();
    }

    public Team getHomeTeam(){
        return home;
    }

    public Team getAwayTeam(){
        return away;
    }


    public int getGoalsAway() {
        return goalsAway;
    }

    public int getGoalsHome() {
        return goalsHome;
    }
}
