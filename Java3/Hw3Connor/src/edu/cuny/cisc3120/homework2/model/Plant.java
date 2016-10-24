package edu.cuny.cisc3120.homework2.model;

// A Plant *is a* Thing
public abstract class Plant extends Thing {
    // In "Plant" we provide the "getAdjective" implementation at the superclass level.
    // Later in "Dog" and we provide the "getAdjective" implementation at the most derived class level.
    public Color getColor()
    {
        // In our model, all plants are green.
        // No Poinsettia allowed.
        	return Color.green;
    
    }
    
}
