package edu.cuny.cisc3120.homework2.model;

public class Lion extends Mammal {
	public Lion(int size, Color color) {
		super(size, color);
	}

	public void eat(Animal food) {
		if (food.getSize() <= this.getSize()) {
			this.acceptFood(food);
		} else {
			this.refuseFood(food);
			System.out.println("It's way to big.");
		}
	}

	public void eat(Plant food) {
	
		this.acceptFood(food);
	}

	public void speak() {
		System.out.println("Ghrrrrrr!");
	}

}