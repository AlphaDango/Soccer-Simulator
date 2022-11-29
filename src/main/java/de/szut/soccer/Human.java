package de.szut.soccer;

public abstract class Human {
    protected String name;
    protected int age;

    public abstract String toString();

    protected Human(String name, int age){
        if(age < 1)
            throw new IllegalArgumentException("Age out of range!");
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
