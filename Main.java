import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("********START********");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] slice = new String[20];
		List<Topping> pizzaToppings = new ArrayList<Topping>();
		slice = in.readLine().split(" ");
		String pizzaName;
		int numbOfTopping;
		try {
			if (slice[0].equals("Pizza")) {
				pizzaName = slice[1];
				numbOfTopping = Integer.parseUnsignedInt(slice[2]);
			} else {
				throw new IllegalArgumentException("Incorrect command line Pizza.");
			}
			Pizza myFirstPizza = new Pizza(pizzaName, numbOfTopping);
			slice = in.readLine().split(" ");
			if (slice[0].equals("Dough")) {
				Dough myPizzaDough = new Dough(slice[1], slice[2], Integer.parseUnsignedInt(slice[3]));
				myFirstPizza.setDough(myPizzaDough);
			} else {
				throw new IllegalArgumentException("Incorrect command line Dough.");
			}
			while (true) {
				slice = in.readLine().split(" ");
				if (!slice[0].equals("END")) {
					if (slice[0].equals("Topping")) {
						Topping topping = new Topping(slice[1], Integer.parseUnsignedInt(slice[2]));
						pizzaToppings.add(topping);
					} else {
						throw new IllegalArgumentException("Incorrect command line Topping.");
					}
				} else {
					myFirstPizza.setToppings(pizzaToppings);
					myFirstPizza.calculateCalories();
					break;
				}
			}
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return;
		}

	}

}
