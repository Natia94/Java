package edu.cuny.cisc3120.homework2.model;

// A Reptile *is a* Animal
public abstract class Reptile extends Animal {
    // In this constructor, we default color to green.
    // This seems reasonable for a reptile.
    //
    // This allows the *caller* to determine the color,
    // while still allowing the *implementor* to assign a default.
    // Contrast this with how `Plant` overrides `getColor`.
    public Reptile(int size)
    {
        super(size, Color.green);
    }

    public Reptile(int size, Color color)
    {
        super(size, color);
    }

    public void speak()
    {
        // I'm pretty sure all reptiles hiss.
        System.out.println("Hisss!");
    }
}
