package edu.cuny.cisc3120.homework2.model;

public class Rabbit extends Mammal {
    public Rabbit(int size, Color color)
    {
        super(size, color);
    }

    public void eat(Plant food)
    {
            this.acceptFood(food);
    }

    public void eat(Animal food)
    {
        this.refuseFood(food);
        System.out.println("Rabbits are herbavores and only eat plants.");
    }

    public void speak()
    {
        System.out.println("Nuaam nuaaam");
    }
}
