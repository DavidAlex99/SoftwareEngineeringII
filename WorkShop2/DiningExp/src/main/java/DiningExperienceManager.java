import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiningExperienceManager {
	private static final Map<String, Double> MENU = new HashMap();
	private static final double BASE_COST = 5.0;
	private static final int MAX_MEALS = 100;
	
	static {
		MENU.put("Burger", 10.0);
		MENU.put("Pizza", 15.0);
		MENU.put("Salad", 8.0);
		MENU.put("Sushi", 12.0);
		MENU.put("Pasta", 9.0);
	}
	
	private DiningExperienceManager() {
		throw new UnsupportedOperationException("constructor privadono puede ser inicializado");
	}
	
	private static void displayMenu() {
		System.out.println("Bienvenido al Dining EXP");
		System.out.println("Menu");
		MENU.forEach((meal, price) -> 
			System.out.println("Comida: " + meal + " : $" + price)
		);
	}
	
	private static double calculateTotalCost(Map<String, Integer> orders) {
		double totalCost = BASE_COST;
		int totalQuantity = 0;
		for(Integer quantity : orders.values()) {
			totalQuantity += quantity;
		}
		
		for(Map.Entry<String, Integer> order : orders.entrySet()) {
			String meal = order.getKey();
			int quantity =order.getValue();
			totalCost += MENU.get(meal) * quantity;
		}
		
		if(totalQuantity > 10) {
			totalCost *= 0.8; //20% discount
		} else if (totalQuantity > 5){
			totalCost *= 0.9; //10% discount
		}
		
		if(totalCost > 100) {
			totalCost -= 25; //$25 discount
		} else if (totalCost > 50) {
			totalCost -= 10; //$10 discount
		}
		
		return totalCost;
	}
	
	private static boolean validateMealAvailability(String meal) {
		return MENU.containsKey(meal);
	}
	
	private static boolean validateQuantity(int quantity) {
		return quantity > 0 && quantity <= MAX_MEALS;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> orders = new HashMap<>();
		displayMenu();
		
		String input;
		do {
			System.out.println("Ingrese una comida a ordenar o ingrese 'fin' para finalizar");
			input = sc.nextLine();
			
			if(!"done".equalsIgnoreCase(input) && validateMealAvailability(input)) {
				System.out.println("Ingrese cantidad:");
				int quantity;
				try {
					quantity = Integer.parseInt(sc.nextLine());
					if(validateQuantity(quantity)) {
						orders.put(input, orders.getOrDefault(input, 0));
					} else {
						System.out.println("Cabntidad incorrecta");
					}
				} catch (NumberFormatException e) {
					System.out.println("Numero invalido");
				}
			} else if(!"fin".equalsIgnoreCase(input)) {
				System.out.println("Comida no disponible");
			}
		} while (!"fin".equalsIgnoreCase(input));
		
		if(orders.isEmpty()) {
			System.out.println("Ninunga comida seleccionada");
		}
		
		double totalCost = calculateTotalCost(orders);
		System.out.println("Resumen de la orden");
		orders.forEach((meal, quantity) ->
			System.out.println(quantity + " por " + meal)
		);
		System.out.println("Costo total: " + totalCost);
		System.out.println("Confirmar orden? Ingrese si o no");
		String confirmacion =sc.nextLine();
		
		if("si".equalsIgnoreCase(confirmacion)) {
			System.out.println("Costo total: $" + totalCost);
		} else {
			System.out.println("Orden cancelada");
			totalCost = -1;
		}
		
		sc.close();
		
	}
}
