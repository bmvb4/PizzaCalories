import java.util.ArrayList;
import java.util.List;

class Pizza {
	private String strName;
	private Dough pizzaDough;
	private List<Topping> pizzaTopping = new ArrayList<Topping>();
	private int numberOfToppings;

	public Pizza(String name, int sizeOfToppings) {
		this.setName(name);
		this.setNumberOfToppings(sizeOfToppings);
	}

	public void setName(String name) {
		if (!name.isEmpty() || name.length() <= 15)
			this.strName = name;
		else
			throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");

	}

	public void setNumberOfToppings(int number) {
		if (number >= 0 && number <= 10)
			this.numberOfToppings = number;
		else
			throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
	}

	public void setToppings(List<Topping> toppings) {
		if (toppings.size() == this.numberOfToppings)
			this.pizzaTopping = toppings;
		else
			throw new IllegalArgumentException("Number of toppings should be equal Toppings.");
	}

	public void setDough(Dough dough) {
		this.pizzaDough = dough;
	}

	public void calculateCalories() {
		double totalCalories = 0;
		for (Topping topping : pizzaTopping) {
			totalCalories = totalCalories + topping.calculateCalories();
		}
		totalCalories = totalCalories + this.pizzaDough.calculateCalories();
		System.out.printf("%s - %.2f", this.strName, totalCalories);
	}
}
