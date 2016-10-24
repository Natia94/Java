import edu.cuny.cisc3120.homework2.model.*;

class Homework {
    static public void main(String[] args) {
        Plant[] plants = {
            new Grass(),
            // TODO:  Add your new plant here.
            new Daisy()
        };

        Animal[] animals = {
            new Dog(5, Thing.Color.brown),
            new Iguana(4),
            new Iguana(10, Thing.Color.pink),
            // TODO:  Add your new mammals here.
            new Lion(5,Thing.Color.brown),
            new Rabbit(5,Thing.Color.white)
        };

        for (int i = 0; i < animals.length; i++) {
            animals[i].speak();
        }

        for (int i = 0; i < animals.length; i++) {
            // Have each animal try to eat each plant.
            for (int j = 0; j < plants.length; j++) {
                animals[i].eat(plants[j]);
            }

            // Have each animal try to each animal.
            for (int j = 0; j < animals.length; j++) {
                animals[i].eat(animals[j]);
            }
        }

        // This works, because a dog is an animal.
        Animal dog1 = new Dog(5, Thing.Color.black);

        // So does this, because a dog is a mammal.
        Mammal dog2 = new Dog(5, Thing.Color.black);

        //So does this because a dog is a thing.
        Thing dog3 = new Dog(5, Thing.Color.black);
        
        Mammal rabbit1 = new Rabbit(5,Thing.Color.white);
        // Assigning "Dog" to "Thing" is *NOT* the same as instantiating an abstract class,
        // since we are instantiating a "Dog" and *assigning* it to a variable of type "Thing".

        // This does NOT work, because a dog is not a Reptile.
        // Reptile dog4 = new Dog(7, Thing.Color.green);

        // This works, because animal has an eat method that accepts an animal,
        // and dog1 is of type animal and dog2 is of type Mammal, which is a type animal.
        dog1.eat(dog2);

        // This will NOT work, because "Animal" only has "eat" methods accepting "Animal" and "Plant",
        // but no "eat" method for "Things".
        // dog2.eat(dog3);
    }
}
