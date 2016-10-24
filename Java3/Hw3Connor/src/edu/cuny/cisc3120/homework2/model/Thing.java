package edu.cuny.cisc3120.homework2.model;

// All classes in our Model descend from "Thing".
public abstract class Thing {
    // This is an enumeration of all of the colors a Thing may have.
    public enum Color {
        red,
        blue,
        pink,
        green,
        brown,
        black,
        white
    }

    // In our model, all things *have a* size.
    abstract public int getSize();

    // In our model, all things *have a* color.
    abstract public Color getColor();
    

    // In our model, all things *have a* name.
    public String getName()
    {
        // This implementation gives us the name of the class.

        // This gets us a "Class" object which describes the class of "this".
        java.lang.Class cls = this.getClass();
        // This gets us the class name of "this".
        String className = cls.getName();
        // The class name has the package in it, so for example it is:
        // edu.cuny/cisc3120.homework2.model.Iguana
        //
        // This code "splits" the string on the "." character into an array containing the segments that were seprated by the "."
        String[] segments = className.split("\\.");

        // Take the last segment, which is the name of this class.
        String name = segments[segments.length - 1];
        // Convert to lower case.
        name = name.toLowerCase();

        return name;
    }
}
