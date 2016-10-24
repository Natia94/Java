package edu.cuny.cisc3120.homework2.model;

// A Dog *is a* Mammal
public class Dog extends Mammal {
    public Dog(int size, Color color)
    {
        super(size, color);
    }

    public void eat(Animal food)
    {
        if (food.getSize() < this.getSize()) {
            this.acceptFood(food);
        } else {
            this.refuseFood(food);
            System.out.println("It's way to big.");
        }
    }

    public void eat(Plant food)
    {
        // In our model, dogs don't eat plants.
        // Not even grass.
        this.refuseFood(food);
    }

    public void speak()
    {
        System.out.println("Bow wow!");
    }

}
