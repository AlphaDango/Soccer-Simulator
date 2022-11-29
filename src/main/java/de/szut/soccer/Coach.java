package de.szut.soccer;

public class Coach extends Human{
    protected int experience;

    public Coach(String name,int age, int experience){
        super(name, age);
        if(experience > 10 || experience < 1)
            throw new IllegalArgumentException("Experience out of range!");
        this.experience = age;
    }

    @Override
    public String toString(){
        return  "\nCoach\n"
                + "name: " + name
                + "\nage: " + age
                + "\nexperience: " + experience;
    }

    public int getExperience() {
        return experience;
    }
}
