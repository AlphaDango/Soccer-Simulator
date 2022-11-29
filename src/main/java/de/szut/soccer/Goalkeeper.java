package de.szut.soccer;

import java.util.Random;

public class Goalkeeper extends Player{

    protected int reaction;

    public Goalkeeper(String name, int age, int strength, int powerAtGoalkick, int motivation, int numberOfGoals, int reaction) {
        super(name, age, strength, powerAtGoalkick, motivation, numberOfGoals);
        if(reaction < 1 || reaction > 10)
            throw new IllegalArgumentException("Ball holdingpower is out of range!");
        this.reaction = reaction;
    }

    public boolean ballHold(int powerAtGoalkick){
        if(new Random().nextInt(100-1)+1 < 50){
            return reaction+1 > validate(powerAtGoalkick);
        }else{
            return reaction-1 > validate(powerAtGoalkick);
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\nreaction : " + reaction;
    }

    public int getReaction() {
        return reaction;
    }
}
