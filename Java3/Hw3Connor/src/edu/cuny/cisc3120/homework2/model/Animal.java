package edu.cuny.cisc3120.homework2.model;

public abstract class Animal extends Thing {
    protected int size;
    protected Color color;
    public int getSize()
    {
        return size;
    }

    public Color getColor()
    {
        return color;
    }

    // The size and color of any animal is given as a parameter to the constructor.
    // This means all subclass constructors must call "super(size, color)".
    public Animal(int size, Color color)
    {
        this.size = size;
        this.color = color;
    }

    // All animals eat.
    abstract public void eat(Plant food);
    abstract public void eat(Animal food);

    // All animals can speak.
    abstract public void speak();

    // If an animal will accept some piece of food, then the instance should call this method.

    // If an animal will refuse some piece of food, then the instance should call this method.
    protected void refuseFood(Thing food) {
        System.out.printf("The %s %s refuses to eat the %s %s.\n", 
            this.getColor(),
            this.getName(),
            food.getColor(),
            food.getName());
    }
    protected void acceptFood(Thing food) {
        if (!(this == food)) {
          System.out.printf("The %s %s chows down on the %s %s.\n",
              this.getColor(),
              this.getName(),
              food.getColor(),
              food.getName());
        } else {
          System.out.printf("Oh no! An animal can't eat itself.");
        }
      }
}
