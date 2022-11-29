package de.szut.soccer;

import java.util.Random;

public class Player extends Human{

    protected int force;
    protected int powerAtGoalkick;
    protected int motivation;
    protected int numberOfGoals;


    public Player(String name, int age, int strength, int powerAtGoalkick, int motivation, int numberOfGoals) {
        super(name, age);
        if(strength < 1 || strength > 10)
            throw new IllegalArgumentException("Strength out of range!");
        if(powerAtGoalkick < 1 || powerAtGoalkick > 10)
            throw new IllegalArgumentException("Power at goalkick is out of range!");
        if(motivation < 1 || motivation > 10)
            throw new IllegalArgumentException("Motivation out of range!");
        if(numberOfGoals < 0)
            throw new IllegalArgumentException("Number of goals can't be lower then 0!");
        this.force = strength;
        this.powerAtGoalkick = powerAtGoalkick;
        this.motivation = motivation;
        this.numberOfGoals = numberOfGoals;
    }

    public int shootAtGoal(){
        int variation = new Random().nextInt(3);
        if(new Random().nextInt(100-1)+1 < 50 || variation == 2)
            variation = -variation;

        return validate(this.powerAtGoalkick+variation);
    }

    public void addGoal(){
        this.numberOfGoals++;
    }

    protected int validate(int number){
        if(number > 10)
            return 10;
        if(number < 1)
            return 1;
        return number;
    }

    @Override
    public String toString() {
        return  "\nPlayer\n"
                + "name: " + name
                + "\nage: " + age
                + "\nforce: " + force
                + "\nmotivation: " + motivation
                + "\ngoalkick power: " + powerAtGoalkick
                + "\ngoals: " + numberOfGoals;
    }

    public int getForce() {
        return force;
    }

    public int getPowerAtGoalkick() {
        return powerAtGoalkick;
    }

    public int getMotivation() {
        return motivation;
    }

    public int getNumberOfGoals() {
        return numberOfGoals;
    }
}
