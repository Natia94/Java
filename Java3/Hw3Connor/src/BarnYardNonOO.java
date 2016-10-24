class BarnYardNonOO {
    static public class Animal {
        public int size;
        public String name;

        public Animal(String name, int size) {
            this.size = size;
            this.name = name;
        }
    }

    static public void speak(Animal critter)
    {
        if (critter.name.equals("dog")) {
            System.out.println("woof");
        } else if (critter.name.equals("cat")) {
            System.out.println("meow");
        } else if (critter.name.equals("iguana")) {
            System.out.println("hiss");
        } else if (critter.name.equals("snake")) {
            System.out.println("hiss");
        } else {
            System.out.println("???");
        }
    }

    static public void eat(Animal eater, Animal eated) {
        if (eater.name.equals("dog") && eated.name.equals("cat")) {
            if (eater.size > eated.size) {
                System.out.println("The dog eats the cat :`(");
            } else {
                System.out.println("The dog tries to eat the cat, but its too big.");
            }
        } else if (eater.name.equals("cat") && eated.name.equals("snake")) {
            // If a cat tries to eat a snake that's too big, the snake eats the cat!
            // See how complex and unwieldy these rules are getting?
            if (eater.size < eated.size) {
                System.out.println("Oh no!  The big snake eats the tiny kitty instead! :`(");
            } else {
                System.out.println("The cat gobbles the snake.");
            }
        } else {
            System.out.printf("The %s won't devour the %s.\n", eater.name, eated.name);
        }

        // And so on...
    }

    static public void main(String[] args) {
        speak(new Animal("dog", 1));
        speak(new Animal("cat", 2));
        speak(new Animal("snake", 1));
        speak(new Animal("iguana", 1));
        speak(new Animal("foo", 1));

        eat(new Animal("dog", 1), new Animal("cat", 2));
        eat(new Animal("cat", 2), new Animal("dog", 1));
        eat(new Animal("cat", 2), new Animal("snake", 1));
        eat(new Animal("cat", 2), new Animal("snake", 3));
        eat(new Animal("foo", 2), new Animal("bar", 3));
    }
}
