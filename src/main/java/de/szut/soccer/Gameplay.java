package de.szut.soccer;

import java.util.Random;

public class Gameplay {
    private static final int PLAYING_TIME = 90;
    private static final int MAX_ADDITIONAL_TIME=5;
    private static final int MAX_DURATION_UNTIL_NEXT_ACTION = 15;

    private Game game;

    public Gameplay(Game game){
        if(game == null)
            throw new IllegalArgumentException("Game can't be null!");
        this.game = game;
    }

    public int calculateForceOfTheTeam(Team team){
        int variation = new Random().nextInt(4);
        if(new Random().nextInt(100-1)+1 < 50)
            variation = -variation;
        if(team.getTotalForce()*team.getTotalMotivation()*team.getCoach().getExperience()+variation < 1)
            return 1;
        return team.getTotalForce()* team.getTotalMotivation()*team.getCoach().getExperience()+1;
    }

    private void doGameAction(Player player, Goalkeeper goalkeeper, int minute, Team team){

        System.out.println(minute+". Minute:");
        System.out.println(" Chance für " + team.getName());
        System.out.println(" " + player.getName() + " zieht ab!");

        try{
            Thread.sleep(1000);
        }catch (Exception e){
          e.printStackTrace();
        }

        if(goalkeeper.ballHold(player.shootAtGoal())){
            System.out.println("  "+ goalkeeper.getName() + " pariert glanzvoll!\n");
        }else{
            if(team.equals(game.getHomeTeam()))
                game.incrementHomeGoals();
            else
                game.incrementAwayGoals();
            player.addGoal();
            System.out.println("  TOR!!! " + game.getGoalsHome() + " - " + game.getGoalsAway()+ " " + player.getName()+"(" + player.getNumberOfGoals()+")\n");
        }
    }

    public void play(){
        System.out.println(game.getHomeTeam().getName() + " gegen " + game.getAwayTeam().getName()+"\n");
        int duration = (int) ((Math.random() * ((PLAYING_TIME+MAX_ADDITIONAL_TIME) - PLAYING_TIME)) + PLAYING_TIME);

        int nextAction = 0;
        nextAction += (int) ((Math.random() * (MAX_DURATION_UNTIL_NEXT_ACTION - 1)) + 1);
        int homeTeamForce = calculateForceOfTheTeam(game.getHomeTeam());
        int awayTeamForce = calculateForceOfTheTeam(game.getAwayTeam());
        int sumOfTeamForce = homeTeamForce + awayTeamForce;

        for (int i = 0; i <= duration; i++){
            if (i == nextAction){
                if((int) ((Math.random() * (sumOfTeamForce))) > homeTeamForce)
                    doGameAction(game.getAwayTeam().getRandomPlayer(),game.getHomeTeam().getGoalkeeper(),nextAction,game.getAwayTeam());
                else
                    doGameAction(game.getHomeTeam().getRandomPlayer(),game.getAwayTeam().getGoalkeeper(),nextAction,game.getHomeTeam());

                nextAction += (int) ((Math.random() * (MAX_DURATION_UNTIL_NEXT_ACTION - 1)) + 1);

                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Das Spiel ist beendet!");
        System.out.println(game.getHomeTeam().getName() + " - " + game.getAwayTeam().getName() + " " + game.getGoalsHome()+":"+game.getGoalsAway());
    }
}
