package edu.cuny.cisc3120.homework2.model;

// An Iguana *is a* Reptile
public class Iguana extends Reptile {
    // To take advantage of `Reptile`s default green constructor,
    // we need to provide a way to call it.
    public Iguana(int size)
    {
        super(size);
    }

    public Iguana(int size, Color color)
    {
        super(size, color);
    }

    public void eat(Animal food)
    {
        // Iguans's are vegetarians.
        this.refuseFood(food);
    }

    public void eat(Plant food)
    {
        // We don't check the size, because you can just eat part of a plant, 
        // without the plant trying to run away or eat you back.
        this.acceptFood(food);
    }

}
